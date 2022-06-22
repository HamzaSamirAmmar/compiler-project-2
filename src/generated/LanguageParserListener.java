// Generated from C:/Users/ASUS/Desktop/cloned compiler/compiler-project-2/grammers\LanguageParser.g4 by ANTLR 4.9.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#start_page}.
	 * @param ctx the parse tree
	 */
	void enterStart_page(LanguageParser.Start_pageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#start_page}.
	 * @param ctx the parse tree
	 */
	void exitStart_page(LanguageParser.Start_pageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(LanguageParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(LanguageParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(LanguageParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(LanguageParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(LanguageParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(LanguageParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#body_element}.
	 * @param ctx the parse tree
	 */
	void enterBody_element(LanguageParser.Body_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#body_element}.
	 * @param ctx the parse tree
	 */
	void exitBody_element(LanguageParser.Body_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(LanguageParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(LanguageParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(LanguageParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(LanguageParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elsebody}.
	 * @param ctx the parse tree
	 */
	void enterElsebody(LanguageParser.ElsebodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elsebody}.
	 * @param ctx the parse tree
	 */
	void exitElsebody(LanguageParser.ElsebodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_statement(LanguageParser.Switch_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_statement(LanguageParser.Switch_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#switch_body}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_body(LanguageParser.Switch_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#switch_body}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_body(LanguageParser.Switch_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_case(LanguageParser.Switch_caseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_case(LanguageParser.Switch_caseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#switch_default}.
	 * @param ctx the parse tree
	 */
	void enterSwitch_default(LanguageParser.Switch_defaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#switch_default}.
	 * @param ctx the parse tree
	 */
	void exitSwitch_default(LanguageParser.Switch_defaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(LanguageParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(LanguageParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#shared_data_declaration}.
	 * @param ctx the parse tree
	 */
	void enterShared_data_declaration(LanguageParser.Shared_data_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#shared_data_declaration}.
	 * @param ctx the parse tree
	 */
	void exitShared_data_declaration(LanguageParser.Shared_data_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(LanguageParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(LanguageParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#for_index}.
	 * @param ctx the parse tree
	 */
	void enterFor_index(LanguageParser.For_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#for_index}.
	 * @param ctx the parse tree
	 */
	void exitFor_index(LanguageParser.For_indexContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#authentication}.
	 * @param ctx the parse tree
	 */
	void enterAuthentication(LanguageParser.AuthenticationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#authentication}.
	 * @param ctx the parse tree
	 */
	void exitAuthentication(LanguageParser.AuthenticationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#authorization}.
	 * @param ctx the parse tree
	 */
	void enterAuthorization(LanguageParser.AuthorizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#authorization}.
	 * @param ctx the parse tree
	 */
	void exitAuthorization(LanguageParser.AuthorizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#rawphp}.
	 * @param ctx the parse tree
	 */
	void enterRawphp(LanguageParser.RawphpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#rawphp}.
	 * @param ctx the parse tree
	 */
	void exitRawphp(LanguageParser.RawphpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#layoutInheritance}.
	 * @param ctx the parse tree
	 */
	void enterLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#layoutInheritance}.
	 * @param ctx the parse tree
	 */
	void exitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#out_element}.
	 * @param ctx the parse tree
	 */
	void enterOut_element(LanguageParser.Out_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#out_element}.
	 * @param ctx the parse tree
	 */
	void exitOut_element(LanguageParser.Out_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(LanguageParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(LanguageParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#text_attributes}.
	 * @param ctx the parse tree
	 */
	void enterText_attributes(LanguageParser.Text_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#text_attributes}.
	 * @param ctx the parse tree
	 */
	void exitText_attributes(LanguageParser.Text_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#image}.
	 * @param ctx the parse tree
	 */
	void enterImage(LanguageParser.ImageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#image}.
	 * @param ctx the parse tree
	 */
	void exitImage(LanguageParser.ImageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#image_attributes}.
	 * @param ctx the parse tree
	 */
	void enterImage_attributes(LanguageParser.Image_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#image_attributes}.
	 * @param ctx the parse tree
	 */
	void exitImage_attributes(LanguageParser.Image_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#button}.
	 * @param ctx the parse tree
	 */
	void enterButton(LanguageParser.ButtonContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#button}.
	 * @param ctx the parse tree
	 */
	void exitButton(LanguageParser.ButtonContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#button_attributes}.
	 * @param ctx the parse tree
	 */
	void enterButton_attributes(LanguageParser.Button_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#button_attributes}.
	 * @param ctx the parse tree
	 */
	void exitButton_attributes(LanguageParser.Button_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(LanguageParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(LanguageParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#list_attributes}.
	 * @param ctx the parse tree
	 */
	void enterList_attributes(LanguageParser.List_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#list_attributes}.
	 * @param ctx the parse tree
	 */
	void exitList_attributes(LanguageParser.List_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(LanguageParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(LanguageParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#link}.
	 * @param ctx the parse tree
	 */
	void enterLink(LanguageParser.LinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#link}.
	 * @param ctx the parse tree
	 */
	void exitLink(LanguageParser.LinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#link_attributes}.
	 * @param ctx the parse tree
	 */
	void enterLink_attributes(LanguageParser.Link_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#link_attributes}.
	 * @param ctx the parse tree
	 */
	void exitLink_attributes(LanguageParser.Link_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#body_options}.
	 * @param ctx the parse tree
	 */
	void enterBody_options(LanguageParser.Body_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#body_options}.
	 * @param ctx the parse tree
	 */
	void exitBody_options(LanguageParser.Body_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#in_element}.
	 * @param ctx the parse tree
	 */
	void enterIn_element(LanguageParser.In_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#in_element}.
	 * @param ctx the parse tree
	 */
	void exitIn_element(LanguageParser.In_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(LanguageParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(LanguageParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#form_attributes}.
	 * @param ctx the parse tree
	 */
	void enterForm_attributes(LanguageParser.Form_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#form_attributes}.
	 * @param ctx the parse tree
	 */
	void exitForm_attributes(LanguageParser.Form_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#form_body}.
	 * @param ctx the parse tree
	 */
	void enterForm_body(LanguageParser.Form_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#form_body}.
	 * @param ctx the parse tree
	 */
	void exitForm_body(LanguageParser.Form_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#text_field}.
	 * @param ctx the parse tree
	 */
	void enterText_field(LanguageParser.Text_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#text_field}.
	 * @param ctx the parse tree
	 */
	void exitText_field(LanguageParser.Text_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#text_field_attributes}.
	 * @param ctx the parse tree
	 */
	void enterText_field_attributes(LanguageParser.Text_field_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#text_field_attributes}.
	 * @param ctx the parse tree
	 */
	void exitText_field_attributes(LanguageParser.Text_field_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(LanguageParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(LanguageParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#date_attributes}.
	 * @param ctx the parse tree
	 */
	void enterDate_attributes(LanguageParser.Date_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#date_attributes}.
	 * @param ctx the parse tree
	 */
	void exitDate_attributes(LanguageParser.Date_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#check_box}.
	 * @param ctx the parse tree
	 */
	void enterCheck_box(LanguageParser.Check_boxContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#check_box}.
	 * @param ctx the parse tree
	 */
	void exitCheck_box(LanguageParser.Check_boxContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#check_box_attributes}.
	 * @param ctx the parse tree
	 */
	void enterCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#check_box_attributes}.
	 * @param ctx the parse tree
	 */
	void exitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(LanguageParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(LanguageParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#selection_attribute}.
	 * @param ctx the parse tree
	 */
	void enterSelection_attribute(LanguageParser.Selection_attributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#selection_attribute}.
	 * @param ctx the parse tree
	 */
	void exitSelection_attribute(LanguageParser.Selection_attributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#selection_body}.
	 * @param ctx the parse tree
	 */
	void enterSelection_body(LanguageParser.Selection_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#selection_body}.
	 * @param ctx the parse tree
	 */
	void exitSelection_body(LanguageParser.Selection_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(LanguageParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(LanguageParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#radio}.
	 * @param ctx the parse tree
	 */
	void enterRadio(LanguageParser.RadioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#radio}.
	 * @param ctx the parse tree
	 */
	void exitRadio(LanguageParser.RadioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#extra_attributes}.
	 * @param ctx the parse tree
	 */
	void enterExtra_attributes(LanguageParser.Extra_attributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#extra_attributes}.
	 * @param ctx the parse tree
	 */
	void exitExtra_attributes(LanguageParser.Extra_attributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#array_value}.
	 * @param ctx the parse tree
	 */
	void enterArray_value(LanguageParser.Array_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#array_value}.
	 * @param ctx the parse tree
	 */
	void exitArray_value(LanguageParser.Array_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#table_body}.
	 * @param ctx the parse tree
	 */
	void enterTable_body(LanguageParser.Table_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#table_body}.
	 * @param ctx the parse tree
	 */
	void exitTable_body(LanguageParser.Table_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#table_header_body}.
	 * @param ctx the parse tree
	 */
	void enterTable_header_body(LanguageParser.Table_header_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#table_header_body}.
	 * @param ctx the parse tree
	 */
	void exitTable_header_body(LanguageParser.Table_header_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#controller}.
	 * @param ctx the parse tree
	 */
	void enterController(LanguageParser.ControllerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#controller}.
	 * @param ctx the parse tree
	 */
	void exitController(LanguageParser.ControllerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#controller_body_element}.
	 * @param ctx the parse tree
	 */
	void enterController_body_element(LanguageParser.Controller_body_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#controller_body_element}.
	 * @param ctx the parse tree
	 */
	void exitController_body_element(LanguageParser.Controller_body_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(LanguageParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(LanguageParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#map_value}.
	 * @param ctx the parse tree
	 */
	void enterMap_value(LanguageParser.Map_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#map_value}.
	 * @param ctx the parse tree
	 */
	void exitMap_value(LanguageParser.Map_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(LanguageParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(LanguageParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalControllerFunctionCall}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalControllerFunctionCall(LanguageParser.LogicalControllerFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalControllerFunctionCall}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalControllerFunctionCall(LanguageParser.LogicalControllerFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralArrayExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralArrayExpression(LanguageParser.LiteralArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralArrayExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralArrayExpression(LanguageParser.LiteralArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SharedVariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSharedVariableNameExpression(LanguageParser.SharedVariableNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SharedVariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSharedVariableNameExpression(LanguageParser.SharedVariableNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FormVariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFormVariableNameExpression(LanguageParser.FormVariableNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FormVariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFormVariableNameExpression(LanguageParser.FormVariableNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralObjectExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralObjectExpression(LanguageParser.LiteralObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralObjectExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralObjectExpression(LanguageParser.LiteralObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx);
}