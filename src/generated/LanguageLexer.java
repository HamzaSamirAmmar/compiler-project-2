// Generated from C:/Users/ASUS/Desktop/cloned compiler/compiler-project-2/grammers\LanguageLexer.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
		BRACKET_OPEN=45, BRACKET_CLOSE=46, SQUARE_OPEN=47, SQUARE_CLOSE=48, CURLEY_BRACKET_OPEN=49, 
		CURLEY_BRACKET_CLOSE=50, COMMA=51, COLON=52, OPERATOR_TWO_OPERAND=53, 
		CONDITIONAL_CONCAT_OPERATOR=54, ONE_LOGICAL_OPERAND=55, ONE_VALUABLE_OPERAND=56, 
		ADDITIVE_OPERATOR=57, MULTIPLICATIVE_OPERATOR=58, EQUAL=59, AT=60, ARROW=61, 
		ID=62, WHITESPACE=63, DECIMAL=64, HEXCHARS=65, STRING=66, CHAR=67, AT_END_RAW_PHP=68;
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
			"BRACKET_OPEN", "BRACKET_CLOSE", "SQUARE_OPEN", "SQUARE_CLOSE", "CURLEY_BRACKET_OPEN", 
			"CURLEY_BRACKET_CLOSE", "COMMA", "COLON", "OPERATOR_TWO_OPERAND", "CONDITIONAL_CONCAT_OPERATOR", 
			"ONE_LOGICAL_OPERAND", "ONE_VALUABLE_OPERAND", "ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", 
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
			"'@endinverserole'", "'@endsection'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "','", "':'", null, null, "'!'", null, null, null, "'='", "'@'", 
			"'=>'"
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
			"BRACKET_OPEN", "BRACKET_CLOSE", "SQUARE_OPEN", "SQUARE_CLOSE", "CURLEY_BRACKET_OPEN", 
			"CURLEY_BRACKET_CLOSE", "COMMA", "COLON", "OPERATOR_TWO_OPERAND", "CONDITIONAL_CONCAT_OPERATOR", 
			"ONE_LOGICAL_OPERAND", "ONE_VALUABLE_OPERAND", "ADDITIVE_OPERATOR", "MULTIPLICATIVE_OPERATOR", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2F\u028f\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\5\24\u0125\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\5\26\u014c\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\5(\u01d7\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3"+
		"/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0228\n\66\3\67\3\67\3\67\3\67\5\67"+
		"\u022e\n\67\38\38\39\39\39\39\59\u0236\n9\3:\3:\3:\3:\3:\5:\u023d\n:\3"+
		";\3;\3;\3;\3;\3;\3;\5;\u0246\n;\3<\3<\3=\3=\3>\3>\3>\3?\3?\7?\u0251\n"+
		"?\f?\16?\u0254\13?\3@\3@\3@\3@\3A\6A\u025b\nA\rA\16A\u025c\3B\3B\6B\u0261"+
		"\nB\rB\16B\u0262\3C\3C\7C\u0267\nC\fC\16C\u026a\13C\3C\3C\3C\7C\u026f"+
		"\nC\fC\16C\u0272\13C\3C\5C\u0275\nC\3D\3D\5D\u0279\nD\3D\3D\3E\7E\u027e"+
		"\nE\fE\16E\u0281\13E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3\u027f\2"+
		"F\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20"+
		" \21\"\22$\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35:\36<\37"+
		"> @!B\"D#F$H%J&L\'N(P)R*T+V,X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8"+
		"p9r:t;v<x=z>|?~@\u0080A\u0082B\u0084C\u0086D\u0088E\u008aF\4\2\3\r\4\2"+
		">>@@\4\2--//\5\2\'\',,\61\61\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17"+
		"\"\"\3\2\62;\5\2\62;CHch\4\2$$>>\4\2))>>\13\2\"\"%%-/\61=??AAC\\aac|\2"+
		"\u02a9\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16"+
		"\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2"+
		"\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$"+
		"\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3"+
		"\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2"+
		"<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3"+
		"\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2"+
		"\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2"+
		"\2b\3\2\2\2\2d\3\2\2\2\2f\3\2\2\2\2h\3\2\2\2\2j\3\2\2\2\2l\3\2\2\2\2n"+
		"\3\2\2\2\2p\3\2\2\2\2r\3\2\2\2\2t\3\2\2\2\2v\3\2\2\2\2x\3\2\2\2\2z\3\2"+
		"\2\2\2|\3\2\2\2\2~\3\2\2\2\2\u0080\3\2\2\2\2\u0082\3\2\2\2\2\u0084\3\2"+
		"\2\2\2\u0086\3\2\2\2\2\u0088\3\2\2\2\3\u008a\3\2\2\2\4\u008c\3\2\2\2\6"+
		"\u0091\3\2\2\2\b\u009c\3\2\2\2\n\u00a4\3\2\2\2\f\u00ae\3\2\2\2\16\u00b3"+
		"\3\2\2\2\20\u00b6\3\2\2\2\22\u00c9\3\2\2\2\24\u00d4\3\2\2\2\26\u00de\3"+
		"\2\2\2\30\u00e7\3\2\2\2\32\u00ec\3\2\2\2\34\u00f2\3\2\2\2\36\u00f4\3\2"+
		"\2\2 \u00f9\3\2\2\2\"\u00ff\3\2\2\2$\u0106\3\2\2\2&\u010d\3\2\2\2(\u0124"+
		"\3\2\2\2*\u0126\3\2\2\2,\u014b\3\2\2\2.\u014d\3\2\2\2\60\u0156\3\2\2\2"+
		"\62\u015b\3\2\2\2\64\u0165\3\2\2\2\66\u016a\3\2\2\28\u0173\3\2\2\2:\u017d"+
		"\3\2\2\2<\u0183\3\2\2\2>\u018a\3\2\2\2@\u018f\3\2\2\2B\u0195\3\2\2\2D"+
		"\u019c\3\2\2\2F\u01a2\3\2\2\2H\u01af\3\2\2\2J\u01b9\3\2\2\2L\u01c2\3\2"+
		"\2\2N\u01c9\3\2\2\2P\u01d6\3\2\2\2R\u01d8\3\2\2\2T\u01e1\3\2\2\2V\u01eb"+
		"\3\2\2\2X\u01f4\3\2\2\2Z\u0204\3\2\2\2\\\u0210\3\2\2\2^\u0212\3\2\2\2"+
		"`\u0214\3\2\2\2b\u0216\3\2\2\2d\u0218\3\2\2\2f\u021a\3\2\2\2h\u021c\3"+
		"\2\2\2j\u021e\3\2\2\2l\u0227\3\2\2\2n\u022d\3\2\2\2p\u022f\3\2\2\2r\u0235"+
		"\3\2\2\2t\u023c\3\2\2\2v\u0245\3\2\2\2x\u0247\3\2\2\2z\u0249\3\2\2\2|"+
		"\u024b\3\2\2\2~\u024e\3\2\2\2\u0080\u0255\3\2\2\2\u0082\u025a\3\2\2\2"+
		"\u0084\u025e\3\2\2\2\u0086\u0274\3\2\2\2\u0088\u0276\3\2\2\2\u008a\u027f"+
		"\3\2\2\2\u008c\u008d\7r\2\2\u008d\u008e\7c\2\2\u008e\u008f\7i\2\2\u008f"+
		"\u0090\7g\2\2\u0090\5\3\2\2\2\u0091\u0092\7e\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7p\2\2\u0094\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7q\2\2"+
		"\u0097\u0098\7n\2\2\u0098\u0099\7n\2\2\u0099\u009a\7g\2\2\u009a\u009b"+
		"\7t\2\2\u009b\7\3\2\2\2\u009c\u009d\7g\2\2\u009d\u009e\7z\2\2\u009e\u009f"+
		"\7v\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7f\2\2\u00a2"+
		"\u00a3\7u\2\2\u00a3\t\3\2\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\u00a7\7p\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7q\2\2"+
		"\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7u\2\2\u00ad\13\3\2"+
		"\2\2\u00ae\u00af\7j\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7c\2\2\u00b1\u00b2"+
		"\7f\2\2\u00b2\r\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7h\2\2\u00b5\17"+
		"\3\2\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7g\2\2\u00b9"+
		"\u00ba\7e\2\2\u00ba\u00bb\7m\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7w\2\2"+
		"\u00bd\u00be\7v\2\2\u00be\u00bf\7j\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1"+
		"\7p\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7e\2\2\u00c4"+
		"\u00c5\7c\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7f\2\2"+
		"\u00c8\21\3\2\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7j\2\2\u00cb\u00cc\7"+
		"g\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7m\2\2\u00ce\u00cf\7X\2\2\u00cf\u00d0"+
		"\7c\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7f\2\2\u00d3"+
		"\23\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7\7g\2\2\u00d7"+
		"\u00d8\7e\2\2\u00d8\u00d9\7m\2\2\u00d9\u00da\7T\2\2\u00da\u00db\7q\2\2"+
		"\u00db\u00dc\7n\2\2\u00dc\u00dd\7g\2\2\u00dd\25\3\2\2\2\u00de\u00df\7"+
		"t\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7f\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3"+
		"\7t\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7e\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"\27\3\2\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7z\2\2\u00ea"+
		"\u00eb\7v\2\2\u00eb\31\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7o\2\2\u00ee"+
		"\u00ef\7c\2\2\u00ef\u00f0\7i\2\2\u00f0\u00f1\7g\2\2\u00f1\33\3\2\2\2\u00f2"+
		"\u00f3\7=\2\2\u00f3\35\3\2\2\2\u00f4\u00f5\7n\2\2\u00f5\u00f6\7k\2\2\u00f6"+
		"\u00f7\7u\2\2\u00f7\u00f8\7v\2\2\u00f8\37\3\2\2\2\u00f9\u00fa\7v\2\2\u00fa"+
		"\u00fb\7c\2\2\u00fb\u00fc\7d\2\2\u00fc\u00fd\7n\2\2\u00fd\u00fe\7g\2\2"+
		"\u00fe!\3\2\2\2\u00ff\u0100\7d\2\2\u0100\u0101\7w\2\2\u0101\u0102\7v\2"+
		"\2\u0102\u0103\7v\2\2\u0103\u0104\7q\2\2\u0104\u0105\7p\2\2\u0105#\3\2"+
		"\2\2\u0106\u0107\7j\2\2\u0107\u0108\7g\2\2\u0108\u0109\7c\2\2\u0109\u010a"+
		"\7f\2\2\u010a\u010b\7g\2\2\u010b\u010c\7t\2\2\u010c%\3\2\2\2\u010d\u010e"+
		"\7d\2\2\u010e\u010f\7q\2\2\u010f\u0110\7f\2\2\u0110\u0111\7{\2\2\u0111"+
		"\'\3\2\2\2\u0112\u0113\7V\2\2\u0113\u0114\7T\2\2\u0114\u0115\7W\2\2\u0115"+
		"\u0125\7G\2\2\u0116\u0117\7H\2\2\u0117\u0118\7C\2\2\u0118\u0119\7N\2\2"+
		"\u0119\u011a\7U\2\2\u011a\u0125\7G\2\2\u011b\u011c\7v\2\2\u011c\u011d"+
		"\7t\2\2\u011d\u011e\7w\2\2\u011e\u0125\7g\2\2\u011f\u0120\7h\2\2\u0120"+
		"\u0121\7c\2\2\u0121\u0122\7n\2\2\u0122\u0123\7u\2\2\u0123\u0125\7g\2\2"+
		"\u0124\u0112\3\2\2\2\u0124\u0116\3\2\2\2\u0124\u011b\3\2\2\2\u0124\u011f"+
		"\3\2\2\2\u0125)\3\2\2\2\u0126\u0127\7e\2\2\u0127\u0128\7c\2\2\u0128\u0129"+
		"\7u\2\2\u0129\u012a\7g\2\2\u012a+\3\2\2\2\u012b\u012c\7r\2\2\u012c\u012d"+
		"\7q\2\2\u012d\u012e\7u\2\2\u012e\u014c\7v\2\2\u012f\u0130\7f\2\2\u0130"+
		"\u0131\7g\2\2\u0131\u0132\7n\2\2\u0132\u0133\7g\2\2\u0133\u0134\7v\2\2"+
		"\u0134\u014c\7g\2\2\u0135\u0136\7i\2\2\u0136\u0137\7g\2\2\u0137\u014c"+
		"\7v\2\2\u0138\u0139\7r\2\2\u0139\u013a\7w\2\2\u013a\u014c\7v\2\2\u013b"+
		"\u013c\7R\2\2\u013c\u013d\7Q\2\2\u013d\u013e\7U\2\2\u013e\u014c\7V\2\2"+
		"\u013f\u0140\7I\2\2\u0140\u0141\7G\2\2\u0141\u014c\7V\2\2\u0142\u0143"+
		"\7F\2\2\u0143\u0144\7G\2\2\u0144\u0145\7N\2\2\u0145\u0146\7G\2\2\u0146"+
		"\u0147\7V\2\2\u0147\u014c\7G\2\2\u0148\u0149\7R\2\2\u0149\u014a\7W\2\2"+
		"\u014a\u014c\7V\2\2\u014b\u012b\3\2\2\2\u014b\u012f\3\2\2\2\u014b\u0135"+
		"\3\2\2\2\u014b\u0138\3\2\2\2\u014b\u013b\3\2\2\2\u014b\u013f\3\2\2\2\u014b"+
		"\u0142\3\2\2\2\u014b\u0148\3\2\2\2\u014c-\3\2\2\2\u014d\u014e\7f\2\2\u014e"+
		"\u014f\7c\2\2\u014f\u0150\7h\2\2\u0150\u0151\7c\2\2\u0151\u0152\7w\2\2"+
		"\u0152\u0153\7n\2\2\u0153\u0154\7v\2\2\u0154\u0155\7n\2\2\u0155/\3\2\2"+
		"\2\u0156\u0157\7h\2\2\u0157\u0158\7q\2\2\u0158\u0159\7t\2\2\u0159\u015a"+
		"\7o\2\2\u015a\61\3\2\2\2\u015b\u015c\7v\2\2\u015c\u015d\7g\2\2\u015d\u015e"+
		"\7z\2\2\u015e\u015f\7v\2\2\u015f\u0160\7H\2\2\u0160\u0161\7k\2\2\u0161"+
		"\u0162\7g\2\2\u0162\u0163\7n\2\2\u0163\u0164\7f\2\2\u0164\63\3\2\2\2\u0165"+
		"\u0166\7f\2\2\u0166\u0167\7c\2\2\u0167\u0168\7v\2\2\u0168\u0169\7g\2\2"+
		"\u0169\65\3\2\2\2\u016a\u016b\7e\2\2\u016b\u016c\7j\2\2\u016c\u016d\7"+
		"g\2\2\u016d\u016e\7e\2\2\u016e\u016f\7m\2\2\u016f\u0170\7d\2\2\u0170\u0171"+
		"\7q\2\2\u0171\u0172\7z\2\2\u0172\67\3\2\2\2\u0173\u0174\7u\2\2\u0174\u0175"+
		"\7g\2\2\u0175\u0176\7n\2\2\u0176\u0177\7g\2\2\u0177\u0178\7e\2\2\u0178"+
		"\u0179\7v\2\2\u0179\u017a\7k\2\2\u017a\u017b\7q\2\2\u017b\u017c\7p\2\2"+
		"\u017c9\3\2\2\2\u017d\u017e\7t\2\2\u017e\u017f\7c\2\2\u017f\u0180\7f\2"+
		"\2\u0180\u0181\7k\2\2\u0181\u0182\7q\2\2\u0182;\3\2\2\2\u0183\u0184\7"+
		"u\2\2\u0184\u0185\7y\2\2\u0185\u0186\7k\2\2\u0186\u0187\7v\2\2\u0187\u0188"+
		"\7e\2\2\u0188\u0189\7j\2\2\u0189=\3\2\2\2\u018a\u018b\7n\2\2\u018b\u018c"+
		"\7k\2\2\u018c\u018d\7p\2\2\u018d\u018e\7m\2\2\u018e?\3\2\2\2\u018f\u0190"+
		"\7B\2\2\u0190\u0191\7c\2\2\u0191\u0192\7w\2\2\u0192\u0193\7v\2\2\u0193"+
		"\u0194\7j\2\2\u0194A\3\2\2\2\u0195\u0196\7B\2\2\u0196\u0197\7i\2\2\u0197"+
		"\u0198\7w\2\2\u0198\u0199\7g\2\2\u0199\u019a\7u\2\2\u019a\u019b\7v\2\2"+
		"\u019bC\3\2\2\2\u019c\u019d\7B\2\2\u019d\u019e\7t\2\2\u019e\u019f\7q\2"+
		"\2\u019f\u01a0\7n\2\2\u01a0\u01a1\7g\2\2\u01a1E\3\2\2\2\u01a2\u01a3\7"+
		"B\2\2\u01a3\u01a4\7k\2\2\u01a4\u01a5\7p\2\2\u01a5\u01a6\7x\2\2\u01a6\u01a7"+
		"\7g\2\2\u01a7\u01a8\7t\2\2\u01a8\u01a9\7u\2\2\u01a9\u01aa\7g\2\2\u01aa"+
		"\u01ab\7t\2\2\u01ab\u01ac\7q\2\2\u01ac\u01ad\7n\2\2\u01ad\u01ae\7g\2\2"+
		"\u01aeG\3\2\2\2\u01af\u01b0\7B\2\2\u01b0\u01b1\7t\2\2\u01b1\u01b2\7c\2"+
		"\2\u01b2\u01b3\7y\2\2\u01b3\u01b4\7r\2\2\u01b4\u01b5\7j\2\2\u01b5\u01b6"+
		"\7r\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\b$\2\2\u01b8I\3\2\2\2\u01b9\u01ba"+
		"\7B\2\2\u01ba\u01bb\7u\2\2\u01bb\u01bc\7g\2\2\u01bc\u01bd\7e\2\2\u01bd"+
		"\u01be\7v\2\2\u01be\u01bf\7k\2\2\u01bf\u01c0\7q\2\2\u01c0\u01c1\7p\2\2"+
		"\u01c1K\3\2\2\2\u01c2\u01c3\7B\2\2\u01c3\u01c4\7{\2\2\u01c4\u01c5\7k\2"+
		"\2\u01c5\u01c6\7g\2\2\u01c6\u01c7\7n\2\2\u01c7\u01c8\7f\2\2\u01c8M\3\2"+
		"\2\2\u01c9\u01ca\7h\2\2\u01ca\u01cb\7q\2\2\u01cb\u01cc\7t\2\2\u01ccO\3"+
		"\2\2\2\u01cd\u01ce\7B\2\2\u01ce\u01cf\7g\2\2\u01cf\u01d0\7n\2\2\u01d0"+
		"\u01d1\7u\2\2\u01d1\u01d7\7g\2\2\u01d2\u01d3\7g\2\2\u01d3\u01d4\7n\2\2"+
		"\u01d4\u01d5\7u\2\2\u01d5\u01d7\7g\2\2\u01d6\u01cd\3\2\2\2\u01d6\u01d2"+
		"\3\2\2\2\u01d7Q\3\2\2\2\u01d8\u01d9\7B\2\2\u01d9\u01da\7g\2\2\u01da\u01db"+
		"\7p\2\2\u01db\u01dc\7f\2\2\u01dc\u01dd\7c\2\2\u01dd\u01de\7w\2\2\u01de"+
		"\u01df\7v\2\2\u01df\u01e0\7j\2\2\u01e0S\3\2\2\2\u01e1\u01e2\7B\2\2\u01e2"+
		"\u01e3\7g\2\2\u01e3\u01e4\7p\2\2\u01e4\u01e5\7f\2\2\u01e5\u01e6\7i\2\2"+
		"\u01e6\u01e7\7w\2\2\u01e7\u01e8\7g\2\2\u01e8\u01e9\7u\2\2\u01e9\u01ea"+
		"\7v\2\2\u01eaU\3\2\2\2\u01eb\u01ec\7B\2\2\u01ec\u01ed\7g\2\2\u01ed\u01ee"+
		"\7p\2\2\u01ee\u01ef\7f\2\2\u01ef\u01f0\7t\2\2\u01f0\u01f1\7q\2\2\u01f1"+
		"\u01f2\7n\2\2\u01f2\u01f3\7g\2\2\u01f3W\3\2\2\2\u01f4\u01f5\7B\2\2\u01f5"+
		"\u01f6\7g\2\2\u01f6\u01f7\7p\2\2\u01f7\u01f8\7f\2\2\u01f8\u01f9\7k\2\2"+
		"\u01f9\u01fa\7p\2\2\u01fa\u01fb\7x\2\2\u01fb\u01fc\7g\2\2\u01fc\u01fd"+
		"\7t\2\2\u01fd\u01fe\7u\2\2\u01fe\u01ff\7g\2\2\u01ff\u0200\7t\2\2\u0200"+
		"\u0201\7q\2\2\u0201\u0202\7n\2\2\u0202\u0203\7g\2\2\u0203Y\3\2\2\2\u0204"+
		"\u0205\7B\2\2\u0205\u0206\7g\2\2\u0206\u0207\7p\2\2\u0207\u0208\7f\2\2"+
		"\u0208\u0209\7u\2\2\u0209\u020a\7g\2\2\u020a\u020b\7e\2\2\u020b\u020c"+
		"\7v\2\2\u020c\u020d\7k\2\2\u020d\u020e\7q\2\2\u020e\u020f\7p\2\2\u020f"+
		"[\3\2\2\2\u0210\u0211\7*\2\2\u0211]\3\2\2\2\u0212\u0213\7+\2\2\u0213_"+
		"\3\2\2\2\u0214\u0215\7]\2\2\u0215a\3\2\2\2\u0216\u0217\7_\2\2\u0217c\3"+
		"\2\2\2\u0218\u0219\7}\2\2\u0219e\3\2\2\2\u021a\u021b\7\177\2\2\u021bg"+
		"\3\2\2\2\u021c\u021d\7.\2\2\u021di\3\2\2\2\u021e\u021f\7<\2\2\u021fk\3"+
		"\2\2\2\u0220\u0228\t\2\2\2\u0221\u0222\7>\2\2\u0222\u0228\7?\2\2\u0223"+
		"\u0224\7@\2\2\u0224\u0228\7?\2\2\u0225\u0226\7?\2\2\u0226\u0228\7?\2\2"+
		"\u0227\u0220\3\2\2\2\u0227\u0221\3\2\2\2\u0227\u0223\3\2\2\2\u0227\u0225"+
		"\3\2\2\2\u0228m\3\2\2\2\u0229\u022a\7(\2\2\u022a\u022e\7(\2\2\u022b\u022c"+
		"\7~\2\2\u022c\u022e\7~\2\2\u022d\u0229\3\2\2\2\u022d\u022b\3\2\2\2\u022e"+
		"o\3\2\2\2\u022f\u0230\7#\2\2\u0230q\3\2\2\2\u0231\u0232\7-\2\2\u0232\u0236"+
		"\7-\2\2\u0233\u0234\7/\2\2\u0234\u0236\7/\2\2\u0235\u0231\3\2\2\2\u0235"+
		"\u0233\3\2\2\2\u0236s\3\2\2\2\u0237\u023d\t\3\2\2\u0238\u0239\7-\2\2\u0239"+
		"\u023d\7?\2\2\u023a\u023b\7/\2\2\u023b\u023d\7?\2\2\u023c\u0237\3\2\2"+
		"\2\u023c\u0238\3\2\2\2\u023c\u023a\3\2\2\2\u023du\3\2\2\2\u023e\u0246"+
		"\t\4\2\2\u023f\u0240\7,\2\2\u0240\u0246\7?\2\2\u0241\u0242\7\61\2\2\u0242"+
		"\u0246\7?\2\2\u0243\u0244\7\'\2\2\u0244\u0246\7?\2\2\u0245\u023e\3\2\2"+
		"\2\u0245\u023f\3\2\2\2\u0245\u0241\3\2\2\2\u0245\u0243\3\2\2\2\u0246w"+
		"\3\2\2\2\u0247\u0248\7?\2\2\u0248y\3\2\2\2\u0249\u024a\7B\2\2\u024a{\3"+
		"\2\2\2\u024b\u024c\7?\2\2\u024c\u024d\7@\2\2\u024d}\3\2\2\2\u024e\u0252"+
		"\t\5\2\2\u024f\u0251\t\6\2\2\u0250\u024f\3\2\2\2\u0251\u0254\3\2\2\2\u0252"+
		"\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\177\3\2\2\2\u0254\u0252\3\2\2"+
		"\2\u0255\u0256\t\7\2\2\u0256\u0257\3\2\2\2\u0257\u0258\b@\3\2\u0258\u0081"+
		"\3\2\2\2\u0259\u025b\t\b\2\2\u025a\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c"+
		"\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u0083\3\2\2\2\u025e\u0260\7%"+
		"\2\2\u025f\u0261\t\t\2\2\u0260\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262"+
		"\u0260\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u0085\3\2\2\2\u0264\u0268\7$"+
		"\2\2\u0265\u0267\n\n\2\2\u0266\u0265\3\2\2\2\u0267\u026a\3\2\2\2\u0268"+
		"\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026b\3\2\2\2\u026a\u0268\3\2"+
		"\2\2\u026b\u0275\7$\2\2\u026c\u0270\7)\2\2\u026d\u026f\n\13\2\2\u026e"+
		"\u026d\3\2\2\2\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2"+
		"\2\2\u0271\u0273\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0275\7)\2\2\u0274"+
		"\u0264\3\2\2\2\u0274\u026c\3\2\2\2\u0275\u0087\3\2\2\2\u0276\u0278\7$"+
		"\2\2\u0277\u0279\t\f\2\2\u0278\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a"+
		"\u027b\7$\2\2\u027b\u0089\3\2\2\2\u027c\u027e\13\2\2\2\u027d\u027c\3\2"+
		"\2\2\u027e\u0281\3\2\2\2\u027f\u0280\3\2\2\2\u027f\u027d\3\2\2\2\u0280"+
		"\u0282\3\2\2\2\u0281\u027f\3\2\2\2\u0282\u0283\7B\2\2\u0283\u0284\7g\2"+
		"\2\u0284\u0285\7p\2\2\u0285\u0286\7f\2\2\u0286\u0287\7t\2\2\u0287\u0288"+
		"\7c\2\2\u0288\u0289\7y\2\2\u0289\u028a\7r\2\2\u028a\u028b\7j\2\2\u028b"+
		"\u028c\7r\2\2\u028c\u028d\3\2\2\2\u028d\u028e\bE\4\2\u028e\u008b\3\2\2"+
		"\2\24\2\3\u0124\u014b\u01d6\u0227\u022d\u0235\u023c\u0245\u0252\u025c"+
		"\u0262\u0268\u0270\u0274\u0278\u027f\5\7\3\2\2\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}