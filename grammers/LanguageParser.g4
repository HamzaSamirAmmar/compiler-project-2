parser grammar LanguageParser;

options { tokenVocab=LanguageLexer; }

program
     : start_page page* controller*
     ;
start_page
    : page
    ;
page
    : PAGE  ID head (EXTENDS  ID (COMMA ID )*)? CURLEY_BRACKET_OPEN body_element* CURLEY_BRACKET_CLOSE
    ;
head
    : HEAD BRACKET_OPEN title BRACKET_CLOSE
    ;
title
    : STRING
    ;
body_element
    : in_element
    | out_element
    | statement //statements include logics(for, if , switch),declaretions,expressions
    | authentication
    | authorization
    | layoutInheritance
    ;
statement
    : if_statement
    | switch_statement
    | for_statement
    | variable_declaration
    | expression
    | rawphp
    ;
if_statement
    : IF BRACKET_OPEN expression BRACKET_CLOSE  CURLEY_BRACKET_OPEN body_element* CURLEY_BRACKET_CLOSE (ELSE CURLEY_BRACKET_OPEN body_element* CURLEY_BRACKET_CLOSE)?
    ;
switch_statement
    : SWITCH BRACKET_OPEN expression BRACKET_CLOSE CURLEY_BRACKET_OPEN switch_body CURLEY_BRACKET_CLOSE
    ;
switch_body
    : switch_case* switch_default?
    ;
switch_case
    :CASE expression COLON body_element* SEMI_COLON
    ;
switch_default
    : DEFAULT COLON body_element*
    ;
variable_declaration
    : AT ID EQUAL expression
    ;
for_statement
    : FOR BRACKET_OPEN for_index SEMI_COLON expression SEMI_COLON expression BRACKET_CLOSE CURLEY_BRACKET_OPEN body_element* CURLEY_BRACKET_CLOSE
    ;
for_index
    : variable_declaration
    ;
authentication
    : AT_AUTH body_element* (ELSE body_element*)? AT_END_AUTH
    | AT_GUEST body_element* (ELSE body_element*)? AT_END_GUEST
    ;
authorization
    : AT_ROLE BRACKET_OPEN SQUARE_OPEN STRING (COMMA STRING )*  SQUARE_CLOSE BRACKET_CLOSE body_element* (ELSE body_element*)? AT_END_ROLE
    | AT_INVERSE_ROLE BRACKET_OPEN SQUARE_OPEN STRING (COMMA STRING )* SQUARE_CLOSE BRACKET_CLOSE body_element* (ELSE body_element*)? AT_END_INVERSE_ROLE
    ;
rawphp
    : AT_RAW_PHP  AT_END_RAW_PHP
    ;
layoutInheritance
    : AT_SECTION BRACKET_OPEN STRING BRACKET_CLOSE body_element* AT_END_SECTION
    | AT_YIELD BRACKET_OPEN STRING BRACKET_CLOSE
    ;
out_element
    : text
    | table
    | button
    | image
    | list
    | link
    ;
text
    : TEXT BRACKET_OPEN text_attributes (COMMA  extra_attributes)? BRACKET_CLOSE
    ;
text_attributes
    : expression COMMA DECIMAL COMMA HEXCHARS
    ;
image
    : IMAGE BRACKET_OPEN image_attributes (COMMA extra_attributes)? BRACKET_CLOSE
    ;
image_attributes
    : STRING COMMA DECIMAL COMMA DECIMAL
    ;
button
    : BUTTON BRACKET_OPEN button_attributes (COMMA extra_attributes)? BRACKET_CLOSE
    ;
button_attributes
    : STRING COMMA STRING
    ;
list
    : LIST BRACKET_OPEN list_attributes (COMMA extra_attributes)? BRACKET_CLOSE CURLEY_BRACKET_OPEN body_options* CURLEY_BRACKET_CLOSE
    ;
list_attributes
    : BOOLEAN
    ;
table
    : TABLE BRACKET_OPEN BRACKET_CLOSE CURLEY_BRACKET_OPEN table_body CURLEY_BRACKET_CLOSE
    ;
link
    : LINK BRACKET_OPEN link_attributes (COMMA extra_attributes)? BRACKET_CLOSE CURLEY_BRACKET_OPEN body_options CURLEY_BRACKET_CLOSE
    ;
link_attributes
    : STRING
    ;
body_options
    : text
    | image
    | link
    | list
    ;
in_element
    : form
    | text_field
    | date
    | check_box
    | selection
    | radio
    ;
form
    : FORM BRACKET_OPEN form_attributes (COMMA extra_attributes)? BRACKET_CLOSE CURLEY_BRACKET_OPEN form_body CURLEY_BRACKET_CLOSE
    ;
form_attributes
    : METHOD COMMA STRING
    ;
form_body
    :  body_element*
    ;
text_field
    : TEXT_FIELD BRACKET_OPEN text_field_attributes (COMMA extra_attributes)? BRACKET_CLOSE
    ;
text_field_attributes
    : STRING COMMA STRING COMMA expression
    ;
date
    : DATE BRACKET_OPEN date_attributes (COMMA extra_attributes)? BRACKET_CLOSE
    ;
date_attributes
    : STRING COMMA STRING COMMA expression
    ;
check_box
    : CHECKBOX BRACKET_OPEN check_box_attributes (COMMA extra_attributes)? BRACKET_CLOSE //CURLEY_BRACKET_OPEN check_box_body? CURLEY_BRACKET_CLOSE
    ;
check_box_attributes
    : STRING COMMA expression COMMA STRING
    ;
//check_box_body
//    : body_options(COLON body_options)*
//    ;
selection
    : SELCTION BRACKET_OPEN selection_attribute (COMMA extra_attributes)? BRACKET_CLOSE  CURLEY_BRACKET_OPEN selection_body CURLEY_BRACKET_CLOSE
    ;
selection_attribute
    : BOOLEAN COMMA STRING
    ;
selection_body
    : option? (COLON option)*
    ;
option
    : ID COMMA expression
    ;
radio
    : RADIO BRACKET_OPEN extra_attributes? BRACKET_CLOSE CURLEY_BRACKET_OPEN selection_body CURLEY_BRACKET_CLOSE
    ;
//radio_body
//    : body_options(COLON body_options)*
//    ;
extra_attributes
    :  SQUARE_OPEN array_value (COMMA array_value)* SQUARE_CLOSE
    ;
array_value
    : STRING ARROW expression
    ;
table_body
    : HEADER COLON CURLEY_BRACKET_OPEN table_header_body CURLEY_BRACKET_CLOSE COMMA BODY COLON CURLEY_BRACKET_OPEN body_options(COMMA body_options)* CURLEY_BRACKET_CLOSE
    ;
table_header_body
    : text (COMMA text)*
    ;
controller
    : CONTROLLER ID CONTROLES ID CURLEY_BRACKET_OPEN controller_body_element* CURLEY_BRACKET_CLOSE
    ;
controller_body_element
    : statement//statements include logics(for, if , switch),declaretions,expressions
    | CHECK_AUTH BRACKET_OPEN  BRACKET_CLOSE
    | CHECK_VALID BRACKET_OPEN expression COMMA expression  BRACKET_CLOSE
    | CHECK_ROLE BRACKET_OPEN expression BRACKET_CLOSE
    | REDIRECT ID
    ;
expression
   : expression OPERATOR_TWO_OPERAND expression                #TwoOperandsConditionExpression
   | expression CONDITIONAL_CONCAT_OPERATOR expression         #ConcatConditionExpression
   | expression MULTIPLICATIVE_OPERATOR expression             #MathematicalExpression
   | expression ADDITIVE_OPERATOR expression                   #MathematicalExpression
   | AT ID                                                     #VariableNameExpression
   | DECIMAL                                                   #LiteralNumericExpression
   | CHAR                                                      #LiteralCharExpression
   | STRING                                                    #LiteralStringExpression
   | BOOLEAN                                                   #LiteralBooleanExpression
   | expression (SQUARE_OPEN expression SQUARE_CLOSE)          #IndexedVariableExpression
   | ONE_LOGICAL_OPERAND expression                            #OneOperandConditionExpression
   | ONE_VALUABLE_OPERAND expression                           #OneOperandValuableExpression
   | expression ONE_VALUABLE_OPERAND                           #OneOperandValuableExpression
   | BRACKET_OPEN expression BRACKET_CLOSE                     #ParenthesizedExpression
   ;