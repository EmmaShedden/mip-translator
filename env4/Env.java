/* Generated By:JJTree&JavaCC: Do not edit this line. Env.java */
import java.lang.*;
import java.io.*;
import java.util.*;

public class Env/*@bgen(jjtree)*/implements EnvTreeConstants, EnvConstants {/*@bgen(jjtree)*/
  protected static JJTEnvState jjtree = new JJTEnvState();// Main entry point

    public static void main(String args[]) throws ParseException, TokenMgrError, FileNotFoundException, IOException {
        Env parser;
        if (args.length == 1) {
            parser = new Env(System.in);
        } else if (args.length == 2) {
            parser = new Env(new FileInputStream(args[1]));
        } else {
            throw new RuntimeException("Incorrect usage: only output (required) & input (optional) filenames can be passed by command line (in that order)");
        }

        System.out.println("Parsing...");

        ASTRoot n = parser.Root();

        //System.out.println("\n");
        //n.dump("");
        //System.out.println("\n");

        System.out.println("\nGenerating Symbol Table...");

        SymbolTableVisitor v = new SymbolTableVisitor();
        n.jjtAccept(v, null);
        System.out.println("\n\t" + v.getST());

        System.out.println("\nGenerating Minizinc Program...");

        MinizincVisitor m = new MinizincVisitor();
        n.jjtAccept(m, args[0]);
        System.out.println("\n\tMiniZinc Program Complete: " + args[0]);
    }

  static final public ASTRoot Root() throws ParseException {
                  /*@bgen(jjtree) Root */
  ASTRoot jjtn000 = new ASTRoot(JJTROOT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
        case 22:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
          jj_consume_token(21);
          break;
        case 22:
          jj_consume_token(22);
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
      case PRIMEWORD:
        Assignment();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMENT:
          jj_consume_token(COMMENT);
          break;
        default:
          jj_la1[2] = jj_gen;
          ;
        }
        break;
      case VARLABEL:
        TypeDef();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMENT:
          jj_consume_token(COMMENT);
          break;
        default:
          jj_la1[3] = jj_gen;
          ;
        }
        break;
      case COMMENT:
        jj_consume_token(COMMENT);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 21:
        case 22:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_2;
        }
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 21:
            jj_consume_token(21);
            break;
          case 22:
            jj_consume_token(22);
            break;
          default:
            jj_la1[6] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 21:
          case 22:
            ;
            break;
          default:
            jj_la1[7] = jj_gen;
            break label_3;
          }
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case WORD:
        case PRIMEWORD:
          Assignment();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMENT:
            jj_consume_token(COMMENT);
            break;
          default:
            jj_la1[8] = jj_gen;
            ;
          }
          break;
        case VARLABEL:
          TypeDef();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMENT:
            jj_consume_token(COMMENT);
            break;
          default:
            jj_la1[9] = jj_gen;
            ;
          }
          break;
        case COMMENT:
          jj_consume_token(COMMENT);
          break;
        case 0:
          jj_consume_token(0);
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(0);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

  static final public void Assignment() throws ParseException {
                     /*@bgen(jjtree) Assignment */
  ASTAssignment jjtn000 = new ASTAssignment(JJTASSIGNMENT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case WORD:
        Var();
        break;
      case PRIMEWORD:
        PrimeVar();
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(23);
      Expression();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Var() throws ParseException {
              /*@bgen(jjtree) Var */
              ASTVar jjtn000 = new ASTVar(JJTVAR);
              boolean jjtc000 = true;
              jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(WORD);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setName(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void PrimeVar() throws ParseException {
                   /*@bgen(jjtree) PrimeVar */
                   ASTPrimeVar jjtn000 = new ASTPrimeVar(JJTPRIMEVAR);
                   boolean jjtc000 = true;
                   jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(PRIMEWORD);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setName(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Expression() throws ParseException {
                           List<String> ops = new ArrayList<String>(); String op;
      ASTExpression jjtn001 = new ASTExpression(JJTEXPRESSION);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      Term();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
        case 25:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_4;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          op = jj_consume_token(24).image;
          break;
        case 25:
          op = jj_consume_token(25).image;
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Term();
                                                          ops.add(op);
      }
          jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          jjtc001 = false;
         jjtn001.setOps(ops);
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void Term() throws ParseException {
                     List<String> ops = new ArrayList<String>(); String op;
      ASTTerm jjtn001 = new ASTTerm(JJTTERM);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      Factor();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 26:
        case 27:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_5;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 26:
          op = jj_consume_token(26).image;
          break;
        case 27:
          op = jj_consume_token(27).image;
          break;
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Factor();
                                                              ops.add(op);
      }
          jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          jjtc001 = false;
         jjtn001.setOps(ops);
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void Factor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case INTEGER:
    case FLOAT:
    case WORD:
    case 28:
      Primary();
      break;
    case 24:
    case 25:
        ASTFactor jjtn001 = new ASTFactor(JJTFACTOR);
        boolean jjtc001 = true;
        jjtree.openNodeScope(jjtn001);
      try {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          jj_consume_token(24);
          Primary();
                        jjtree.closeNodeScope(jjtn001, true);
                        jjtc001 = false;
                       jjtn001.setName("+");
          break;
        case 25:
          jj_consume_token(25);
          Primary();
                          jjtree.closeNodeScope(jjtn001, true);
                          jjtc001 = false;
                         jjtn001.setName("-");
          break;
        default:
          jj_la1[16] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      } catch (Throwable jjte001) {
        if (jjtc001) {
          jjtree.clearNodeScope(jjtn001);
          jjtc001 = false;
        } else {
          jjtree.popNode();
        }
        if (jjte001 instanceof RuntimeException) {
          {if (true) throw (RuntimeException)jjte001;}
        }
        if (jjte001 instanceof ParseException) {
          {if (true) throw (ParseException)jjte001;}
        }
        {if (true) throw (Error)jjte001;}
      } finally {
        if (jjtc001) {
          jjtree.closeNodeScope(jjtn001, true);
        }
      }
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Primary() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case INTEGER:
      Integer();
      break;
    case FLOAT:
      Float();
      break;
    case WORD:
      Var();
      break;
    case 28:
      jj_consume_token(28);
      Expression();
      jj_consume_token(29);
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Integer() throws ParseException {
                  /*@bgen(jjtree) Integer */
                  ASTInteger jjtn000 = new ASTInteger(JJTINTEGER);
                  boolean jjtc000 = true;
                  jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        t = jj_consume_token(INTEGER);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setName(t.image);
        jjtn000.jjtSetValue(Integer.valueOf(t.image));
        break;
      case INF:
        t = jj_consume_token(INF);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setName(t.image);
        jjtn000.jjtSetValue(null);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Float() throws ParseException {
                /*@bgen(jjtree) Float */
                ASTFloat jjtn000 = new ASTFloat(JJTFLOAT);
                boolean jjtc000 = true;
                jjtree.openNodeScope(jjtn000);Token t;
    try {
      t = jj_consume_token(FLOAT);
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setName(t.image);
        jjtn000.jjtSetValue(Float.valueOf(t.image));
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void TypeDef() throws ParseException {
                  /*@bgen(jjtree) TypeDef */
  ASTTypeDef jjtn000 = new ASTTypeDef(JJTTYPEDEF);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(VARLABEL);
      Var();
      jj_consume_token(30);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTLABEL:
      case FLOATLABEL:
      case BOOLLABEL:
        Type();
        break;
      case INF:
      case INTEGER:
      case FLOAT:
      case 24:
      case 25:
      case 28:
        Range();
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Type() throws ParseException {
               /*@bgen(jjtree) Type */
               ASTType jjtn000 = new ASTType(JJTTYPE);
               boolean jjtc000 = true;
               jjtree.openNodeScope(jjtn000);Token t;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTLABEL:
        t = jj_consume_token(INTLABEL);
        break;
      case FLOATLABEL:
        t = jj_consume_token(FLOATLABEL);
        break;
      case BOOLLABEL:
        t = jj_consume_token(BOOLLABEL);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.set(t.image);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

// should I assign the range type here or figure it out in the visitor?
  static final public void Range() throws ParseException {
                /*@bgen(jjtree) Range */
  ASTRange jjtn000 = new ASTRange(JJTRANGE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      ConstExpression();
      jj_consume_token(31);
      ConstExpression();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void ConstExpression() throws ParseException {
                                List<String> ops = new ArrayList<String>(); String op;
      ASTConstExpression jjtn001 = new ASTConstExpression(JJTCONSTEXPRESSION);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      ConstTerm();
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
        case 25:
          ;
          break;
        default:
          jj_la1[22] = jj_gen;
          break label_6;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          op = jj_consume_token(24).image;
          break;
        case 25:
          op = jj_consume_token(25).image;
          break;
        default:
          jj_la1[23] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        ConstTerm();
                                                                    ops.add(op);
      }
          jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          jjtc001 = false;
         jjtn001.setOps(ops);
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void ConstTerm() throws ParseException {
                          List<String> ops = new ArrayList<String>(); String op;
      ASTConstTerm jjtn001 = new ASTConstTerm(JJTCONSTTERM);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      ConstFactor();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 26:
        case 27:
          ;
          break;
        default:
          jj_la1[24] = jj_gen;
          break label_7;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 26:
          op = jj_consume_token(26).image;
          break;
        case 27:
          op = jj_consume_token(27).image;
          break;
        default:
          jj_la1[25] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        ConstFactor();
                                                                        ops.add(op);
      }
          jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
          jjtc001 = false;
         jjtn001.setOps(ops);
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void ConstFactor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case INTEGER:
    case FLOAT:
    case 28:
      ConstPrimary();
      break;
    case 24:
    case 25:
        ASTConstFactor jjtn001 = new ASTConstFactor(JJTCONSTFACTOR);
        boolean jjtc001 = true;
        jjtree.openNodeScope(jjtn001);
      try {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 24:
          jj_consume_token(24);
          ConstPrimary();
                             jjtree.closeNodeScope(jjtn001, true);
                             jjtc001 = false;
                            jjtn001.setName("+");
          break;
        case 25:
          jj_consume_token(25);
          ConstPrimary();
                               jjtree.closeNodeScope(jjtn001, true);
                               jjtc001 = false;
                              jjtn001.setName("-");
          break;
        default:
          jj_la1[26] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      } catch (Throwable jjte001) {
        if (jjtc001) {
          jjtree.clearNodeScope(jjtn001);
          jjtc001 = false;
        } else {
          jjtree.popNode();
        }
        if (jjte001 instanceof RuntimeException) {
          {if (true) throw (RuntimeException)jjte001;}
        }
        if (jjte001 instanceof ParseException) {
          {if (true) throw (ParseException)jjte001;}
        }
        {if (true) throw (Error)jjte001;}
      } finally {
        if (jjtc001) {
          jjtree.closeNodeScope(jjtn001, true);
        }
      }
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ConstPrimary() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INF:
    case INTEGER:
      Integer();
      break;
    case FLOAT:
      Float();
      break;
    case 28:
      jj_consume_token(28);
      ConstExpression();
      jj_consume_token(29);
      break;
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public EnvTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[29];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x600000,0x600000,0x10,0x10,0x180810,0x600000,0x600000,0x600000,0x10,0x10,0x180811,0x180000,0x3000000,0x3000000,0xc000000,0xc000000,0x3000000,0x130b1000,0x100b1000,0x11000,0x13031700,0x700,0x3000000,0x3000000,0xc000000,0xc000000,0x3000000,0x13031000,0x10031000,};
   }

  /** Constructor with InputStream. */
  public Env(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Env(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new EnvTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Env(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new EnvTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Env(EnvTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(EnvTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 29; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[32];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 29; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 32; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
