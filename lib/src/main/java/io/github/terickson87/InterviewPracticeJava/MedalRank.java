package io.github.terickson87.InterviewPracticeJava;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All
 * the scores are guaranteed to be unique.
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place  *  * athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
 * •  The 1st place athlete's rank is "Gold Medal".
 * •  The 2nd place athlete's rank is "Silver Medal".
 * •  The 3rd place athlete's rank is "Bronze Medal".
 * •  For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 * 
 * Example 1:
 * Input: score = [5,4,3,2,1]
 * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 * 
 * Example 2:
 * Input: score = [10,3,8,9,4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 */

public class MedalRank {
    public String[] rank(int[] athleteScores) {
        // Sort Array
        Integer[] sortedScores = Arrays.stream(athleteScores.clone()).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedScores, Collections.reverseOrder());

        // Build sorted indices
        Map<Integer, Integer> scoreAthleteMap = new LinkedHashMap<>(athleteScores.length);
        for (int athlete = 0; athlete < athleteScores.length; athlete++) {
            scoreAthleteMap.put(athleteScores[athlete], athlete);
        }
        Map<Integer, Integer> sortedScoreAthleteMap = new LinkedHashMap<>(sortedScores.length);
        for (int i = 0; i < sortedScores.length; i++) {
            int athlete = scoreAthleteMap.get(sortedScores[i]);
            sortedScoreAthleteMap.put(sortedScores[i], athlete);
        }

        String[] ranks = new String[athleteScores.length];

        for (int iSortedScore = 0; iSortedScore < sortedScores.length; iSortedScore++) {
            int score = sortedScores[iSortedScore];
            int athlete = sortedScoreAthleteMap.get(score);
            int scorePosition = iSortedScore + 1;
            switch (scorePosition) {
                case 1:
                    ranks[athlete] = "Gold Medal";
                    break;

                case 2:
                    ranks[athlete] =  "Silver Medal";
                    break;

                case 3:
                    ranks[athlete] =  "Bronze Medal";
                    break;
                    
                default:
                    ranks[athlete] =  Integer.toString(scorePosition);
                    break;
            }
        }

        return ranks;
    }
}
