
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

  public String toString() {
    return "Var: " + name;
  }

}
