package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    @Test
    void testToString() {
    }

    @Test
    void testToString1() {
    }

    @Test
    void toByteArray() {
    }

    @Test
    void normalize() {
    }

    @Test
    void readLines() {
    }

    @Test
    void isEmptyDirectory() {
    }
}