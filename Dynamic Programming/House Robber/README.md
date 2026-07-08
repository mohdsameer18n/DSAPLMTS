# House Robber (LeetCode 198)

## Problem Statement

You are given an integer array `nums` where `nums[i]` represents the amount of money in the `iᵗʰ` house.

A robber cannot rob two adjacent houses because it will trigger the alarm.

Return the maximum amount of money that can be robbed without robbing two adjacent houses.

**LeetCode:** 198 - House Robber

---

## Approach

This problem can be solved using **Dynamic Programming (Top-Down Memoization)**.

At every house, we have two choices:

1. **Rob the current house**
   - Add its value.
   - Skip the next house.
   - Move to `i + 2`.

2. **Skip the current house**
   - Move to the next house.
   - Move to `i + 1`.

The answer is the maximum of these two choices.

To avoid solving the same subproblem multiple times, we store the answer for each index in a DP array.

---

## Algorithm

1. Create a DP array initialized with `-1`.
2. Start recursion from index `0`.
3. If the index is outside the array, return `0`.
4. If the answer is already stored, return it.
5. Compute:
   - `take = nums[i] + solve(i + 2)`
   - `leave = solve(i + 1)`
6. Store and return the maximum.

---

## Dry Run

### Input

```text
nums = [2,7,9,3,1]
```

### Recursive Choices

```text
solve(0)

Take 2
│
└── solve(2)
      │
      ├── Take 9
      │     └── solve(4)
      │             └── Take 1
      │
      └── Skip 9
            └── solve(3)

Skip 2
│
└── solve(1)
```

### DP Values

| Index | Maximum Money |
|------:|--------------:|
| 4 | 1 |
| 3 | 3 |
| 2 | 10 |
| 1 | 10 |
| 0 | 12 |

**Output**

```text
12
```

---

## Java Solution (Memoization)

```java
import java.util.Arrays;

class Solution {

    public int solve(int[] nums, int i, int[] dp) {

        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int take = nums[i] + solve(nums, i + 2, dp);
        int leave = solve(nums, i + 1, dp);

        return dp[i] = Math.max(take, leave);
    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }
}
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(n)** |
| Space | **O(n)** |

---

## Key Concepts

- Dynamic Programming
- Recursion
- Memoization
- Decision Making
- Optimal Substructure
- Overlapping Subproblems

---

## Interview Questions

### Why do we use `i + 2` after robbing a house?

Because two adjacent houses cannot be robbed. After robbing house `i`, the next possible house is `i + 2`.

---

### Why do we use memoization?

Without memoization, the same indices are solved multiple times, resulting in exponential time complexity.

Memoization stores previously computed results, reducing the complexity to **O(n)**.

---

### Can this be optimized further?

Yes.

Instead of storing the entire DP array, we only need the previous two states.

This reduces the space complexity from **O(n)** to **O(1)**.

---

## Tags

- Dynamic Programming
- Memoization
- Recursion
- Array
- LeetCode 198
```
