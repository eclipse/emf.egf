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

// $ANTLR 3.0 ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g 2007-06-28 16:45:58

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;

public class PatternLanguageLexer extends Lexer {
  public static final int ENDOFCALL = 7;
  public static final int T10 = 10;
  public static final int RPAR = 6;
  public static final int T11 = 11;
  public static final int T9 = 9;
  public static final int EOF = -1;
  public static final int WS = 8;
  public static final int LPAR = 4;
  public static final int T12 = 12;
  public static final int Tokens = 13;
  public static final int PARAM = 5;

  public PatternLanguageLexer(CharStream input_p) {
    super(input_p);
  }

  @Override
  public String getGrammarFileName() {
    return "./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g";} //$NON-NLS-1$

  // $ANTLR start T9
  public final void mT9() throws RecognitionException {
    try {
      int _type = T9;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:3:6: ( 'CALL' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:3:6: 'CALL'
      {
        match("CALL"); //$NON-NLS-1$
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end T9

  // $ANTLR start T10
  public final void mT10() throws RecognitionException {
    try {
      int _type = T10;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:4:7: ( 'SUPER' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:4:7: 'SUPER'
      {
        match("SUPER"); //$NON-NLS-1$
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end T10

  // $ANTLR start T11
  public final void mT11() throws RecognitionException {
    try {
      int _type = T11;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:5:7: ( 'READ' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:5:7: 'READ'
      {
        match("READ"); //$NON-NLS-1$
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end T11

  // $ANTLR start T12
  public final void mT12() throws RecognitionException {
    try {
      int _type = T12;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:6:7: ( 'PATTERN' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:6:7: 'PATTERN'
      {
        match("PATTERN"); //$NON-NLS-1$
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end T12

  // $ANTLR start ENDOFCALL
  public final void mENDOFCALL() throws RecognitionException {
    try {
      int _type = ENDOFCALL;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:14:13: ( ';' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:14:13: ';'
      {
        match(';');
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end ENDOFCALL

  // $ANTLR start LPAR
  public final void mLPAR() throws RecognitionException {
    try {
      int _type = LPAR;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:15:8: ( '(' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:15:8: '('
      {
        match('(');
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end LPAR

  // $ANTLR start RPAR
  public final void mRPAR() throws RecognitionException {
    try {
      int _type = RPAR;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:16:8: ( ')' )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:16:8: ')'
      {
        match(')');
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end RPAR

  // $ANTLR start PARAM
  public final void mPARAM() throws RecognitionException {
    try {
      int _type = PARAM;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:17:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | '#' )* )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:17:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | '#' )*
      {
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:17:9: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' | '/' | '#' )*
        loop1: do {
          int alt1 = 2;
          int LA1_0 = input.LA(1);

          if ((LA1_0 == '#' || (LA1_0 >= '.' && LA1_0 <= '9') || (LA1_0 >= 'A' && LA1_0 <= 'Z') || (LA1_0 >= 'a' && LA1_0 <= 'z'))) {
            alt1 = 1;
          }

          switch (alt1) {
            case 1:
              // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:
            {
              if (input.LA(1) == '#' || (input.LA(1) >= '.' && input.LA(1) <= '9') || (input.LA(1) >= 'A' && input.LA(1) <= 'Z')
                  || (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
                input.consume();
              } else {
                MismatchedSetException mse = new MismatchedSetException(null, input);
                recover(mse);
                throw mse;
              }
            }
            break;

            default:
            break loop1;
          }
        } while (true);
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end PARAM

  // $ANTLR start WS
  public final void mWS() throws RecognitionException {
    try {
      int _type = WS;
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:18:9: ( ( ' ' | '\\r' | '\\n' | '\\t' ) )
      // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:18:9: ( ' ' | '\\r' | '\\n' | '\\t' )
      {
        if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
          input.consume();
        } else {
          MismatchedSetException mse = new MismatchedSetException(null, input);
          recover(mse);
          throw mse;
        }
        channel = HIDDEN;
      }
      this.type = _type;
    } finally {
      // NTD.
    }
  }

  // $ANTLR end WS
  @Override
  public void mTokens() throws RecognitionException {
    // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:10: ( T9 | T10 | T11 | T12 | ENDOFCALL | LPAR | RPAR | PARAM | WS )
    int alt2 = 9;
    switch (input.LA(1)) {
      case 'C': {
        int LA2_1 = input.LA(2);

        if ((LA2_1 == 'A')) {
          int LA2_10 = input.LA(3);

          if ((LA2_10 == 'L')) {
            int LA2_14 = input.LA(4);

            if ((LA2_14 == 'L')) {
              int LA2_18 = input.LA(5);

              if ((LA2_18 == '#' || (LA2_18 >= '.' && LA2_18 <= '9') || (LA2_18 >= 'A' && LA2_18 <= 'Z') || (LA2_18 >= 'a' && LA2_18 <= 'z'))) {
                alt2 = 8;
              } else {
                alt2 = 1;
              }
            } else {
              alt2 = 8;
            }
          } else {
            alt2 = 8;
          }
        } else {
          alt2 = 8;
        }
      }
      break;
      case 'S': {
        int LA2_2 = input.LA(2);

        if ((LA2_2 == 'U')) {
          int LA2_11 = input.LA(3);

          if ((LA2_11 == 'P')) {
            int LA2_15 = input.LA(4);

            if ((LA2_15 == 'E')) {
              int LA2_19 = input.LA(5);

              if ((LA2_19 == 'R')) {
                int LA2_23 = input.LA(6);

                if ((LA2_23 == '#' || (LA2_23 >= '.' && LA2_23 <= '9') || (LA2_23 >= 'A' && LA2_23 <= 'Z') || (LA2_23 >= 'a' && LA2_23 <= 'z'))) {
                  alt2 = 8;
                } else {
                  alt2 = 2;
                }
              } else {
                alt2 = 8;
              }
            } else {
              alt2 = 8;
            }
          } else {
            alt2 = 8;
          }
        } else {
          alt2 = 8;
        }
      }
      break;
      case 'R': {
        int LA2_3 = input.LA(2);

        if ((LA2_3 == 'E')) {
          int LA2_12 = input.LA(3);

          if ((LA2_12 == 'A')) {
            int LA2_16 = input.LA(4);

            if ((LA2_16 == 'D')) {
              int LA2_20 = input.LA(5);

              if ((LA2_20 == '#' || (LA2_20 >= '.' && LA2_20 <= '9') || (LA2_20 >= 'A' && LA2_20 <= 'Z') || (LA2_20 >= 'a' && LA2_20 <= 'z'))) {
                alt2 = 8;
              } else {
                alt2 = 3;
              }
            } else {
              alt2 = 8;
            }
          } else {
            alt2 = 8;
          }
        } else {
          alt2 = 8;
        }
      }
      break;
      case 'P': {
        int LA2_4 = input.LA(2);

        if ((LA2_4 == 'A')) {
          int LA2_13 = input.LA(3);

          if ((LA2_13 == 'T')) {
            int LA2_17 = input.LA(4);

            if ((LA2_17 == 'T')) {
              int LA2_21 = input.LA(5);

              if ((LA2_21 == 'E')) {
                int LA2_25 = input.LA(6);

                if ((LA2_25 == 'R')) {
                  int LA2_27 = input.LA(7);

                  if ((LA2_27 == 'N')) {
                    int LA2_28 = input.LA(8);

                    if ((LA2_28 == '#' || (LA2_28 >= '.' && LA2_28 <= '9') || (LA2_28 >= 'A' && LA2_28 <= 'Z') || (LA2_28 >= 'a' && LA2_28 <= 'z'))) {
                      alt2 = 8;
                    } else {
                      alt2 = 4;
                    }
                  } else {
                    alt2 = 8;
                  }
                } else {
                  alt2 = 8;
                }
              } else {
                alt2 = 8;
              }
            } else {
              alt2 = 8;
            }
          } else {
            alt2 = 8;
          }
        } else {
          alt2 = 8;
        }
      }
      break;
      case ';': {
        alt2 = 5;
      }
      break;
      case '(': {
        alt2 = 6;
      }
      break;
      case ')': {
        alt2 = 7;
      }
      break;
      case '\t':
      case '\n':
      case '\r':
      case ' ': {
        alt2 = 9;
      }
      break;
      default:
        alt2 = 8;
    }

    switch (alt2) {
      case 1:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:10: T9
      {
        mT9();

      }
      break;
      case 2:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:13: T10
      {
        mT10();

      }
      break;
      case 3:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:17: T11
      {
        mT11();

      }
      break;
      case 4:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:21: T12
      {
        mT12();

      }
      break;
      case 5:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:25: ENDOFCALL
      {
        mENDOFCALL();

      }
      break;
      case 6:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:35: LPAR
      {
        mLPAR();

      }
      break;
      case 7:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:40: RPAR
      {
        mRPAR();

      }
      break;
      case 8:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:45: PARAM
      {
        mPARAM();

      }
      break;
      case 9:
        // ./src/org/eclipse/egf/pattern/ecore/grammar/PatternLanguage.g:1:51: WS
      {
        mWS();

      }
      break;

    }

  }

}