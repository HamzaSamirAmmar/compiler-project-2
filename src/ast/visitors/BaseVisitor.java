package ast.visitors;

import ast.nodes.AbstractNode;
import ast.nodes.Element;
import ast.nodes.Program;
import ast.nodes.basicNodes.*;
import ast.nodes.basicNodes.expressions.*;
import ast.nodes.basicNodes.expressions.Math.AdditiveNode;
import ast.nodes.basicNodes.expressions.Math.MultiplicativeNode;
import ast.nodes.basicNodes.expressions.Math.OneOperandMathematicalNode;
import ast.nodes.basicNodes.expressions.conditions.ConditionConcatenation;
import ast.nodes.basicNodes.expressions.conditions.OneOperandCondition;
import ast.nodes.basicNodes.expressions.conditions.TwoOperandCondition;
import ast.nodes.basicNodes.expressions.literals.*;
import ast.nodes.controllerNodes.Controller;
import ast.nodes.controllerNodes.contollerElements.AuthCheck;
import ast.nodes.controllerNodes.contollerElements.Redirect;
import ast.nodes.controllerNodes.contollerElements.RoleCheck;
import ast.nodes.controllerNodes.contollerElements.ValidCheck;
import ast.nodes.pageNodes.*;
import ast.nodes.pageNodes.authNodes.AtAuth;
import ast.nodes.pageNodes.authNodes.AtGuest;
import ast.nodes.pageNodes.authorizetionNodes.AtInverseRole;
import ast.nodes.pageNodes.authorizetionNodes.AtRole;
import ast.nodes.pageNodes.inNodes.*;
import ast.nodes.pageNodes.layoutNodes.Section;
import ast.nodes.pageNodes.layoutNodes.Yield;
import ast.nodes.pageNodes.outNodes.*;
import generated.LanguageParser;
import generated.LanguageParserBaseVisitor;
import semanticExceptions.IncompatibleExpressionTypeException;
import symbolTable.SymbolTable;

import java.lang.Iterable;
import java.util.ArrayList;

/**
 * in base visitor we travers the parse tree and we detect semantic errors that relate to type checking
 */

public class BaseVisitor extends LanguageParserBaseVisitor<AbstractNode> {
    SymbolTable symbolTable;
    ArrayList<String> errors;

    ArrayList<Page> pageNodes = new ArrayList<>();

    ArrayList<Controller> controllerNodes = new ArrayList<>();

    public BaseVisitor() {
    }

    public BaseVisitor(SymbolTable symbolTable, ArrayList<String> errors, ArrayList<Page> pageNodes, ArrayList<Controller> controllerNodes) {
        this.symbolTable = symbolTable;
        this.errors = errors;
        this.pageNodes = pageNodes;
        this.controllerNodes = controllerNodes;

    }

    @Override
    public Program visitProgram(LanguageParser.ProgramContext ctx) {
        ArrayList<Page> pages = new ArrayList<>();
        ArrayList<Controller> controllers = new ArrayList<>();
        pages.add((Page) visit(ctx.start_page()));
        pageNodes.add((Page) visit(ctx.start_page()));
        for (int i = 0; i < ctx.page().size(); i++) {
            Page page = (Page) visit(ctx.page(i));
            pages.add(page);
            pageNodes.add(page);
        }
        for (int i = 0; i < ctx.controller().size(); i++) {
            controllers.add((Controller) visit(ctx.controller(i)));
        }
//        pageNodes.addAll(pages);
        controllerNodes.addAll(controllers);
        System.out.println("length of controller list is " + controllerNodes.size());
        System.out.println("length of page list is " + pageNodes.size());
        return new Program(pages, controllers);
    }

    @Override
    public Page visitStart_page(LanguageParser.Start_pageContext ctx) {
        return (Page) visit(ctx.page());
    }

    @Override
    public Page visitPage(LanguageParser.PageContext ctx) {
        String id;
        String title = null;
        ArrayList<Element> bodyElements = new ArrayList<>();
        id = ctx.ID(0).getText();
        String extendedPageId = null;
        if (ctx.ID(1) != null)
            extendedPageId = ctx.ID(1).getText();
        if (ctx.head().HEAD() != null) {
            title = ctx.head().title().getText();
        }
        for (int i = 0; i < ctx.body_element().size(); i++) {
            bodyElements.add((Element) visit(ctx.body_element(i)));
        }
        return new Page(id, title, bodyElements, extendedPageId);
    }

    @Override
    public AbstractNode visitSwitch_case(LanguageParser.Switch_caseContext ctx) {
        Expression expression;
        ArrayList<Element> body = new ArrayList<>();
        expression = (Expression) visit(ctx.expression());
        for (int i = 0; i < ctx.element().size(); i++) {
            body.add((Element) visit(ctx.element(i)));
        }
        return new SwitchCase(expression, body);
    }

    @Override
    public AbstractNode visitSwitch_default(LanguageParser.Switch_defaultContext ctx) {
        System.out.println("In switch default");
        return super.visitSwitch_default(ctx);
    }

    @Override
    public AbstractNode visitHead(LanguageParser.HeadContext ctx) {
        System.out.println("In visit head");
        return visit(ctx.title());
    }

    @Override//not used
    public AbstractNode visitTitle(LanguageParser.TitleContext ctx) {
        System.out.println("In visit title");
        return super.visitTitle(ctx);
    }

    @Override
    public AbstractNode visitBody_element(LanguageParser.Body_elementContext ctx) {
        System.out.println("In visit body element");
        if (ctx.in_element() != null) {
            return visit(ctx.in_element());
        } else if (ctx.out_element() != null) {
            return visit(ctx.out_element());
        } else if (ctx.statement() != null) {
            return visit(ctx.statement());
        } else if (ctx.authentication() != null) {
            return visit(ctx.authentication());
        } else if (ctx.authorization() != null) {
            return visit(ctx.authorization());
        } else {
            return visit(ctx.layoutInheritance());
        }

    }

    @Override
    public AbstractNode visitStatement(LanguageParser.StatementContext ctx) {
        System.out.println("In visit statement");
        if (ctx.if_statement() != null) {
            return visit(ctx.if_statement());
        } else if (ctx.switch_statement() != null) {
            return visit(ctx.switch_statement());
        } else if (ctx.for_statement() != null) {
            return visit(ctx.for_statement());
        } else if (ctx.variable_declaration() != null) {
            return visit(ctx.variable_declaration());
        } else if (ctx.shared_data_declaration() != null) {
            return visitShared_data_declaration(ctx.shared_data_declaration());
        } else if (ctx.expression() != null) {
            return visit(ctx.expression());
        } else {
            return visit(ctx.rawphp());
        }

    }

    @Override
    public AbstractNode visitElement(LanguageParser.ElementContext ctx) {
        if (ctx.body_element() != null)
            return visit(ctx.body_element());
        else if(ctx.controller_body_element() != null)
            return visit(ctx.controller_body_element());
        else return visit(ctx.statement());

    }

    @Override
    public AbstractNode visitIf_statement(LanguageParser.If_statementContext ctx) {
        Expression condition;
        ArrayList<Element> bodyElements = new ArrayList<>();
        ArrayList<Element> elseBodyElements = new ArrayList<>();
        condition = (Expression) visit(ctx.expression());
        //check the type of the expression
        if (!(condition instanceof Logical)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.IF().getSymbol().getLine(), ctx.IF().getSymbol().getCharPositionInLine(),
                    "LogicalNode", condition.getClass().getSimpleName());
            this.errors.add(typeException.toString());
        }
        for (int i = 0; i < ctx.element().size(); i++) {
            bodyElements.add((Element) visit(ctx.element(i)));
        }
        if (ctx.elsebody() != null) {
            for (int i = 0; i < ctx.elsebody().element().size(); i++) {
                elseBodyElements.add((Element) visit(ctx.elsebody().element().get(i)));
            }
        }
        return new IfStatement(condition, bodyElements, elseBodyElements);
    }

    @Override//not used
    public AbstractNode visitElsebody(LanguageParser.ElsebodyContext ctx) {
        return super.visitElsebody(ctx);
    }

    @Override
    public AbstractNode visitSwitch_statement(LanguageParser.Switch_statementContext ctx) {
        Expression expression;
        ArrayList<SwitchCase> switchCases = new ArrayList<>();
        expression = (Expression) visit(ctx.expression());
        if (!(expression instanceof Valuable) || !(expression instanceof Concatable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(), ctx.expression().start.getCharPositionInLine(), "Valuable or Contactable", expression.getClass().getSimpleName());
            this.errors.add(typeException.toString());
        }
        for (int i = 0; i < ctx.switch_body().switch_case().size(); i++) {
            switchCases.add((SwitchCase) visit(ctx.switch_body().switch_case(i)));
        }
        if (ctx.switch_body().switch_default() != null) {
            ArrayList<Element> elements = new ArrayList<>();
            for (int i = 0; i < ctx.switch_body().switch_default().element().size(); i++) {
                elements.add((Element) visit(ctx.switch_body().switch_default().element().get(i)));

            }
            switchCases.add(new SwitchCase(null, elements));
        }
        return new Switch(expression, switchCases);
    }

    @Override
    public AbstractNode visitSwitch_body(LanguageParser.Switch_bodyContext ctx) {
        System.out.println("In visit switch body");
        return super.visitSwitch_body(ctx);
    }

    @Override
    public AbstractNode visitVariable_declaration(LanguageParser.Variable_declarationContext ctx) {
        System.out.println("in Variable_declaration visitor");
        VariableDeclaration variableDeclaration = new VariableDeclaration();
        variableDeclaration.setId(ctx.ID().toString());
        variableDeclaration.setValue((Expression) visit(ctx.expression()));
        if (variableDeclaration.getValue() instanceof OneOperandMathematicalNode) {
            ((OneOperandMathematicalNode) variableDeclaration.getValue()).setSolStatement(false);
        }
        return variableDeclaration;
    }

    @Override
    public AbstractNode visitFor_statement(LanguageParser.For_statementContext ctx) {
        System.out.println("in For_statement visitor");
        ForStatement forStatement = new ForStatement();
        forStatement.setVariableDeclaration((VariableDeclaration) visit(ctx.for_index()));
        forStatement.setConditionExpression((Expression) visit(ctx.expression(0)));
        if (!(forStatement.getConditionExpression() instanceof Logical)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression(0).stop.getLine(), ctx.expression(0).stop.getCharPositionInLine(),
                    "LogicalNode", forStatement.getConditionExpression().getClass().getSimpleName());
            this.errors.add(typeException.toString());
        }
        forStatement.setStepExpression((Expression) visit(ctx.expression(1)));
        if (!(forStatement.getStepExpression() instanceof OneOperandMathematicalNode)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression(1).stop.getLine(), ctx.expression(1).stop.getCharPositionInLine(),
                    "OneOperandMathematicalNode", forStatement.getStepExpression().getClass().getSimpleName());
            this.errors.add(typeException.toString());
        } else {
            ((OneOperandMathematicalNode) forStatement.getStepExpression()).setSolStatement(false);
        }
        ArrayList<Element> bodyElements = new ArrayList<>();
        for (int i = 0; i < ctx.element().size(); i++) {
            bodyElements.add((Element) visit(ctx.element(i)));
        }
        forStatement.setBodyElements(bodyElements);
        return forStatement;
    }

    @Override
    public AbstractNode visitFor_index(LanguageParser.For_indexContext ctx) {
        return visitVariable_declaration(ctx.variable_declaration());
    }

    @Override
    public AbstractNode visitAuthentication(LanguageParser.AuthenticationContext ctx) {
        System.out.println("in Authentication visitor");
        ArrayList<Element> bodyElements = new ArrayList<>();
        ArrayList<Element> elseBodyElements = new ArrayList<>();
        if (ctx.AT_AUTH() != null) {

            AtAuth atAuth = new AtAuth();
            if (ctx.ELSE() != null) {
                int i;
                for (i = 1; i < ctx.children.indexOf(ctx.ELSE()); i++) {
                    bodyElements.add((Element) visit(ctx.getChild(i)));
                }
                for (i = ctx.children.indexOf(ctx.ELSE()) + 1; i < ctx.children.indexOf(ctx.AT_END_AUTH()); i++) {
                    elseBodyElements.add((Element) visit(ctx.getChild(i)));
                }
                atAuth.setBodyElements(bodyElements);
                atAuth.setElseBodyElements(elseBodyElements);
                return atAuth;
            } else {
                int i;
                for (i = 0; i < ctx.body_element().size(); i++) {
                    bodyElements.add((Element) visit(ctx.body_element(i)));
                }
                atAuth.setBodyElements(bodyElements);
                return atAuth;
            }
        } else {
            AtGuest atGuest = new AtGuest();
            if (ctx.ELSE() != null) {
                int i;
                for (i = 1; i < ctx.children.indexOf(ctx.ELSE()); i++) {
                    bodyElements.add((Element) visit(ctx.getChild(i)));
                }
                for (i = ctx.children.indexOf(ctx.ELSE()) + 1; i < ctx.children.indexOf(ctx.AT_END_GUEST()); i++) {
                    elseBodyElements.add((Element) visit(ctx.getChild(i)));
                }
                atGuest.setBodyElements(bodyElements);
                atGuest.setElseBodyElements(elseBodyElements);
                return atGuest;
            } else {
                int i;
                for (i = 0; i < ctx.body_element().size(); i++) {
                    bodyElements.add((Element) visit(ctx.body_element(i)));
                }
                atGuest.setBodyElements(bodyElements);
                return atGuest;
            }
        }
    }

    @Override
    public AbstractNode visitAuthorization(LanguageParser.AuthorizationContext ctx) {
        System.out.println("in Authorization visitor");
        ArrayList<Element> bodyElements = new ArrayList<>();
        ArrayList<Element> elseBodyElements = new ArrayList<>();
        ArrayList<String> roles = new ArrayList<>();
        for (int i = 0; i < ctx.STRING().size(); i++) {
            roles.add(ctx.STRING(i).toString());
        }
        if (ctx.AT_ROLE() != null) {

            AtRole atRole = new AtRole();
            atRole.setRoles(roles);
            if (ctx.ELSE() != null) {

                int i;

                for (i = ctx.children.indexOf(ctx.BRACKET_CLOSE()) + 1; i < ctx.children.indexOf(ctx.ELSE()); i++) {
                    bodyElements.add((Element) visit(ctx.getChild(i)));
                }
                for (i = ctx.children.indexOf(ctx.ELSE()) + 1; i < ctx.children.indexOf(ctx.AT_END_ROLE()); i++) {
                    elseBodyElements.add((Element) visit(ctx.getChild(i)));
                }
                atRole.setBodyElements(bodyElements);
                atRole.setElseBodyElements(elseBodyElements);
                return atRole;
            } else {
                int i;
                for (i = 0; i < ctx.body_element().size(); i++) {
                    bodyElements.add((Element) visit(ctx.body_element(i)));
                }
                atRole.setBodyElements(bodyElements);
                return atRole;
            }
        } else {
            AtInverseRole atInverseRole = new AtInverseRole();
            atInverseRole.setRoles(roles);
            if (ctx.ELSE() != null) {
                int i;
                for (i = ctx.children.indexOf(ctx.BRACKET_CLOSE()) + 1; i < ctx.children.indexOf(ctx.ELSE()); i++) {
                    bodyElements.add((Element) visit(ctx.getChild(i)));
                }
                for (i = ctx.children.indexOf(ctx.ELSE()) + 1; i < ctx.children.indexOf(ctx.AT_END_INVERSE_ROLE()); i++) {
                    elseBodyElements.add((Element) visit(ctx.getChild(i)));
                }
                atInverseRole.setBodyElements(bodyElements);
                atInverseRole.setElseBodyElements(elseBodyElements);
                return atInverseRole;
            } else {
                int i;
                for (i = 0; i < ctx.body_element().size(); i++) {
                    bodyElements.add((Element) visit(ctx.body_element(i)));
                }
                atInverseRole.setBodyElements(bodyElements);
                return atInverseRole;
            }
        }
    }

    @Override
    public AbstractNode visitRawphp(LanguageParser.RawphpContext ctx) {
        RawPHP rawPHP = new RawPHP();
        rawPHP.setRawPhp(ctx.AT_END_RAW_PHP().toString().split("@endrawphp")[0]);
        return rawPHP;
    }

    @Override
    public AbstractNode visitLayoutInheritance(LanguageParser.LayoutInheritanceContext ctx) {
        if (ctx.AT_SECTION() != null) {
            Section section = new Section();
            section.setName(ctx.STRING().getText());
            ArrayList<Element> bodyElements = new ArrayList<>();
            for (int i = 0; i < ctx.body_element().size(); i++) {
                bodyElements.add((Element) visit(ctx.body_element(i)));
            }
            for (int i = 0; i < pageNodes.size(); i++) {
                for (int j = 0; j < pageNodes.get(i).getBodyElements().size(); j++) {
                    if (pageNodes.get(i).getBodyElements().get(j) instanceof Yield) {
                        if (((Yield) pageNodes.get(i).getBodyElements().get(j)).getName().equals(
                                section.getName()
                        )) {
                            for (int k = 0; k < pageNodes.get(i).getBodyElements().size(); k++) {
                                if (k < j) {
                                    bodyElements.add(0, pageNodes.get(i).getBodyElements().get(k));
                                } else if (k > j) {
                                    bodyElements.add(pageNodes.get(i).getBodyElements().get(k));
                                }
                            }
//                            ((Yield) pageNodes.get(i).getBodyElements().get(j)).setBodyElements(((Section) section.getBodyElements().get(j)).getBodyElements());
                        }
                    }
                }
            }
            section.setBodyElements(bodyElements);
            return section;
        } else {
            Yield yield = new Yield();
            /// get section elements and add them to yield
            yield.setName(ctx.STRING().getText());
            return yield;
        }
    }

    @Override//should contain all cases in if else
    public AbstractNode visitOut_element(LanguageParser.Out_elementContext ctx) {
        System.out.println("in out element");
        if (ctx.button() != null) return visit(ctx.button());
        else if (ctx.image() != null) return visit(ctx.image());
        else if (ctx.link() != null) return visit(ctx.link());
        else if (ctx.list() != null) return visit(ctx.list());
        else if (ctx.table() != null) return visit(ctx.table());
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
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                text.setExtraAttributes(extraAttributes);
            }
            return text;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitText_attributes(LanguageParser.Text_attributesContext ctx) {
        Expression text = (Expression) visit(ctx.expression());
        if (!(text instanceof Valuable)) {
            errors.add(new IncompatibleExpressionTypeException(ctx.expression().start.getLine()
                    , ctx.expression().start.getCharPositionInLine(), "valuable", text.getClass().getSimpleName()).toString());
        }
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
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
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
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
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
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                list.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.body_options().size(); i++) {
                listBody.add((OutNode) visit(ctx.body_options().get(i).getChild(0))); // need to check what is the body
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
        ArrayList<Text> headers = new ArrayList<>();
        ArrayList<OutNode> tableBody = new ArrayList<>();
        if (ctx.table_body().table_header_body() != null) {
            for (int i = 0; i < ctx.table_body().table_header_body().text().size(); i++) {
                visit(ctx.table_body().table_header_body());
                headers.add((Text) visit(ctx.table_body().table_header_body().text().get(i)));
            }
        } else throw new RuntimeException("Invalid table");
        for (int i = 0; i < ctx.table_body().body_options().size(); i++) {
            tableBody.add((OutNode) visit(ctx.table_body().body_options().get(i).getChild(0)));
        }
        MapNode extraAttributes =null;
        if (ctx.extra_attributes() != null) {
            extraAttributes = (MapNode) visit(ctx.extra_attributes());
        }
        return new Table(headers, tableBody,extraAttributes);
    }

    @Override
    public AbstractNode visitLink(LanguageParser.LinkContext ctx) {
        Link link;
        MapNode extraAttributes;
        ArrayList<OutNode> linkBody = new ArrayList<>();
        System.out.println("in link out element visitor");
        if (ctx.link_attributes() != null) {
            link = (Link) visit(ctx.link_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                link.setExtraAttributes(extraAttributes);
            }
        } else throw new RuntimeException("invalid link");
        for (int i = 0; i < ctx.body_options().size(); i++) {
            linkBody.add((OutNode) visit(ctx.body_options().get(i).getChild(0)));
        }
        link.setLinkBody(linkBody);
        return link;
    }

    @Override
    public AbstractNode visitLink_attributes(LanguageParser.Link_attributesContext ctx) {
        String linkReference = ctx.STRING().getText();
        return new Link(linkReference, null, null);
    }

    @Override
    public AbstractNode visitBody_options(LanguageParser.Body_optionsContext ctx) {
        return visit(ctx);
    }

    @Override
    public AbstractNode visitIn_element(LanguageParser.In_elementContext ctx) {
        System.out.println("Visit in element");
        if (ctx.check_box() != null) return visit(ctx.check_box());
        else if (ctx.form() != null) return visit(ctx.form());
        else if (ctx.text_field() != null) return visit(ctx.text_field());
        else if (ctx.date() != null) return visit(ctx.date());
        else if (ctx.radio() != null) return visit(ctx.radio());
        else
            return visit(ctx.selection());
    }

    @Override
    public AbstractNode visitForm(LanguageParser.FormContext ctx) {
        Form form;
        MapNode extraAttributes;
        ArrayList<Element> formBody = new ArrayList<>();
        System.out.println("in form in element visitor");
        if (ctx.form_attributes() != null) {
            form = (Form) visitForm_attributes(ctx.form_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                form.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.form_body().body_element().size(); i++) {
                formBody.add((Element) visit(ctx.form_body().body_element().get(i)));
            }
            form.setFormBody(formBody);
            return form;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitForm_attributes(LanguageParser.Form_attributesContext ctx) {
        String method = ctx.METHOD().getText();
        String action = ctx.STRING().getText();
        return new Form(method, action, null, null);
    }

    @Override
    public AbstractNode visitForm_body(LanguageParser.Form_bodyContext ctx) {
        System.out.println("In visit form body");
        return super.visitForm_body(ctx);
    }

    @Override
    public AbstractNode visitText_field(LanguageParser.Text_fieldContext ctx) {
        TextField textField;
        MapNode extraAttributes;
        System.out.println("in text field in element visitor");
        if (ctx.text_field_attributes() != null) {
            textField = (TextField) visitText_field_attributes(ctx.text_field_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                textField.setExtraAttributes(extraAttributes);
            }
            return textField;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitText_field_attributes(LanguageParser.Text_field_attributesContext ctx) {

        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        Expression value = (Expression) visit(ctx.expression());
        if (!(value instanceof Valuable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(),
                    ctx.expression().start.getCharPositionInLine(), "Valuable", value.getClass().getSimpleName());
            errors.add(typeException.toString());
        }
        TextField textField = new TextField(name, label, value, null);
        return textField;
    }

    @Override
    public AbstractNode visitDate(LanguageParser.DateContext ctx) {
        Date date;
        MapNode extraAttributes;
        System.out.println("in date in element visitor");
        if (ctx.date_attributes() != null) {
            date = (Date) visitDate_attributes(ctx.date_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                date.setExtraAttributes(extraAttributes);
            }
            return date;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitDate_attributes(LanguageParser.Date_attributesContext ctx) {

        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        Expression value = (Expression) visit(ctx.expression());
        if (!(value instanceof Valuable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(),
                    ctx.expression().start.getCharPositionInLine(), "Valuable", value.getClass().getSimpleName());
            errors.add(typeException.toString());
        }
        Date date = new Date(name, label, value, null);
        return date;
    }

    @Override
    public AbstractNode visitCheck_box(LanguageParser.Check_boxContext ctx) {
        CheckBox checkBox;
        MapNode extraAttributes;
        System.out.println("in checkBox in element visitor");
        if (ctx.check_box_attributes() != null) {
            checkBox = (CheckBox) visitCheck_box_attributes(ctx.check_box_attributes());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                checkBox.setExtraAttributes(extraAttributes);
            }
            return checkBox;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitCheck_box_attributes(LanguageParser.Check_box_attributesContext ctx) {
        String name = ctx.STRING().get(0).getText();
        String label = ctx.STRING().get(1).getText();
        Expression expression = (Expression) visit(ctx.expression());
        if (!(expression instanceof Valuable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(),
                    ctx.expression().start.getCharPositionInLine(), "Valuable", expression.getClass().getSimpleName());
            errors.add(typeException.toString());
        }
        CheckBox checkBox = new CheckBox(name, label, expression, null);
        return checkBox;
    }

    @Override
    public AbstractNode visitSelection(LanguageParser.SelectionContext ctx) {
        Selection selection;
        MapNode extraAttributes;
        ArrayList<Option> selectionBody = new ArrayList<>();
        System.out.println("in selection in element visitor");
        if (ctx.selection_attribute() != null) {
            selection = (Selection) visitSelection_attribute(ctx.selection_attribute());
            if (ctx.extra_attributes() != null) {
                extraAttributes = (MapNode) visit(ctx.extra_attributes());
                selection.setExtraAttributes(extraAttributes);
            }
            for (int i = 0; i < ctx.selection_body().option().size(); i++) {
                selectionBody.add((Option) visit(ctx.selection_body().option().get(i)));
            }
            selection.setOptions(selectionBody);
            return selection;
        }
        throw new RuntimeException("Invalid text");
    }

    @Override
    public AbstractNode visitSelection_attribute(LanguageParser.Selection_attributeContext ctx) {
        Boolean isMultiple = Boolean.parseBoolean(ctx.BOOLEAN().getText());
        String name = ctx.STRING().getText();
        return new Selection(isMultiple, name, null, null);
    }

    @Override
    public AbstractNode visitSelection_body(LanguageParser.Selection_bodyContext ctx) {

        return super.visitSelection_body(ctx);
    }

    @Override
    public AbstractNode visitOption(LanguageParser.OptionContext ctx) {
        String label = ctx.STRING().getText();
        Expression expression = (Expression) visit(ctx.expression());
        if (!(expression instanceof Valuable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(),
                    ctx.expression().start.getCharPositionInLine(), "Valuable", expression.getClass().getSimpleName());
            errors.add(typeException.toString());
        }
        return new Option(expression, label);
    }

    @Override
    public AbstractNode visitRadio(LanguageParser.RadioContext ctx) {
        Radio radio = new Radio(null, null, null);
        MapNode extraAttributes;
        ArrayList<Option> radioOptions = new ArrayList<>();
        System.out.println("in selection in element visitor");
        radio.setName(ctx.ID().getText());
        if (ctx.extra_attributes() != null) {
            extraAttributes = (MapNode) visit(ctx.extra_attributes());
            radio.setExtraAttributes(extraAttributes);
        }
        for (int i = 0; i < ctx.selection_body().option().size(); i++) {
            radioOptions.add((Option) visit(ctx.selection_body().option().get(i)));
        }
        radio.setOptions(radioOptions);
        return radio;

    }

    @Override
    public AbstractNode visitExtra_attributes(LanguageParser.Extra_attributesContext ctx) {
        ArrayList<MapPairNode> array_values = new ArrayList<>();
        for (int i = 0; i < ctx.array_value().size(); i++) {
            array_values.add((MapPairNode) visitArray_value(ctx.array_value().get(i)));
        }
        return new MapNode(array_values);
    }

    @Override
    public AbstractNode visitArray_value(LanguageParser.Array_valueContext ctx) {
        System.out.println("in array_value (key => value) node");
        String key = ctx.STRING().getText();
        Expression value = (Expression) visit(ctx.expression());
        if (!(value instanceof Valuable)) {
            Exception typeException = new IncompatibleExpressionTypeException(ctx.expression().start.getLine(),
                    ctx.expression().start.getCharPositionInLine(), "Valuable", value.getClass().getSimpleName());
            errors.add(typeException.toString());
        }
        MapPairNode pairNode = new MapPairNode(key, value);
        return pairNode;
    }

    @Override
    public AbstractNode visitTable_body(LanguageParser.Table_bodyContext ctx) {
        System.out.println("Visit in table body");
        return super.visitTable_body(ctx);
    }

    @Override
    public AbstractNode visitTable_header_body(LanguageParser.Table_header_bodyContext ctx) {
        System.out.println("Visit in header body");
        return super.visitTable_header_body(ctx);
    }

    @Override
    public AbstractNode visitController(LanguageParser.ControllerContext ctx) {
        String id;
        String controlledPageId;
        ArrayList<Element> bodyElements = new ArrayList<>();
        id = ctx.ID(0).getText();
        controlledPageId = ctx.ID(1).getText();
        for (int i = ctx.children.indexOf(ctx.CURLEY_BRACKET_OPEN()) + 1; i < ctx.children.indexOf(ctx.CURLEY_BRACKET_CLOSE()); i++) {
            bodyElements.add((Element) visit(ctx.getChild(i)));
        }
        return new Controller(controlledPageId, id, bodyElements);
    }

    @Override
    public AbstractNode visitLogicalControllerFunctionCall(LanguageParser.LogicalControllerFunctionCallContext ctx) {
        if (ctx.CHECK_AUTH() != null) {
            return new AuthCheck();
        } else if (ctx.CHECK_VALID() != null) {
            Expression uniqueIdentifier = (Expression) visit(ctx.expression(0));
            Expression password = (Expression) visit(ctx.expression(1));
            // both uniqueIdentifier and password should either be literal string or variable names only
            if (!(uniqueIdentifier instanceof StringNode) && !(uniqueIdentifier instanceof VariableNode)) {
                Exception typeException = new IncompatibleExpressionTypeException(ctx.expression(0).start.getLine(),
                        ctx.expression(0).start.getCharPositionInLine(), "String or variable name", uniqueIdentifier.getClass().getSimpleName());
                errors.add(typeException.toString());
            }
            if (!(password instanceof StringNode) && !(password instanceof VariableNode)) {
                Exception typeException = new IncompatibleExpressionTypeException(ctx.expression(1).start.getLine(),
                        ctx.expression(1).start.getCharPositionInLine(), "String or variable name", password.getClass().getSimpleName());
                errors.add(typeException.toString());
            }
            return new ValidCheck(uniqueIdentifier, password);
        } else if (ctx.CHECK_ROLE() != null) {
            Expression role = (Expression) visit(ctx.expression(0));
            if (!(role instanceof StringNode) && !(role instanceof VariableNode)) {
                Exception typeException = new IncompatibleExpressionTypeException(ctx.expression(0).start.getLine(),
                        ctx.expression(0).start.getCharPositionInLine(), "String or variable name", role.getClass().getSimpleName());
                errors.add(typeException.toString());
            }
            return new RoleCheck(role);
        } else
            return super.visitLogicalControllerFunctionCall(ctx);
    }

    @Override
    public AbstractNode visitController_body_element(LanguageParser.Controller_body_elementContext ctx) {
        if (ctx.REDIRECT() != null) {
            String goalPageId = ctx.ID().getText();
            return new Redirect(goalPageId);}
//        }else if(ctx.statement()!=null)
//            return visit(ctx.statement());
        return super.visitController_body_element(ctx);
    }

    @Override
    public AbstractNode visitParenthesizedExpression(LanguageParser.ParenthesizedExpressionContext ctx) {
        System.out.println("in Parenthesized Expression visitor");
        return visit(ctx.expression());
    }

    @Override
    public AbstractNode visitLiteralStringExpression(LanguageParser.LiteralStringExpressionContext ctx) {
        System.out.println("in literal string expression visitor");
        String fullText = ctx.STRING().getText();
        if (ctx.STRING().getText().length() == 3) {
            return new CharNode(fullText.charAt(1));
        }
        return new StringNode(fullText.substring(1, fullText.length() - 1));
    }

    @Override
    public AbstractNode visitTwoOperandsConditionExpression(LanguageParser.TwoOperandsConditionExpressionContext ctx) {
        System.out.println("in two operands condition visitor");
        Expression leftOperand = (Expression) visit(ctx.expression(0));
        Expression rightOperand = (Expression) visit(ctx.expression(1));
        String operator = ctx.OPERATOR_TWO_OPERAND().getText();

        return new TwoOperandCondition(leftOperand, rightOperand, operator);
    }

    @Override
    public AbstractNode visitConcatConditionExpression(LanguageParser.ConcatConditionExpressionContext ctx) {
        System.out.println("in Condition Concatenation visitor");
        Expression leftOperand = (Expression) visit(ctx.expression(0));
        Expression rightOperand = (Expression) visit(ctx.expression(1));
        String operator = ctx.CONDITIONAL_CONCAT_OPERATOR().getText();

        return new ConditionConcatenation(operator, leftOperand, rightOperand);
    }

    @Override
    public AbstractNode visitMathematicalExpression(LanguageParser.MathematicalExpressionContext ctx) {
        System.out.println("Math is Math, and nothing else");
        if (ctx.ADDITIVE_OPERATOR() != null) {
            System.out.println("Additive");
            String operator = ctx.ADDITIVE_OPERATOR().getText();
            Expression leftOperand = (Expression) visit(ctx.expression(0));
            Expression rightOperand = (Expression) visit(ctx.expression(1));
            return new AdditiveNode(leftOperand, rightOperand, operator);
        } else {
            System.out.println("Multiplication");
            String operator = ctx.MULTIPLICATIVE_OPERATOR().getText();
            Expression leftOperand = (Expression) visit(ctx.expression(0));
            Expression rightOperand = (Expression) visit(ctx.expression(1));
            return new MultiplicativeNode(leftOperand, rightOperand, operator);
        }
    }

    @Override
    public AbstractNode visitIndexedVariableExpression(LanguageParser.IndexedVariableExpressionContext ctx) {
        System.out.println("in indexed variable expression visitor");
        if (ctx.SQUARE_OPEN() != null && ctx.SQUARE_CLOSE() != null) {
            Expression indexed = (Expression) visit(ctx.expression(0));
            Expression index = (Expression) visit(ctx.expression(1));
            if (indexed instanceof Iterable && index instanceof Numeric)
                return new IndexedExpressionNode(indexed, index);
        }
        throw new RuntimeException("Invalid Indexed Variable Expression");
    }

    @Override
    public AbstractNode visitOneOperandValuableExpression(LanguageParser.OneOperandValuableExpressionContext ctx) {
        System.out.println("One operand valuable");
        boolean operandIsLeft = (ctx.children.get(0) == ctx.ONE_VALUABLE_OPERAND());
        String operator = ctx.ONE_VALUABLE_OPERAND().getText();
        Expression operand = (Expression) visit(ctx.expression());
        return new OneOperandMathematicalNode(operandIsLeft, operator, operand);
    }

    @Override
    public AbstractNode visitLiteralBooleanExpression(LanguageParser.LiteralBooleanExpressionContext ctx) {
        System.out.println("in literal boolean expression visitor");
        return new BooleanNode(Boolean.parseBoolean(ctx.BOOLEAN().getText()));
    }

    @Override
    public AbstractNode visitOneOperandConditionExpression(LanguageParser.OneOperandConditionExpressionContext ctx) {
        System.out.println("in one operand condition visitor");
        Expression operand = (Expression) visit(ctx.expression());
        return new OneOperandCondition(operand);
    }

    @Override
    public AbstractNode visitVariableNameExpression(LanguageParser.VariableNameExpressionContext ctx) {
        System.out.println("in variable name expression visitor");
        return new VariableNode(ctx.ID().getText());
    }

    @Override
    public AbstractNode visitLiteralNumericExpression(LanguageParser.LiteralNumericExpressionContext ctx) {
        System.out.println("in literal numeric expression visitor");
        return new DecimalNode(Double.parseDouble(ctx.DECIMAL().getText()));
    }

    @Override
    public AbstractNode visitLiteralCharExpression(LanguageParser.LiteralCharExpressionContext ctx) {
        System.out.println("in literal char expression visitor");
        return new CharNode(ctx.CHAR().getText().charAt(1));
    }

    @Override
    public AbstractNode visitArray(LanguageParser.ArrayContext ctx) {
        ArrayList<Expression> elements = new ArrayList<>();
        for (int i = 0; i < ctx.expression().size(); i++) {
            elements.add((Expression) visit(ctx.expression(i)));
        }
        return new ListNode(elements);
    }

    @Override
    public AbstractNode visitMap_value(LanguageParser.Map_valueContext ctx) {
        System.out.println("in map_value visitor");
        MapPairNode keyValue = new MapPairNode();
        keyValue.setKey(ctx.ID().getText());
        keyValue.setValue((Expression) visit(ctx.expression()));
        return keyValue;
    }

    @Override
    public AbstractNode visitMap(LanguageParser.MapContext ctx) {
        System.out.println("in map visitor");
        ArrayList<MapPairNode> pairNodes = new ArrayList<>();
        for (int i = 0; i < ctx.map_value().size(); i++) {
            pairNodes.add((MapPairNode) visit(ctx.map_value(i)));
        }
        return new MapNode(pairNodes);
    }

    @Override
    public AbstractNode visitLiteralArrayExpression(LanguageParser.LiteralArrayExpressionContext ctx) {
        System.out.println("in Literal Array Expression visitor");
        return visit(ctx.array());
    }

    @Override
    public AbstractNode visitLiteralObjectExpression(LanguageParser.LiteralObjectExpressionContext ctx) {
        System.out.println("in literal object expression visitor");
        MapNode map = (MapNode) visit(ctx.map());
        return map;
    }

    @Override
    public AbstractNode visitShared_data_declaration(LanguageParser.Shared_data_declarationContext ctx) {
        SharedDataDeclaration sharedDataDeclaration = new SharedDataDeclaration();
        sharedDataDeclaration.setId(ctx.ID().toString());
        sharedDataDeclaration.setValue((Expression) visit(ctx.expression()));
        if (sharedDataDeclaration.getValue() instanceof OneOperandMathematicalNode) {
            ((OneOperandMathematicalNode) sharedDataDeclaration.getValue()).setSolStatement(false);
        }
        return sharedDataDeclaration;
    }

    @Override
    public AbstractNode visitSharedVariableNameExpression(LanguageParser.SharedVariableNameExpressionContext ctx) {
        return new SharedDataNode(ctx.ID().getText());
    }

    @Override
    public AbstractNode visitFormVariableNameExpression(LanguageParser.FormVariableNameExpressionContext ctx) {
        return new FormDataNode(ctx.ID().getText());
    }
}
