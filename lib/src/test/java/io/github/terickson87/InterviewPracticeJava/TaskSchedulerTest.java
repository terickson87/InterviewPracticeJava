package io.github.terickson87.InterviewPracticeJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TaskSchedulerTest {
    @Test
    public void example1() {
        char[] tasks = {'A','A','A','B','B','B'};
        int waitTime = 2;
        int out = TaskScheduler.leastInterval(tasks, waitTime);
        int expected = 8;
        assertEquals(expected, out);
    }

    @Test
    public void example2() {
        char[] tasks = {'A','C','A','B','D','B'};
        int waitTime = 1;
        int out = TaskScheduler.leastInterval(tasks, waitTime);
        int expected = 6;
        assertEquals(expected, out);
    }

    @Test
    public void example3() {
        char[] tasks = {'A','A','A','B','B','B'};
        int waitTime = 3;
        int out = TaskScheduler.leastInterval(tasks, waitTime);
        int expected = 10;
        assertEquals(expected, out);
    }

    @Test
    public void test1() {
        char[] tasks = {'A','B','A'};
        int waitTime = 2;
        int out = TaskScheduler.leastInterval(tasks, waitTime);
        int expected = 4;
        assertEquals(expected, out);
    }
}
