/* Generated By:JJTree: Do not edit this line. ASTAssignment.java Version 4.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY= */
public class ASTAssignment extends SimpleNode {
  public ASTAssignment(int id) {
    super(id);
  }

  public ASTAssignment(Env p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(EnvVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=476cc1f42eb03431662dfa0943bc1ccb (do not edit this line) */