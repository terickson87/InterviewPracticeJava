package io.github.terickson87.InterviewPracticeJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    static class Task {
        public char letter;
        public int requiredNumberOfRuns;
        public int gapIntervalsRemaining;
        
        public Task(char letter, int requiredNumberOfRuns) {
            this.letter = letter;
            this.requiredNumberOfRuns = requiredNumberOfRuns;
            this.gapIntervalsRemaining = 0;
            
        }
        
        void decrementGapIntervalsRemaining() {
            this.gapIntervalsRemaining--;
            return;
        }
        
        void run(int waitTime) {
            this.requiredNumberOfRuns--;
            this.gapIntervalsRemaining = waitTime;
            return;
        }
        
        int getGapIntervalsRemaining() {
            return this.gapIntervalsRemaining;
        }
        
        int getRequiredNumberOfRuns() {
            return this.requiredNumberOfRuns;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> inputMap = new HashMap<>();
        
        for (char iTask: tasks) {
            int currentCount = inputMap.getOrDefault(iTask, 0);
            inputMap.put(iTask, currentCount + 1);
        }
        
        PriorityQueue<Task> pq = new PriorityQueue<Task>( 
            Comparator.comparing(Task::getGapIntervalsRemaining)
                .thenComparing(Task::getRequiredNumberOfRuns, Comparator.reverseOrder())
        );
        List<Task> taskList = new ArrayList<>();
            
        for (Map.Entry<Character, Integer> entry : inputMap.entrySet()) {
            Task task = new Task(entry.getKey(), entry.getValue());
            taskList.add(task);
        }
        
        int consumedCycles = 0;
        while (taskList.size() > 0) {
            consumedCycles++;
            pq.clear();
            pq.addAll(taskList);

            Task headTask = pq.poll();
            if (headTask.getGapIntervalsRemaining() < 1) {
                headTask.run(n);
            } else {
                headTask.decrementGapIntervalsRemaining();
            }
            
            pq.forEach(task -> task.decrementGapIntervalsRemaining());
            taskList.removeIf(task -> task.getRequiredNumberOfRuns() < 1);
        }
                   
        return consumedCycles;
    }
    
}
