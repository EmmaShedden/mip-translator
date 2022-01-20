
public class ASTType extends SimpleNode {
  private String name;
  private DataType type;

  public ASTType(int id) {
    super(id);
  }

  public ASTType(Env p, int id) {
    super(p, id);
  }

  public void set(String n) {
    name = n;
    if (n == "Int") {
      type = DataType.Int;
    } else if (n == "Float") {
      type = DataType.Float;
    } else {
      type = DataType.Null;
    }
  }

  public DataType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return "Type: " + name;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

}
