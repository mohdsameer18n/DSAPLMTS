# Climbing Stairs (LeetCode 70)

## Problem Statement

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can climb either:
- **1 step**
- **2 steps**

Return the total number of **distinct ways** to reach the top.

---

## Example 1

**Input**
```text
n = 2
```

**Output**
```text
2
```

**Explanation**

```text
1 + 1
2
```

---

## Example 2

**Input**
```text
n = 3
```

**Output**
```text
3
```

**Explanation**

```text
1 + 1 + 1
1 + 2
2 + 1
```

---

# Approach (Memoization - Top Down DP)

To reach the `n`th stair, there are only two possible ways:

1. Come from the `(n-1)`th stair by taking **1 step**.
2. Come from the `(n-2)`th stair by taking **2 steps**.

Therefore,

```text
Ways(n) = Ways(n-1) + Ways(n-2)
```

This is the same recurrence as the Fibonacci sequence.

Since the same subproblems are solved repeatedly, we use **Dynamic Programming (Memoization)** to store already computed results.

---

# Algorithm

1. Create a `dp[]` array initialized with `-1`.
2. If `n <= 2`, return `n`.
3. If `dp[n]` is already computed, return it.
4. Otherwise compute:
   ```
   dp[n] = solve(n-1) + solve(n-2)
   ```
5. Store the answer in `dp[n]`.
6. Return `dp[n]`.

---

# Java Solution

```java
import java.util.Arrays;

class Solution {

    int[] dp = new int[46];

    public int climbStairs(int n) {

        Arrays.fill(dp, -1);

        return solve(n);
    }

    private int solve(int n) {

        if (n <= 2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + solve(n - 2);

        return dp[n];
    }
}
```

---

# Dry Run (n = 5)

```
solve(5)

= solve(4) + solve(3)

solve(4)

= solve(3) + solve(2)

solve(3)

= solve(2) + solve(1)

= 2 + 1

= 3
```

Store:

```
dp[3] = 3
```

Now,

```
solve(4)

= 3 + 2

= 5
```

Store:

```
dp[4] = 5
```

Finally,

```
solve(5)

= 5 + 3

= 8
```

Store:

```
dp[5] = 8
```

---

# DP Array

Initially

```
Index : 0 1 2 3 4 5
Value : -1 -1 -1 -1 -1 -1
```

After computation

```
Index : 0 1 2 3 4 5
Value : -1 -1 -1 3 5 8
```

The next time `solve(5)` is called, the answer is returned directly from the DP array.

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Each state is computed only once.

### Space Complexity

```
O(n)
```

- DP array: `O(n)`
- Recursion stack: `O(n)`

---

# Key Insight

The last move to reach stair `n` can only be:

- from stair `n-1` by taking **1 step**, or
- from stair `n-2` by taking **2 steps**.

Therefore,

```
Ways(n) = Ways(n-1) + Ways(n-2)
```

This recurrence makes the Climbing Stairs problem equivalent to the Fibonacci sequence, and memoization optimizes the recursive solution by avoiding repeated calculations.
