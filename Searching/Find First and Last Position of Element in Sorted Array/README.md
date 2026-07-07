# Find First and Last Position of Element in Sorted Array

## Problem Statement

Given a sorted array `nums` and an integer `target`, return the **first** and **last** position of the target in the array.

If the target is not found, return `[-1, -1]`.

---

## Example 1

### Input
```text
nums = [5,7,7,8,8,10]
target = 8
```

### Output
```text
[3,4]
```

---

## Example 2

### Input
```text
nums = [5,7,7,8,8,10]
target = 6
```

### Output
```text
[-1,-1]
```

---

# Approach 1: Linear Search

## Idea

Traverse the array from left to right.

- When the target is found for the first time, store its index as the **first occurrence**.
- Continue traversing and update the **last occurrence** every time the target is found.
- If the target is never found, both indices remain `-1`.

---

## Algorithm

1. Initialize `first = -1` and `last = -1`.
2. Traverse the array.
3. If `nums[i] == target`:
   - If `first == -1`, set `first = i`.
   - Update `last = i`.
4. Return `{first, last}`.

---

## Java Code (Linear Search)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != target)
                continue;

            if (first == -1)
                first = i;

            last = i;
        }

        return new int[]{first, last};
    }
}
```

---

## Dry Run

### Input

```text
nums = [5,7,7,8,8,10]
target = 8
```

| Index | Value | First | Last |
|------|------|------|------|
|0|5|-1|-1|
|1|7|-1|-1|
|2|7|-1|-1|
|3|8|3|3|
|4|8|3|4|
|5|10|3|4|

### Output

```text
[3,4]
```

---

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

# Approach 2: Binary Search (Optimal)

## Idea

Since the array is sorted, use **Binary Search** twice.

### First Binary Search

- Find the first occurrence.
- After finding the target, continue searching on the **left**.

### Second Binary Search

- Find the last occurrence.
- After finding the target, continue searching on the **right**.

---

## Algorithm

### Find First Occurrence

1. Initialize `low`, `high`, and `ans = -1`.
2. While `low <= high`:
   - Calculate `mid`.
   - If target found:
     - Store `mid`.
     - Move left (`high = mid - 1`).
   - Else move according to binary search rules.
3. Return `ans`.

### Find Last Occurrence

1. Initialize `low`, `high`, and `ans = -1`.
2. While `low <= high`:
   - Calculate `mid`.
   - If target found:
     - Store `mid`.
     - Move right (`low = mid + 1`).
   - Else move according to binary search rules.
3. Return `ans`.

---

## Java Code (Binary Search)

```java
class Solution {

    public int findFirst(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int findLast(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }
}
```

---

## Dry Run

### Input

```text
nums = [5,7,7,8,8,10]
target = 8
```

### Finding First Occurrence

| Low | High | Mid | nums[mid] | Answer | Action |
|-----|------|-----|-----------|--------|--------|
|0|5|2|7|-1|Move Right|
|3|5|4|8|4|Move Left|
|3|3|3|8|3|Move Left|

**First Occurrence = 3**

---

### Finding Last Occurrence

| Low | High | Mid | nums[mid] | Answer | Action |
|-----|------|-----|-----------|--------|--------|
|0|5|2|7|-1|Move Right|
|3|5|4|8|4|Move Right|
|5|5|5|10|4|Move Left|

**Last Occurrence = 4**

---

## Complexity

### Linear Search

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

### Binary Search

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

# Comparison

| Approach | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Linear Search | `O(n)` | `O(1)` |
| Binary Search | `O(log n)` | `O(1)` |

---

## Key Takeaways

- Linear Search is simple and works for any array.
- Binary Search is much faster but requires the array to be **sorted**.
- For LeetCode 34, the expected solution is **Binary Search (`O(log n)`)**.
