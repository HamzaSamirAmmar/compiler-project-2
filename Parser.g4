parser grammar Parser;

options { tokenVocab=Lexer; }
out_element:
out_element_with_attributes_without_body |out_element_without_attributes_with_body
|out_element_with_attributes_with_body
 /*out_element_with_body*/
    ;

out_element_without_attributes_with_body: table;
out_element_with_attributes_with_body: list extra_attributes BRACKET_CLOSE body;



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
      BUTTON BRACKET_OPEN button|
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
    : string COMMA DECIMAL COMMA HEXCHARS
    ;
image
    : string COMMA DECIMAL COMMA DECIMAL
    ;
list
    : LIST BRACKET_OPEN BOOLEAN
    ;
button
    : string COMMA string
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
    : (DOUBLE_QUOTE_STRING|SINGLE_QUOTE_STRING) ARROW (DOUBLE_QUOTE_STRING|SINGLE_QUOTE_STRING)
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
    :CURLEY_BRACKET_OPEN string COLON map_value (string COLON map_value COMMA)* COMMA? CURLEY_BRACKET_CLOSE ;

map_value
    : string |DECIMAL
    // 'id?' 'string?' 'expression?'
    ;
program:
     start_page page* controller*
     ;
start_page:
    page
    ;
page:
    PAGE ID head (EXTENDS (ID COMMA?)*)? OPEN_CURLY_BRACE page_body* CLOSE_CURLY_BRACE
    ;
head:
    HEAD OPEN_BRACE title ClOSE_BRACE
    ;
title:
    STRING;
page_body:
    input
    | output
    | statement//statements include logics(for, if , switch),declaretions,directives
    ;
controller:
    CONTROLLER ID CONTROLES ID OPEN_CURLY_BRACE controller_body CLOSE_CURLY_BRACE
    ;
controller_body:
    | statement//statements include logics(for, if , switch),declaretions,directives
    | CHECK_AUTH OPEN_BRACE  CLOSE_BRACE
    | CHECK_VALID OPEN_BRACE STRING COMMA STRING  CLOSE_BRACE
    | CHECK_ROLE OPEN_BRACE STRING CLOSE_BRACE
    | REDIRECT ID
    ;
statement:
    IF OPEN_BRACE expression CLOSE_BRACE  OPEN_CURLY_BRACE page_body CLOSE_CURLY_BRACE
    ;




