# Merge Intervals (LeetCode 56)

## Problem Statement

Given an array of intervals where `intervals[i] = [starti, endi]`, merge all overlapping intervals and return an array of the non-overlapping intervals.

### Example

**Input**

```text
[[1,3],[2,6],[8,10],[15,18]]
```

**Output**

```text
[[1,6],[8,10],[15,18]]
```

---

## Approach

1. Sort the intervals based on their starting value.
2. Create an empty list to store merged intervals.
3. Traverse each interval:
   - If the result list is empty or the current interval does not overlap with the last merged interval, add it.
   - Otherwise, merge the intervals by updating the ending value of the last interval.
4. Convert the list into a 2D array and return it.

---

## Algorithm

```text
Sort the intervals by start value

Create an empty result list

For each interval:
    If result is empty
        Add interval
    Else
        Get the last interval from result

        If current.start > last.end
            Add current interval
        Else
            last.end = max(last.end, current.end)

Return result
```

---

## Java Solution

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {

            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
```

---

## Dry Run

### Input

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### Step 1: Sort

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### Step 2: Traverse

```text
Result = []

Add [1,3]

Result = [[1,3]]

Compare [2,6]

3 >= 2

Merge

Result = [[1,6]]

Compare [8,10]

6 < 8

Add

Result = [[1,6],[8,10]]

Compare [15,18]

10 < 15

Add

Result = [[1,6],[8,10],[15,18]]
```

---

## Time Complexity

- Sorting: **O(n log n)**
- Traversing: **O(n)**

**Overall:** `O(n log n)`

---

## Space Complexity

**O(n)**

---

## Data Structures Used

- `ArrayList<int[]>`
- `Arrays.sort()`

---

## Key Learning

- Sorting intervals
- Detecting overlaps
- Greedy merging
- Working with `ArrayList<int[]>`
- Converting `List<int[]>` to `int[][]` using `toArray()`

---

## Related Problems

- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Meeting Rooms
- Meeting Rooms II
- Interval List Intersections
