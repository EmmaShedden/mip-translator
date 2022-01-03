
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

  public String getName() {
    return name;
  }

  public void jjtSetValue(Object n) {
    name = (String) n;
  }

  public Object jjtGetValue() {
    return name;
  }

  public String toString() {
    return "PrimeVar: " + name;
  }

  public String getParentName() {
    return name.substring(0, name.length()-1);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
