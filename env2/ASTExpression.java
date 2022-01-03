
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
    ops = new ArrayList(o);
  }

  public String toString() {
    return "Expression: " + ops;
  }

}
