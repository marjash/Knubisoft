package com.knubisoft.tasks.algorithm.collection;

import lombok.SneakyThrows;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        try (Scanner scanner = new Scanner(url.openStream(), encoding.toString())) {
            return scanner.useDelimiter("\\A").next();
        } catch (IOException e) {
            throw new IOException("IOException");
        }
    }


    @Override
    public String toString(InputStream input, Charset charset) {
        if (input == null)
            throw new NullPointerException("InputStream cannot be null");
        try (Scanner scanner = new Scanner(input, charset.name())) {
            return scanner.useDelimiter("\\A").next();
        }
    }


    @Override
    public byte[] toByteArray(URL url) throws IOException {
        if (url == null)
            throw new NullPointerException();
        try (InputStream inputStream = url.openStream()){
            return inputStream.readAllBytes();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    @Override
    public String normalize(String fileName) {
        return null;
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        if (file == null)
            throw new NullPointerException();
        if (!file.exists() || file.isDirectory())
            throw new FileNotFoundException();
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(file, charset.name())) {
            while (scanner.hasNextLine())
                result.add(scanner.nextLine());
        }
        return result;
    }

    @SneakyThrows
    @Override
    public boolean isEmptyDirectory(File directory) {
        if (!directory.isDirectory())
            throw new NotDirectoryException(directory + " is not s directory");
        File[] files = directory.listFiles();
        return files == null;
    }
}
