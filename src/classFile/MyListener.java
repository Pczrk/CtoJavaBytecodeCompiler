package classFile;

import antlrGen.MyParser;
import antlrGen.MyParserBaseListener;
import info.Method2;
import info.Type;
import simulation.Stack;

import java.util.ArrayList;
import java.util.List;

public class MyListener extends MyParserBaseListener {
    Stack stack;
    ClassFile classFile = ClassFile.get();
    @Override public void enterFunDecl(MyParser.FunDeclContext ctx) {
        MyParser.ParamsContext params;
        Method2 m;
        if(ctx.voidFunDecl()!=null){
            params = ctx.voidFunDecl().params();
            m = new Method2(new Type(0, 0));
        }
        else if(ctx.nonVoidFunDecl().sinVoidFunDecl() != null){
            params = ctx.nonVoidFunDecl().sinVoidFunDecl().params();
            m = new Method2(new Type(ctx.nonVoidFunDecl().sinVoidFunDecl().typeSpec().getText(), 0));
        }
        else{
            params = ctx.nonVoidFunDecl().arrVoidFunDecl().params();
            m = new Method2(new Type(ctx.nonVoidFunDecl().sinVoidFunDecl().typeSpec().getText(), 1));
        }

        List<String> argNames = new ArrayList<>();

        for(MyParser.ParamContext p : params.param()){
            if(p.sinParam()!= null){
                m.arguments.add(new Type(p.sinParam().typeSpec().getText(), 0));
                argNames.add(p.sinParam().ID().getText());
            }
            else{
                m.arguments.add(new Type(p.arrParam().typeSpec().getText(), 0));
                argNames.add(p.arrParam().ID().getText());
            }
        }

        stack = new Stack(argNames.toArray(new String[0]), m);

    }
    @Override public void exitFunDecl(MyParser.FunDeclContext ctx) { }


}
