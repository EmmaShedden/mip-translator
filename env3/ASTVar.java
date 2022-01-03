
public class ASTVar extends SimpleNode {
  private String name;

  public ASTVar(int id) {
    super(id);
  }

  public ASTVar(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public void jjtSetValue(String n) {
    name = n;
  }

  public String jjtGetValue() {
    return name;
  }

  public String toString() {
    return "Var: " + name;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
