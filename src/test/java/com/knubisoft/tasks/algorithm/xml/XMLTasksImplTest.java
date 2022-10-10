package com.knubisoft.tasks.algorithm.xml;

import com.knubisoft.tasks.algorithm.ModelRoot;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XMLTasksImplTest {

    private final XMLTasks object = new XMLTasksImpl();
    private final String content;

    public XMLTasksImplTest() throws IOException {
        content = IOUtils.toString(Objects.requireNonNull(
                getClass().getClassLoader().getResourceAsStream("xml.xml")), StandardCharsets.UTF_8);
    }

    @SneakyThrows
    @Test
    void parseXML() {
        ModelRoot result = object.parseXML(content);
        InputStream wrongPath = ModelRoot.class.getClassLoader().getResourceAsStream("js.s");

        assertEquals(3, result.items.size());

        assertEquals(result.getItems().get(0), result.getItems().get(0));

        assertEquals("Cake3:3", result.getItems().get(2).name + ":" + result.getItems().get(2).id);

        assertThrows(IndexOutOfBoundsException.class, () -> result.items.get(result.getItems().size() + 1));
        assertThrows(NullPointerException.class, () -> object.parseXML(wrongPath.toString()));
    }

    @Test
    void getAllIds() {
        List<Integer> result = object.getAllIds(content);

        assertEquals(Arrays.asList(1,2,3), result);
    }

    @Test
    void getNameWithIdMoreThan1() {
        List<String> result = object.getNameWithIdMoreThan1(content);
        assertEquals(Arrays.asList("Cake2","Cake3"), result);
    }

    @Test
    void xpathSuccess() {
        String expression = "/root/items/element/batters/batter/element[id>'1001']/";
        String expression2 = "/root/items/element/batters/batter/element[type='Chocolate']/";

        assertEquals(List.of("Chocolate", "Blueberry", "Devil's Food", "Regular",
                "Chocolate", "Blueberry", "Devil's Food", "Regular", "Chocolate", "Blueberry",
                "Devil's Food"), object.xpath(content, expression, QName.valueOf("type")));
        assertEquals(List.of("1002", "2002", "3002"), object.xpath(content, expression2, QName.valueOf("id")));
    }

    @Test
    void xpathFail() {
        String expression = "/root/items/element/batters/batter/element[id>'1001']/";
        assertThrows(NullPointerException.class, () -> object.xpath("", expression, QName.valueOf("type")));
        assertThrows(NullPointerException.class, () -> object.xpath(null, expression, QName.valueOf("type")));
    }
}