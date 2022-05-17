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
EQUAL:
    '='
    ;
HASHTAG:
    '#'
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
SEMI_COLON
    : ';'
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
    :'radio'
    ;

SWITCH
    :'switch'
    ;
LINK:
    'link'
    ;

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
    :'@rawphp'
    ;


AT_SECTION
    :'@section'
    ;

AT_YIELD
    :'@yield'
    ;

FOR
    :'for'
    ;



// tag declarations

ELSE
    :'@else'
    ;

AT_END_AUTH
    :'@endauth'
    ;

AT_END_GUEST
    :'@endguest'
    ;

/// names ? string : var


AT_END_ROLE
    :'@endrole'
    ;


AT_END_INVERSE_ROLE
    :'@endinverserole'
    ;

AT_END_RAW_PHP
    :'@endrawphp'
    ;

AT_END_SECTION
    :'@endsection'
    ;



FOR_INDEX
    : [a-zA-Z_] ([a-zA-Z0-9_])*
    ;

REDIRECT
: 'redirect'
;



