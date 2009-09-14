lexer grammar PatternLanguage;

T9 : 'CALL' ;
T10 : 'SUPER' ;
T11 : 'READ' ;
T12 : 'PATTERN' ;

// $ANTLR src "./src/com/thalesgroup/mde/mdsofa/asset/pattern/ecore/grammar/PatternLanguage.g" 14
ENDOFCALL : ';' ;
// $ANTLR src "./src/com/thalesgroup/mde/mdsofa/asset/pattern/ecore/grammar/PatternLanguage.g" 15
LPAR : '(' ;
// $ANTLR src "./src/com/thalesgroup/mde/mdsofa/asset/pattern/ecore/grammar/PatternLanguage.g" 16
RPAR : ')' ;
// $ANTLR src "./src/com/thalesgroup/mde/mdsofa/asset/pattern/ecore/grammar/PatternLanguage.g" 17
PARAM : ('a'..'z'|'A'..'Z'|'0'..'9'|'.'|'/'|'#')* ;
// $ANTLR src "./src/com/thalesgroup/mde/mdsofa/asset/pattern/ecore/grammar/PatternLanguage.g" 18
WS    : (' '|'\r'|'\n'|'\t'){$channel=HIDDEN;}
      ;
