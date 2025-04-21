package io.github.terickson87.InterviewPracticeJava;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>(nums.length);
        int maxCount = 0;
        int maxNum = -1;
        
        for(int iNum: nums) {
            int currentVal = counts.getOrDefault(iNum, 0);
            int newVal = currentVal + 1;
            counts.put(iNum, newVal);
            if (newVal > maxCount) {
                maxCount = newVal;
                maxNum = iNum;
            }
        }
        
        return maxNum;
        
    }
}