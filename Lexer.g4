lexer grammar  Lexer;

PAGE : 'page';
CONTROLLER :'controller';
EXTENDS : 'extends' ;
CONTROLES : 'controles';
HEAD : 'head';
IF:'if';
CHECK_AUTH:'checkAuthenticated';
CHECK_VALID:'checkValid';
CHECK_ROLE:'checkRole';
ID : [a-zA-Z_] ([a-zA-Z0-9_])*;
BRACKET_OPEN
    : '('
    ;
BRACKET_CLOSE
    : ')'
    ;
SQUARE_OPEN
    : '['
    ;
SQUARE_CLOSE
    : ']'
    ;
CURLEY_BRACKET_OPEN
    : '{'
    ;
CURLEY_BRACKET_CLOSE
    : '}'
    ;
COMMA
    : ','
    ;
COLON
    : ':'
    ;
ARROW
    : '=>'
    ;
TEXT
    : 'text'
    ;
IMAGE
    : 'image'
    ;
LIST
    : 'list'
    ;
TABLE
    :'table'
    ;
BUTTON
    : 'button'
    ;
HEADER
    : 'header'
    ;
BODY
    : 'body'
    ;
ROW
    : 'row'
    ;
BOOLEAN
    : 'TRUE'
    | 'FALSE'
    | 'true'
    | 'false'
    ;
OPEN_CURLY_BRACE : '{';
CLOSE_CURLY_BRACE : '}';
OPEN_BRACE:'(';
ClOSE_BRACE:')';
DECIMAL
    :[0-9]+
    ;
HEXCHARS
    : '#' [0-9a-fA-F]+
    ;
STRING
     : '"' ~[<"]* '"'
     | '\'' ~[<']* '\''
     ;




