/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.ecore.grammar;

// $ANTLR 3.0 ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g 2007-06-28 16:45:58

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

public class PatternLanguageParser extends Parser {
  public static final String[] tokenNames =
                                            new String[] {
                                                          "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LPAR", "PARAM", "RPAR", "ENDOFCALL", "WS", "'CALL'", "'SUPER'", "'READ'", "'PATTERN'" //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$//$NON-NLS-13$
                                            };
  public static final int ENDOFCALL = 7;
  public static final int RPAR = 6;
  public static final int WS = 8;
  public static final int EOF = -1;
  public static final int LPAR = 4;
  public static final int PARAM = 5;

  public PatternLanguageParser(TokenStream input_p) {
    super(input_p);
  }

  protected TreeAdaptor adaptor = new CommonTreeAdaptor();

  public void setTreeAdaptor(TreeAdaptor adaptor_p) {
    this.adaptor = adaptor_p;
  }

  public TreeAdaptor getTreeAdaptor() {
    return adaptor;
  }

  @Override
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public String getGrammarFileName() {
    return "./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g"; //$NON-NLS-1$
  }

  public static class call_return extends ParserRuleReturnScope {
    CommonTree tree;

    @Override
    public Object getTree() {
      return tree;
    }
  }

  // $ANTLR start call
  // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:8:1: call : ( operationCall )+ ;
  public final call_return call() throws RecognitionException {
    call_return retval = new call_return();
    retval.start = input.LT(1);

    CommonTree root_0 = null;

    operationCall_return operationCall1 = null;

    try {
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:8:8: ( ( operationCall )+ )
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:8:8: ( operationCall )+
      {
        root_0 = (CommonTree) adaptor.nil();

        // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:8:8: ( operationCall )+
        int cnt1 = 0;
        loop1: do {
          int alt1 = 2;
          int LA1_0 = input.LA(1);

          if (((LA1_0 >= 9 && LA1_0 <= 12))) {
            alt1 = 1;
          }

          switch (alt1) {
            case 1:
              // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:8:8: operationCall
            {
              pushFollow(FOLLOW_operationCall_in_call29);
              operationCall1 = operationCall();
              _fsp--;

              adaptor.addChild(root_0, operationCall1.getTree());

            }
            break;

            default:
              if (cnt1 >= 1)
                break loop1;
              EarlyExitException eee = new EarlyExitException(1, input);
              throw eee;
          }
          cnt1++;
        } while (true);

      }

      retval.stop = input.LT(-1);

      retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
      adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
      // NTD.
    }
    return retval;
  }

  // $ANTLR end call

  public static class operationCall_return extends ParserRuleReturnScope {
    CommonTree tree;

    @Override
    public Object getTree() {
      return tree;
    }
  }

  // $ANTLR start operationCall
  // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:10:1: operationCall : operationName LPAR ( PARAM )* RPAR ENDOFCALL ;
  @SuppressWarnings("unused")
  public final operationCall_return operationCall() throws RecognitionException {
    operationCall_return retval = new operationCall_return();
    retval.start = input.LT(1);

    CommonTree root_0 = null;

    Token LPAR3 = null;
    Token PARAM4 = null;
    Token RPAR5 = null;
    Token ENDOFCALL6 = null;
    operationName_return operationName2 = null;

    CommonTree LPAR3_tree = null;
    CommonTree PARAM4_tree = null;
    CommonTree RPAR5_tree = null;
    CommonTree ENDOFCALL6_tree = null;

    try {
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:10:17: ( operationName LPAR ( PARAM )* RPAR ENDOFCALL )
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:10:17: operationName LPAR ( PARAM )* RPAR ENDOFCALL
      {
        root_0 = (CommonTree) adaptor.nil();

        pushFollow(FOLLOW_operationName_in_operationCall39);
        operationName2 = operationName();
        _fsp--;

        root_0 = (CommonTree) adaptor.becomeRoot(operationName2.getTree(), root_0);
        LPAR3 = input.LT(1);
        match(input, LPAR, FOLLOW_LPAR_in_operationCall42);
        // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:10:38: ( PARAM )*
        loop2: do {
          int alt2 = 2;
          int LA2_0 = input.LA(1);

          if ((LA2_0 == PARAM)) {
            alt2 = 1;
          }

          switch (alt2) {
            case 1:
              // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:10:38: PARAM
            {
              PARAM4 = input.LT(1);
              match(input, PARAM, FOLLOW_PARAM_in_operationCall45);
              PARAM4_tree = (CommonTree) adaptor.create(PARAM4);
              adaptor.addChild(root_0, PARAM4_tree);

            }
            break;

            default:
            break loop2;
          }
        } while (true);

        RPAR5 = input.LT(1);
        match(input, RPAR, FOLLOW_RPAR_in_operationCall48);
        ENDOFCALL6 = input.LT(1);
        match(input, ENDOFCALL, FOLLOW_ENDOFCALL_in_operationCall51);

      }

      retval.stop = input.LT(-1);

      retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
      adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
      // NTD.
    }
    return retval;
  }

  // $ANTLR end operationCall

  public static class operationName_return extends ParserRuleReturnScope {
    CommonTree tree;

    @Override
    public Object getTree() {
      return tree;
    }
  }

  // $ANTLR start operationName
  // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:12:1: operationName : ( 'CALL' | 'SUPER' | 'READ' | 'PATTERN' ) ;
  @SuppressWarnings("unused")
  public final operationName_return operationName() throws RecognitionException {
    operationName_return retval = new operationName_return();
    retval.start = input.LT(1);

    CommonTree root_0 = null;

    Token set7 = null;

    CommonTree set7_tree = null;

    try {
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:12:17: ( ( 'CALL' | 'SUPER' | 'READ' | 'PATTERN' ) )
      // ./src/org/eclipse/egf/pattern/pattern/ecore/grammar/PatternLanguage.g:12:17: ( 'CALL' | 'SUPER' | 'READ' | 'PATTERN' )
      {
        root_0 = (CommonTree) adaptor.nil();

        set7 = input.LT(1);
        if ((input.LA(1) >= 9 && input.LA(1) <= 12)) {
          input.consume();
          adaptor.addChild(root_0, adaptor.create(set7));
          errorRecovery = false;
        } else {
          MismatchedSetException mse = new MismatchedSetException(null, input);
          recoverFromMismatchedSet(input, mse, FOLLOW_set_in_operationName61);
          throw mse;
        }

      }

      retval.stop = input.LT(-1);

      retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
      adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

    } catch (RecognitionException re) {
      reportError(re);
      recover(input, re);
    } finally {
      // NTD.
    }
    return retval;
  }

  // $ANTLR end operationName

  public static final BitSet FOLLOW_operationCall_in_call29 = new BitSet(new long[] { 0x0000000000001E02L });
  public static final BitSet FOLLOW_operationName_in_operationCall39 = new BitSet(new long[] { 0x0000000000000010L });
  public static final BitSet FOLLOW_LPAR_in_operationCall42 = new BitSet(new long[] { 0x0000000000000060L });
  public static final BitSet FOLLOW_PARAM_in_operationCall45 = new BitSet(new long[] { 0x0000000000000060L });
  public static final BitSet FOLLOW_RPAR_in_operationCall48 = new BitSet(new long[] { 0x0000000000000080L });
  public static final BitSet FOLLOW_ENDOFCALL_in_operationCall51 = new BitSet(new long[] { 0x0000000000000002L });
  public static final BitSet FOLLOW_set_in_operationName61 = new BitSet(new long[] { 0x0000000000000002L });

}