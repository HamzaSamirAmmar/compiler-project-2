parser grammar Parser;

options { tokenVocab=Lexer; }
out_element:
out_element_with_attributes_without_body |out_element_without_attributes_with_body
|out_element_with_attributes_with_body
 /*out_element_with_body*/
    ;

out_element_without_attributes_with_body: table;
out_element_with_attributes_with_body: list extra_attributes BRACKET_CLOSE body;

in_element
    : form
    | text_field
    | date
    | check_box
    | selection
    | radio
    ;



out_element_with_attributes_without_body
    :  out_element_attributes extra_attributes BRACKET_CLOSE
    ;
 // element_name BRACKET_OPEN main_attributes extra_attributes BRACKET_CLOSE // compare element_name with main_attributes
/*out_element_with_body
    :  out_element_without_body BRACKET_CLOSE body
    ;*/

/*body
    :
    ;*/
out_element_attributes
    : TEXT BRACKET_OPEN text |
      IMAGE BRACKET_OPEN image|
      BUTTON BRACKET_OPEN button
    ;
form
    : FORM BRACKET_OPEN METHOD COMMA STRING COMMA extra_attributes? BRACKET_CLOSE CURLEY_BRACKET_OPEN form_body? CURLEY_BRACKET_OPEN
    ;

form_body
    :  out_element
    | statement
    | STRING
    ;

text_field
    : TEXT_FIELD BRACKET_OPEN STRING COMMA STRING COMMA STRING COMMA extra_attributes? BRACKET_CLOSE
    ;

date
    : DATE BRACKET_OPEN STRING COMMA STRING COMMA STRING COMMA extra_attributes? BRACKET_CLOSE
    ;

check_box
    : CHECKBOX BRACKET_OPEN extra_attributes? BRACKET_CLOSE CURLEY_BRACKET_OPEN check_box_body CURLEY_BRACKET_CLOSE
    ;

check_box_body
    : STRING
    ;

selection
    : SELCTION BRACKET_OPEN BOOLEAN COMMA extra_attributes? BRACKET_CLOSE  CURLEY_BRACKET_OPEN selection_body CURLEY_BRACKET_CLOSE
    ;

selection_body
    : STRING (COLON STRING)?
    ;

radio
    : RADIO BRACKET_OPEN extra_attributes? BRACKET_CLOSE CURLEY_BRACKET_OPEN radio_body CURLEY_BRACKET_CLOSE
    ;

radio_body
     : STRING (COLON STRING)?
     ;

switch
    : SWITCH BRACKET_OPEN (expression) BRACKET_CLOSE CURLEY_BRACKET_OPEN switch_body CURLEY_BRACKET_CLOSE
    ;

switch_body
    : (CASE COLON expression SEMI_COLON)? (DEFAULT COLON expression)?
    ;

extra_attributes
    : (COMMA key_value_array)? COMMA?
    ;

text
    : STRING COMMA DECIMAL COMMA HEXCHARS
    ;
image
    : STRING COMMA DECIMAL COMMA DECIMAL
    ;
list
    : LIST BRACKET_OPEN BOOLEAN
    ;
button
    : STRING COMMA STRING
    /** text on button string? action string?**/
    ;
table
    :
    TABLE BRACKET_OPEN BRACKET_CLOSE table_body // body or normal map?
    ;
key_value_array
    : SQUARE_OPEN array_value(COMMA array_value)* COMMA? SQUARE_CLOSE
    ;
array_value
    : STRING ARROW STRING
    ;
table_body
    :CURLEY_BRACKET_OPEN HEADER COLON table_map BODY COLON table_map
    ;
table_map
    : CURLEY_BRACKET_OPEN (table_map_value)*  CURLEY_BRACKET_CLOSE COMMA? ;

table_map_value
    :ROW COLON map_value  (COMMA ROW COLON map_value )* COMMA?
    ;

body: map;
map
    :CURLEY_BRACKET_OPEN STRING COLON map_value (STRING COLON map_value COMMA)* COMMA? CURLEY_BRACKET_CLOSE ;

map_value
    : STRING |DECIMAL
    // 'id?' 'string?' 'expression?'
    ;
program:
     start_page page* controller*
     ;
start_page:
    page
    ;
page:
    PAGE ID head (EXTENDS (ID COMMA?)*)? CURLEY_BRACKET_OPEN page_body* CURLEY_BRACKET_CLOSE
    ;
head:
    HEAD BRACKET_OPEN title BRACKET_CLOSE
    ;
title:
    STRING;
page_body:
    in_element
    | out_element
    | statement//statements include logics(for, if , switch),declaretions,directives
    ;
controller:
    CONTROLLER ID CONTROLES ID CURLEY_BRACKET_OPEN controller_body CURLEY_BRACKET_CLOSE
    ;
controller_body:8
    | statement//statements include logics(for, if , switch),declaretions,directives
    | CHECK_AUTH BRACKET_OPEN  BRACKET_CLOSE
    | CHECK_VALID BRACKET_OPEN STRING COMMA STRING  BRACKET_CLOSE
    | CHECK_ROLE BRACKET_OPEN STRING BRACKET_CLOSE
    | REDIRECT ID
    ;
statement:
    IF BRACKET_OPEN expression BRACKET_CLOSE  CURLEY_BRACKET_OPEN page_body CURLEY_BRACKET_CLOSE
    ;

anythingInLife
        : expression
        ;

authentication
        : AT_AUTH anythingInLife (ELSE anythingInLife)? AT_END_AUTH
        | AT_GUEST anythingInLife (ELSE anythingInLife)? AT_END_GUEST
        ;

autherization
        : AT_ROLE BRACKET_OPEN SQUARE_OPEN (expression COMMA)* expression COMMA? SQUARE_CLOSE BRACKET_CLOSE anythingInLife (ELSE anythingInLife)? AT_END_ROLE
        | AT_INVERSE_ROLE BRACKET_OPEN SQUARE_OPEN (expression COMMA)* expression COMMA? SQUARE_CLOSE BRACKET_CLOSE anythingInLife (ELSE anythingInLife)? AT_END_INVERSE_ROLE
        ;

rawphp
    : AT_RAW_PHP anythingInLife AT_END_RAW_PHP
    ;

layoutInheritance
      : AT_SECTION BRACKET_OPEN expression BRACKET_CLOSE anythingInLife AT_END_SECTION
      | AT_YIELD BRACKET_OPEN expression BRACKET_CLOSE
      ;

forLoop
    : FOR BRACKET_OPEN FOR_INDEX SEMI_COLON expression SEMI_COLON expression BRACKET_CLOSE CURLEY_BRACKET_OPEN anythingInLife CURLEY_BRACKET_CLOSE
    ;

expression
//       : expression DOT expression                                    #VariableConcatExpression
//       | expression NG_OPERATOR_TWO_OPERAND expression                #TwoOperandsConditionExpression
//       | expression CONDITIONAL_CONCAT_OPERATOR expression            #ConcatConditionExpression
//       | expression QUESTION_MARK expression COLON expression         #TernaryExpression
//       | expression MULTIPLICATIVE_OPERATOR expression                #MathematicalExpression
//       | expression ADDITIVE_OPERATOR expression                      #MathematicalExpression
//       | NG_ID                                                        #VariableNameExpression
//       | NG_DECIMAL                                                   #LiteralNumericExpression
//       | NG_CHAR                                                      #LiteralCharExpression
//       | NG_STRING                                                    #LiteralStringExpression
//       | NG_BOOLEAN                                                   #LiteralBooleanExpression
//       | expression (SQUARE_OPEN expression SQUARE_CLOSE)             #IndexedVariableExpression
//       | NG_ONE_LOGICAL_OPERAND expression                           #OneOperandConditionExpression
//       | NG_ONE_VALUABLE_OPERAND expression                             #OneOperandValuableExpression
//       | expression NG_ONE_VALUABLE_OPERAND                             #OneOperandValuableExpression
//       | BRACKET_OPEN expression BRACKET_CLOSE                        #ParenthesizedExpression
        : FOR
       ;


