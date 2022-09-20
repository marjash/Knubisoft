package com.knubisoft.tasks.algorithm.collection;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        } else
            return false;
        return true;
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {
        if (sourceDir == null || destinationDir == null)
            throw new NullPointerException("file can't be null");
        if (!sourceDir.exists())
            throw new FileNotFoundException("sourceDir doesn't exist");
        if (!sourceDir.isDirectory())
            throw new IOException(sourceDir + " is not a directory");
        if (sourceDir.getCanonicalPath().equals(destinationDir.getCanonicalPath()))
            throw new IOException("Source '" + sourceDir + "' and destination '" + destinationDir + "' are the same");
        Path destination = destinationDir.toPath();
        File copyDir = new File(destination + "/" + sourceDir.getName());
        if (!copyDir.exists())
            copyDir.mkdirs();
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory())
                    copyDirectoryToDirectory(f, copyDir);
                else {
                    Path path = Paths.get(copyDir.toPath() + "/" + f.getName());
                    java.nio.file.Files.copy(f.toPath(), path, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
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
