# Longest Subarray with Given Sum K (Positive Numbers)

## Problem Statement

Given an array `nums` of size `n` consisting of **positive integers** and an integer `k`, find the **length of the longest contiguous subarray** whose sum is exactly `k`.

If no such subarray exists, return `0`.

---

## Examples

### Example 1

**Input**

```text
nums = [10, 5, 2, 7, 1, 9]
k = 15
```

**Output**

```text
4
```

**Explanation**

The longest subarray with sum equal to `15` is:

```text
[5, 2, 7, 1]
```

Length = **4**

---

### Example 2

**Input**

```text
nums = [1, 2, 3]
k = 7
```

**Output**

```text
0
```

**Explanation**

No subarray has a sum equal to `7`.

---

## Approach

Since the array contains **only positive numbers**, we use the **Sliding Window (Two Pointers)** technique.

### Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = 0`
2. Maintain the current window sum.
3. Expand the window by moving `right`.
4. If the sum becomes greater than `k`, shrink the window by moving `left`.
5. Whenever the sum equals `k`, update the maximum length.
6. Continue until the end of the array.

---

## Dry Run

### Input

```text
nums = [10, 5, 2, 7, 1, 9]
k = 15
```

| Left | Right | Current Window | Sum | Max Length |
|------|-------|----------------|-----|------------|
|0|0|[10]|10|0|
|0|1|[10,5]|15|2|
|1|2|[5,2]|7|2|
|1|3|[5,2,7]|14|2|
|1|4|[5,2,7,1]|15|4|
|2|5|[2,7,1,9]|19|4|

**Answer = 4**

---

## Java Code

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        int k = scan.nextInt();

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        System.out.println(maxLen);
    }
}
```

---

## Time Complexity

- Each element is visited at most twice.
- **Time Complexity:** `O(n)`

---

## Space Complexity

- Only a few extra variables are used.
- **Space Complexity:** `O(1)`

---

## Why Sliding Window Works?

The Sliding Window technique works because the array contains **only positive integers**.

- Adding an element increases the sum.
- Removing an element decreases the sum.

This allows us to efficiently expand and shrink the window while maintaining the desired sum.

> **Note:** If the array contains negative numbers, this approach does not work. In that case, use the **Prefix Sum + HashMap** approach with `O(n)` time complexity.
