package classFile;

import antlrGen.MyParser;
import antlrGen.MyParserBaseListener;
import info.CodeAttribute;
import info.Method2;
import info.Type;
import simulation.Stack;

import java.util.ArrayList;
import java.util.List;

public class MyListener extends MyParserBaseListener {
    Stack stack;
    ClassFile classFile = ClassFile.get();

    CodeAttribute currentFuncCode;

    @Override public void enterProgram(MyParser.ProgramContext ctx) {}
    @Override public void exitProgram(MyParser.ProgramContext ctx) {
        try {
            classFile.generateClassFile();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override public void enterFunDecl(MyParser.FunDeclContext ctx) {
        MyParser.ParamsContext params;
        Method2 m;
        String name;
        if(ctx.voidFunDecl()!=null){
            params = ctx.voidFunDecl().params();
            m = new Method2(new Type(0, 0));
            name = ctx.voidFunDecl().ID().getText();
        }
        else if(ctx.nonVoidFunDecl().sinVoidFunDecl() != null){
            params = ctx.nonVoidFunDecl().sinVoidFunDecl().params();
            m = new Method2(new Type(ctx.nonVoidFunDecl().sinVoidFunDecl().typeSpec().getText(), 0));
            name = ctx.nonVoidFunDecl().sinVoidFunDecl().ID().getText();
        }
        else{
            params = ctx.nonVoidFunDecl().arrVoidFunDecl().params();
            m = new Method2(new Type(ctx.nonVoidFunDecl().arrVoidFunDecl().typeSpec().getText(), 1));
            name = ctx.nonVoidFunDecl().arrVoidFunDecl().ID().getText();
        }


        List<String> argNames = new ArrayList<>();

        for(MyParser.ParamContext p : params.param()){
            if(p.sinParam()!= null){
                m.arguments.add(new Type(p.sinParam().typeSpec().getText(), 0));
                argNames.add(p.sinParam().ID().getText());
            }
            else{
                m.arguments.add(new Type(p.arrParam().typeSpec().getText(), 1));
                argNames.add(p.arrParam().ID().getText());
            }
        }

        stack = new Stack(argNames.toArray(new String[0]), m);

        try {
            currentFuncCode = classFile.createMethod(new byte[]{(byte) 0x00, (byte) 0x09}, name, m, argNames.toArray(new String[0]));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override public void exitFunDecl(MyParser.FunDeclContext ctx) {
        currentFuncCode.fillWithStack(stack);
    }

    @Override public void enterVarDeclInit(MyParser.VarDeclInitContext ctx) {
    }

    @Override public void exitVarDeclInit(MyParser.VarDeclInitContext ctx) {
        stack.addVar(ctx.varDeclId().ID().getText(), new Type(((MyParser.VarSinDeclContext)ctx.parent.parent).typeSpec().getText(), 0));
        if(ctx.ASSIGN()!=null){
            stack.storeVar(ctx.varDeclId().ID().getText());
        }
    }

    @Override public void exitArrDeclId(MyParser.ArrDeclIdContext ctx) {
        stack.addArr(ctx.ID().getText(),
                new Type(((MyParser.VarArrDeclContext)ctx.parent.parent.parent).typeSpec().getText(), 0));
    }

    /**
     * @see MyListener.exitArrDeclInit()
     * */
    @Override public void enterSimpleExp(MyParser.SimpleExpContext ctx) {
        if(ctx.parent instanceof MyParser.ArrDeclInitContext){
            MyParser.ArrDeclInitContext pa = (MyParser.ArrDeclInitContext) ctx.parent;
            stack.storeArrEnter(pa.arrDeclId().ID().getText());
            int pos = (pa.children.indexOf(ctx) - 3)/2;
            stack.getConstInt(pos);
        }
    }

    @Override public void exitSimpleExp(MyParser.SimpleExpContext ctx) {
        if(ctx.parent instanceof MyParser.ArrDeclInitContext){
            stack.storeArrExit();
        }
    }

    @Override public void exitNumSimpleExp(MyParser.NumSimpleExpContext ctx) {
        if(ctx.sumop()!=null){
            if(ctx.sumop().getText().equals("+")){
                stack.summation();
            }
            else{
                stack.subtraction();
            }
        }
    }

    @Override public void exitNumMulExp(MyParser.NumMulExpContext ctx) {
        if(ctx.mulop()!=null){
            if(ctx.mulop().getText().equals("*")){
                stack.multiplication();
            }
            else{
                stack.division();
            }
        }
    }

    @Override public void exitNumUnaryExp(MyParser.NumUnaryExpContext ctx) {
        if(ctx.MINUS()!=null){
            stack.minus();
        }
    }

    @Override public void enterNumFactor(MyParser.NumFactorContext ctx) {
        if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrEnter(ctx.ID().getText());
            }
        }
    }


    @Override public void exitNumFactor(MyParser.NumFactorContext ctx) {
        if(ctx.NUMCONST()!=null){
            stack.getConstInt(ctx.NUMCONST().getText());
        }
        else if(ctx.FLOATCONST()!=null){
            stack.getConstFloat(ctx.FLOATCONST().getText());
        }
        else if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrExit();
            }
            else{
                stack.getVar(ctx.ID().getText());
            }
        }
        else if(ctx.INT()!=null){
            stack.intConversion();
        }
        else if(ctx.FLOAT()!=null){
            stack.floatConversion();
        }

    }

    @Override public void exitNumExp(MyParser.NumExpContext ctx){
        if(ctx.INCREASE()!=null){
            stack.subtraction();
        }
        else if(ctx.DECREASE()!=null){
            stack.subtraction();
        }
        else if(ctx.SELFMULTIPLY()!=null){
            stack.multiplication();
        }
        else if(ctx.SELFDIVIDE()!=null){
            stack.division();
        }

        if(ctx.mutable()!=null){
            if(ctx.mutable().LSB()!=null){
                stack.storeArrExit();
            }
            else{
                stack.storeVar(ctx.mutable().ID().getText());
            }
        }
    }

    @Override public void exitBoolSimpleExp(MyParser.BoolSimpleExpContext ctx) {
        if(ctx.brelop()!=null){
            if(ctx.brelop().getText().equals("==")){
                stack.equals();
            }
            else{
                stack.notEquals();
            }
        }
    }

    @Override public void exitOrExp(MyParser.OrExpContext ctx) {
        if(ctx.OR()!=null){
            stack.orOp();
        }
    }

    @Override public void exitAndExp(MyParser.AndExpContext ctx) {
        if(ctx.AND()!=null){
            stack.andOp();
        }
    }

    @Override public void exitUnaryRelExp(MyParser.UnaryRelExpContext ctx) {
        if(ctx.NOT()!=null){
            stack.notOp();
        }
    }

    @Override public void enterRelExp(MyParser.RelExpContext ctx) {
        if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrEnter(ctx.ID().getText());
            }
        }
    }

    @Override public void exitRelExp(MyParser.RelExpContext ctx) {
        if(ctx.boolean_()!=null){
            stack.getConstBool(ctx.boolean_().getText());
        }
        else if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrExit();
            }
            else{
                stack.getVar(ctx.ID().getText());
            }
        }
        else if(ctx.BOOL()!=null){
            stack.boolConversion();
        }
    }

    @Override public void enterCharSimpleExp(MyParser.CharSimpleExpContext ctx){
        if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrEnter(ctx.ID().getText());
            }
        }
    }

    @Override public void exitCharSimpleExp(MyParser.CharSimpleExpContext ctx){
        if(ctx.CHARCONST()!=null){
            stack.getConstChar(ctx.CHARCONST().getText());
        }
        else if(ctx.ID()!=null){
            if(ctx.LSB()!=null){
                stack.getArrExit();
            }
            else{
                stack.getVar(ctx.ID().getText());
            }
        }
        else if(ctx.CHAR()!=null){
            stack.charConversion();
        }
    }

    @Override public void enterAssignExp (MyParser.AssignExpContext ctx){
        if(ctx.mutable().LSB()!=null){
            stack.storeArrEnter(ctx.mutable().ID().getText());
        }

    }

    @Override public void exitAssignExp (MyParser.AssignExpContext ctx){
        if(ctx.mutable().LSB()!=null){
            stack.storeArrExit();
        }
        else{
            stack.storeVar(ctx.mutable().ID().getText());
        }
    }

    @Override public void exitCall(MyParser.CallContext ctx){
        stack.call(ctx.ID().getText());
    }

    @Override public void enterMutable(MyParser.MutableContext ctx){
        if(ctx.parent instanceof MyParser.SimpleExpContext){
            if(ctx.LSB()!=null){
                stack.getArrEnter(ctx.ID().getText());
            }
        }

        if(ctx.parent instanceof MyParser.NumExpContext){
            stack.getVar(ctx.ID().getText());
        }
    }

    @Override public void exitMutable(MyParser.MutableContext ctx){
        if(ctx.parent instanceof MyParser.SimpleExpContext){
            if(ctx.LSB()!=null){
                stack.getArrExit();
            }
            else{
                stack.getVar(ctx.ID().getText());
            }
        }

        if(ctx.parent instanceof MyParser.NumExpContext){
            if(ctx.LSB()!=null){
                stack.dup2();
                stack.getArrExit();
            }
        }
    }

}
