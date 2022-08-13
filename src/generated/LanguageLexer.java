// Generated from F:/Programming/compiler/compiler 22_6/codeGenerationVersion/grammers\LanguageLexer.g4 by ANTLR 4.9.1
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PAGE=1, CONTROLLER=2, EXTENDS=3, CONTROLES=4, HEAD=5, IF=6, CHECK_AUTH=7, 
		CHECK_VALID=8, CHECK_ROLE=9, REDIRECT=10, TEXT=11, IMAGE=12, SEMI_COLON=13, 
		LIST=14, TABLE=15, BUTTON=16, HEADER=17, BODY=18, BOOLEAN=19, CASE=20, 
		METHOD=21, DEFAULT=22, FORM=23, TEXT_FIELD=24, DATE=25, CHECKBOX=26, SELCTION=27, 
		RADIO=28, SWITCH=29, LINK=30, AT_AUTH=31, AT_GUEST=32, AT_ROLE=33, AT_INVERSE_ROLE=34, 
		AT_RAW_PHP=35, AT_SECTION=36, AT_YIELD=37, FOR=38, ELSE=39, AT_END_AUTH=40, 
		AT_END_GUEST=41, AT_END_ROLE=42, AT_END_INVERSE_ROLE=43, AT_END_SECTION=44, 
		SHARED_DATA=45, FORM_DATA=46, BRACKET_OPEN=47, BRACKET_CLOSE=48, SQUARE_OPEN=49, 
		SQUARE_CLOSE=50, CURLEY_BRACKET_OPEN=51, CURLEY_BRACKET_CLOSE=52, COMMA=53, 
		COLON=54, OPERATOR_TWO_OPERAND=55, CONDITIONAL_CONCAT_OPERATOR=56, ONE_LOGICAL_OPERAND=57, 
		ONE_VALUABLE_OPERAND=58, ADDITIVE_OPERATOR=59, MULTIPLICATIVE_OPERATOR=60, 
		EQUAL=61, AT=62, ARROW=63, ID=64, WHITESPACE=65, DECIMAL=66, HEXCHARS=67, 
		STRING=68, CHAR=69, AT_END_RAW_PHP=70;
	public static final int
		PHP=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "PHP"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PAGE", "CONTROLLER", "EXTENDS", "CONTROLES", "HEAD", "IF", "CHECK_AUTH", 
			"CHECK_VALID", "CHECK_ROLE", "REDIRECT", "TEXT", "IMAGE", "SEMI_COLON", 
			"LIST", "TABLE", "BUTTON", "HEADER", "BODY", "BOOLEAN", "CASE", "METHOD", 
			"DEFAULT", "FORM", "TEXT_FIELD", "DATE", "CHECKBOX", "SELCTION", "RADIO", 
			"SWITCH", "LINK", "AT_AUTH", "AT_GUEST", "AT_ROLE", "AT_INVERSE_ROLE", 
			"AT_RAW_PHP", "AT_SECTION", "AT_YIELD", "FOR", "ELSE", "AT_END_AUTH", 
			"AT_END_GUEST", "AT_END_ROLE", "AT_END_INVERSE_ROLE", "AT_END_SECTION", 
			"SHARED_DATA", "FORM_DATA", "BRACKET_OPEN", "BRACKET_CLOSE", "SQUARE_OPEN", 
			"SQUARE_CLOSE", "CURLEY_BRACKET_OPEN", "CURLEY_BRACKET_CLOSE", "COMMA", 
			"COLON", "OPERATOR_TWO_OPERAND", "CONDITIONAL_CONCAT_OPERATOR", "ONE_LOGICAL_OPERAND", 
			"ONE_VALUABLE_OPERAND", "ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", 
			"EQUAL", "AT", "ARROW", "ID", "WHITESPACE", "DECIMAL", "HEXCHARS", "STRING", 
			"CHAR", "AT_END_RAW_PHP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'page'", "'controller'", "'extends'", "'controles'", "'head'", 
			"'if'", "'checkAuthenticated'", "'checkValid'", "'checkRole'", "'redirect'", 
			"'text'", "'image'", "';'", "'list'", "'table'", "'button'", "'header'", 
			"'body'", null, "'case'", null, "'dafaultl'", "'form'", "'textField'", 
			"'date'", "'checkbox'", "'selection'", "'radio'", "'switch'", "'link'", 
			"'@auth'", "'@guest'", "'@role'", "'@inverserole'", "'@rawphp'", "'@section'", 
			"'@yield'", "'for'", null, "'@endauth'", "'@endguest'", "'@endrole'", 
			"'@endinverserole'", "'@endsection'", "'shared_data'", "'form_data'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "','", "':'", null, null, "'!'", 
			null, null, null, "'='", "'@'", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PAGE", "CONTROLLER", "EXTENDS", "CONTROLES", "HEAD", "IF", "CHECK_AUTH", 
			"CHECK_VALID", "CHECK_ROLE", "REDIRECT", "TEXT", "IMAGE", "SEMI_COLON", 
			"LIST", "TABLE", "BUTTON", "HEADER", "BODY", "BOOLEAN", "CASE", "METHOD", 
			"DEFAULT", "FORM", "TEXT_FIELD", "DATE", "CHECKBOX", "SELCTION", "RADIO", 
			"SWITCH", "LINK", "AT_AUTH", "AT_GUEST", "AT_ROLE", "AT_INVERSE_ROLE", 
			"AT_RAW_PHP", "AT_SECTION", "AT_YIELD", "FOR", "ELSE", "AT_END_AUTH", 
			"AT_END_GUEST", "AT_END_ROLE", "AT_END_INVERSE_ROLE", "AT_END_SECTION", 
			"SHARED_DATA", "FORM_DATA", "BRACKET_OPEN", "BRACKET_CLOSE", "SQUARE_OPEN", 
			"SQUARE_CLOSE", "CURLEY_BRACKET_OPEN", "CURLEY_BRACKET_CLOSE", "COMMA", 
			"COLON", "OPERATOR_TWO_OPERAND", "CONDITIONAL_CONCAT_OPERATOR", "ONE_LOGICAL_OPERAND", 
			"ONE_VALUABLE_OPERAND", "ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", 
			"EQUAL", "AT", "ARROW", "ID", "WHITESPACE", "DECIMAL", "HEXCHARS", "STRING", 
			"CHAR", "AT_END_RAW_PHP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LanguageLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2H\u02a9\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0129\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0150\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u01db\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\38\38\38\38\38\58\u0242\n8\39\39\39\39\59\u0248\n9\3:\3"+
		":\3;\3;\3;\3;\5;\u0250\n;\3<\3<\3<\3<\3<\5<\u0257\n<\3=\3=\3=\3=\3=\3"+
		"=\3=\5=\u0260\n=\3>\3>\3?\3?\3@\3@\3@\3A\3A\7A\u026b\nA\fA\16A\u026e\13"+
		"A\3B\3B\3B\3B\3C\6C\u0275\nC\rC\16C\u0276\3D\3D\6D\u027b\nD\rD\16D\u027c"+
		"\3E\3E\7E\u0281\nE\fE\16E\u0284\13E\3E\3E\3E\7E\u0289\nE\fE\16E\u028c"+
		"\13E\3E\5E\u028f\nE\3F\3F\5F\u0293\nF\3F\3F\3G\7G\u0298\nG\fG\16G\u029b"+
		"\13G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3\u0299\2H\4\3\6\4\b\5\n\6"+
		"\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24"+
		"(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37> @!B\"D#F$H%J&L\'"+
		"N(P)R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8p9r:t;v<x=z>|?~@\u0080"+
		"A\u0082B\u0084C\u0086D\u0088E\u008aF\u008cG\u008eH\4\2\3\r\4\2>>@@\4\2"+
		"--//\5\2\'\',,\61\61\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\3\2"+
		"\62;\5\2\62;CHch\4\2$$>>\4\2))>>\13\2\"\"%%-/\61=??AAC\\aac|\2\u02c3\2"+
		"\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2"+
		"\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2"+
		"\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2"+
		"\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2"+
		"\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2"+
		"\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2"+
		"J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3"+
		"\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2"+
		"\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n\3\2\2\2"+
		"\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2\2\2\2|"+
		"\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2\2\2\2"+
		"\u0086\3\2\2\2\2\u0088\3\2\2\2\2\u008a\3\2\2\2\2\u008c\3\2\2\2\3\u008e"+
		"\3\2\2\2\4\u0090\3\2\2\2\6\u0095\3\2\2\2\b\u00a0\3\2\2\2\n\u00a8\3\2\2"+
		"\2\f\u00b2\3\2\2\2\16\u00b7\3\2\2\2\20\u00ba\3\2\2\2\22\u00cd\3\2\2\2"+
		"\24\u00d8\3\2\2\2\26\u00e2\3\2\2\2\30\u00eb\3\2\2\2\32\u00f0\3\2\2\2\34"+
		"\u00f6\3\2\2\2\36\u00f8\3\2\2\2 \u00fd\3\2\2\2\"\u0103\3\2\2\2$\u010a"+
		"\3\2\2\2&\u0111\3\2\2\2(\u0128\3\2\2\2*\u012a\3\2\2\2,\u014f\3\2\2\2."+
		"\u0151\3\2\2\2\60\u015a\3\2\2\2\62\u015f\3\2\2\2\64\u0169\3\2\2\2\66\u016e"+
		"\3\2\2\28\u0177\3\2\2\2:\u0181\3\2\2\2<\u0187\3\2\2\2>\u018e\3\2\2\2@"+
		"\u0193\3\2\2\2B\u0199\3\2\2\2D\u01a0\3\2\2\2F\u01a6\3\2\2\2H\u01b3\3\2"+
		"\2\2J\u01bd\3\2\2\2L\u01c6\3\2\2\2N\u01cd\3\2\2\2P\u01da\3\2\2\2R\u01dc"+
		"\3\2\2\2T\u01e5\3\2\2\2V\u01ef\3\2\2\2X\u01f8\3\2\2\2Z\u0208\3\2\2\2\\"+
		"\u0214\3\2\2\2^\u0220\3\2\2\2`\u022a\3\2\2\2b\u022c\3\2\2\2d\u022e\3\2"+
		"\2\2f\u0230\3\2\2\2h\u0232\3\2\2\2j\u0234\3\2\2\2l\u0236\3\2\2\2n\u0238"+
		"\3\2\2\2p\u0241\3\2\2\2r\u0247\3\2\2\2t\u0249\3\2\2\2v\u024f\3\2\2\2x"+
		"\u0256\3\2\2\2z\u025f\3\2\2\2|\u0261\3\2\2\2~\u0263\3\2\2\2\u0080\u0265"+
		"\3\2\2\2\u0082\u0268\3\2\2\2\u0084\u026f\3\2\2\2\u0086\u0274\3\2\2\2\u0088"+
		"\u0278\3\2\2\2\u008a\u028e\3\2\2\2\u008c\u0290\3\2\2\2\u008e\u0299\3\2"+
		"\2\2\u0090\u0091\7r\2\2\u0091\u0092\7c\2\2\u0092\u0093\7i\2\2\u0093\u0094"+
		"\7g\2\2\u0094\5\3\2\2\2\u0095\u0096\7e\2\2\u0096\u0097\7q\2\2\u0097\u0098"+
		"\7p\2\2\u0098\u0099\7v\2\2\u0099\u009a\7t\2\2\u009a\u009b\7q\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e\u009f\7t\2\2"+
		"\u009f\7\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7z\2\2\u00a2\u00a3\7v"+
		"\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7f\2\2\u00a6\u00a7"+
		"\7u\2\2\u00a7\t\3\2\2\2\u00a8\u00a9\7e\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab"+
		"\7p\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7q\2\2\u00ae"+
		"\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7u\2\2\u00b1\13\3\2\2\2\u00b2"+
		"\u00b3\7j\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7f\2\2"+
		"\u00b6\r\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7h\2\2\u00b9\17\3\2\2"+
		"\2\u00ba\u00bb\7e\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7e\2\2\u00be\u00bf\7m\2\2\u00bf\u00c0\7C\2\2\u00c0\u00c1\7w\2\2\u00c1"+
		"\u00c2\7v\2\2\u00c2\u00c3\7j\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7p\2\2"+
		"\u00c5\u00c6\7v\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9"+
		"\7c\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7f\2\2\u00cc"+
		"\21\3\2\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"\u00d1\7e\2\2\u00d1\u00d2\7m\2\2\u00d2\u00d3\7X\2\2\u00d3\u00d4\7c\2\2"+
		"\u00d4\u00d5\7n\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7f\2\2\u00d7\23\3\2"+
		"\2\2\u00d8\u00d9\7e\2\2\u00d9\u00da\7j\2\2\u00da\u00db\7g\2\2\u00db\u00dc"+
		"\7e\2\2\u00dc\u00dd\7m\2\2\u00dd\u00de\7T\2\2\u00de\u00df\7q\2\2\u00df"+
		"\u00e0\7n\2\2\u00e0\u00e1\7g\2\2\u00e1\25\3\2\2\2\u00e2\u00e3\7t\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4\u00e5\7f\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7t\2\2"+
		"\u00e7\u00e8\7g\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7v\2\2\u00ea\27\3\2"+
		"\2\2\u00eb\u00ec\7v\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7z\2\2\u00ee\u00ef"+
		"\7v\2\2\u00ef\31\3\2\2\2\u00f0\u00f1\7k\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3"+
		"\7c\2\2\u00f3\u00f4\7i\2\2\u00f4\u00f5\7g\2\2\u00f5\33\3\2\2\2\u00f6\u00f7"+
		"\7=\2\2\u00f7\35\3\2\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb"+
		"\7u\2\2\u00fb\u00fc\7v\2\2\u00fc\37\3\2\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff"+
		"\7c\2\2\u00ff\u0100\7d\2\2\u0100\u0101\7n\2\2\u0101\u0102\7g\2\2\u0102"+
		"!\3\2\2\2\u0103\u0104\7d\2\2\u0104\u0105\7w\2\2\u0105\u0106\7v\2\2\u0106"+
		"\u0107\7v\2\2\u0107\u0108\7q\2\2\u0108\u0109\7p\2\2\u0109#\3\2\2\2\u010a"+
		"\u010b\7j\2\2\u010b\u010c\7g\2\2\u010c\u010d\7c\2\2\u010d\u010e\7f\2\2"+
		"\u010e\u010f\7g\2\2\u010f\u0110\7t\2\2\u0110%\3\2\2\2\u0111\u0112\7d\2"+
		"\2\u0112\u0113\7q\2\2\u0113\u0114\7f\2\2\u0114\u0115\7{\2\2\u0115\'\3"+
		"\2\2\2\u0116\u0117\7V\2\2\u0117\u0118\7T\2\2\u0118\u0119\7W\2\2\u0119"+
		"\u0129\7G\2\2\u011a\u011b\7H\2\2\u011b\u011c\7C\2\2\u011c\u011d\7N\2\2"+
		"\u011d\u011e\7U\2\2\u011e\u0129\7G\2\2\u011f\u0120\7v\2\2\u0120\u0121"+
		"\7t\2\2\u0121\u0122\7w\2\2\u0122\u0129\7g\2\2\u0123\u0124\7h\2\2\u0124"+
		"\u0125\7c\2\2\u0125\u0126\7n\2\2\u0126\u0127\7u\2\2\u0127\u0129\7g\2\2"+
		"\u0128\u0116\3\2\2\2\u0128\u011a\3\2\2\2\u0128\u011f\3\2\2\2\u0128\u0123"+
		"\3\2\2\2\u0129)\3\2\2\2\u012a\u012b\7e\2\2\u012b\u012c\7c\2\2\u012c\u012d"+
		"\7u\2\2\u012d\u012e\7g\2\2\u012e+\3\2\2\2\u012f\u0130\7r\2\2\u0130\u0131"+
		"\7q\2\2\u0131\u0132\7u\2\2\u0132\u0150\7v\2\2\u0133\u0134\7f\2\2\u0134"+
		"\u0135\7g\2\2\u0135\u0136\7n\2\2\u0136\u0137\7g\2\2\u0137\u0138\7v\2\2"+
		"\u0138\u0150\7g\2\2\u0139\u013a\7i\2\2\u013a\u013b\7g\2\2\u013b\u0150"+
		"\7v\2\2\u013c\u013d\7r\2\2\u013d\u013e\7w\2\2\u013e\u0150\7v\2\2\u013f"+
		"\u0140\7R\2\2\u0140\u0141\7Q\2\2\u0141\u0142\7U\2\2\u0142\u0150\7V\2\2"+
		"\u0143\u0144\7I\2\2\u0144\u0145\7G\2\2\u0145\u0150\7V\2\2\u0146\u0147"+
		"\7F\2\2\u0147\u0148\7G\2\2\u0148\u0149\7N\2\2\u0149\u014a\7G\2\2\u014a"+
		"\u014b\7V\2\2\u014b\u0150\7G\2\2\u014c\u014d\7R\2\2\u014d\u014e\7W\2\2"+
		"\u014e\u0150\7V\2\2\u014f\u012f\3\2\2\2\u014f\u0133\3\2\2\2\u014f\u0139"+
		"\3\2\2\2\u014f\u013c\3\2\2\2\u014f\u013f\3\2\2\2\u014f\u0143\3\2\2\2\u014f"+
		"\u0146\3\2\2\2\u014f\u014c\3\2\2\2\u0150-\3\2\2\2\u0151\u0152\7f\2\2\u0152"+
		"\u0153\7c\2\2\u0153\u0154\7h\2\2\u0154\u0155\7c\2\2\u0155\u0156\7w\2\2"+
		"\u0156\u0157\7n\2\2\u0157\u0158\7v\2\2\u0158\u0159\7n\2\2\u0159/\3\2\2"+
		"\2\u015a\u015b\7h\2\2\u015b\u015c\7q\2\2\u015c\u015d\7t\2\2\u015d\u015e"+
		"\7o\2\2\u015e\61\3\2\2\2\u015f\u0160\7v\2\2\u0160\u0161\7g\2\2\u0161\u0162"+
		"\7z\2\2\u0162\u0163\7v\2\2\u0163\u0164\7H\2\2\u0164\u0165\7k\2\2\u0165"+
		"\u0166\7g\2\2\u0166\u0167\7n\2\2\u0167\u0168\7f\2\2\u0168\63\3\2\2\2\u0169"+
		"\u016a\7f\2\2\u016a\u016b\7c\2\2\u016b\u016c\7v\2\2\u016c\u016d\7g\2\2"+
		"\u016d\65\3\2\2\2\u016e\u016f\7e\2\2\u016f\u0170\7j\2\2\u0170\u0171\7"+
		"g\2\2\u0171\u0172\7e\2\2\u0172\u0173\7m\2\2\u0173\u0174\7d\2\2\u0174\u0175"+
		"\7q\2\2\u0175\u0176\7z\2\2\u0176\67\3\2\2\2\u0177\u0178\7u\2\2\u0178\u0179"+
		"\7g\2\2\u0179\u017a\7n\2\2\u017a\u017b\7g\2\2\u017b\u017c\7e\2\2\u017c"+
		"\u017d\7v\2\2\u017d\u017e\7k\2\2\u017e\u017f\7q\2\2\u017f\u0180\7p\2\2"+
		"\u01809\3\2\2\2\u0181\u0182\7t\2\2\u0182\u0183\7c\2\2\u0183\u0184\7f\2"+
		"\2\u0184\u0185\7k\2\2\u0185\u0186\7q\2\2\u0186;\3\2\2\2\u0187\u0188\7"+
		"u\2\2\u0188\u0189\7y\2\2\u0189\u018a\7k\2\2\u018a\u018b\7v\2\2\u018b\u018c"+
		"\7e\2\2\u018c\u018d\7j\2\2\u018d=\3\2\2\2\u018e\u018f\7n\2\2\u018f\u0190"+
		"\7k\2\2\u0190\u0191\7p\2\2\u0191\u0192\7m\2\2\u0192?\3\2\2\2\u0193\u0194"+
		"\7B\2\2\u0194\u0195\7c\2\2\u0195\u0196\7w\2\2\u0196\u0197\7v\2\2\u0197"+
		"\u0198\7j\2\2\u0198A\3\2\2\2\u0199\u019a\7B\2\2\u019a\u019b\7i\2\2\u019b"+
		"\u019c\7w\2\2\u019c\u019d\7g\2\2\u019d\u019e\7u\2\2\u019e\u019f\7v\2\2"+
		"\u019fC\3\2\2\2\u01a0\u01a1\7B\2\2\u01a1\u01a2\7t\2\2\u01a2\u01a3\7q\2"+
		"\2\u01a3\u01a4\7n\2\2\u01a4\u01a5\7g\2\2\u01a5E\3\2\2\2\u01a6\u01a7\7"+
		"B\2\2\u01a7\u01a8\7k\2\2\u01a8\u01a9\7p\2\2\u01a9\u01aa\7x\2\2\u01aa\u01ab"+
		"\7g\2\2\u01ab\u01ac\7t\2\2\u01ac\u01ad\7u\2\2\u01ad\u01ae\7g\2\2\u01ae"+
		"\u01af\7t\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1\7n\2\2\u01b1\u01b2\7g\2\2"+
		"\u01b2G\3\2\2\2\u01b3\u01b4\7B\2\2\u01b4\u01b5\7t\2\2\u01b5\u01b6\7c\2"+
		"\2\u01b6\u01b7\7y\2\2\u01b7\u01b8\7r\2\2\u01b8\u01b9\7j\2\2\u01b9\u01ba"+
		"\7r\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\b$\2\2\u01bcI\3\2\2\2\u01bd\u01be"+
		"\7B\2\2\u01be\u01bf\7u\2\2\u01bf\u01c0\7g\2\2\u01c0\u01c1\7e\2\2\u01c1"+
		"\u01c2\7v\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4\7q\2\2\u01c4\u01c5\7p\2\2"+
		"\u01c5K\3\2\2\2\u01c6\u01c7\7B\2\2\u01c7\u01c8\7{\2\2\u01c8\u01c9\7k\2"+
		"\2\u01c9\u01ca\7g\2\2\u01ca\u01cb\7n\2\2\u01cb\u01cc\7f\2\2\u01ccM\3\2"+
		"\2\2\u01cd\u01ce\7h\2\2\u01ce\u01cf\7q\2\2\u01cf\u01d0\7t\2\2\u01d0O\3"+
		"\2\2\2\u01d1\u01d2\7B\2\2\u01d2\u01d3\7g\2\2\u01d3\u01d4\7n\2\2\u01d4"+
		"\u01d5\7u\2\2\u01d5\u01db\7g\2\2\u01d6\u01d7\7g\2\2\u01d7\u01d8\7n\2\2"+
		"\u01d8\u01d9\7u\2\2\u01d9\u01db\7g\2\2\u01da\u01d1\3\2\2\2\u01da\u01d6"+
		"\3\2\2\2\u01dbQ\3\2\2\2\u01dc\u01dd\7B\2\2\u01dd\u01de\7g\2\2\u01de\u01df"+
		"\7p\2\2\u01df\u01e0\7f\2\2\u01e0\u01e1\7c\2\2\u01e1\u01e2\7w\2\2\u01e2"+
		"\u01e3\7v\2\2\u01e3\u01e4\7j\2\2\u01e4S\3\2\2\2\u01e5\u01e6\7B\2\2\u01e6"+
		"\u01e7\7g\2\2\u01e7\u01e8\7p\2\2\u01e8\u01e9\7f\2\2\u01e9\u01ea\7i\2\2"+
		"\u01ea\u01eb\7w\2\2\u01eb\u01ec\7g\2\2\u01ec\u01ed\7u\2\2\u01ed\u01ee"+
		"\7v\2\2\u01eeU\3\2\2\2\u01ef\u01f0\7B\2\2\u01f0\u01f1\7g\2\2\u01f1\u01f2"+
		"\7p\2\2\u01f2\u01f3\7f\2\2\u01f3\u01f4\7t\2\2\u01f4\u01f5\7q\2\2\u01f5"+
		"\u01f6\7n\2\2\u01f6\u01f7\7g\2\2\u01f7W\3\2\2\2\u01f8\u01f9\7B\2\2\u01f9"+
		"\u01fa\7g\2\2\u01fa\u01fb\7p\2\2\u01fb\u01fc\7f\2\2\u01fc\u01fd\7k\2\2"+
		"\u01fd\u01fe\7p\2\2\u01fe\u01ff\7x\2\2\u01ff\u0200\7g\2\2\u0200\u0201"+
		"\7t\2\2\u0201\u0202\7u\2\2\u0202\u0203\7g\2\2\u0203\u0204\7t\2\2\u0204"+
		"\u0205\7q\2\2\u0205\u0206\7n\2\2\u0206\u0207\7g\2\2\u0207Y\3\2\2\2\u0208"+
		"\u0209\7B\2\2\u0209\u020a\7g\2\2\u020a\u020b\7p\2\2\u020b\u020c\7f\2\2"+
		"\u020c\u020d\7u\2\2\u020d\u020e\7g\2\2\u020e\u020f\7e\2\2\u020f\u0210"+
		"\7v\2\2\u0210\u0211\7k\2\2\u0211\u0212\7q\2\2\u0212\u0213\7p\2\2\u0213"+
		"[\3\2\2\2\u0214\u0215\7u\2\2\u0215\u0216\7j\2\2\u0216\u0217\7c\2\2\u0217"+
		"\u0218\7t\2\2\u0218\u0219\7g\2\2\u0219\u021a\7f\2\2\u021a\u021b\7a\2\2"+
		"\u021b\u021c\7f\2\2\u021c\u021d\7c\2\2\u021d\u021e\7v\2\2\u021e\u021f"+
		"\7c\2\2\u021f]\3\2\2\2\u0220\u0221\7h\2\2\u0221\u0222\7q\2\2\u0222\u0223"+
		"\7t\2\2\u0223\u0224\7o\2\2\u0224\u0225\7a\2\2\u0225\u0226\7f\2\2\u0226"+
		"\u0227\7c\2\2\u0227\u0228\7v\2\2\u0228\u0229\7c\2\2\u0229_\3\2\2\2\u022a"+
		"\u022b\7*\2\2\u022ba\3\2\2\2\u022c\u022d\7+\2\2\u022dc\3\2\2\2\u022e\u022f"+
		"\7]\2\2\u022fe\3\2\2\2\u0230\u0231\7_\2\2\u0231g\3\2\2\2\u0232\u0233\7"+
		"}\2\2\u0233i\3\2\2\2\u0234\u0235\7\177\2\2\u0235k\3\2\2\2\u0236\u0237"+
		"\7.\2\2\u0237m\3\2\2\2\u0238\u0239\7<\2\2\u0239o\3\2\2\2\u023a\u0242\t"+
		"\2\2\2\u023b\u023c\7>\2\2\u023c\u0242\7?\2\2\u023d\u023e\7@\2\2\u023e"+
		"\u0242\7?\2\2\u023f\u0240\7?\2\2\u0240\u0242\7?\2\2\u0241\u023a\3\2\2"+
		"\2\u0241\u023b\3\2\2\2\u0241\u023d\3\2\2\2\u0241\u023f\3\2\2\2\u0242q"+
		"\3\2\2\2\u0243\u0244\7(\2\2\u0244\u0248\7(\2\2\u0245\u0246\7~\2\2\u0246"+
		"\u0248\7~\2\2\u0247\u0243\3\2\2\2\u0247\u0245\3\2\2\2\u0248s\3\2\2\2\u0249"+
		"\u024a\7#\2\2\u024au\3\2\2\2\u024b\u024c\7-\2\2\u024c\u0250\7-\2\2\u024d"+
		"\u024e\7/\2\2\u024e\u0250\7/\2\2\u024f\u024b\3\2\2\2\u024f\u024d\3\2\2"+
		"\2\u0250w\3\2\2\2\u0251\u0257\t\3\2\2\u0252\u0253\7-\2\2\u0253\u0257\7"+
		"?\2\2\u0254\u0255\7/\2\2\u0255\u0257\7?\2\2\u0256\u0251\3\2\2\2\u0256"+
		"\u0252\3\2\2\2\u0256\u0254\3\2\2\2\u0257y\3\2\2\2\u0258\u0260\t\4\2\2"+
		"\u0259\u025a\7,\2\2\u025a\u0260\7?\2\2\u025b\u025c\7\61\2\2\u025c\u0260"+
		"\7?\2\2\u025d\u025e\7\'\2\2\u025e\u0260\7?\2\2\u025f\u0258\3\2\2\2\u025f"+
		"\u0259\3\2\2\2\u025f\u025b\3\2\2\2\u025f\u025d\3\2\2\2\u0260{\3\2\2\2"+
		"\u0261\u0262\7?\2\2\u0262}\3\2\2\2\u0263\u0264\7B\2\2\u0264\177\3\2\2"+
		"\2\u0265\u0266\7?\2\2\u0266\u0267\7@\2\2\u0267\u0081\3\2\2\2\u0268\u026c"+
		"\t\5\2\2\u0269\u026b\t\6\2\2\u026a\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c"+
		"\u026a\3\2\2\2\u026c\u026d\3\2\2\2\u026d\u0083\3\2\2\2\u026e\u026c\3\2"+
		"\2\2\u026f\u0270\t\7\2\2\u0270\u0271\3\2\2\2\u0271\u0272\bB\3\2\u0272"+
		"\u0085\3\2\2\2\u0273\u0275\t\b\2\2\u0274\u0273\3\2\2\2\u0275\u0276\3\2"+
		"\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0087\3\2\2\2\u0278"+
		"\u027a\7%\2\2\u0279\u027b\t\t\2\2\u027a\u0279\3\2\2\2\u027b\u027c\3\2"+
		"\2\2\u027c\u027a\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u0089\3\2\2\2\u027e"+
		"\u0282\7$\2\2\u027f\u0281\n\n\2\2\u0280\u027f\3\2\2\2\u0281\u0284\3\2"+
		"\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0285\u028f\7$\2\2\u0286\u028a\7)\2\2\u0287\u0289\n\13"+
		"\2\2\u0288\u0287\3\2\2\2\u0289\u028c\3\2\2\2\u028a\u0288\3\2\2\2\u028a"+
		"\u028b\3\2\2\2\u028b\u028d\3\2\2\2\u028c\u028a\3\2\2\2\u028d\u028f\7)"+
		"\2\2\u028e\u027e\3\2\2\2\u028e\u0286\3\2\2\2\u028f\u008b\3\2\2\2\u0290"+
		"\u0292\7$\2\2\u0291\u0293\t\f\2\2\u0292\u0291\3\2\2\2\u0293\u0294\3\2"+
		"\2\2\u0294\u0295\7$\2\2\u0295\u008d\3\2\2\2\u0296\u0298\13\2\2\2\u0297"+
		"\u0296\3\2\2\2\u0298\u029b\3\2\2\2\u0299\u029a\3\2\2\2\u0299\u0297\3\2"+
		"\2\2\u029a\u029c\3\2\2\2\u029b\u0299\3\2\2\2\u029c\u029d\7B\2\2\u029d"+
		"\u029e\7g\2\2\u029e\u029f\7p\2\2\u029f\u02a0\7f\2\2\u02a0\u02a1\7t\2\2"+
		"\u02a1\u02a2\7c\2\2\u02a2\u02a3\7y\2\2\u02a3\u02a4\7r\2\2\u02a4\u02a5"+
		"\7j\2\2\u02a5\u02a6\7r\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a8\bG\4\2\u02a8"+
		"\u008f\3\2\2\2\24\2\3\u0128\u014f\u01da\u0241\u0247\u024f\u0256\u025f"+
		"\u026c\u0276\u027c\u0282\u028a\u028e\u0292\u0299\5\7\3\2\2\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}