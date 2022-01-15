
public class ASTFloat extends SimpleNode {
  private String name;

  public ASTFloat(int id) {
    super(id);
  }

  public ASTFloat(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "Float: " + name;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
