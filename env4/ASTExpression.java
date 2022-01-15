
import java.util.*;

public class ASTExpression extends SimpleNode {
  List<String> ops;

  public ASTExpression(int id) {
    super(id);
  }

  public ASTExpression(Env p, int id) {
    super(p, id);
  }

  public void setOps(List<String> o) {
    ops = new ArrayList<String>(o);
  }

  public List<String> getOps() {
    return ops;
  }

  public String getOps(int i) {
    return ops.get(i);
  }

  public String toString() {
    return "Expression: " + ops;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
