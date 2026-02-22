// Generated from src/main/resources/DFAGrammar.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DFAGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, CHAR=11, ID=12, LETTER=13, INT=14, DIGIT=15, WS=16, BLOCK_COMMENT=17;
	public static final int
		RULE_dfa = 0, RULE_states = 1, RULE_transitions = 2, RULE_transition = 3, 
		RULE_iniState = 4, RULE_finalStates = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"dfa", "states", "transitions", "transition", "iniState", "finalStates"
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

	@Override
	public String getGrammarFileName() { return "DFAGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DFAGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DfaContext extends ParserRuleContext {
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
		public DfaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dfa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitDfa(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DfaContext dfa() throws RecognitionException {
		DfaContext _localctx = new DfaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dfa);
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

	public static class StatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DFAGrammarParser.ID, i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitStates(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitTransitions(this);
			else return visitor.visitChildren(this);
		}
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

	public static class TransitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DFAGrammarParser.ID, i);
		}
		public TerminalNode CHAR() { return getToken(DFAGrammarParser.CHAR, 0); }
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitTransition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_transition);
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
			match(CHAR);
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

	public static class IniStateContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DFAGrammarParser.ID, 0); }
		public IniStateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iniState; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitIniState(this);
			else return visitor.visitChildren(this);
		}
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

	public static class FinalStatesContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(DFAGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DFAGrammarParser.ID, i);
		}
		public FinalStatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalStates; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DFAGrammarVisitor ) return ((DFAGrammarVisitor<? extends T>)visitor).visitFinalStates(this);
			else return visitor.visitChildren(this);
		}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23G\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7@\n\7\f\7\16\7C\13\7\3\7\3\7\3\7"+
		"\2\2\b\2\4\6\b\n\f\2\2\2C\2\16\3\2\2\2\4\23\3\2\2\2\6 \3\2\2\2\b-\3\2"+
		"\2\2\n\65\3\2\2\2\f9\3\2\2\2\16\17\5\4\3\2\17\20\5\6\4\2\20\21\5\n\6\2"+
		"\21\22\5\f\7\2\22\3\3\2\2\2\23\24\7\3\2\2\24\25\7\4\2\2\25\26\7\5\2\2"+
		"\26\33\7\16\2\2\27\30\7\6\2\2\30\32\7\16\2\2\31\27\3\2\2\2\32\35\3\2\2"+
		"\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\7\2"+
		"\2\37\5\3\2\2\2 !\7\b\2\2!\"\7\4\2\2\"#\7\5\2\2#(\5\b\5\2$%\7\6\2\2%\'"+
		"\5\b\5\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2"+
		"+,\7\7\2\2,\7\3\2\2\2-.\7\t\2\2./\7\16\2\2/\60\7\6\2\2\60\61\7\r\2\2\61"+
		"\62\7\6\2\2\62\63\7\16\2\2\63\64\7\n\2\2\64\t\3\2\2\2\65\66\7\13\2\2\66"+
		"\67\7\4\2\2\678\7\16\2\28\13\3\2\2\29:\7\f\2\2:;\7\4\2\2;<\7\5\2\2<A\7"+
		"\16\2\2=>\7\6\2\2>@\7\16\2\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B"+
		"D\3\2\2\2CA\3\2\2\2DE\7\7\2\2E\r\3\2\2\2\5\33(A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}