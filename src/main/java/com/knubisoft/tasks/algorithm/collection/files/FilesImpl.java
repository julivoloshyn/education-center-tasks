package com.knubisoft.tasks.algorithm.collection.files;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FilesImpl implements FilesInterface{

    @Override
    public boolean contentEquals(File file1, File file2) throws IOException {
        if(!file1.exists() || !file2.exists()){
            throw new NoSuchFileException("File exception");
        }

        if(file1.length() != file2.length()) {
            return false;
        }

        List<String> list1 = Files.readAllLines(Path.of(file1.getPath()));
        List<String> list2 = Files.readAllLines(Path.of(file2.getPath()));

        return list1.equals(list2);
    }

    @Override
    public void copyDirectoryToDirectory(File sourceDir, File destinationDir) throws IOException {
        if(sourceDir == null || destinationDir == null) {
            throw new NullPointerException();
        }

        if(!sourceDir.exists() || !destinationDir.exists()) {
            throw new FileNotFoundException();
        }

        FileUtils.copyDirectoryToDirectory(sourceDir, destinationDir);
    }

    @Override
    public String toString(URL url, Charset encoding) throws IOException {
        if(url == null || encoding == null){
            throw new NullPointerException();
        }

        try (Scanner scanner = new Scanner(url.openStream(), encoding.toString())){
            return scanner.useDelimiter("\\A").next();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    @Override
    public String toString(InputStream input, Charset charset) throws IOException {
        if (input == null || charset == null){
            throw new NullPointerException();
        }

        return IOUtils.toString(input, charset);
    }

    @SneakyThrows
    @Override
    public byte[] toByteArray(URL url){
        if(url == null){
            throw new NullPointerException();
        }

        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        return bufferedReader.readLine().getBytes();
    }

    @Override
    public String normalize(String fileName) {
        if(fileName == null){
            throw new NullPointerException();
        }

        return Paths.get(fileName).normalize().toString();
    }

    @Override
    public List<String> readLines(File file, Charset charset) throws IOException {
        if (file == null || charset == null){
            throw new NullPointerException();
        }

        if (!file.exists()){
            throw new FileNotFoundException();
        }

        return FileUtils.readLines(file, charset);
    }

    @SneakyThrows
    @Override
    public boolean isEmptyDirectory(File directory) {
        if(directory == null){
            throw new NullPointerException();
        }

        if (!directory.exists()){
            throw new FileNotFoundException();
        }

        return Objects.requireNonNull(directory.list()).length == 0;
    }
}
