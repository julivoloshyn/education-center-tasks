package com.knubisoft.tasks.algorithm.xml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class XMLTasksImpl implements XMLTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseXML(String xml) {

        if (xml.isEmpty()) {
            throw new NullPointerException();
        }

        ObjectMapper objectMapper = new XmlMapper();

        return objectMapper.readValue(xml, ModelRoot.class);
    }

    @Override
    public List<Integer> getAllIds(String xml) {

        ModelRoot modelRoot = parseXML(xml);

        List<Integer> idsList = new ArrayList<>();

        int i = 0;
        for (ModelRoot.Item item : modelRoot.getItems()) {
            idsList.add(i, item.id);
            i++;
        }
        return idsList;
    }

    @Override
    public List<String> getNameWithIdMoreThan1(String xml) {

        ModelRoot modelRoot = parseXML(xml);

        List<String> namesList = new ArrayList<>();

        for (ModelRoot.Item item : modelRoot.getItems()) {
            if (item.id > 1) {
                namesList.add(item.name);
            }
        }

        return namesList;
    }

    @SneakyThrows
    public Object xpath(String xml, String expression, QName q) {
        if (xml == null || xml.isEmpty()) {
            throw new NullPointerException();
        }

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression pathExpression = xPath.compile(expression + q + "/text()");
        InputSource inputSource = new InputSource(new StringReader(xml));

        NodeList nodes = (NodeList) pathExpression.evaluate(inputSource, XPathConstants.NODESET);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            list.add(nodes.item(i).getNodeValue());
        }

        return list;
    }

    public <T> List<T> apply(NodeList nodeList, Function<Node, T> tFunction) {
        return null;
    }
}
