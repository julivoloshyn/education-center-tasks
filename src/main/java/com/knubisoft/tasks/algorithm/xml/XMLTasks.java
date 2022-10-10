package com.knubisoft.tasks.algorithm.xml;

import com.knubisoft.tasks.algorithm.ModelRoot;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.function.Function;

public interface XMLTasks {

    ModelRoot parseXML(String xml);

    List<Integer> getAllIds(String xml);

    List<String> getNameWithIdMoreThan1(String xml);

    Object xpath(String xml, String expression, QName q);

    <T> List<T> apply(NodeList nodeList, Function<Node, T> tFunction);

}
