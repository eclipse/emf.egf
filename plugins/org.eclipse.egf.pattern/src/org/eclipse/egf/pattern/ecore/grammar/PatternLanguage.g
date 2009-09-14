grammar PatternLanguage;

options {
  output=AST;
  ASTLabelType=CommonTree;
}

call : operationCall+ ;

operationCall : operationName^ LPAR! PARAM* RPAR! ENDOFCALL! ;

operationName : ('CALL' | 'SUPER' | 'READ' | 'PATTERN') ;

ENDOFCALL : ';' ;
LPAR : '(' ;
RPAR : ')' ;
PARAM : ('a'..'z'|'A'..'Z'|'0'..'9'|'.'|'/'|'#')* ;
WS    : (' '|'\r'|'\n'|'\t'){$channel=HIDDEN;}
      ;
