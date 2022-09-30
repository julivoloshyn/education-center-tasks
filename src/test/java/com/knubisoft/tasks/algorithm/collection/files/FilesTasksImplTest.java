package com.knubisoft.tasks.algorithm.collection.files;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilesTasksImplTest {

    FilesImpl instance = new FilesImpl();

    @SneakyThrows
    @Test
    void contentEqualsSuccess() {
        File file1 = new File("src/main/resources/file1");
        File file2 = new File("src/main/resources/file2");
        File file3 = new File("src/main/resources/file3");

        assertTrue(instance.contentEquals(file1, file2));
        assertTrue(instance.contentEquals(file1, file1));
        assertFalse(instance.contentEquals(file1, file3));
        assertFalse(instance.contentEquals(file2, file3));
    }

    @Test
    void contentEqualsFail() {
        File file1 = new File("file1");
        File file2 = new File("file2");

        File file3 = new File("src/main/resources/file3");

        assertThrows(NullPointerException.class, () -> instance.contentEquals(null, null));
        assertThrows(NullPointerException.class, () -> instance.contentEquals(file3, null));
        assertThrows(NoSuchFileException.class, () -> instance.contentEquals(file1, file2));
    }

    @SneakyThrows
    @Test
    void copyDirectoryToDirectorySuccess() {
        File sourceDir = new File("src/main/resources/testdir");
        File destinationDir = new File("src/main/resources/insertdir");

        instance.copyDirectoryToDirectory(sourceDir, destinationDir);

        boolean flag = FileUtils.getFile(destinationDir).isDirectory();

        assertTrue(flag);
    }

    @Test
    void copyDirectoryToDirectoryFail() {
        File sourceDir = new File("src/main/resources/testdir");
        File wrongFile = new File("");

        assertThrows(NullPointerException.class, () -> instance.copyDirectoryToDirectory(null, null));
        assertThrows(FileNotFoundException.class, () -> instance.copyDirectoryToDirectory(sourceDir, wrongFile));
    }

    @SneakyThrows
    @Test
    void ToStringUrlSuccessful(){
        URL url = new URL("https://github.com/julivoloshyn/education-center-tasks");
        Charset charset = Charset.defaultCharset();

        assertNotNull(instance.toString(url, charset));
    }

    @SneakyThrows
    @Test
    void ToStringUrlFail(){
        assertThrows(MalformedURLException.class, () -> instance.toString(new URL(""), Charset.defaultCharset()));
        assertThrows(NullPointerException.class, () -> instance.toString((URL) null, null));
    }

    @SneakyThrows
    @Test
    void toStringInputStreamSuccess(){
        InputStream test = new FileInputStream("src/main/resources/file1");
        InputStream test1 = new FileInputStream("src/main/resources/file2");

        Charset charset = Charset.defaultCharset();

        assertEquals(IOUtils.toString(test, charset), instance.toString(test1, charset));
    }

    @Test
    void toStringInputStreamFail(){
        assertThrows(NullPointerException.class, () -> instance.toString((URL) null, null));
        assertThrows(FileNotFoundException.class, () -> instance.toString(new FileInputStream(""), null));
    }

    @SneakyThrows
    @Test
    void toByteArraySuccess(){
        URL url = new URL("https://github.com/julivoloshyn?tab=repositories");

        assertNotNull(instance.toByteArray(url));
    }

    @Test
    void toByteArrayFail(){
        assertThrows(NullPointerException.class, () -> instance.toByteArray(null));
    }

    @Test
    void normalizeSuccess(){
        String file = "scr/main///resources/////file1";
        assertEquals("scr\\main\\resources\\file1", instance.normalize(file));
    }

    @Test
    void normalizeFail(){
        assertThrows(NullPointerException.class, () -> instance.normalize(null));
    }

    @SneakyThrows
    @Test
    void readLinesSuccess(){
        File file = new File("src/main/resources/file1");
        List<String> list = FileUtils.readLines(file, Charset.defaultCharset());

        assertEquals(list.get(0), instance.readLines(file, Charset.defaultCharset()).get(0));
    }

    @Test
    void readLinesFail(){
        File file = new File("src/main/resources/file1");

        assertThrows(NullPointerException.class, () -> instance.readLines(null, StandardCharsets.UTF_8));
        assertThrows(FileNotFoundException.class, () -> instance.readLines(new File(""), StandardCharsets.UTF_8));
        assertThrows(NullPointerException.class, () -> instance.readLines(file, null));
    }

    @Test
    void isEmptyDirectorySuccess() {
        File empty = new File("src/main/resources/testdir");
        File notEmpty = new File("src/main/resources/insertdir");

        assertTrue(instance.isEmptyDirectory(empty));
        assertFalse(instance.isEmptyDirectory(notEmpty));
    }

    @Test
    void isEmptyDirectoryFail(){
        File wrongDir = new File("src/main/resources/dir");

        assertThrows(NullPointerException.class, () -> instance.isEmptyDirectory(null));
        assertThrows(FileNotFoundException.class, () -> instance.isEmptyDirectory(wrongDir));
    }
}
