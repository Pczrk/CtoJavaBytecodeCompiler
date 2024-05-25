import antlrGen.MyParserBaseListener;
import antlrGen.MyParserListener;
import descriptor.FieldDescriptor;
import descriptor.MethodDescriptor;
import antlrGen.MyLexer;
import antlrGen.MyParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            MyLexer lexer = new MyLexer(new ANTLRFileStream("data/program.c"));
            TokenStream tokens = new CommonTokenStream(lexer);

            MyParser parser = new MyParser(tokens);

            MyParser.ProgramContext myContext = parser.program();;

            ParseTreeWalker walker = new ParseTreeWalker();
            MyParserListener listener = new MyParserBaseListener();
            walker.walk(listener, myContext);
        }
        catch(IOException ignored){}
    }
}