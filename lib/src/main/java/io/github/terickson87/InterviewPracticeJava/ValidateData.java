package io.github.terickson87.InterviewPracticeJava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ValidateData {
    record YearStateMonthData(Integer year, String state, String month, Integer count) {}

    private YearStateMonthData readYearStateMonthData(String line) {
        String[] split = line.split(",");
        Integer year = Integer.parseInt(split[0]);
        String state = split[1];
        String month = split[2];
        Integer count = Integer.parseInt(split[3]);

        return new YearStateMonthData(year, state, month, count);
    }

    private void readSummaryData(String line,  Map<Integer, Integer> summaryData) {
        String[] split = line.split(",");
        Integer year = Integer.parseInt(split[0]);
        Integer count = Integer.parseInt(split[1]);
        summaryData.put(year, count);
    }

    private Map<Integer, Integer> makeYearStateMonthSummaryData(List<YearStateMonthData> yearStateMonthDataList) {
        Map<Integer, Integer> summaryData = new HashMap<>();

        for (YearStateMonthData yearStateMonthData : yearStateMonthDataList) {
            Integer year = yearStateMonthData.year;
            Optional<Integer> maybeCurrentCount = Optional.ofNullable(summaryData.get(year));
            Integer currentCount = maybeCurrentCount.orElse(0);
            Integer newCount = currentCount + yearStateMonthData.count;
            summaryData.put(year, newCount);
        }

        return summaryData;
    }

    private boolean compareSummaryYearStateMonthData(Map<Integer, Integer> summaryData, Map<Integer, Integer> yearStateMonthSummaryData) {
        for (Integer year : summaryData.keySet()) {
            Integer summaryCount = summaryData.get(year);
            Integer yearStateMonthCount = yearStateMonthSummaryData.get(year);
            if (yearStateMonthCount == null || summaryCount.intValue() != yearStateMonthCount.intValue()) {
                return false;
            }
        }

        return true;
    }

    public boolean validateData(List<String> fileLines) throws IOException {
        boolean isFirst = true;
        boolean skip = false;
        boolean isSummary = false;
        Map<Integer, Integer> summaryData = new HashMap<>();
        List<YearStateMonthData> yearStateMonthDataList = new ArrayList<>();

        for (String line : fileLines) {
            if (line.isEmpty()) {
                skip = true;
                isSummary = true;
                continue;
            }
            if (isFirst) {
                isFirst = false;
                continue;
            }
            if (skip) {
                skip = false;
                continue;
            }

            if (isSummary) {
                readSummaryData(line, summaryData);
            } else {
                YearStateMonthData yearStateMonthData = readYearStateMonthData(line);
                yearStateMonthDataList.add(yearStateMonthData);
            }
        }

        Map<Integer, Integer> yearStateMonthSummaryData = makeYearStateMonthSummaryData(yearStateMonthDataList);

        boolean result = compareSummaryYearStateMonthData(summaryData, yearStateMonthSummaryData);
        
        return result;
    }
}
