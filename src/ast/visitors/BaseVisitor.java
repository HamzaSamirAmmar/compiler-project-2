package ast.visitors;

import ast.nodes.AbstractNode;
import ast.nodes.basicNodes.expressions.Expression;
import ast.nodes.basicNodes.expressions.literals.MapNode;
import ast.nodes.basicNodes.expressions.literals.MapPairNode;
import ast.nodes.pageNodes.outNodes.*;
import generated.LanguageParser;
import generated.LanguageParserBaseVisitor;

import java.util.ArrayList;

public class BaseVisitor extends LanguageParserBaseVisitor<AbstractNode> {
    @Override
    public AbstractNode visitProgram(LanguageParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public AbstractNode visitStart_page(LanguageParser.Start_pageContext ctx) {
        return super.visitStart_page(ctx);
    }

    @Override
    public AbstractNode visitPage(LanguageParser.PageContext ctx) {
        return super.visitPage(ctx);
    }

    @Override
    public AbstractNode visitHead(LanguageParser.HeadContext ctx) {
        return super.visitHead(ctx);
    }

    @Override
    public AbstractNode visitTitle(LanguageParser.TitleContext ctx) {
        return super.visitTitle(ctx);
    }

    @Override
    public AbstractNode visitBody_element(LanguageParser.Body_elementContext ctx) {
        return super.visitBody_element(ctx);
    }

    @Override
    public AbstractNode visitStatement(LanguageParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public AbstractNode visitIf_statement(LanguageParser.If_statementContext ctx) {
        return super.visitIf_statement(ctx);
    }

    @Override
    public AbstractNode visitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        return super.visitSwitch_statement(ctx);
    }

    @Override
    public AbstractNode visitSwitch_body(LanguageParser.Switch_bodyContext ctx) {
        return super.visitSwitch_body(ctx);
    }

    @Override
    public AbstractNode visitVariable_declaration(LanguageParser.Variable_declarationContext ctx) {
        return super.visitVariable_declaration(ctx);
    }

    @Override
    public AbstractNode visitFor_statement(LanguageParser.For_statementContext ctx) {
        return super.visitFor_statement(ctx);
    }

    @Override
    public AbstractNode visitFor_index(LanguageParser.For_indexContext ctx) {
        return super.visitFor_index(ctx);
    }

    @Override
    public AbstractNode visitAuthentication(LanguageParser.AuthenticationContext ctx) {
        return super.visitAuthentication(ctx);
    }

    @Override
    public AbstractNode visitAuthorization(LanguageParser.AuthorizationContext ctx) {
        return super.visitAuthorization(ctx);
    }

    @Override
    public AbstractNode visitRawphp(LanguageParser.RawphpContext ctx) {
        return super.visitRawphp(ctx);
    }

    @Override
    public AbstractNode visitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        return super.visitLayoutInheritance(ctx);
    }

    @Override
    public AbstractNode visitOut_element(LanguageParser.Out_elementContext ctx) {
        System.out.println("in out element");
        if (ctx.button() != null)
            return visit(ctx.button());
        else if (ctx.image() != null)
            return visit(ctx.image());
        else if (ctx.link() != null)
            return visit(ctx.link());
        else if (ctx.list() != null)
            return visit(ctx.list());
        else if (ctx.table() != null)
            return visit(ctx.table());
        else //if (ctx.text()!=null)
            return visit(ctx.text());
    }

    @Override
    public AbstractNode visitText(LanguageParser.TextContext ctx) {
        Text text;
        MapNode extraAttributes;
        System.out.println("in text out element visitor");
        if (ctx.text_attributes() != null) {
            text = (Text) visitText_attributes(ctx.text_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visitExtra_attributes(ctx.extra_attributes());
                text.setExtraAttributes(extraAttributes);
            }
            return text;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitText_attributes(LanguageParser.Text_attributesContext ctx) {
        Expression text = (Expression) visit(ctx.expression());
        Integer fontSize = Integer.parseInt(ctx.DECIMAL().getText());
        String color = ctx.HEXCHARS().getText();
        Text textElement = new Text(text, fontSize, color, null);
        return textElement;
    }

    @Override
    public AbstractNode visitImage(LanguageParser.ImageContext ctx) {
        Image image;
        MapNode extraAttributes;
        System.out.println("in image out element visitor");
        if (ctx.image_attributes() != null) {
            image = (Image) visitImage_attributes(ctx.image_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visitExtra_attributes(ctx.extra_attributes());
                image.setExtraAttributes(extraAttributes);
            }
            return image;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitImage_attributes(LanguageParser.Image_attributesContext ctx) {
        String imgReference = ctx.STRING().getText();
        Integer height = Integer.parseInt(ctx.DECIMAL().get(0).getText());
        Integer width = Integer.parseInt(ctx.DECIMAL().get(1).getText());
        return new Image(imgReference, height, width, null);
    }

    @Override
    public AbstractNode visitButton(LanguageParser.ButtonContext ctx) {
        Button button;
        MapNode extraAttributes;
        System.out.println("in image out element visitor");
        if (ctx.button_attributes() != null) {
            button = (Button) visitButton_attributes(ctx.button_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visitExtra_attributes(ctx.extra_attributes());
                button.setExtraAttributes(extraAttributes);
            }
            return button;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitButton_attributes(LanguageParser.Button_attributesContext ctx) {
        String text = ctx.STRING().get(0).getText();
        String action = ctx.STRING().get(1).getText();
        return new Button(text, action, null);
    }

    @Override
    public AbstractNode visitList(LanguageParser.ListContext ctx) {
        List list;
        MapNode extraAttributes;
        ArrayList<OutNode> listBody = new ArrayList<>();
        System.out.println("in list out element visitor");
        if (ctx.list_attributes() != null) {
            list = (List) visitList_attributes(ctx.list_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visitExtra_attributes(ctx.extra_attributes());
                list.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.body_options().size(); i++) {
                listBody.add((OutNode) visit(ctx.body_options().get(i))); // need to check what is the body
            }
            list.setListBody(listBody);
            return list;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitList_attributes(LanguageParser.List_attributesContext ctx) {
        Boolean isOrdered = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        return new List(isOrdered, null, null);
    }

    @Override
    public AbstractNode visitTable(LanguageParser.TableContext ctx) {
        System.out.println("in table out element visitor");
        ArrayList<Text> headers= new ArrayList<>();
        ArrayList<OutNode> tableBody = new ArrayList<>();
        if (ctx.table_body().table_header_body() != null) {
            for (int i = 0; i < ctx.table_body().table_header_body().text().size(); i++) {
                headers.add((Text) visit(ctx.table_body().table_header_body().text().get(i)));
            }
        }else throw new RuntimeException("Invalid table");
        for(int i=0;i<ctx.table_body().body_options().size();i++){
            tableBody.add( (OutNode)visit(ctx.table_body().body_options().get(i)));
        }
        return new Table(headers,tableBody);
    }

    @Override
    public AbstractNode visitLink(LanguageParser.LinkContext ctx) {
        /*OutNode referenceElement;
    String linkReference;
    OutNode linkBody;
    ArrayList <MapPairNode> extraAttributes;*/
        Link link;
        MapNode extraAttributes;
        ArrayList<OutNode> linkBody = new ArrayList<>();
        System.out.println("in link out element visitor");
        if (ctx.link_attributes() != null) {
            link = (Link) visitLink_attributes(ctx.link_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visitExtra_attributes(ctx.extra_attributes());
                link.setExtraAttributes(extraAttributes);
            }
        }
        else
            throw new RuntimeException("invalid link");
        for(int i=0;i<ctx.body_options().size();i++){
            linkBody.add( (OutNode)visit(ctx.body_options().get(i)));
        }
        link.setLinkBody(linkBody);
        return link;
    }

    @Override
    public AbstractNode visitLink_attributes(LanguageParser.Link_attributesContext ctx) {
        String linkReference = ctx.STRING().getText();
        return new Link(linkReference,null,null);
    }

    @Override
    public AbstractNode visitBody_options(LanguageParser.Body_optionsContext ctx) {
        return super.visitBody_options(ctx);
    }

    @Override
    public AbstractNode visitIn_element(LanguageParser.In_elementContext ctx) {
        return super.visitIn_element(ctx);
    }

    @Override
    public AbstractNode visitForm(LanguageParser.FormContext ctx) {
        return super.visitForm(ctx);
    }

    @Override
    public AbstractNode visitForm_attributes(LanguageParser.Form_attributesContext ctx) {
        return super.visitForm_attributes(ctx);
    }

    @Override
    public AbstractNode visitForm_body(LanguageParser.Form_bodyContext ctx) {
        return super.visitForm_body(ctx);
    }

    @Override
    public AbstractNode visitText_field(LanguageParser.Text_fieldContext ctx) {
        return super.visitText_field(ctx);
    }

    @Override
    public AbstractNode visitText_field_attributes(LanguageParser.Text_field_attributesContext ctx) {
        return super.visitText_field_attributes(ctx);
    }

    @Override
    public AbstractNode visitDate(LanguageParser.DateContext ctx) {
        return super.visitDate(ctx);
    }

    @Override
    public AbstractNode visitDate_attributes(LanguageParser.Date_attributesContext ctx) {
        return super.visitDate_attributes(ctx);
    }

    @Override
    public AbstractNode visitCheck_box(LanguageParser.Check_boxContext ctx) {
        return super.visitCheck_box(ctx);
    }

    @Override
    public AbstractNode visitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx) {
        return super.visitCheck_box_attributes(ctx);
    }

    @Override
    public AbstractNode visitSelection(LanguageParser.SelectionContext ctx) {
        return super.visitSelection(ctx);
    }

    @Override
    public AbstractNode visitSelection_attribute(LanguageParser.Selection_attributeContext ctx) {
        return super.visitSelection_attribute(ctx);
    }

    @Override
    public AbstractNode visitSelection_body(LanguageParser.Selection_bodyContext ctx) {
        return super.visitSelection_body(ctx);
    }

    @Override
    public AbstractNode visitOption(LanguageParser.OptionContext ctx) {
        return super.visitOption(ctx);
    }

    @Override
    public AbstractNode visitRadio(LanguageParser.RadioContext ctx) {
        return super.visitRadio(ctx);
    }

    @Override
    public AbstractNode visitExtra_attributes(LanguageParser.Extra_attributesContext ctx) {
        ArrayList<MapPairNode> array_values = new ArrayList<>();
        for (int i=0;i<ctx.array_value().size();i++) {
            array_values.add((MapPairNode)visitArray_value(ctx.array_value().get(i)));
        }
        return new MapNode(array_values);
    }

    @Override
    public AbstractNode visitArray_value(LanguageParser.Array_valueContext ctx) {
       System.out.println("in array_value (key => value) node");
       String key = ctx.STRING().getText();
       Expression value =(Expression) visit(ctx.expression());
       MapPairNode pairNode = new MapPairNode(key,value);
       return  pairNode;
    }

    @Override
    public AbstractNode visitTable_body(LanguageParser.Table_bodyContext ctx) {
        return super.visitTable_body(ctx);
    }

    @Override
    public AbstractNode visitTable_header_body(LanguageParser.Table_header_bodyContext ctx) {
        return super.visitTable_header_body(ctx);
    }

    @Override
    public AbstractNode visitController(LanguageParser.ControllerContext ctx) {
        return super.visitController(ctx);
    }

    @Override
    public AbstractNode visitController_body_element(LanguageParser.Controller_body_elementContext ctx) {
        return super.visitController_body_element(ctx);
    }

    @Override
    public AbstractNode visitParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx) {
        return super.visitParenthesizedExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx) {
        return super.visitLiteralStringExpression(ctx);
    }

    @Override
    public AbstractNode visitTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx) {
        return super.visitTwoOperandsConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx) {
        return super.visitConcatConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx) {
        return super.visitMathematicalExpression(ctx);
    }

    @Override
    public AbstractNode visitIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx) {
        return super.visitIndexedVariableExpression(ctx);
    }

    @Override
    public AbstractNode visitOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx) {
        return super.visitOneOperandValuableExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx) {
        return super.visitLiteralBooleanExpression(ctx);
    }

    @Override
    public AbstractNode visitOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx) {
        return super.visitOneOperandConditionExpression(ctx);
    }

    @Override
    public AbstractNode visitVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx) {
        return super.visitVariableNameExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx) {
        return super.visitLiteralNumericExpression(ctx);
    }

    @Override
    public AbstractNode visitLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx) {
        return super.visitLiteralCharExpression(ctx);
    }
}
