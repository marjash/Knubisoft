package com.knubisoft.tasks.algorithm.xml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.annotations.VisibleForTesting;
import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.xpath.*;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class XMLTasksImpl implements XMLTasks {

    @Override
    @SneakyThrows
    public ModelRoot parseXML(String xml) {
        if (xml == null || xml.isEmpty())
            throw new NullPointerException();
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(xml, ModelRoot.class);
    }

    @SneakyThrows
    @Override
    public List<Integer> getAllIds(String xml) {
        if (xml == null || xml.isEmpty())
            throw new NullPointerException();
        XmlMapper mapper = new XmlMapper();
        List<Integer> list = new ArrayList<>();
        ModelRoot modelRoot = mapper.readValue(xml, ModelRoot.class);
        List<ModelRoot.Item> items = modelRoot.getItems();
        for (ModelRoot.Item i : items) {
            list.add(i.id);
        }
        return list;
    }

    @SneakyThrows
    @Override
    public List<String> getNameWithIdMoreThan1(String xml) {
        if (xml == null || xml.isEmpty())
            throw new NullPointerException();
        XmlMapper mapper = new XmlMapper();
        List<String> list = new ArrayList<>();
        ModelRoot modelRoot = mapper.readValue(xml, ModelRoot.class);
        List<ModelRoot.Item> items = modelRoot.getItems();
        for (ModelRoot.Item i : items) {
            if (i.id > 1)
                list.add(i.name);
        }
        return list;
    }

    @SneakyThrows
    @VisibleForTesting
    public Object xpath(String xml, String expression, QName q) {
        if (xml == null || xml.isEmpty())
            throw new NullPointerException();
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression pathExpression = xPath.compile(expression + q + "/text()");
        InputSource inputSource = new InputSource( new StringReader(xml) );
        NodeList nodes = (NodeList) pathExpression.evaluate(inputSource, XPathConstants.NODESET);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            list.add(nodes.item(i).getNodeValue());
        }
        return list;
    }

    private <T> List<T> apply(NodeList nodeList, Function<Node, T> tFunction) {
        return null;
    }
}
