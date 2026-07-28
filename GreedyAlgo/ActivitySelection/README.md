# Activity Selection Problem (Greedy Algorithm)

## Problem Statement

You are given two arrays:

- `start[]` → Start time of each activity.
- `finish[]` → Finish time of each activity.

A person can perform **only one activity at a time**.

An activity can be selected only if its **start time is greater than or equal to the finish time of the previously selected activity**.

Return the **maximum number of non-overlapping activities** that can be performed.

---

## Example 1

### Input

```text
start  = [1, 3, 0, 5, 8, 5]
finish = [2, 4, 6, 7, 9, 9]
```

### Output

```text
4
```

### Explanation

The selected activities are:

```text
(1,2)
(3,4)
(5,7)
(8,9)
```

Maximum activities = **4**

---

## Example 2

### Input

```text
start  = [10, 12, 20]
finish = [20, 25, 30]
```

### Output

```text
1
```

---

# Intuition

To perform the maximum number of activities, we should **finish the current activity as early as possible**.

If we always choose the activity with the **earliest finish time**, more time remains for the remaining activities.

This is why the problem is solved using a **Greedy Algorithm**.

---

# Greedy Strategy

1. Combine the start and finish times.
2. Sort all activities by **finish time** in ascending order.
3. Select the first activity.
4. Traverse the remaining activities:
   - If the current activity starts **after or at** the finish time of the last selected activity, select it.
5. Count the selected activities.

---

# Algorithm

1. Store every activity as:

```text
[start, finish]
```

2. Sort activities based on finish time.

3. Select the first activity.

4. Keep track of the finish time of the last selected activity.

5. For every remaining activity:
   - If

```text
start >= lastFinishTime
```

Select it and update the last finish time.

6. Return the total count.

---

# Dry Run

### Input

```text
start  = [1,3,0,5,8,5]
finish = [2,4,6,7,9,9]
```

Create activities

```text
(1,2)
(3,4)
(0,6)
(5,7)
(8,9)
(5,9)
```

Already sorted by finish time.

---

### Step 1

Select first activity

```text
(1,2)

Count = 1
Last Finish = 2
```

---

### Step 2

Activity

```text
(3,4)
```

Since

```text
3 >= 2
```

Select it.

```text
Count = 2
Last Finish = 4
```

---

### Step 3

Activity

```text
(0,6)
```

```text
0 < 4
```

Cannot select.

Skip it.

---

### Step 4

Activity

```text
(5,7)
```

```text
5 >= 4
```

Select it.

```text
Count = 3
Last Finish = 7
```

---

### Step 5

Activity

```text
(8,9)
```

```text
8 >= 7
```

Select it.

```text
Count = 4
Last Finish = 9
```

---

### Step 6

Activity

```text
(5,9)
```

```text
5 < 9
```

Cannot select.

---

### Final Answer

```text
Maximum Activities = 4
```

Selected activities

```text
(1,2)
(3,4)
(5,7)
(8,9)
```

---

# Java Solution

```java
package GreedyAlgo;

import java.util.*;

public class ActivitySelection {

    public static int maxActivities(int[] start, int[] finish) {

        int n = start.length;

        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int lastFinishTime = activities[0][1];

        for (int i = 1; i < n; i++) {

            if (activities[i][0] >= lastFinishTime) {

                count++;
                lastFinishTime = activities[i][1];
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
```

---

# Complexity Analysis

### Time Complexity

```text
O(N log N)
```

- Sorting the activities takes **O(N log N)**.
- Traversing the sorted list takes **O(N)**.

Overall:

```text
O(N log N)
```

---

### Space Complexity

```text
O(N)
```

- Extra space is used to store the combined `activities` array.

---

# Why Greedy Works?

Choosing the activity that **finishes earliest** leaves the maximum remaining time for future activities.

This greedy choice ensures that we can schedule the largest possible number of non-overlapping activities.

---

# Key Points

- Use a **Greedy Algorithm**.
- Sort activities by **finish time**.
- Always select the activity with the earliest finish time that does not overlap with the previously selected activity.
- Keep updating the finish time of the last selected activity.
- This approach guarantees the maximum number of activities.

---

# Similar Problems

- LeetCode 435 – Non-overlapping Intervals
- LeetCode 452 – Minimum Number of Arrows to Burst Balloons
- Job Sequencing Problem
- Fractional Knapsack
- Meeting Rooms
- Maximum Meetings in One Room
