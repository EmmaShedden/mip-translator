
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

  public String toString() {
    return "Float: " + name;
  }

}
