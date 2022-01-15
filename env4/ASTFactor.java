
public class ASTFactor extends SimpleNode {
  private String name;

  public ASTFactor(int id) {
    super(id);
  }

  public ASTFactor(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "Sign: " + name;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
