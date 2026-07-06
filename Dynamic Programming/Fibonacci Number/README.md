# Fibonacci Number (LeetCode 509)

## Problem Statement

The **Fibonacci sequence** is defined as:

- `F(0) = 0`
- `F(1) = 1`

For `n > 1`,

```
F(n) = F(n - 1) + F(n - 2)
```

Given an integer `n`, return the `n`th Fibonacci number.

---

## Example 1

**Input**

```text
n = 2
```

**Output**

```text
1
```

**Explanation**

```
F(2) = F(1) + F(0)
     = 1 + 0
     = 1
```

---

## Example 2

**Input**

```text
n = 3
```

**Output**

```text
2
```

**Explanation**

```
F(3) = F(2) + F(1)
     = 1 + 1
     = 2
```

---

## Example 3

**Input**

```text
n = 4
```

**Output**

```text
3
```

**Explanation**

```
F(4) = F(3) + F(2)
     = 2 + 1
     = 3
```

---

# Approach (Memoization - Top Down DP)

The Fibonacci sequence follows the recurrence:

```
F(n) = F(n - 1) + F(n - 2)
```

A simple recursive solution repeatedly solves the same subproblems, leading to exponential time complexity.

To optimize it, we use **Memoization (Top-Down Dynamic Programming)**.

Store every computed Fibonacci value in a `dp[]` array.

- If the value is already computed, return it.
- Otherwise, compute it, store it, and return it.

---

# Algorithm

1. Create a `dp` array of size `n + 1`.
2. Initialize every element with `-1`.
3. If `n <= 1`, return `n`.
4. If `dp[n]` is already computed, return it.
5. Otherwise compute:

```
dp[n] = solve(n-1) + solve(n-2)
```

6. Store the answer.
7. Return `dp[n]`.

---

# Java Solution

```java
import java.util.Arrays;

class Solution {

    int[] dp;

    private int solve(int n) {

        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + solve(n - 2);

        return dp[n];
    }

    public int fib(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n);
    }
}
```

---

# Dry Run (n = 5)

Initially,

```
dp = [-1, -1, -1, -1, -1, -1]
```

Call:

```
solve(5)
```

Recursion tree:

```
solve(5)
│
├── solve(4)
│   ├── solve(3)
│   │   ├── solve(2)
│   │   │   ├── solve(1)=1
│   │   │   └── solve(0)=0
│   │   │
│   │   └── dp[2]=1
│   │
│   └── dp[3]=2
│
└── dp[4]=3
```

Finally,

```
dp[5]=5
```

Answer:

```
5
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
Value : -1 -1 1 2 3 5
```

Whenever `solve(5)` is called again, it immediately returns:

```
dp[5] = 5
```

without recomputing the recursion.

---

# Why Memoization?

Without memoization:

```
fib(5)

├── fib(4)
│   ├── fib(3)
│   │   ├── fib(2)
│   │   └── fib(1)
│   └── fib(2)
└── fib(3)
```

Notice that:

- `fib(3)` is calculated multiple times.
- `fib(2)` is calculated multiple times.

This leads to many unnecessary recursive calls.

Memoization stores each result once and reuses it whenever needed.

---

# Complexity Analysis

### Time Complexity

```
O(n)
```

Each Fibonacci number is computed only once.

### Space Complexity

```
O(n)
```

- DP array: `O(n)`
- Recursion stack: `O(n)`

---

# Key Insights

- Fibonacci follows the recurrence:

```
F(n) = F(n-1) + F(n-2)
```

- The problem contains **overlapping subproblems**, making it suitable for Dynamic Programming.

- Memoization stores computed values and avoids repeated calculations.

- Compared to plain recursion (`O(2ⁿ)`), memoization reduces the time complexity to **O(n)**.
