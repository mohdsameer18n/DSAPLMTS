# Insert Interval (LeetCode 57)

## Problem Statement

You are given a list of **non-overlapping intervals** sorted in ascending order by their start time and a new interval.

Insert the new interval into the list such that:
- The intervals remain sorted.
- Any overlapping intervals are merged.

Return the updated list of intervals.

---

## Example 1

### Input

```text
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

### Output

```text
[[1,5],[6,9]]
```

---

## Example 2

### Input

```text
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
```

### Output

```text
[[1,2],[3,10],[12,16]]
```

---

# Approach

Since the intervals are already sorted, we don't need to sort them.

There are three cases:

### Case 1: Before the new interval

If an interval ends before the new interval starts, simply add it.

```text
interval.end < newInterval.start
```

---

### Case 2: Overlapping intervals

Merge all overlapping intervals.

```text
interval.start <= newInterval.end
```

Update

```text
newStart = min(newStart, interval.start)

newEnd = max(newEnd, interval.end)
```

---

### Case 3: After the new interval

Once merging is complete:

- Add the merged interval.
- Add all remaining intervals.

---

# Algorithm

```text
Create an empty result list

Traverse intervals before newInterval
    Add them directly

Traverse overlapping intervals
    Merge them

Add merged interval

Traverse remaining intervals
    Add them

Return result
```

---

# Java Solution

```java
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        ans.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
```

---

# Dry Run

### Input

```text
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]

newInterval = [4,8]
```

### Step 1

Before new interval

```text
[1,2]
```

Result

```text
[[1,2]]
```

---

### Step 2

Current

```text
[3,5]
```

Merge

```text
newInterval

[3,8]
```

---

Current

```text
[6,7]
```

Merge

```text
[3,8]
```

---

Current

```text
[8,10]
```

Merge

```text
[3,10]
```

---

### Step 3

Add merged interval

```text
[[1,2],[3,10]]
```

---

### Step 4

Remaining

```text
[12,16]
```

Final

```text
[[1,2],[3,10],[12,16]]
```

---

# Time Complexity

```
O(n)
```

---

# Space Complexity

```
O(n)
```

---

# Key Difference from Merge Intervals

| Merge Intervals | Insert Interval |
|-----------------|-----------------|
| Sort required | Already sorted |
| Merge all intervals | Insert one interval and merge |
| Time: O(n log n) | Time: O(n) |

---

# Pattern to Remember

```text
1. Add intervals before new interval.

2. Merge overlapping intervals.

3. Add merged interval.

4. Add remaining intervals.
```

---

# Related Problems

- Merge Intervals (56)
- Non-overlapping Intervals (435)
- Meeting Rooms (252)
- Meeting Rooms II (253)
- Interval List Intersections (986)
