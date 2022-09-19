package com.knubisoft.tasks.algorithm.collection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class FilesImpl implements Files {

    @Override
    public boolean contentEquals(File file1, File file2) throws IOException {
        if (!file1.exists() && !file2.exists())
            return true;
        if (file1.exists() && file2.exists()) {
            if (file1.isDirectory() || file2.isDirectory())
                throw new IOException();
            if (file1.length() != file2.length())
                return false;
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            byte[] arr1 = new byte[(int) file1.length()];
            byte[] arr2 = new byte[(int) file2.length()];
            fileInputStream.read(arr1);
            fileInputStream.close();
            fileInputStream2.read(arr2);
            fileInputStream2.close();
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i])
                    return false;
            }
        }
        else
            return false;
        return true;
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {

    }

    @Override
    public String toString(URL url, Charset encoding) throws IOException {
        return null;
    }

    @Override
    public String toString(InputStream input, Charset charset) throws IOException {
        return null;
    }

    @Override
    public byte[] toByteArray(URL url) throws IOException {
        return new byte[0];
    }

    @Override
    public String normalize(String fileName) {
        return null;
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        return null;
    }

    @Override
    public boolean isEmptyDirectory(File directory) {
        return false;
    }
}
