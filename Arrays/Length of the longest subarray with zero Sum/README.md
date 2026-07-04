# Longest Subarray with Sum Zero

## Problem Statement

Given an array of integers (containing positive, negative, and zero values), find the **length of the longest contiguous subarray whose sum is equal to 0**.

If no such subarray exists, return `0`.

---

## Examples

### Example 1

**Input**

```text
N = 6
array = {9, -3, 3, -1, 6, -5}
```

**Output**

```text
5
```

**Explanation**

Subarrays with sum `0` are:

```text
{-3, 3}
{-1, 6, -5}
{-3, 3, -1, 6, -5}
```

The longest subarray is:

```text
{-3, 3, -1, 6, -5}
```

Length = **5**

---

### Example 2

**Input**

```text
N = 8
array = {6, -2, 2, -8, 1, 7, 4, -10}
```

**Output**

```text
8
```

**Explanation**

Subarrays with sum `0` are:

```text
{-2, 2}
{-8, 1, 7}
{-2, 2, -8, 1, 7}
{6, -2, 2, -8, 1, 7, 4, -10}
```

The longest subarray is the entire array.

Length = **8**

---

## Approach (Prefix Sum + HashMap)

The Sliding Window approach does **not** work because the array contains negative numbers.

Instead, use a **Prefix Sum + HashMap**.

### Algorithm

1. Initialize:
   - `sum = 0`
   - `maxLen = 0`
   - HashMap to store `(prefixSum, firstIndex)`.

2. Traverse the array.

3. Add the current element to the prefix sum.

4. If the prefix sum becomes `0`, then the subarray from index `0` to `i` has sum `0`.

5. If the prefix sum has been seen before, then the elements between the previous index and current index sum to `0`.

6. Store the prefix sum in the HashMap only the **first time** it appears.

---

## Dry Run

### Input

```text
array = {9, -3, 3, -1, 6, -5}
```

| Index | Element | Prefix Sum | HashMap | Max Length |
|------:|--------:|-----------:|---------|-----------:|
|0|9|9|9 → 0|0|
|1|-3|6|6 → 1|0|
|2|3|9|Already exists|2|
|3|-1|8|8 → 3|2|
|4|6|14|14 → 4|2|
|5|-5|9|Already exists|5|

Answer = **5**

---

## Java Code

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }
}
```

---

## Time Complexity

- Array traversal: **O(n)**
- HashMap operations: **O(1)** (average)

**Overall Time Complexity:** `O(n)`

---

## Space Complexity

- HashMap stores at most `n` prefix sums.

**Space Complexity:** `O(n)`

---

## Why Prefix Sum Works?

Suppose:

```text
Prefix Sum at index i = X
Prefix Sum at index j = X
```

Then,

```text
Sum(i + 1 ... j) = 0
```

because the prefix sums cancel each other.

This allows us to find zero-sum subarrays efficiently in a single traversal.

> **Note:** This approach works for arrays containing **positive, negative, and zero** values, unlike the Sliding Window technique, which works only for positive numbers.
