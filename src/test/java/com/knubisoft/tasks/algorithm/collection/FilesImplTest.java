package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    void copyDirectoryToDirectory() {
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