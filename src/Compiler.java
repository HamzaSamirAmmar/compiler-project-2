import ast.listeners.BaseListener;
import ast.nodes.AbstractNode;
import ast.visitors.BaseVisitor;
import generated.LanguageLexer;
import generated.LanguageParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import symbolTable.SymbolTable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Compiler {

	static String filePath = "language syntax.txt";
	static String ASTPath = "AST.txt";
	static String ErrorFilePath="errors.txt";

	
	public static void main(String[] argv) {
		CharStream cs;
		SymbolTable symbolTable =new SymbolTable();
		final ArrayList<String> errorMessages = new ArrayList<>();
		try {
			cs = CharStreams.fromFileName(filePath);
			LanguageLexer lexer = new LanguageLexer(cs);
			CommonTokenStream cts = new CommonTokenStream(lexer);
			LanguageParser parser = new LanguageParser(cts);
			parser.removeErrorListeners();
			parser.addErrorListener(new BaseErrorListener(){
				@Override
				public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
					errorMessages.add("line "+line+" at column "+charPositionInLine+": "+msg);
				}
			});
			//base visitor
			ParseTree parseTree = parser.program();
			BaseVisitor visitor = new BaseVisitor(symbolTable,errorMessages);
			AbstractNode document = (AbstractNode) visitor.visit(parseTree);
			//base listener
			ParseTreeWalker walker = new ParseTreeWalker();
			BaseListener listener = new BaseListener(symbolTable,errorMessages);
			walker.walk(listener,parseTree);
			FileWriter resultFile = new FileWriter(ASTPath);
			resultFile.write(document.toString());
			resultFile.close();
			//printing errors
			System.err.println("errorMessages: " + errorMessages);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
