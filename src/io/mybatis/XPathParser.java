package io.mybatis;

import io.mybatis.exceptions.BuilderException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/17
 **/
public class XPathParser {
    private XPath xPath;
    private Document document;
    private Properties variables;

    public XPathParser(InputStream inputStream) {
        commonConstructor();
        this.document = createDocument(new InputSource(inputStream));
        this.variables = new Properties();
    }

    public void commonConstructor() {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        this.xPath = xPathFactory.newXPath();
    }

    public Object evaluate(String expression, Object root, QName returnType) {
        try {
            return xPath.evaluate(expression, root, returnType);
        } catch (XPathExpressionException e) {
            throw new BuilderException("Error evaluating XPath.  Cause: " + e, e);
        }
    }

    public XNode evalNode(String expression) {
        return evalNode(document, expression);
    }

    public XNode evalNode(Object root, String expression) {
        Node node = (Node) evaluate(expression, root, XPathConstants.NODE);
        if (node == null) {
            return null;
        }
        return new XNode(this, node, variables);
    }

    private Document createDocument(InputSource inputSource) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            return builder.parse(inputSource);
        } catch (Exception e) {
            throw new BuilderException("Error creating document instance.  Cause: " + e, e);
        }
    }
}
