package io.github.terickson87.InterviewPracticeJava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MajorityElementTest {

    @Test
    public void example1() {
        int[] nums = {3,2,3};
        int out = MajorityElement.majorityElement(nums);
        int expected = 3;
        assertEquals(expected, out);
    }

    @Test
    public void example2() {
        int[] nums = {2,2,1,1,1,2,2};
        int out = MajorityElement.majorityElement(nums);
        int expected = 2;
        assertEquals(expected, out);
    }
    
}
