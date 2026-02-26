// Generated from c:/Users/rolan/Documents/Work/academic-duties/teaching/2026/Formal-languages/code/task4-regular-expression-mysolution/src/main/resources/REGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class REGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CHAR=8, WS=9, 
		BLOCK_COMMENT=10;
	public static final int
		RULE_expr = 0, RULE_term = 1, RULE_factor = 2, RULE_base = 3, RULE_charClass = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "term", "factor", "base", "charClass"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'*'", "'('", "')'", "'['", "'-'", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "CHAR", "WS", "BLOCK_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "REGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public REGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprREContext extends ExprContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExprREContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			_localctx = new ExprREContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			term();
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(11);
				match(T__0);
				setState(12);
				term();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TermREContext extends TermContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public TermREContext(TermContext ctx) { copyFrom(ctx); }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		int _la;
		try {
			_localctx = new TermREContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			factor();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 296L) != 0)) {
				{
				{
				setState(19);
				factor();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FactorREContext extends FactorContext {
		public BaseContext base() {
			return getRuleContext(BaseContext.class,0);
		}
		public FactorREContext(FactorContext ctx) { copyFrom(ctx); }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_factor);
		int _la;
		try {
			_localctx = new FactorREContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			base();
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(26);
				match(T__1);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BaseContext extends ParserRuleContext {
		public BaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base; }
	 
		public BaseContext() { }
		public void copyFrom(BaseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharREContext extends BaseContext {
		public TerminalNode CHAR() { return getToken(REGrammarParser.CHAR, 0); }
		public CharREContext(BaseContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesREContext extends BaseContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesesREContext(BaseContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharClassREContext extends BaseContext {
		public CharClassContext charClass() {
			return getRuleContext(CharClassContext.class,0);
		}
		public CharClassREContext(BaseContext ctx) { copyFrom(ctx); }
	}

	public final BaseContext base() throws RecognitionException {
		BaseContext _localctx = new BaseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_base);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
				_localctx = new CharREContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(CHAR);
				}
				break;
			case T__4:
				_localctx = new CharClassREContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				charClass();
				}
				break;
			case T__2:
				_localctx = new ParenthesesREContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				match(T__2);
				setState(32);
				expr();
				setState(33);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharClassContext extends ParserRuleContext {
		public CharClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charClass; }
	 
		public CharClassContext() { }
		public void copyFrom(CharClassContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharRangeREContext extends CharClassContext {
		public List<TerminalNode> CHAR() { return getTokens(REGrammarParser.CHAR); }
		public TerminalNode CHAR(int i) {
			return getToken(REGrammarParser.CHAR, i);
		}
		public CharRangeREContext(CharClassContext ctx) { copyFrom(ctx); }
	}

	public final CharClassContext charClass() throws RecognitionException {
		CharClassContext _localctx = new CharClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_charClass);
		try {
			_localctx = new CharRangeREContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__4);
			setState(38);
			match(CHAR);
			setState(39);
			match(T__5);
			setState(40);
			match(CHAR);
			setState(41);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\n,\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u0015\b\u0001\n\u0001"+
		"\f\u0001\u0018\t\u0001\u0001\u0002\u0001\u0002\u0003\u0002\u001c\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003$\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002\u0004"+
		"\u0006\b\u0000\u0000+\u0000\n\u0001\u0000\u0000\u0000\u0002\u0012\u0001"+
		"\u0000\u0000\u0000\u0004\u0019\u0001\u0000\u0000\u0000\u0006#\u0001\u0000"+
		"\u0000\u0000\b%\u0001\u0000\u0000\u0000\n\u000f\u0003\u0002\u0001\u0000"+
		"\u000b\f\u0005\u0001\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\u000b"+
		"\u0001\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001"+
		"\u0000\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0001\u0001"+
		"\u0000\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0016\u0003"+
		"\u0004\u0002\u0000\u0013\u0015\u0003\u0004\u0002\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0003\u0001"+
		"\u0000\u0000\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0019\u001b\u0003"+
		"\u0006\u0003\u0000\u001a\u001c\u0005\u0002\u0000\u0000\u001b\u001a\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0005\u0001"+
		"\u0000\u0000\u0000\u001d$\u0005\b\u0000\u0000\u001e$\u0003\b\u0004\u0000"+
		"\u001f \u0005\u0003\u0000\u0000 !\u0003\u0000\u0000\u0000!\"\u0005\u0004"+
		"\u0000\u0000\"$\u0001\u0000\u0000\u0000#\u001d\u0001\u0000\u0000\u0000"+
		"#\u001e\u0001\u0000\u0000\u0000#\u001f\u0001\u0000\u0000\u0000$\u0007"+
		"\u0001\u0000\u0000\u0000%&\u0005\u0005\u0000\u0000&\'\u0005\b\u0000\u0000"+
		"\'(\u0005\u0006\u0000\u0000()\u0005\b\u0000\u0000)*\u0005\u0007\u0000"+
		"\u0000*\t\u0001\u0000\u0000\u0000\u0004\u000f\u0016\u001b#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}