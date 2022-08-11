import ast.listeners.BaseListener;
import ast.nodes.AbstractNode;
import ast.nodes.controllerNodes.Controller;
import ast.nodes.pageNodes.Page;
import ast.visitors.BaseVisitor;
import generated.LanguageLexer;
import generated.LanguageParser;
import helpers.CodeGeneratorHelper;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import symbolTable.SymbolTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Compiler {

//	static String filePath = "samples/login_register_posts.blaze";
	static String filePath = "samples/authentication_authorization_tests.blaze";
	static String ASTPath = "AST.txt";
	static String ErrorFilePath="errors.txt";


	public static void main(String[] argv) {
		CharStream cs;
		SymbolTable symbolTable =new SymbolTable();
		final ArrayList<String> errorMessages = new ArrayList<>();
		ArrayList<Page> pageNodes=new ArrayList<>();
		ArrayList<Controller> controllerNodes=new ArrayList<>();
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
			BaseVisitor visitor = new BaseVisitor(symbolTable,errorMessages,pageNodes,controllerNodes);
			AbstractNode document = (AbstractNode) visitor.visit(parseTree);
			//base listener
			ParseTreeWalker walker = new ParseTreeWalker();
			BaseListener listener = new BaseListener(symbolTable,errorMessages);
			walker.walk(listener,parseTree);
			FileWriter resultFile = new FileWriter(ASTPath);
			resultFile.write(document.toString());
			resultFile.close();
			//printing errors
			if(!errorMessages.isEmpty()) {
				FileWriter errorFile = new FileWriter(ErrorFilePath);
				System.err.println("Found Errors:");
				for (String errorMessage : errorMessages) {
					errorFile.write(errorMessage);
					errorFile.write("\n");
					System.err.println(errorMessage);
				}
				errorFile.close();
			}
			//code generation if there are no errors
			if(errorMessages.isEmpty()){
				for (Page page:pageNodes) {
					//make new html file
					String fileName="generatedCode/"+page.getId()+".php";
					File file = new File(fileName); //initialize File object and passing path as argument
					file.createNewFile();
					FileWriter htmlFile = new FileWriter(fileName);
					//generate code
					htmlFile.write(page.toHtmlCode());
					htmlFile.close();
				}
				//generate php helper files and methods
				CodeGeneratorHelper.generateControllersMutualFiles();
				for (Controller controller:controllerNodes) {
					//make new php file
					String fileName="generatedCode/"+controller.getId()+".php";
					File file = new File(fileName); //initialize File object and passing path as argument
					file.createNewFile();
					FileWriter phpFile = new FileWriter(fileName);
					//generate code
					phpFile.write(controller.toPhpCode());
					phpFile.close();
				}
				System.out.println("code files has been generated :)");
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}