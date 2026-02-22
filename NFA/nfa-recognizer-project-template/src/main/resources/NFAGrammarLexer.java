// Generated from NFAGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NFAGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CHAR=11, EPSILON=12, ID=13, LETTER=14, INT=15, DIGIT=16, WS=17, 
		BLOCK_COMMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "CHAR", "EPSILON", "ID", "LETTER", "INT", "DIGIT", "WS", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'states'", "'='", "'{'", "','", "'}'", "'transitions'", "'('", 
			"')'", "'ini'", "'finals'", null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "CHAR", 
			"EPSILON", "ID", "LETTER", "INT", "DIGIT", "WS", "BLOCK_COMMENT"
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


	public NFAGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NFAGrammar.g4"; }

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
		"\u0004\u0000\u0012|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\nR\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0004\fX\b\f\u000b\f\f\fY\u0001\r\u0004\r]\b\r"+
		"\u000b\r\f\r^\u0001\u000e\u0004\u000eb\b\u000e\u000b\u000e\f\u000ec\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0004\u0010i\b\u0010\u000b\u0010\f\u0010"+
		"j\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011s\b\u0011\n\u0011\f\u0011v\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001t\u0000\u0012\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012\u0001\u0000\u0003\u0002\u0000AZaz\u0001\u000009\u0003\u0000"+
		"\t\n\r\r  \u0082\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001"+
		"%\u0001\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u0005.\u0001"+
		"\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t2\u0001\u0000\u0000"+
		"\u0000\u000b4\u0001\u0000\u0000\u0000\r@\u0001\u0000\u0000\u0000\u000f"+
		"B\u0001\u0000\u0000\u0000\u0011D\u0001\u0000\u0000\u0000\u0013H\u0001"+
		"\u0000\u0000\u0000\u0015Q\u0001\u0000\u0000\u0000\u0017S\u0001\u0000\u0000"+
		"\u0000\u0019W\u0001\u0000\u0000\u0000\u001b\\\u0001\u0000\u0000\u0000"+
		"\u001da\u0001\u0000\u0000\u0000\u001fe\u0001\u0000\u0000\u0000!h\u0001"+
		"\u0000\u0000\u0000#n\u0001\u0000\u0000\u0000%&\u0005s\u0000\u0000&\'\u0005"+
		"t\u0000\u0000\'(\u0005a\u0000\u0000()\u0005t\u0000\u0000)*\u0005e\u0000"+
		"\u0000*+\u0005s\u0000\u0000+\u0002\u0001\u0000\u0000\u0000,-\u0005=\u0000"+
		"\u0000-\u0004\u0001\u0000\u0000\u0000./\u0005{\u0000\u0000/\u0006\u0001"+
		"\u0000\u0000\u000001\u0005,\u0000\u00001\b\u0001\u0000\u0000\u000023\u0005"+
		"}\u0000\u00003\n\u0001\u0000\u0000\u000045\u0005t\u0000\u000056\u0005"+
		"r\u0000\u000067\u0005a\u0000\u000078\u0005n\u0000\u000089\u0005s\u0000"+
		"\u00009:\u0005i\u0000\u0000:;\u0005t\u0000\u0000;<\u0005i\u0000\u0000"+
		"<=\u0005o\u0000\u0000=>\u0005n\u0000\u0000>?\u0005s\u0000\u0000?\f\u0001"+
		"\u0000\u0000\u0000@A\u0005(\u0000\u0000A\u000e\u0001\u0000\u0000\u0000"+
		"BC\u0005)\u0000\u0000C\u0010\u0001\u0000\u0000\u0000DE\u0005i\u0000\u0000"+
		"EF\u0005n\u0000\u0000FG\u0005i\u0000\u0000G\u0012\u0001\u0000\u0000\u0000"+
		"HI\u0005f\u0000\u0000IJ\u0005i\u0000\u0000JK\u0005n\u0000\u0000KL\u0005"+
		"a\u0000\u0000LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000N\u0014\u0001\u0000"+
		"\u0000\u0000OR\u0003\u001b\r\u0000PR\u0003\u001f\u000f\u0000QO\u0001\u0000"+
		"\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0016\u0001\u0000\u0000\u0000"+
		"ST\u0005_\u0000\u0000T\u0018\u0001\u0000\u0000\u0000UX\u0003\u001b\r\u0000"+
		"VX\u0003\u001f\u000f\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z\u001a\u0001\u0000\u0000\u0000[]\u0007\u0000\u0000\u0000"+
		"\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_\u001c\u0001\u0000\u0000\u0000`b\u0003"+
		"\u001f\u000f\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\u001e\u0001\u0000"+
		"\u0000\u0000ef\u0007\u0001\u0000\u0000f \u0001\u0000\u0000\u0000gi\u0007"+
		"\u0002\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000lm\u0006\u0010\u0000\u0000m\"\u0001\u0000\u0000\u0000no\u0005/\u0000"+
		"\u0000op\u0005*\u0000\u0000pt\u0001\u0000\u0000\u0000qs\t\u0000\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000wx\u0005*\u0000\u0000xy\u0005/\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000z{\u0006\u0011\u0000\u0000{$\u0001\u0000\u0000\u0000\b\u0000"+
		"QWY^cjt\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}