// Generated from D:/Damascus university-IT/4th year/second semestere/compiler-project/compiler-project-2\Parser.g4 by ANTLR 4.9.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Parser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#start_page}.
	 * @param ctx the parse tree
	 */
	void enterStart_page(Parser.Start_pageContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#start_page}.
	 * @param ctx the parse tree
	 */
	void exitStart_page(Parser.Start_pageContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(Parser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(Parser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(Parser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(Parser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(Parser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(Parser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#body_element}.
	 * @param ctx the parse tree
	 */
	void enterBody_element(Parser.Body_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#body_element}.
	 * @param ctx the parse tree
	 */
	void exitBody_element(Parser.Body_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(Parser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(Parser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_statement(Parser.Switch_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_statement(Parser.Switch_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#switch_body}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_body(Parser.Switch_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#switch_body}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_body(Parser.Switch_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(Parser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(Parser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(Parser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(Parser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#for_index}.
	 * @param ctx the parse tree
	 */
	void enterFor_index(Parser.For_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#for_index}.
	 * @param ctx the parse tree
	 */
	void exitFor_index(Parser.For_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#authentication}.
	 * @param ctx the parse tree
	 */
	void enterAuthentication(Parser.AuthenticationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#authentication}.
	 * @param ctx the parse tree
	 */
	void exitAuthentication(Parser.AuthenticationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#authorization}.
	 * @param ctx the parse tree
	 */
	void enterAuthorization(Parser.AuthorizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#authorization}.
	 * @param ctx the parse tree
	 */
	void exitAuthorization(Parser.AuthorizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#rawphp}.
	 * @param ctx the parse tree
	 */
	void enterRawphp(Parser.RawphpContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#rawphp}.
	 * @param ctx the parse tree
	 */
	void exitRawphp(Parser.RawphpContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#layoutInheritance}.
	 * @param ctx the parse tree
	 */
	void enterLayoutInheritance(Parser.LayoutInheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#layoutInheritance}.
	 * @param ctx the parse tree
	 */
	void exitLayoutInheritance(Parser.LayoutInheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#out_element}.
	 * @param ctx the parse tree
	 */
	void enterOut_element(Parser.Out_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#out_element}.
	 * @param ctx the parse tree
	 */
	void exitOut_element(Parser.Out_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(Parser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(Parser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#text_attributes}.
	 * @param ctx the parse tree
	 */
	void enterText_attributes(Parser.Text_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#text_attributes}.
	 * @param ctx the parse tree
	 */
	void exitText_attributes(Parser.Text_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#image}.
	 * @param ctx the parse tree
	 */
	void enterImage(Parser.ImageContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#image}.
	 * @param ctx the parse tree
	 */
	void exitImage(Parser.ImageContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#image_attributes}.
	 * @param ctx the parse tree
	 */
	void enterImage_attributes(Parser.Image_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#image_attributes}.
	 * @param ctx the parse tree
	 */
	void exitImage_attributes(Parser.Image_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#button}.
	 * @param ctx the parse tree
	 */
	void enterButton(Parser.ButtonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#button}.
	 * @param ctx the parse tree
	 */
	void exitButton(Parser.ButtonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#button_attributes}.
	 * @param ctx the parse tree
	 */
	void enterButton_attributes(Parser.Button_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#button_attributes}.
	 * @param ctx the parse tree
	 */
	void exitButton_attributes(Parser.Button_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(Parser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(Parser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#list_attributes}.
	 * @param ctx the parse tree
	 */
	void enterList_attributes(Parser.List_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#list_attributes}.
	 * @param ctx the parse tree
	 */
	void exitList_attributes(Parser.List_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(Parser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(Parser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#link}.
	 * @param ctx the parse tree
	 */
	void enterLink(Parser.LinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#link}.
	 * @param ctx the parse tree
	 */
	void exitLink(Parser.LinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#link_attributes}.
	 * @param ctx the parse tree
	 */
	void enterLink_attributes(Parser.Link_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#link_attributes}.
	 * @param ctx the parse tree
	 */
	void exitLink_attributes(Parser.Link_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#body_options}.
	 * @param ctx the parse tree
	 */
	void enterBody_options(Parser.Body_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#body_options}.
	 * @param ctx the parse tree
	 */
	void exitBody_options(Parser.Body_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#in_element}.
	 * @param ctx the parse tree
	 */
	void enterIn_element(Parser.In_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#in_element}.
	 * @param ctx the parse tree
	 */
	void exitIn_element(Parser.In_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(Parser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(Parser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#form_attributes}.
	 * @param ctx the parse tree
	 */
	void enterForm_attributes(Parser.Form_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#form_attributes}.
	 * @param ctx the parse tree
	 */
	void exitForm_attributes(Parser.Form_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#form_body}.
	 * @param ctx the parse tree
	 */
	void enterForm_body(Parser.Form_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#form_body}.
	 * @param ctx the parse tree
	 */
	void exitForm_body(Parser.Form_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#text_field}.
	 * @param ctx the parse tree
	 */
	void enterText_field(Parser.Text_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#text_field}.
	 * @param ctx the parse tree
	 */
	void exitText_field(Parser.Text_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#text_field_attributes}.
	 * @param ctx the parse tree
	 */
	void enterText_field_attributes(Parser.Text_field_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#text_field_attributes}.
	 * @param ctx the parse tree
	 */
	void exitText_field_attributes(Parser.Text_field_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(Parser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(Parser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#date_attributes}.
	 * @param ctx the parse tree
	 */
	void enterDate_attributes(Parser.Date_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#date_attributes}.
	 * @param ctx the parse tree
	 */
	void exitDate_attributes(Parser.Date_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#check_box}.
	 * @param ctx the parse tree
	 */
	void enterCheck_box(Parser.Check_boxContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#check_box}.
	 * @param ctx the parse tree
	 */
	void exitCheck_box(Parser.Check_boxContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#check_box_body}.
	 * @param ctx the parse tree
	 */
	void enterCheck_box_body(Parser.Check_box_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#check_box_body}.
	 * @param ctx the parse tree
	 */
	void exitCheck_box_body(Parser.Check_box_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(Parser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(Parser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#selection_attribute}.
	 * @param ctx the parse tree
	 */
	void enterSelection_attribute(Parser.Selection_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#selection_attribute}.
	 * @param ctx the parse tree
	 */
	void exitSelection_attribute(Parser.Selection_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#selection_body}.
	 * @param ctx the parse tree
	 */
	void enterSelection_body(Parser.Selection_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#selection_body}.
	 * @param ctx the parse tree
	 */
	void exitSelection_body(Parser.Selection_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#radio}.
	 * @param ctx the parse tree
	 */
	void enterRadio(Parser.RadioContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#radio}.
	 * @param ctx the parse tree
	 */
	void exitRadio(Parser.RadioContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#radio_body}.
	 * @param ctx the parse tree
	 */
	void enterRadio_body(Parser.Radio_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#radio_body}.
	 * @param ctx the parse tree
	 */
	void exitRadio_body(Parser.Radio_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#extra_attributes}.
	 * @param ctx the parse tree
	 */
	void enterExtra_attributes(Parser.Extra_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#extra_attributes}.
	 * @param ctx the parse tree
	 */
	void exitExtra_attributes(Parser.Extra_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#array_value}.
	 * @param ctx the parse tree
	 */
	void enterArray_value(Parser.Array_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#array_value}.
	 * @param ctx the parse tree
	 */
	void exitArray_value(Parser.Array_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#table_body}.
	 * @param ctx the parse tree
	 */
	void enterTable_body(Parser.Table_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#table_body}.
	 * @param ctx the parse tree
	 */
	void exitTable_body(Parser.Table_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#table_header_body}.
	 * @param ctx the parse tree
	 */
	void enterTable_header_body(Parser.Table_header_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#table_header_body}.
	 * @param ctx the parse tree
	 */
	void exitTable_header_body(Parser.Table_header_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#controller}.
	 * @param ctx the parse tree
	 */
	void enterController(Parser.ControllerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#controller}.
	 * @param ctx the parse tree
	 */
	void exitController(Parser.ControllerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Parser#controller_body}.
	 * @param ctx the parse tree
	 */
	void enterController_body(Parser.Controller_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Parser#controller_body}.
	 * @param ctx the parse tree
	 */
	void exitController_body(Parser.Controller_bodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(Parser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(Parser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralStringExpression(Parser.LiteralStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralStringExpression(Parser.LiteralStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTwoOperandsConditionExpression(Parser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTwoOperandsConditionExpression(Parser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcatConditionExpression(Parser.ConcatConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcatConditionExpression(Parser.ConcatConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMathematicalExpression(Parser.MathematicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMathematicalExpression(Parser.MathematicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexedVariableExpression(Parser.IndexedVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexedVariableExpression(Parser.IndexedVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOneOperandValuableExpression(Parser.OneOperandValuableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOneOperandValuableExpression(Parser.OneOperandValuableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralBooleanExpression(Parser.LiteralBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralBooleanExpression(Parser.LiteralBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOneOperandConditionExpression(Parser.OneOperandConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOneOperandConditionExpression(Parser.OneOperandConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableNameExpression(Parser.VariableNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableNameExpression(Parser.VariableNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralNumericExpression(Parser.LiteralNumericExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralNumericExpression(Parser.LiteralNumericExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralCharExpression(Parser.LiteralCharExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralCharExpression(Parser.LiteralCharExpressionContext ctx);
}