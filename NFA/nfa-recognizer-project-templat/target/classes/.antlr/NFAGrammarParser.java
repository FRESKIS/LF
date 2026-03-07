// Generated from c:/Users/rolan/Documents/Work/academic-duties/teaching/2026/Formal-languages/code/task3-nfa-recognizer-mysolution/src/main/resources/NFAGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NFAGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CHAR=11, EPSILON=12, ID=13, LETTER=14, INT=15, DIGIT=16, WS=17, 
		BLOCK_COMMENT=18;
	public static final int
		RULE_nfa = 0, RULE_states = 1, RULE_transitions = 2, RULE_transition = 3, 
		RULE_iniState = 4, RULE_finalStates = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"nfa", "states", "transitions", "transition", "iniState", "finalStates"
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

	@Override
	public String getGrammarFileName() { return "NFAGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NFAGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NfaContext extends ParserRuleContext {
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
		}
		public IniStateContext iniState() {
			return getRuleContext(IniStateContext.class,0);
		}
		public FinalStatesContext finalStates() {
			return getRuleContext(FinalStatesContext.class,0);
		}
		public NfaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nfa; }
	}

	public final NfaContext nfa() throws RecognitionException {
		NfaContext _localctx = new NfaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_nfa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			states();
			setState(13);
			transitions();
			setState(14);
			iniState();
			setState(15);
			finalStates();
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
	public static class StatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NFAGrammarParser.ID, i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(T__0);
			setState(18);
			match(T__1);
			setState(19);
			match(T__2);
			setState(20);
			match(ID);
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(21);
				match(T__3);
				setState(22);
				match(ID);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(T__4);
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
	public static class TransitionsContext extends ParserRuleContext {
		public List<TransitionContext> transition() {
			return getRuleContexts(TransitionContext.class);
		}
		public TransitionContext transition(int i) {
			return getRuleContext(TransitionContext.class,i);
		}
		public TransitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions; }
	}

	public final TransitionsContext transitions() throws RecognitionException {
		TransitionsContext _localctx = new TransitionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_transitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__5);
			setState(31);
			match(T__1);
			setState(32);
			match(T__2);
			setState(33);
			transition();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(34);
				match(T__3);
				setState(35);
				transition();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(T__4);
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
	public static class TransitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NFAGrammarParser.ID, i);
		}
		public TerminalNode CHAR() { return getToken(NFAGrammarParser.CHAR, 0); }
		public TerminalNode EPSILON() { return getToken(NFAGrammarParser.EPSILON, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_transition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__6);
			setState(44);
			match(ID);
			setState(45);
			match(T__3);
			setState(46);
			_la = _input.LA(1);
			if ( !(_la==CHAR || _la==EPSILON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(47);
			match(T__3);
			setState(48);
			match(ID);
			setState(49);
			match(T__7);
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
	public static class IniStateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NFAGrammarParser.ID, 0); }
		public IniStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iniState; }
	}

	public final IniStateContext iniState() throws RecognitionException {
		IniStateContext _localctx = new IniStateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_iniState);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__8);
			setState(52);
			match(T__1);
			setState(53);
			match(ID);
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
	public static class FinalStatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(NFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(NFAGrammarParser.ID, i);
		}
		public FinalStatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalStates; }
	}

	public final FinalStatesContext finalStates() throws RecognitionException {
		FinalStatesContext _localctx = new FinalStatesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_finalStates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__9);
			setState(56);
			match(T__1);
			setState(57);
			match(T__2);
			setState(58);
			match(ID);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(59);
				match(T__3);
				setState(60);
				match(ID);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(T__4);
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
		"\u0004\u0001\u0012E\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002%\b\u0002\n\u0002\f\u0002(\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005>\b\u0005\n\u0005\f\u0005A\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0000\u0000\u0006\u0000\u0002\u0004\u0006\b\n"+
		"\u0000\u0001\u0001\u0000\u000b\fA\u0000\f\u0001\u0000\u0000\u0000\u0002"+
		"\u0011\u0001\u0000\u0000\u0000\u0004\u001e\u0001\u0000\u0000\u0000\u0006"+
		"+\u0001\u0000\u0000\u0000\b3\u0001\u0000\u0000\u0000\n7\u0001\u0000\u0000"+
		"\u0000\f\r\u0003\u0002\u0001\u0000\r\u000e\u0003\u0004\u0002\u0000\u000e"+
		"\u000f\u0003\b\u0004\u0000\u000f\u0010\u0003\n\u0005\u0000\u0010\u0001"+
		"\u0001\u0000\u0000\u0000\u0011\u0012\u0005\u0001\u0000\u0000\u0012\u0013"+
		"\u0005\u0002\u0000\u0000\u0013\u0014\u0005\u0003\u0000\u0000\u0014\u0019"+
		"\u0005\r\u0000\u0000\u0015\u0016\u0005\u0004\u0000\u0000\u0016\u0018\u0005"+
		"\r\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0005\u0005\u0000\u0000\u001d\u0003\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0005\u0006\u0000\u0000\u001f \u0005\u0002\u0000"+
		"\u0000 !\u0005\u0003\u0000\u0000!&\u0003\u0006\u0003\u0000\"#\u0005\u0004"+
		"\u0000\u0000#%\u0003\u0006\u0003\u0000$\"\u0001\u0000\u0000\u0000%(\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)*\u0005\u0005\u0000"+
		"\u0000*\u0005\u0001\u0000\u0000\u0000+,\u0005\u0007\u0000\u0000,-\u0005"+
		"\r\u0000\u0000-.\u0005\u0004\u0000\u0000./\u0007\u0000\u0000\u0000/0\u0005"+
		"\u0004\u0000\u000001\u0005\r\u0000\u000012\u0005\b\u0000\u00002\u0007"+
		"\u0001\u0000\u0000\u000034\u0005\t\u0000\u000045\u0005\u0002\u0000\u0000"+
		"56\u0005\r\u0000\u00006\t\u0001\u0000\u0000\u000078\u0005\n\u0000\u0000"+
		"89\u0005\u0002\u0000\u00009:\u0005\u0003\u0000\u0000:?\u0005\r\u0000\u0000"+
		";<\u0005\u0004\u0000\u0000<>\u0005\r\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0005"+
		"\u0000\u0000C\u000b\u0001\u0000\u0000\u0000\u0003\u0019&?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}