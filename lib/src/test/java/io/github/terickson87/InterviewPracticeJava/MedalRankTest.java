package io.github.terickson87.InterviewPracticeJava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class MedalRankTest {
    private MedalRank medalRank;

    @BeforeEach
    public void setup() {
        medalRank = new MedalRank();
    }

    @Test
    public void example1() {
        int[] scores = {5,4,3,2,1};
        String[] expected = {"Gold Medal","Silver Medal","Bronze Medal","4","5"};

        String[] result = medalRank.rank(scores);

        assertArrayEquals(expected, result);
    }

    @Test
    public void example2() {
        int[] scores = {10,3,8,9,4};
        String[] expected = {"Gold Medal","5","Bronze Medal","Silver Medal","4"};

        String[] result = medalRank.rank(scores);

        assertArrayEquals(expected, result);
    }
}
