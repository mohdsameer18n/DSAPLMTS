# Count Subarrays With Fixed Bounds

## Problem

Given an integer array `nums` and two integers `minK` and `maxK`, return the number of subarrays where:

- The minimum value is equal to `minK`.
- The maximum value is equal to `maxK`.

A valid subarray must:
- Contain at least one `minK`.
- Contain at least one `maxK`.
- Every element must lie within the range `[minK, maxK]`.

---

## Approach

We solve the problem in **O(n)** using a single traversal.

Maintain three indices:

- `lastBad` → Last index where an element is outside `[minK, maxK]`.
- `lastMin` → Last occurrence of `minK`.
- `lastMax` → Last occurrence of `maxK`.

For every index `i`:

1. Update `lastBad` if `nums[i]` is invalid.
2. Update `lastMin` if `nums[i] == minK`.
3. Update `lastMax` if `nums[i] == maxK`.
4. The number of valid subarrays ending at `i` is:

```java
Math.max(0, Math.min(lastMin, lastMax) - lastBad)
```

Add this value to the answer.

---

## Algorithm

1. Initialize:
   - `lastBad = -1`
   - `lastMin = -1`
   - `lastMax = -1`
   - `ans = 0`
2. Traverse the array.
3. Update the three indices accordingly.
4. Add valid subarrays ending at the current index.
5. Return `ans`.

---

## Java Solution

```java
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int lastBad = -1;
        int lastMin = -1;
        int lastMax = -1;

        long ans = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < minK || nums[i] > maxK)
                lastBad = i;

            if (nums[i] == minK)
                lastMin = i;

            if (nums[i] == maxK)
                lastMax = i;

            ans += Math.max(0, Math.min(lastMin, lastMax) - lastBad);
        }

        return ans;
    }
}
```

---

## Example

### Input

```
nums = [1,3,5,2,7,5]
minK = 1
maxK = 5
```

### Output

```
2
```

### Valid Subarrays

```
[1,3,5]
[1,3,5,2]
```

---

## Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## Key Idea

At every index:

- `lastBad` ensures no invalid element exists in the subarray.
- `lastMin` records the latest occurrence of `minK`.
- `lastMax` records the latest occurrence of `maxK`.

The earliest of `lastMin` and `lastMax` determines the latest valid starting position, while `lastBad` determines the earliest possible starting position.

Hence, the number of valid subarrays ending at the current index is:

```
Math.max(0, Math.min(lastMin, lastMax) - lastBad)
```
