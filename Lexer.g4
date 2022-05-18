lexer grammar  Lexer;

PAGE
    : 'page'
    ;
CONTROLLER
    : 'controller'
    ;
EXTENDS
    : 'extends'
    ;
CONTROLES
    : 'controles'
    ;
HEAD
    : 'head'
    ;
IF
    : 'if'
    ;
CHECK_AUTH
    : 'checkAuthenticated'
    ;
CHECK_VALID
    : 'checkValid'
    ;
CHECK_ROLE
    : 'checkRole'
    ;
REDIRECT
    : 'redirect'
    ;
TEXT
    : 'text'
    ;
IMAGE
    : 'image'
    ;
SEMI_COLON
    : ';'
    ;
LIST
    : 'list'
    ;
TABLE
    : 'table'
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
BOOLEAN
    : 'TRUE'
    | 'FALSE'
    | 'true'
    | 'false'
    ;
CASE
    : 'case'
    ;
METHOD
    : 'post'
    | 'delete'
    | 'get'
    | 'put'
    | 'POST'
    | 'GET'
    | 'DELETE'
    | 'PUT'
    ;
DEFAULT
    : 'dafaultl'
    ;
FORM
    : 'form'
    ;
TEXT_FIELD
    : 'textField'
    ;
DATE
    : 'date'
    ;
CHECKBOX
    : 'checkbox'
    ;
SELCTION
    : 'selection'
    ;
RADIO
    : 'radio'
    ;
SWITCH
    : 'switch'
    ;
LINK
    : 'link'
    ;
AT_AUTH
    : '@auth'
    ;
AT_GUEST
    : '@guest'
    ;
AT_ROLE
    : '@role'
    ;
AT_INVERSE_ROLE
    : '@inverserole'
    ;
AT_RAW_PHP
    : '@rawphp'->pushMode(PHP)
    ;
AT_SECTION
    : '@section'
    ;
AT_YIELD
    : '@yield'
    ;
FOR
    : 'for'
    ;
ELSE
    : '@else'
    ;
AT_END_AUTH
    : '@endauth'
    ;
AT_END_GUEST
    : '@endguest'
    ;
AT_END_ROLE
    : '@endrole'
    ;
AT_END_INVERSE_ROLE
    : '@endinverserole'
    ;
AT_END_SECTION
    : '@endsection'
    ;
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
OPERATOR_TWO_OPERAND
    : '<'
    | '>'
    | '<='
    | '>='
    | '=='
    ;
CONDITIONAL_CONCAT_OPERATOR
    : '&&'
    | '||'
    ;
ONE_LOGICAL_OPERAND
    : '!'
    ;
ONE_VALUABLE_OPERAND
    : '++'
    | '--'
    ;
ADDITIVE_OPERATOR
    : '+' | '-' | '+=' | '-='
    ;
MULTIPLICATIVE_OPERATOR
    : '*' | '/' | '%' | '*=' | '/=' | '%='
    ;
EQUAL
    : '='
    ;
AT
    : '@'
    ;
ARROW
    : '=>'
    ;
ID
    : [a-zA-Z_] ([a-zA-Z0-9_])*
    ;
WHITESPACE
   : [ \t\r\n] -> channel(HIDDEN)
   ;
DECIMAL
   : [0-9]+
   ;
HEXCHARS
    : '#' [0-9a-fA-F]+
    ;
CHAR
    : '\'' ([a-zA-Z0-9_] |'-' | '/'|'+'| ',' | '?' | '=' | ':' | ';' | '#' | ' ') '\''
    ;
STRING
    : '"' ~[<"]* '"'
    | '\'' ~[<']* '\''
    ;

mode PHP;

AT_END_RAW_PHP
    : .*? '@endrawphp'->popMode
    ;
