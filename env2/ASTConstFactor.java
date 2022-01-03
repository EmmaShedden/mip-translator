
public class ASTConstFactor extends SimpleNode {
  private String name;

  public ASTConstFactor(int id) {
    super(id);
  }

  public ASTConstFactor(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String toString() {
    return "ConstFactor: " + name;
  }

}
