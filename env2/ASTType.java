
public class ASTType extends SimpleNode {
  private String name;

  public ASTType(int id) {
    super(id);
  }

  public ASTType(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String toString() {
    return "Type: " + name;
  }

}
