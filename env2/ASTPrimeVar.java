
public class ASTPrimeVar extends SimpleNode {
  private String name;

  public ASTPrimeVar(int id) {
    super(id);
  }

  public ASTPrimeVar(Env p, int id) {
    super(p, id);
  }

  public void setName(String n) {
    name = n;
  }

  public String toString() {
    return "PrimeVar: " + name;
  }

}
