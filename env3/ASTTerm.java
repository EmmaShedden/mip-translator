
import java.util.*;

public class ASTTerm extends SimpleNode {
  List<String> ops;

  public ASTTerm(int id) {
    super(id);
  }

  public ASTTerm(Env p, int id) {
    super(p, id);
  }

  public void setOps(List<String> o) {
    ops = new ArrayList(o);
  }

  public String toString() {
    return "Term: " + ops;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
