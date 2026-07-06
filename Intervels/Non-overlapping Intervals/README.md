# LeetCode 435 - Non-overlapping Intervals

## Problem Statement

Given an array of intervals where `intervals[i] = [starti, endi]`, return the **minimum number of intervals you need to remove** to make the rest of the intervals non-overlapping.

---

## Greedy Idea

The optimal strategy is to **always keep the interval that ends first**.

**Why?**

An interval with a smaller ending time leaves more room for the remaining intervals, maximizing the number of non-overlapping intervals that can be selected.

---

## Java Solution

```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}
```

---

# Step-by-Step Explanation

## Step 1: Sort by Ending Time

```java
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
```

This sorts all intervals according to their **ending time**.

### Example

Before sorting:

```text
[[1,3],
 [2,4],
 [1,2],
 [3,5]]
```

After sorting:

```text
[[1,2],
 [1,3],
 [2,4],
 [3,5]]
```

The interval that finishes earliest comes first.

---

## Step 2: Initialize Variables

```java
int count = 0;
int end = intervals[0][1];
```

* `count` stores the number of removed intervals.
* `end` stores the ending time of the last interval we decided to keep.

Initially,

```text
First interval = [1,2]

end = 2
count = 0
```

---

## Step 3: Traverse Remaining Intervals

```java
for (int i = 1; i < intervals.length; i++)
```

We compare each interval with the previously selected interval.

### If Overlap Exists

```java
if (intervals[i][0] < end)
```

If the current interval starts before the previous interval ends, they overlap.

Example:

```text
Current interval = [1,3]

Current end = 2

1 < 2 → Overlap
```

Remove the current interval.

```java
count++;
```

---

### If No Overlap

```java
else {
    end = intervals[i][1];
}
```

Update the ending time because we keep the current interval.

Example:

```text
Current interval = [2,4]

Current end = 2

2 < 2 → False

No overlap

Update

end = 4
```

---

# Dry Run

Input

```text
[[1,2],[2,3],[3,4],[1,3]]
```

After Sorting

```text
[[1,2],[2,3],[1,3],[3,4]]
```

Initial

```text
end = 2
count = 0
```

| Current Interval | Condition     | Action | end | count |
| ---------------- | ------------- | ------ | --- | ----: |
| [2,3]            | 2 < 2 → False | Keep   | 3   |     0 |
| [1,3]            | 1 < 3 → True  | Remove | 3   |     1 |
| [3,4]            | 3 < 3 → False | Keep   | 4   |     1 |

Final Answer

```text
1
```

---

# Why Sort by End Time?

Example:

```text
[1,100]
[2,3]
[3,4]
[4,5]
```

If we keep `[1,100]`, we must remove:

```text
[2,3]
[3,4]
[4,5]
```

Total removals = **3**

Instead, if we keep the interval that ends first:

```text
[2,3]
[3,4]
[4,5]
```

We only remove:

```text
[1,100]
```

Total removals = **1**

This is why sorting by **ending time** gives the optimal greedy solution.

---

# Sorting Intervals in Java

## Sort by Starting Time

```java
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
```

### Example

Before

```text
[[5,7],
 [1,3],
 [8,10],
 [2,6]]
```

After

```text
[[1,3],
 [2,6],
 [5,7],
 [8,10]]
```

---

## Sort by Ending Time

```java
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
```

Example

Before

```text
[[1,100],
 [2,3],
 [3,4]]
```

After

```text
[[2,3],
 [3,4],
 [1,100]]
```

---

## Sort by Start Time, Then End Time

```java
Arrays.sort(intervals, (a, b) ->
    a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
);
```

or

```java
Arrays.sort(intervals, (a, b) -> {
    if (a[0] != b[0]) {
        return a[0] - b[0];
    }
    return a[1] - b[1];
});
```

This sorts by:

1. Starting time
2. Ending time (if starting times are equal)

---

# When to Use Each Sorting Method

| Sorting Method         | Java Code                                        | Common Problems                                              |
| ---------------------- | ------------------------------------------------ | ------------------------------------------------------------ |
| Sort by Start          | `Arrays.sort(intervals, (a, b) -> a[0] - b[0]);` | Merge Intervals, Insert Interval                             |
| Sort by End            | `Arrays.sort(intervals, (a, b) -> a[1] - b[1]);` | Non-overlapping Intervals, Activity Selection, Meeting Rooms |
| Sort by Start then End | `a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]`       | General interval processing                                  |

---

# Time Complexity

* Sorting: **O(n log n)**
* Traversal: **O(n)**

**Overall:** **O(n log n)**

---

# Space Complexity

* **O(1)** (excluding the sorting space used internally).

---

# Key Takeaways

* Sort by **end time** for greedy interval selection problems.
* Sort by **start time** for interval merging problems.
* During an overlap, **keep the interval that finishes earliest**.
* The greedy approach guarantees the minimum number of removals.
