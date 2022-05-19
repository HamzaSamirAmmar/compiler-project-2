// Generated from D:/Damascus university-IT/4th year/second semestere/compiler-project/compiler-project-2/grammers\LanguageParser.g4 by ANTLR 4.9.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#start_page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_page(LanguageParser.Start_pageContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(LanguageParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(LanguageParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(LanguageParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#body_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_element(LanguageParser.Body_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(LanguageParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#switch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_statement(LanguageParser.Switch_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#switch_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_body(LanguageParser.Switch_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(LanguageParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(LanguageParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#for_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_index(LanguageParser.For_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#authentication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthentication(LanguageParser.AuthenticationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#authorization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthorization(LanguageParser.AuthorizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#rawphp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawphp(LanguageParser.RawphpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#layoutInheritance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#out_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut_element(LanguageParser.Out_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(LanguageParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#text_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_attributes(LanguageParser.Text_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#image}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage(LanguageParser.ImageContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#image_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage_attributes(LanguageParser.Image_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#button}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitButton(LanguageParser.ButtonContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#button_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitButton_attributes(LanguageParser.Button_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(LanguageParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#list_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_attributes(LanguageParser.List_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(LanguageParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(LanguageParser.LinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#link_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink_attributes(LanguageParser.Link_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#body_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_options(LanguageParser.Body_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#in_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_element(LanguageParser.In_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(LanguageParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#form_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_attributes(LanguageParser.Form_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#form_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_body(LanguageParser.Form_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#text_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_field(LanguageParser.Text_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#text_field_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_field_attributes(LanguageParser.Text_field_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(LanguageParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#date_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_attributes(LanguageParser.Date_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#check_box}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_box(LanguageParser.Check_boxContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#check_box_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(LanguageParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#selection_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_attribute(LanguageParser.Selection_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#selection_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_body(LanguageParser.Selection_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(LanguageParser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#radio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadio(LanguageParser.RadioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#extra_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra_attributes(LanguageParser.Extra_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#array_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_value(LanguageParser.Array_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#table_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_body(LanguageParser.Table_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#table_header_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_header_body(LanguageParser.Table_header_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#controller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController(LanguageParser.ControllerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#controller_body_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController_body_element(LanguageParser.Controller_body_elementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx);
}