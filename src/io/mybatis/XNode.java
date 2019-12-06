package io.mybatis;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Properties;

/**
 * @description:
 * @author: YF.Mao
 * @create: 2019/9/17
 **/
public class XNode {
    private final Node node;
    private final String name;
    //private final String body;
    //private final Properties attributes;
    private final Properties variables;
    private final XPathParser xpathParser;

    public XNode(XPathParser xPathParser, Node node, Properties variables) {
        this.xpathParser = xPathParser;
        this.node = node;
        this.name = node.getNodeName();
        this.variables = variables;
        //this.attributes = parseAttributes(node);
        //this.body = parseBody(node);
    }

    //private Properties parseAttributes(Node n) {
    //    Properties attributes = new Properties();
    //    NamedNodeMap attributeNodes = n.getAttributes();
    //    if (attributeNodes != null) {
    //        for (int i = 0; i < attributeNodes.getLength(); i++) {
    //            Node attribute = attributeNodes.item(i);
    //            String value = PropertyParser.parse(attribute.getNodeValue(), variables);
    //            attributes.put(attribute.getNodeName(), value);
    //        }
    //    }
    //    return attributes;
    //}
}
