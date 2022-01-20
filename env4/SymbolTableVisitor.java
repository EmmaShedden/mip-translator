
import java.util.*;
import java.util.zip.DataFormatException;

/*
public class SymbolTableEntry implements Object {
    public String name;
    public String type;
}
*/

// Call on Root node & null data
public class SymbolTableVisitor implements EnvVisitor {

    //private List<SymbolTableEntry> ST = new ArrayList<SymbolTableEntry>();
    public Hashtable<String, Type> ST = new Hashtable<String, Type>();

    public Hashtable getST() {
        return ST;
    }

    public Object visit(SimpleNode node, Object data) throws RuntimeException {
	    throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTRoot node, Object data) {
        data = node.childrenAccept(this, data);
        return ST;
    }

    public Object visit(ASTAssignment node, Object data) {
        data = node.childrenAccept(this, data);
        return data;
    }

    public Object visit(ASTVar node, Object data) {
        //data = node.childrenAccept(this, data);
        if (!ST.containsKey(node.getName())) {
            throw new RuntimeException("Referenced unknown symbol: " + node.getName());
        }
        return data;
    }

    public Object visit(ASTPrimeVar node, Object data) {
        //data = node.childrenAccept(this, data);
        if (!ST.containsKey(node.getParentName())) {
            throw new RuntimeException("Referenced unknown symbol: " + node.getName());
        }
        return data;
    }

    public Object visit(ASTExpression node, Object data) {
        data = node.childrenAccept(this, data);
        return data;
    }

    public Object visit(ASTTerm node, Object data) {
        data = node.childrenAccept(this, data);
        return data;
    }

    public Object visit(ASTFactor node, Object data) {
        data = node.childrenAccept(this, data);
        return data;
    }

    // This should be terminal and contain no symbols
    public Object visit(ASTInteger node, Object data) {
        //data = node.childrenAccept(this, data);
        //return data;
        if (node.getName().equals("infinity")) {
            throw new InfinityException();
        }
        return node.jjtGetValue();
    }

    // This should be terminal and contain no symbols
    public Object visit(ASTFloat node, Object data) {
        //data = node.childrenAccept(this, data);
        //return data;
        return node.jjtGetValue();
    }

    public Object visit(ASTTypeDef node, Object data) {
        try {
            // node.jjtGetChild(0) must be an ASTVar node
            node.jjtGetChild(0).jjtAccept(this, data);
            throw new RuntimeException("Duplicate declaration: " + ((ASTVar) node.jjtGetChild(0)).jjtGetValue());
        } catch (RuntimeException e) {
            String[] msg = e.getMessage().split(": ");
            if (!msg[0].equals("Referenced unknown symbol")) {
                throw e;
            }
            String name = ((ASTVar) node.jjtGetChild(0)).jjtGetValue();
            Type type = (Type) node.jjtGetChild(1).jjtAccept(this, data);
            ST.put(name, type);
        }

        /*
        if (node.jjtGetChild(0).jjtAccept(this, data)) {
            throw new RuntimeException("Duplicate declaration: " + node.jjtGetChild(0).getName());
        } else {
            String name = node.jjtGetChild(0).getName();
            Type type = (Type) node.jjtGetChild(1).jjtAccept(this, data);
        }
        */

        return data;
    }

    // This should be terminal (recursion does nothing)
    public Object visit(ASTType node, Object data) {
        //data = node.childrenAccept(this, data);
        //return data;
        return new Type(node.getType());
    }

    // No symbols from here on down (return type instead to use in TypeDef visit)
    public Object visit(ASTRange node, Object data) {
        //data = node.childrenAccept(this, data);
        Number a, b;
        try {
            a = (Number) node.jjtGetChild(0).jjtAccept(this, data);
        } catch (InfinityException e) {
            if (!e.pos) {
                try {
                    b = (Number) node.jjtGetChild(1).jjtAccept(this, data);
                } catch (InfinityException f) {
                    if (f.pos) {
                        return new Type(DataType.Int);
                    } else {
                        throw new InfinityException("Upper bound of -infinity");
                    }
                }
                return new RestrictedType(false, b);
            }
            throw new InfinityException("Lower bound of +infinity");
        }
        try {
            b = (Number) node.jjtGetChild(1).jjtAccept(this, data);
        } catch (InfinityException e) {
            if (e.pos) {
                return new RestrictedType(a, false);
            }
            throw new InfinityException("Upper bound of -infinity");
        }
        return new RestrictedType(a, b);
    }

    public Object visit(ASTConstExpression node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS total
        Number num = (Number) node.jjtGetChild(0).jjtAccept(this, data);

        // Incorporate successive RHS factors
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            Number next = (Number) node.jjtGetChild(i).jjtAccept(this, data);

            // Integer value
            // I think valueOf() are optional - autoboxed anyway
            if (num.getClass() == Integer.class && next.getClass() == Integer.class) {
                if (node.getOps(i-1).equals("+")) {
                    num = Integer.valueOf(num.intValue() + next.intValue());
                } else {
                    num = Integer.valueOf(num.intValue() - next.intValue());
                }
            }

            // Float value (including auto upcasts)
            else {
                if (node.getOps(i-1).equals("+")) {
                    num = Float.valueOf(num.floatValue() + next.floatValue());
                } else {
                    num = Float.valueOf(num.floatValue() - next.floatValue());
                }
            }
        }
        return num;
    }

    public Object visit(ASTConstTerm node, Object data) {
        //data = node.childrenAccept(this, data);

        // running LHS total
        Number num = (Number) node.jjtGetChild(0).jjtAccept(this, data);

        // Incorporate successive RHS terms
        for (int i = 1; i < node.jjtGetNumChildren(); ++i) {
            Number next = (Number) node.jjtGetChild(i).jjtAccept(this, data);

            // Integer value
            // I think valueOf() are optional - autoboxed anyway
            if (num.getClass() == Integer.class && next.getClass() == Integer.class) {
                if (node.getOps(i-1).equals("*")) {
                    num = Integer.valueOf(num.intValue() * next.intValue());
                } else {
                    num = Integer.valueOf(num.intValue() / next.intValue());
                }
            }

            // Float value (including auto upcasts)
            else {
                if (node.getOps(i-1).equals("*")) {
                    num = Float.valueOf(num.floatValue() * next.floatValue());
                } else {
                    num = Float.valueOf(num.floatValue() / next.floatValue());
                }
            }
        }
        return num;
    }

    public Object visit(ASTConstFactor node, Object data) {
        //data = node.childrenAccept(this, data);
        Number num;
        try {
            num = (Number) node.jjtGetChild(0).jjtAccept(this, data);
        } catch (InfinityException e) {
            if (node.getName().equals("-")) {
                e.pos = false;
            }
            throw e;
        }
        
        if (node.getName().equals("-")) {
            if (num.getClass() == Integer.class) {
                return Integer.valueOf(-1 * num.intValue());
            } else {
                return Float.valueOf(-1 * num.floatValue());
            }
        }
        return num;
    }

}
