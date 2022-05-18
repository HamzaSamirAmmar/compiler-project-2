// Generated from D:/Damascus university-IT/4th year/second semestere/compiler-project/compiler-project-2\Parser.g4 by ANTLR 4.9.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#start_page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_page(Parser.Start_pageContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(Parser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(Parser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(Parser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(Parser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(Parser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#switch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch(Parser.SwitchContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#switch_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_body(Parser.Switch_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(Parser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(Parser.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#for_index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_index(Parser.For_indexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#authentication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthentication(Parser.AuthenticationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#authorization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuthorization(Parser.AuthorizationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#rawphp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawphp(Parser.RawphpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#layoutInheritance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutInheritance(Parser.LayoutInheritanceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#out_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOut_element(Parser.Out_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(Parser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#text_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_attributes(Parser.Text_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#image}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage(Parser.ImageContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#image_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImage_attributes(Parser.Image_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#button}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitButton(Parser.ButtonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#button_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitButton_attributes(Parser.Button_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(Parser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#list_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_attributes(Parser.List_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(Parser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(Parser.LinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#link_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink_attributes(Parser.Link_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#body_options}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_options(Parser.Body_optionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#in_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn_element(Parser.In_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(Parser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#form_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_attributes(Parser.Form_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#form_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_body(Parser.Form_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#text_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_field(Parser.Text_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#text_field_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_field_attributes(Parser.Text_field_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(Parser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#date_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_attributes(Parser.Date_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#check_box}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_box(Parser.Check_boxContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#check_box_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck_box_body(Parser.Check_box_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(Parser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#selection_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_attribute(Parser.Selection_attributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#selection_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_body(Parser.Selection_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#radio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadio(Parser.RadioContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#radio_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRadio_body(Parser.Radio_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#extra_attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtra_attributes(Parser.Extra_attributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#array_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_value(Parser.Array_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#table_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_body(Parser.Table_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#table_header_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_header_body(Parser.Table_header_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#controller}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController(Parser.ControllerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser#controller_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController_body(Parser.Controller_bodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(Parser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralStringExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralStringExpression(Parser.LiteralStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TwoOperandsConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTwoOperandsConditionExpression(Parser.TwoOperandsConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConcatConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatConditionExpression(Parser.ConcatConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathematicalExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathematicalExpression(Parser.MathematicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexedVariableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedVariableExpression(Parser.IndexedVariableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OneOperandValuableExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOperandValuableExpression(Parser.OneOperandValuableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralBooleanExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralBooleanExpression(Parser.LiteralBooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OneOperandConditionExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneOperandConditionExpression(Parser.OneOperandConditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableNameExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableNameExpression(Parser.VariableNameExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralNumericExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralNumericExpression(Parser.LiteralNumericExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralCharExpression}
	 * labeled alternative in {@link Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralCharExpression(Parser.LiteralCharExpressionContext ctx);
}