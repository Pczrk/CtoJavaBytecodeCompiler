// Generated from MyParser.g4 by ANTLR 4.13.1
package antlrGen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyParser}.
 */
public interface MyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MyParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MyParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(MyParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(MyParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MyParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MyParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolDecl}.
	 * @param ctx the parse tree
	 */
	void enterBoolDecl(MyParser.BoolDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolDecl}.
	 * @param ctx the parse tree
	 */
	void exitBoolDecl(MyParser.BoolDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntDecl(MyParser.IntDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntDecl(MyParser.IntDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charDecl}.
	 * @param ctx the parse tree
	 */
	void enterCharDecl(MyParser.CharDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charDecl}.
	 * @param ctx the parse tree
	 */
	void exitCharDecl(MyParser.CharDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatDecl(MyParser.FloatDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatDecl(MyParser.FloatDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrDecl}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrDecl(MyParser.BoolArrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrDecl}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrDecl(MyParser.BoolArrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntArrDecl(MyParser.IntArrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntArrDecl(MyParser.IntArrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrDecl}.
	 * @param ctx the parse tree
	 */
	void enterCharArrDecl(MyParser.CharArrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrDecl}.
	 * @param ctx the parse tree
	 */
	void exitCharArrDecl(MyParser.CharArrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrDecl(MyParser.FloatArrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrDecl(MyParser.FloatArrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#scopedVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterScopedVarDecl(MyParser.ScopedVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#scopedVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitScopedVarDecl(MyParser.ScopedVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolVarDeclList}.
	 * @param ctx the parse tree
	 */
	void enterBoolVarDeclList(MyParser.BoolVarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolVarDeclList}.
	 * @param ctx the parse tree
	 */
	void exitBoolVarDeclList(MyParser.BoolVarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intVarDeclList}.
	 * @param ctx the parse tree
	 */
	void enterIntVarDeclList(MyParser.IntVarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intVarDeclList}.
	 * @param ctx the parse tree
	 */
	void exitIntVarDeclList(MyParser.IntVarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charVarDeclList}.
	 * @param ctx the parse tree
	 */
	void enterCharVarDeclList(MyParser.CharVarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charVarDeclList}.
	 * @param ctx the parse tree
	 */
	void exitCharVarDeclList(MyParser.CharVarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatVarDeclList}.
	 * @param ctx the parse tree
	 */
	void enterFloatVarDeclList(MyParser.FloatVarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatVarDeclList}.
	 * @param ctx the parse tree
	 */
	void exitFloatVarDeclList(MyParser.FloatVarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrDeclList(MyParser.BoolArrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrDeclList(MyParser.BoolArrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterIntArrDeclList(MyParser.IntArrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitIntArrDeclList(MyParser.IntArrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterCharArrDeclList(MyParser.CharArrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitCharArrDeclList(MyParser.CharArrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrDeclList(MyParser.FloatArrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrDeclList(MyParser.FloatArrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterBoolVarDeclInit(MyParser.BoolVarDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitBoolVarDeclInit(MyParser.BoolVarDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterIntVarDeclInit(MyParser.IntVarDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitIntVarDeclInit(MyParser.IntVarDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterCharVarDeclInit(MyParser.CharVarDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitCharVarDeclInit(MyParser.CharVarDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterFloatVarDeclInit(MyParser.FloatVarDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatVarDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitFloatVarDeclInit(MyParser.FloatVarDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrDeclInit(MyParser.BoolArrDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrDeclInit(MyParser.BoolArrDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterIntArrDeclInit(MyParser.IntArrDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitIntArrDeclInit(MyParser.IntArrDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterCharArrDeclInit(MyParser.CharArrDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitCharArrDeclInit(MyParser.CharArrDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrDeclInit(MyParser.FloatArrDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrDeclInit(MyParser.FloatArrDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#varDeclId}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclId(MyParser.VarDeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varDeclId}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclId(MyParser.VarDeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arrDeclId}.
	 * @param ctx the parse tree
	 */
	void enterArrDeclId(MyParser.ArrDeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arrDeclId}.
	 * @param ctx the parse tree
	 */
	void exitArrDeclId(MyParser.ArrDeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(MyParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#funDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(MyParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterBoolFunDecl(MyParser.BoolFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitBoolFunDecl(MyParser.BoolFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntFunDecl(MyParser.IntFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntFunDecl(MyParser.IntFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterCharFunDecl(MyParser.CharFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitCharFunDecl(MyParser.CharFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatFunDecl(MyParser.FloatFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatFunDecl(MyParser.FloatFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrFunDecl(MyParser.BoolArrFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrFunDecl(MyParser.BoolArrFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterIntArrFunDecl(MyParser.IntArrFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitIntArrFunDecl(MyParser.IntArrFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterCharArrFunDecl(MyParser.CharArrFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitCharArrFunDecl(MyParser.CharArrFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrFunDecl(MyParser.FloatArrFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrFunDecl(MyParser.FloatArrFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterVoidFunDecl(MyParser.VoidFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitVoidFunDecl(MyParser.VoidFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MyParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MyParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MyParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MyParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolParam}.
	 * @param ctx the parse tree
	 */
	void enterBoolParam(MyParser.BoolParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolParam}.
	 * @param ctx the parse tree
	 */
	void exitBoolParam(MyParser.BoolParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intParam}.
	 * @param ctx the parse tree
	 */
	void enterIntParam(MyParser.IntParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intParam}.
	 * @param ctx the parse tree
	 */
	void exitIntParam(MyParser.IntParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charParam}.
	 * @param ctx the parse tree
	 */
	void enterCharParam(MyParser.CharParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charParam}.
	 * @param ctx the parse tree
	 */
	void exitCharParam(MyParser.CharParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatParam}.
	 * @param ctx the parse tree
	 */
	void enterFloatParam(MyParser.FloatParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatParam}.
	 * @param ctx the parse tree
	 */
	void exitFloatParam(MyParser.FloatParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrParam}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrParam(MyParser.BoolArrParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrParam}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrParam(MyParser.BoolArrParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrParam}.
	 * @param ctx the parse tree
	 */
	void enterIntArrParam(MyParser.IntArrParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrParam}.
	 * @param ctx the parse tree
	 */
	void exitIntArrParam(MyParser.IntArrParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrParam}.
	 * @param ctx the parse tree
	 */
	void enterCharArrParam(MyParser.CharArrParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrParam}.
	 * @param ctx the parse tree
	 */
	void exitCharArrParam(MyParser.CharArrParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrParam}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrParam(MyParser.FloatArrParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrParam}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrParam(MyParser.FloatArrParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolRStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolRStmt(MyParser.BoolRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolRStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolRStmt(MyParser.BoolRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolRCompoundStmt(MyParser.BoolRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolRCompoundStmt(MyParser.BoolRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolStmt(MyParser.BoolStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolStmt(MyParser.BoolStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolReturnStmt(MyParser.BoolReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolReturnStmt(MyParser.BoolReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolCompoundStmt(MyParser.BoolCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolCompoundStmt(MyParser.BoolCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolSelectStmt(MyParser.BoolSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolSelectStmt(MyParser.BoolSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolIterStmt(MyParser.BoolIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolIterStmt(MyParser.BoolIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intRStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntRStmt(MyParser.IntRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intRStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntRStmt(MyParser.IntRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntRCompoundStmt(MyParser.IntRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntRCompoundStmt(MyParser.IntRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntStmt(MyParser.IntStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntStmt(MyParser.IntStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntReturnStmt(MyParser.IntReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntReturnStmt(MyParser.IntReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntCompoundStmt(MyParser.IntCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntCompoundStmt(MyParser.IntCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntSelectStmt(MyParser.IntSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntSelectStmt(MyParser.IntSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntIterStmt(MyParser.IntIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntIterStmt(MyParser.IntIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charRStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharRStmt(MyParser.CharRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charRStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharRStmt(MyParser.CharRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharRCompoundStmt(MyParser.CharRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharRCompoundStmt(MyParser.CharRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharStmt(MyParser.CharStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharStmt(MyParser.CharStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharReturnStmt(MyParser.CharReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharReturnStmt(MyParser.CharReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharCompoundStmt(MyParser.CharCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharCompoundStmt(MyParser.CharCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharSelectStmt(MyParser.CharSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharSelectStmt(MyParser.CharSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharIterStmt(MyParser.CharIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharIterStmt(MyParser.CharIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatRStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatRStmt(MyParser.FloatRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatRStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatRStmt(MyParser.FloatRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatRCompoundStmt(MyParser.FloatRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatRCompoundStmt(MyParser.FloatRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatStmt(MyParser.FloatStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatStmt(MyParser.FloatStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatReturnStmt(MyParser.FloatReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatReturnStmt(MyParser.FloatReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatCompoundStmt(MyParser.FloatCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatCompoundStmt(MyParser.FloatCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatSelectStmt(MyParser.FloatSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatSelectStmt(MyParser.FloatSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatIterStmt(MyParser.FloatIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatIterStmt(MyParser.FloatIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrRStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrRStmt(MyParser.BoolArrRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrRStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrRStmt(MyParser.BoolArrRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrRCompoundStmt(MyParser.BoolArrRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrRCompoundStmt(MyParser.BoolArrRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrStmt(MyParser.BoolArrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrStmt(MyParser.BoolArrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrReturnStmt(MyParser.BoolArrReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrReturnStmt(MyParser.BoolArrReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrCompoundStmt(MyParser.BoolArrCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrCompoundStmt(MyParser.BoolArrCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrSelectStmt(MyParser.BoolArrSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrSelectStmt(MyParser.BoolArrSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrIterStmt(MyParser.BoolArrIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrIterStmt(MyParser.BoolArrIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrRStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrRStmt(MyParser.IntArrRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrRStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrRStmt(MyParser.IntArrRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrRCompoundStmt(MyParser.IntArrRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrRCompoundStmt(MyParser.IntArrRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrStmt(MyParser.IntArrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrStmt(MyParser.IntArrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrReturnStmt(MyParser.IntArrReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrReturnStmt(MyParser.IntArrReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrCompoundStmt(MyParser.IntArrCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrCompoundStmt(MyParser.IntArrCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrSelectStmt(MyParser.IntArrSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrSelectStmt(MyParser.IntArrSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrIterStmt(MyParser.IntArrIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrIterStmt(MyParser.IntArrIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrRStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrRStmt(MyParser.CharArrRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrRStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrRStmt(MyParser.CharArrRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrRCompoundStmt(MyParser.CharArrRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrRCompoundStmt(MyParser.CharArrRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrStmt(MyParser.CharArrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrStmt(MyParser.CharArrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrReturnStmt(MyParser.CharArrReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrReturnStmt(MyParser.CharArrReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrCompoundStmt(MyParser.CharArrCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrCompoundStmt(MyParser.CharArrCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrSelectStmt(MyParser.CharArrSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrSelectStmt(MyParser.CharArrSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrIterStmt(MyParser.CharArrIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrIterStmt(MyParser.CharArrIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrRStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrRStmt(MyParser.FloatArrRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrRStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrRStmt(MyParser.FloatArrRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrRCompoundStmt(MyParser.FloatArrRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrRCompoundStmt(MyParser.FloatArrRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrStmt(MyParser.FloatArrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrStmt(MyParser.FloatArrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrReturnStmt(MyParser.FloatArrReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrReturnStmt(MyParser.FloatArrReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrCompoundStmt(MyParser.FloatArrCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrCompoundStmt(MyParser.FloatArrCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrSelectStmt(MyParser.FloatArrSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrSelectStmt(MyParser.FloatArrSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrIterStmt(MyParser.FloatArrIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrIterStmt(MyParser.FloatArrIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidRStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidRStmt(MyParser.VoidRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidRStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidRStmt(MyParser.VoidRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidStmt(MyParser.VoidStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidStmt(MyParser.VoidStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidReturnStmt(MyParser.VoidReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidReturnStmt(MyParser.VoidReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidCompoundStmt(MyParser.VoidCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidCompoundStmt(MyParser.VoidCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidSelectStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidSelectStmt(MyParser.VoidSelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidSelectStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidSelectStmt(MyParser.VoidSelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#voidIterStmt}.
	 * @param ctx the parse tree
	 */
	void enterVoidIterStmt(MyParser.VoidIterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#voidIterStmt}.
	 * @param ctx the parse tree
	 */
	void exitVoidIterStmt(MyParser.VoidIterStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpStmt(MyParser.ExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#expStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpStmt(MyParser.ExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(MyParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(MyParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#simpleExp}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExp(MyParser.SimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#simpleExp}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExp(MyParser.SimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpStmt(MyParser.BoolExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpStmt(MyParser.BoolExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntExpStmt(MyParser.IntExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntExpStmt(MyParser.IntExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharExpStmt(MyParser.CharExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharExpStmt(MyParser.CharExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpStmt(MyParser.FloatExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpStmt(MyParser.FloatExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrExpStmt(MyParser.BoolArrExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrExpStmt(MyParser.BoolArrExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterIntArrExpStmt(MyParser.IntArrExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitIntArrExpStmt(MyParser.IntArrExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterCharArrExpStmt(MyParser.CharArrExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitCharArrExpStmt(MyParser.CharArrExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrExpStmt(MyParser.FloatArrExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrExpStmt(MyParser.FloatArrExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolExp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(MyParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolExp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(MyParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterBoolSimpleExp(MyParser.BoolSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitBoolSimpleExp(MyParser.BoolSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#orExp}.
	 * @param ctx the parse tree
	 */
	void enterOrExp(MyParser.OrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#orExp}.
	 * @param ctx the parse tree
	 */
	void exitOrExp(MyParser.OrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#andExp}.
	 * @param ctx the parse tree
	 */
	void enterAndExp(MyParser.AndExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#andExp}.
	 * @param ctx the parse tree
	 */
	void exitAndExp(MyParser.AndExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#unaryRelExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryRelExp(MyParser.UnaryRelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#unaryRelExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryRelExp(MyParser.UnaryRelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(MyParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(MyParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MyParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MyParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(MyParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(MyParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#brelop}.
	 * @param ctx the parse tree
	 */
	void enterBrelop(MyParser.BrelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#brelop}.
	 * @param ctx the parse tree
	 */
	void exitBrelop(MyParser.BrelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intExp}.
	 * @param ctx the parse tree
	 */
	void enterIntExp(MyParser.IntExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intExp}.
	 * @param ctx the parse tree
	 */
	void exitIntExp(MyParser.IntExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterIntSimpleExp(MyParser.IntSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitIntSimpleExp(MyParser.IntSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#sumop}.
	 * @param ctx the parse tree
	 */
	void enterSumop(MyParser.SumopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#sumop}.
	 * @param ctx the parse tree
	 */
	void exitSumop(MyParser.SumopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intMulExp}.
	 * @param ctx the parse tree
	 */
	void enterIntMulExp(MyParser.IntMulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intMulExp}.
	 * @param ctx the parse tree
	 */
	void exitIntMulExp(MyParser.IntMulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(MyParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(MyParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intUnaryExp}.
	 * @param ctx the parse tree
	 */
	void enterIntUnaryExp(MyParser.IntUnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intUnaryExp}.
	 * @param ctx the parse tree
	 */
	void exitIntUnaryExp(MyParser.IntUnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intFactor}.
	 * @param ctx the parse tree
	 */
	void enterIntFactor(MyParser.IntFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intFactor}.
	 * @param ctx the parse tree
	 */
	void exitIntFactor(MyParser.IntFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(MyParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(MyParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MyParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MyParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#mutable}.
	 * @param ctx the parse tree
	 */
	void enterMutable(MyParser.MutableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#mutable}.
	 * @param ctx the parse tree
	 */
	void exitMutable(MyParser.MutableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatExp(MyParser.FloatExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatExp(MyParser.FloatExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatSimpleExp(MyParser.FloatSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatSimpleExp(MyParser.FloatSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatMulExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatMulExp(MyParser.FloatMulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatMulExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatMulExp(MyParser.FloatMulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatUnaryExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatUnaryExp(MyParser.FloatUnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatUnaryExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatUnaryExp(MyParser.FloatUnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatFactor}.
	 * @param ctx the parse tree
	 */
	void enterFloatFactor(MyParser.FloatFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatFactor}.
	 * @param ctx the parse tree
	 */
	void exitFloatFactor(MyParser.FloatFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charExp}.
	 * @param ctx the parse tree
	 */
	void enterCharExp(MyParser.CharExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charExp}.
	 * @param ctx the parse tree
	 */
	void exitCharExp(MyParser.CharExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterCharSimpleExp(MyParser.CharSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitCharSimpleExp(MyParser.CharSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrExp}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrExp(MyParser.BoolArrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrExp}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrExp(MyParser.BoolArrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#boolArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterBoolArrSimpleExp(MyParser.BoolArrSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#boolArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitBoolArrSimpleExp(MyParser.BoolArrSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrExp}.
	 * @param ctx the parse tree
	 */
	void enterIntArrExp(MyParser.IntArrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrExp}.
	 * @param ctx the parse tree
	 */
	void exitIntArrExp(MyParser.IntArrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#intArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterIntArrSimpleExp(MyParser.IntArrSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#intArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitIntArrSimpleExp(MyParser.IntArrSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrExp}.
	 * @param ctx the parse tree
	 */
	void enterCharArrExp(MyParser.CharArrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrExp}.
	 * @param ctx the parse tree
	 */
	void exitCharArrExp(MyParser.CharArrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#charArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterCharArrSimpleExp(MyParser.CharArrSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#charArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitCharArrSimpleExp(MyParser.CharArrSimpleExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrExp(MyParser.FloatArrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrExp(MyParser.FloatArrExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#floatArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterFloatArrSimpleExp(MyParser.FloatArrSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#floatArrSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitFloatArrSimpleExp(MyParser.FloatArrSimpleExpContext ctx);
}