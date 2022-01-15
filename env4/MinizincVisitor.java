
import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class MinizincVisitor implements EnvVisitor {
    /*
        1. Introduce overloaded functions for each operator to clean up logic
        2. Introduce booleans?
        3. Declare curr and next versions of all vars declared
        4. Copy all Var assignments
        5. Copy all primeVar assignments with necessary edits to 
    */
    public Object visit(SimpleNode node, Object data) {
        throw new RuntimeException("Visit SimpleNode");
    }

    // data is a String containing name of the output file
    // text is the text of the MiniZinc program, built bottom-up
    // program will be output to its own file, whose name is specified using data
    public Object visit(ASTRoot node, Object data) { // throws IOException

        StringBuilder text = new StringBuilder(); // empty
        node.childrenAccept(this, text);
        /*
        for (int i = 0; i < node.jjtGetNumChildren(); ++i) {
            String next = (String) node.jjtGetChild(i).jjtAccept(this, text);
            text = text + next;
        }
        */

        // debugging
        //System.out.println(text);

        try {
            File file = new File((String) data);
            file.createNewFile();

            FileWriter writer = new FileWriter(file);

            writer.write("% auto-generated environment model, does not include constraints\n\n");
            writer.write(text.toString());

            writer.flush();    
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException: " + e.getMessage());
        }

        
        return data;
    }

    // always 2 children
    public Object visit(ASTAssignment node, Object data) {
        // append this variable assignment to the end of the current program
        String left = (String) node.jjtGetChild(0).jjtAccept(this, null);
        String right = (String) node.jjtGetChild(1).jjtAccept(this, null);
        String line = left + " = " + right + ";\n";
        ((StringBuilder) data).append(line);
        return null;
    }

    // terminal
    // data is or irrelevant
    public Object visit(ASTVar node, Object data) {
        //data = node.childrenAccept(this, data);
        return node.getName();
    }

    // terminal
    // data is null or irrelevant
    public Object visit(ASTPrimeVar node, Object data) {
        //data = node.childrenAccept(this, data);
        return node.getParentName() + "_prime";
    }

    private String exprParens(Node node, String term) {
        if (node.getClass() == ASTExpression.class) {
            return "(" + term + ")";
        }
        return term;
    }

    // always >1 children
    public Object visit(ASTExpression node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS partial expression
        // Expression is never terminal, so this is safe
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = exprParens(node.jjtGetChild(0), text);

        // Incorporate successive RHS factors
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            String next = (String) node.jjtGetChild(i).jjtAccept(this, null);
            next = exprParens(node.jjtGetChild(i), next);
            text = text + " " + node.getOps(i-1) + " " + next;
        }
        return text;
    }

    private String termParens(Node node, String factor) {
        if (node.getClass() == ASTExpression.class || node.getClass() == ASTTerm.class) {
            return "(" + factor + ")";
        }
        return factor;
    }

    // always >1 children
    public Object visit(ASTTerm node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS partial expression
        // Term is never terminal, so this is safe
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = termParens(node.jjtGetChild(0), text);

        // Incorporate successive RHS factors
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            String next = (String) node.jjtGetChild(i).jjtAccept(this, null);
            next = termParens(node.jjtGetChild(i), next);
            text = text + " " + node.getOps(i-1) + " " + next;
        }
        return text;
    }

    private String factorParens(Node node, String expr) {
        if (node.getClass() == ASTInteger.class
            | node.getClass() == ASTFloat.class
            | node.getClass() == ASTVar.class
            | node.getClass() == ASTPrimeVar.class) {
            return expr;
        }
        return "(" + expr + ")";
    }

    // always has 1 child
    public Object visit(ASTFactor node, Object data) {
        //data = node.childrenAccept(this, data);
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = factorParens(node.jjtGetChild(0), text);
        if (node.getName().equals("-")) {
            return "-" + text;
        }
        // MiniZinc doesn't allow clarifying + signs, e.g. -2 .. +2
        return  text;
    }

    // terminal
    public Object visit(ASTInteger node, Object data) {
        //data = node.childrenAccept(this, data);
        return node.getName();
    }

    // terminal
    public Object visit(ASTFloat node, Object data) {
        //data = node.childrenAccept(this, data);
        return node.getName();
    }

    // always 2 children
    // TODO not sure if parent (nonprime) vars can actually be pars but it's a possibility
    public Object visit(ASTTypeDef node, Object data) {
        String right = (String) node.jjtGetChild(0).jjtAccept(this, null);
        String left = "var " + (String) node.jjtGetChild(1).jjtAccept(this, null);
        String line = left + " : " + right + ";\n";
        ((StringBuilder) data).append(line);
        String primeLine = left + " : " + right + "_prime;\n\n";
        ((StringBuilder) data).append(primeLine);
        return null;
    }

    // terminal
    public Object visit(ASTType node, Object data) {
        //data = node.childrenAccept(this, data);
        return node.getName();
    }

    // 2 children
    public Object visit(ASTRange node, Object data) {
        //data = node.childrenAccept(this, data);
        String left = (String) node.jjtGetChild(0).jjtAccept(this, null);
        String right = (String) node.jjtGetChild(1).jjtAccept(this, null);

        // this is really janky, I'm sorry
        if (left.equals("-infinity") && right.equals("infinity")) {
            return "int";
        }

        return left + " .. " + right;
    }

    private String constExprParens(Node node, String term) {
        if (node.getClass() == ASTConstExpression.class) {
            return "(" + term + ")";
        }
        return term;
    }

    // >1 children
    public Object visit(ASTConstExpression node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS partial expression
        // Expression is never terminal, so this is safe
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = constExprParens(node.jjtGetChild(0), text);

        // Incorporate successive RHS factors
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            String next = (String) node.jjtGetChild(i).jjtAccept(this, null);
            next = constExprParens(node.jjtGetChild(i), next);
            text = text + " " + node.getOps(i-1) + " " + next;
        }
        return text;
    }

    private String constTermParens(Node node, String factor) {
        if (node.getClass() == ASTConstExpression.class || node.getClass() == ASTConstTerm.class) {
            return "(" + factor + ")";
        }
        return factor;
    }

    // >1 children
    public Object visit(ASTConstTerm node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS partial expression
        // Expression is never terminal, so this is safe
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = constTermParens(node.jjtGetChild(0), text);

        // Incorporate successive RHS factors
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            String next = (String) node.jjtGetChild(i).jjtAccept(this, null);
            next = constTermParens(node.jjtGetChild(i), next);
            text = text + " " + node.getOps(i-1) + " " + next;
        }
        return text;
    }

    // always has 1 child
    public Object visit(ASTConstFactor node, Object data) {
        //data = node.childrenAccept(this, data);
        String text = (String) node.jjtGetChild(0).jjtAccept(this, null);
        text = factorParens(node.jjtGetChild(0), text);
        if (node.getName().equals("-")) {
            return "-" + text;
        }
        // MiniZinc doesn't allow clarifying + signs, e.g. -2 .. +2
        return text;
    }


}
