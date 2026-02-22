// Generated from src/main/resources/DFAGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DFAGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CHAR=11, ID=12, LETTER=13, INT=14, DIGIT=15, WS=16, BLOCK_COMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "CHAR", "ID", "LETTER", "INT", "DIGIT", "WS", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'states'", "'='", "'{'", "','", "'}'", "'transitions'", "'('", 
			"')'", "'ini'", "'finals'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "CHAR", 
			"ID", "LETTER", "INT", "DIGIT", "WS", "BLOCK_COMMENT"
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


	public DFAGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DFAGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\fR\n\f\3\r\3\r\6\rV\n\r"+
		"\r\r\16\rW\3\16\6\16[\n\16\r\16\16\16\\\3\17\6\17`\n\17\r\17\16\17a\3"+
		"\20\3\20\3\21\6\21g\n\21\r\21\16\21h\3\21\3\21\3\22\3\22\3\22\3\22\7\22"+
		"q\n\22\f\22\16\22t\13\22\3\22\3\22\3\22\3\22\3\22\3r\2\23\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0080\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5,\3\2"+
		"\2\2\7.\3\2\2\2\t\60\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17@\3\2\2\2\21"+
		"B\3\2\2\2\23D\3\2\2\2\25H\3\2\2\2\27Q\3\2\2\2\31U\3\2\2\2\33Z\3\2\2\2"+
		"\35_\3\2\2\2\37c\3\2\2\2!f\3\2\2\2#l\3\2\2\2%&\7u\2\2&\'\7v\2\2\'(\7c"+
		"\2\2()\7v\2\2)*\7g\2\2*+\7u\2\2+\4\3\2\2\2,-\7?\2\2-\6\3\2\2\2./\7}\2"+
		"\2/\b\3\2\2\2\60\61\7.\2\2\61\n\3\2\2\2\62\63\7\177\2\2\63\f\3\2\2\2\64"+
		"\65\7v\2\2\65\66\7t\2\2\66\67\7c\2\2\678\7p\2\289\7u\2\29:\7k\2\2:;\7"+
		"v\2\2;<\7k\2\2<=\7q\2\2=>\7p\2\2>?\7u\2\2?\16\3\2\2\2@A\7*\2\2A\20\3\2"+
		"\2\2BC\7+\2\2C\22\3\2\2\2DE\7k\2\2EF\7p\2\2FG\7k\2\2G\24\3\2\2\2HI\7h"+
		"\2\2IJ\7k\2\2JK\7p\2\2KL\7c\2\2LM\7n\2\2MN\7u\2\2N\26\3\2\2\2OR\5\33\16"+
		"\2PR\5\37\20\2QO\3\2\2\2QP\3\2\2\2R\30\3\2\2\2SV\5\33\16\2TV\5\37\20\2"+
		"US\3\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\32\3\2\2\2Y[\t\2\2"+
		"\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\34\3\2\2\2^`\5\37\20\2"+
		"_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\36\3\2\2\2cd\t\3\2\2d \3\2\2"+
		"\2eg\t\4\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\b\21"+
		"\2\2k\"\3\2\2\2lm\7\61\2\2mn\7,\2\2nr\3\2\2\2oq\13\2\2\2po\3\2\2\2qt\3"+
		"\2\2\2rs\3\2\2\2rp\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7,\2\2vw\7\61\2\2wx\3"+
		"\2\2\2xy\b\22\2\2y$\3\2\2\2\n\2QUW\\ahr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}