
/*
Activity Selection

Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
Find the maximum number of activities that can be performed without overlapping.

Examples:  

Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be performed is {0, 1, 3, 4} (these are the indexes in the start[] and finish[] arrays).

Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.
*/


package GreedyAlgo;
import java.util.*;

public class ActivitySelection {

    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;
        int[][] activities= new int[n][2];

        for(int i=0;i<n;i++){
            activities[i][0]=start[i];
            activities[i][1]=finish[i];
        }

        Arrays.sort(activities,Comparator.comparingInt(a->a[1]));

        int count=1;

        int LastFinishTime=activities[0][1];

        for(int i=1;i<n;i++){
            if(activities[i][0]>=LastFinishTime){
                count++;
                LastFinishTime=activities[i][1];
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        System.out.println(maxActivities(start, finish));
    }
    
}
