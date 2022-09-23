package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.NotDirectoryException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilesImplTest {

    private final Files files = new FilesImpl();

    @SneakyThrows
    @Test
    void contentEqualsSuccessful() {
        File file1 = new File("text1.txt");
        File file2 = new File("text2.txt");
        File file3 = new File("text3.txt");
        File file4 = new File("text4.txt");
        File file5 = new File("text5.txt");
        File file6 = new File("text6.txt");
        assertTrue(files.contentEquals(file1, file2));
        assertFalse(files.contentEquals(file3, file4));
        assertTrue(files.contentEquals(file5, file6));
        assertFalse(files.contentEquals(file4, file6));
    }

    @Test
    void contentEqualsFail(){
        File file1 = new File("text1.txt");
        File file2 = new File("src/test/java/com/knubisoft/tasks/algorithm/collection");
        File file7 = new File("text7.txt");
        file7.deleteOnExit();
        assertThrows(IOException.class, ()->files.contentEquals(file1, file2));
    }


    @SneakyThrows
    @Test
    void copyDirectoryToDirectorySuccessful() {
        File file1 = new File("one");
        File file2 = new File("two");
        files.copyDirectoryToDirectory(file1, file2);
        assertTrue(new File("two/one/bla/text1.txt").exists());
        assertTrue(new File("two/one/bla/text2.txt").exists());
        assertTrue(new File("two/one/text1.txt").exists());
        assertTrue(new File("two/one/text2.txt").exists());
        assertTrue(new File("two/one/text3.txt").exists());
        assertTrue(new File("two/one/text4.txt").exists());
    }

    @Test
    void copyDirectoryToDirectoryFail(){
        assertThrows(NullPointerException.class, ()-> files.copyDirectoryToDirectory(null, new File("two" )));
        assertThrows(IOException.class, ()-> files.copyDirectoryToDirectory(new File("one/text4"), new File("two" )));
        assertThrows(IOException.class, ()-> files.copyDirectoryToDirectory(new File("one"), new File("one" )));
        assertThrows(FileNotFoundException.class, ()-> files.copyDirectoryToDirectory(new File("one/1"), new File("two" )));
    }

    @SneakyThrows
    @Test
    void testToStringSuccessful() {
        URL url = new URL("https://www.baeldung.com/java-char-encoding");
        assertEquals(IOUtils.toString(url, StandardCharsets.UTF_8), files.toString(url, StandardCharsets.UTF_8));
    }
    @SneakyThrows
    @Test
    void testToStringFail(){
        URL url = new URL("https://www.baeldung.com/java");
        assertThrows(IOException.class, ()-> files.toString(url, StandardCharsets.UTF_8));
    }


    @SneakyThrows
    @Test
    void testToString1Successful() {
        InputStream inputStream = new FileInputStream("text1.txt");
        InputStream inputStream2 = new FileInputStream("text1.txt");
        assertEquals(IOUtils.toString(inputStream, StandardCharsets.UTF_8), files.toString(inputStream2, StandardCharsets.UTF_8));
    }

    @SneakyThrows
    @Test
    void toByteArraySuccessful() {
        URL url = new URL("https://google.com");
        InputStream inputStream = url.openStream();
        assertEquals(inputStream.readAllBytes(), files.toByteArray(url));
    }

    @SneakyThrows
    @Test
    void toByteArrayFail(){
        assertThrows(NullPointerException.class, ()-> files.toByteArray(null));
    }

    @Test
    void normalize() {
        assertEquals("/foo/", files.normalize("/foo//"));
        assertEquals("/foo/", files.normalize("/foo/./"));
        assertEquals("/bar", files.normalize("/foo/../bar"));
        assertEquals("/bar/", files.normalize("/foo/../bar/"));
        assertEquals("/baz", files.normalize("/foo/../bar/../baz"));
//        assertEquals("/foo/bar", files.normalize("//foo//./bar"));
        assertNull(files.normalize("/../"));
        assertNull(files.normalize("../foo"));
        assertEquals("foo/", files.normalize("foo/bar/.."));
        assertEquals("bar", files.normalize("foo/../bar"));
        assertEquals("//server/bar", files.normalize("//server/foo/../bar"));
        assertNull(files.normalize("//server/../bar"));
        assertEquals("C:\\bar", files.normalize("C:\\foo\\..\\bar"));
        assertNull(files.normalize("C:\\..\\bar "));
        assertEquals("~/bar/", files.normalize("~/foo/../bar/"));
        assertEquals("//server/bar", files.normalize("//server/foo/../bar"));
        assertNull(files.normalize("~/../bar"));
        FilenameUtils.normalize("//server/foo/../bar");
    }

    @SneakyThrows
    @Test
    void readLinesSuccessful() {
        File file = new File("text1.txt");
        InputStream inputStream = new FileInputStream(file);
        assertEquals(IOUtils.readLines(inputStream, StandardCharsets.UTF_8), files.readLines(file, StandardCharsets.UTF_8));
    }

    @SneakyThrows
    @Test
    void readLinesFail(){
        File file = new File("dit");
        File file2 = new File("dir");
        assertThrows(NullPointerException.class, ()-> files.readLines(null, StandardCharsets.UTF_8));
        assertThrows(FileNotFoundException.class, ()-> files.readLines(file, StandardCharsets.UTF_8));
        assertThrows(FileNotFoundException.class, ()-> files.readLines(file2, StandardCharsets.UTF_8));
    }

    @Test
    void isEmptyDirectorySuccessful() {
        File file = new File("one");
        File file2 = new File("dit");
        assertFalse(files.isEmptyDirectory(file));
        assertFalse(files.isEmptyDirectory(file2));
    }

    @Test
    void isEmptyDirectoryFail(){
        File file = new File("text1.txt");
        assertThrows(NotDirectoryException.class, ()-> files.isEmptyDirectory(file));
    }
}