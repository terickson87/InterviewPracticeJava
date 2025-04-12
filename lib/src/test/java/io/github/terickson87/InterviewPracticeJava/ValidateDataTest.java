package io.github.terickson87.InterviewPracticeJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateDataTest {
    private ValidateData validateData;

    @BeforeEach
    public void setup() {
        validateData = new ValidateData();
    }

    @Test
    public void example() throws IOException {
        boolean expected = true;
        File directory = new File("src/test/resources");
        File[] fileList = directory.listFiles();
        File file = new File("src/test/resources/validateDataExample.txt");
        Path path = file.toPath();
        List<String> fileLines = Files.readAllLines(path);

        boolean result = validateData.validateData(fileLines);

        assertEquals(expected, result);
    }

    @Test
    public void test1() throws IOException {
        boolean expected = true;
        File file = new File("src/test/resources/validateDataTest1.txt");
        Path path = file.toPath();
        List<String> fileLines = Files.readAllLines(path);

        boolean result = validateData.validateData(fileLines);

        assertEquals(expected, result);
    }

    @Test
    public void test2() throws IOException {
        boolean expected = false;
        File file = new File("src/test/resources/validateDataTest2.txt");
        Path path = file.toPath();
        List<String> fileLines = Files.readAllLines(path);

        boolean result = validateData.validateData(fileLines);

        assertEquals(expected, result);
    }

    @Test
    public void test3() throws IOException {
        boolean expected = true;
        File file = new File("src/test/resources/validateDataTest3.txt");
        Path path = file.toPath();
        List<String> fileLines = Files.readAllLines(path);

        boolean result = validateData.validateData(fileLines);

        assertEquals(expected, result);
    }

    @Test
    public void test4() throws IOException {
        boolean expected = false;
        File file = new File("src/test/resources/validateDataTest4.txt");
        Path path = file.toPath();
        List<String> fileLines = Files.readAllLines(path);

        boolean result = validateData.validateData(fileLines);

        assertEquals(expected, result);
    }
}
