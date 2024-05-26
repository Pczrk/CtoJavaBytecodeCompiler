package antlrGen;
// Generated from MyParser.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link MyParser#varSinDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarSinDecl(MyParser.VarSinDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varSinDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarSinDecl(MyParser.VarSinDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#varArrDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarArrDecl(MyParser.VarArrDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varArrDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarArrDecl(MyParser.VarArrDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpec(MyParser.TypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpec(MyParser.TypeSpecContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclList(MyParser.VarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclList(MyParser.VarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arrDeclList}.
	 * @param ctx the parse tree
	 */
	void enterArrDeclList(MyParser.ArrDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arrDeclList}.
	 * @param ctx the parse tree
	 */
	void exitArrDeclList(MyParser.ArrDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#varDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclInit(MyParser.VarDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#varDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclInit(MyParser.VarDeclInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arrDeclInit}.
	 * @param ctx the parse tree
	 */
	void enterArrDeclInit(MyParser.ArrDeclInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arrDeclInit}.
	 * @param ctx the parse tree
	 */
	void exitArrDeclInit(MyParser.ArrDeclInitContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#nonVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidFunDecl(MyParser.NonVoidFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#nonVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidFunDecl(MyParser.NonVoidFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#sinVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterSinVoidFunDecl(MyParser.SinVoidFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#sinVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitSinVoidFunDecl(MyParser.SinVoidFunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arrVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrVoidFunDecl(MyParser.ArrVoidFunDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arrVoidFunDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrVoidFunDecl(MyParser.ArrVoidFunDeclContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#sinParam}.
	 * @param ctx the parse tree
	 */
	void enterSinParam(MyParser.SinParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#sinParam}.
	 * @param ctx the parse tree
	 */
	void exitSinParam(MyParser.SinParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#arrParam}.
	 * @param ctx the parse tree
	 */
	void enterArrParam(MyParser.ArrParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#arrParam}.
	 * @param ctx the parse tree
	 */
	void exitArrParam(MyParser.ArrParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#nonVoidRStmt}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidRStmt(MyParser.NonVoidRStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#nonVoidRStmt}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidRStmt(MyParser.NonVoidRStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#nonVoidRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidRCompoundStmt(MyParser.NonVoidRCompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#nonVoidRCompoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidRCompoundStmt(MyParser.NonVoidRCompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MyParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MyParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#nonVoidReturnStmt}.
	 * @param ctx the parse tree
	 */
	void enterNonVoidReturnStmt(MyParser.NonVoidReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#nonVoidReturnStmt}.
	 * @param ctx the parse tree
	 */
	void exitNonVoidReturnStmt(MyParser.NonVoidReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStmt(MyParser.CompoundStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#compoundStmt}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStmt(MyParser.CompoundStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectStmt(MyParser.SelectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#selectStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectStmt(MyParser.SelectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#iterStmt}.
	 * @param ctx the parse tree
	 */
	void enterIterStmt(MyParser.IterStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#iterStmt}.
	 * @param ctx the parse tree
	 */
	void exitIterStmt(MyParser.IterStmtContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#numExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterNumExpStmt(MyParser.NumExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitNumExpStmt(MyParser.NumExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#assignExpStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpStmt(MyParser.AssignExpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#assignExpStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpStmt(MyParser.AssignExpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#printf}.
	 * @param ctx the parse tree
	 */
	void enterPrintf(MyParser.PrintfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#printf}.
	 * @param ctx the parse tree
	 */
	void exitPrintf(MyParser.PrintfContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#numExp}.
	 * @param ctx the parse tree
	 */
	void enterNumExp(MyParser.NumExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numExp}.
	 * @param ctx the parse tree
	 */
	void exitNumExp(MyParser.NumExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#numSimpleExp}.
	 * @param ctx the parse tree
	 */
	void enterNumSimpleExp(MyParser.NumSimpleExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numSimpleExp}.
	 * @param ctx the parse tree
	 */
	void exitNumSimpleExp(MyParser.NumSimpleExpContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#numMulExp}.
	 * @param ctx the parse tree
	 */
	void enterNumMulExp(MyParser.NumMulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numMulExp}.
	 * @param ctx the parse tree
	 */
	void exitNumMulExp(MyParser.NumMulExpContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#numUnaryExp}.
	 * @param ctx the parse tree
	 */
	void enterNumUnaryExp(MyParser.NumUnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numUnaryExp}.
	 * @param ctx the parse tree
	 */
	void exitNumUnaryExp(MyParser.NumUnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#numFactor}.
	 * @param ctx the parse tree
	 */
	void enterNumFactor(MyParser.NumFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#numFactor}.
	 * @param ctx the parse tree
	 */
	void exitNumFactor(MyParser.NumFactorContext ctx);
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
	 * Enter a parse tree produced by {@link MyParser#assignExp}.
	 * @param ctx the parse tree
	 */
	void enterAssignExp(MyParser.AssignExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#assignExp}.
	 * @param ctx the parse tree
	 */
	void exitAssignExp(MyParser.AssignExpContext ctx);
}