# 172. Factorial Trailing Zeroes

**Difficulty:** Medium  
**Platform:** LeetCode

## Problem Statement

Given an integer `n`, return the number of trailing zeroes in `n!` (factorial).

> **Note:** Your solution should run in logarithmic time complexity.

---

## Example 1

**Input**
```text
n = 3
```

**Output**
```text
0
```

**Explanation**

```text
3! = 3 × 2 × 1 = 6
```

There are no trailing zeroes.

---

## Example 2

**Input**
```text
n = 5
```

**Output**
```text
1
```

**Explanation**

```text
5! = 120
```

There is **1** trailing zero.

---

## Example 3

**Input**
```text
n = 30
```

**Output**
```text
7
```

**Explanation**

```text
30 / 5   = 6
30 / 25  = 1
Total = 6 + 1 = 7
```

---

## Approach

A trailing zero is produced by a factor of **10**.

```text
10 = 2 × 5
```

In a factorial, the number of factors of **2** is always greater than the number of factors of **5**.

Therefore, the number of trailing zeroes depends only on the number of times **5** appears as a factor.

Count:

- Multiples of `5`
- Multiples of `25` (extra factor of 5)
- Multiples of `125`
- Multiples of `625`
- Continue until `n` becomes `0`.

---

## Algorithm

1. Initialize `count = 0`.
2. While `n > 0`:
   - Divide `n` by `5`.
   - Add the result to `count`.
3. Return `count`.

---

## Java Solution

```java
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }
}
```

---

## Dry Run

### Input

```text
n = 30
```

| Iteration | n = n / 5 | Count |
|-----------|-----------:|------:|
| 1 | 6 | 6 |
| 2 | 1 | 7 |
| 3 | 0 | 7 |

**Answer:** `7`

---

## Why It Works

Every multiple of `5` contributes at least one factor of `5`.

Some numbers contribute more:

- `25 = 5 × 5` → two factors of `5`
- `125 = 5 × 5 × 5` → three factors of `5`

Hence, we repeatedly divide by `5` and add the quotient.

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time | **O(log₅ n)** |
| Space | **O(1)** |

---

## Key Takeaways

- Trailing zeroes come from factors of **10**.
- Count only the factors of **5**.
- Repeated division by `5` accounts for extra factors from `25`, `125`, `625`, etc.
- Efficient logarithmic solution without computing the factorial.
