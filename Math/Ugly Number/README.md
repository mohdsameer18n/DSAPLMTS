# Ugly Number

## Problem Statement

An **ugly number** is a positive integer whose **prime factors are limited to `2`, `3`, and `5`**.

Given an integer `n`, return `true` if `n` is an ugly number; otherwise, return `false`.

---

## Examples

### Example 1

**Input**

```text
n = 6
```

**Output**

```text
true
```

**Explanation**

```text
6 = 2 × 3
```

Since the prime factors are only `2` and `3`, `6` is an ugly number.

---

### Example 2

**Input**

```text
n = 8
```

**Output**

```text
true
```

**Explanation**

```text
8 = 2 × 2 × 2
```

The only prime factor is `2`.

---

### Example 3

**Input**

```text
n = 14
```

**Output**

```text
false
```

**Explanation**

```text
14 = 2 × 7
```

Since `7` is a prime factor, `14` is **not** an ugly number.

---

## Approach

The key observation is:

> If a number is ugly, then after repeatedly dividing it by `2`, `3`, and `5`, the remaining value should become `1`.

If any other prime factor exists (such as `7`, `11`, or `13`), the remaining value will be greater than `1`.

### Algorithm

1. If `n <= 0`, return `false`.
2. Divide `n` by `2` until it is no longer divisible.
3. Divide `n` by `3` until it is no longer divisible.
4. Divide `n` by `5` until it is no longer divisible.
5. If the final value is `1`, return `true`; otherwise, return `false`.

---

## Java Solution

```java
class Solution {
    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }
}
```

---

## Dry Run

### Input

```text
n = 30
```

Initial value

```text
30
```

Divide by `2`

```text
30 → 15
```

Divide by `3`

```text
15 → 5
```

Divide by `5`

```text
5 → 1
```

Final value

```text
1
```

Return

```text
true
```

---

### Another Example

```text
n = 42
```

Prime factorization

```text
42 = 2 × 3 × 7
```

Remove factors of `2`

```text
42 → 21
```

Remove factors of `3`

```text
21 → 7
```

Cannot divide by `5`

Remaining value

```text
7
```

Since the remaining value is not `1`, return

```text
false
```

---

## Complexity Analysis

* **Time Complexity:** `O(log n)`

  Each division reduces the value of `n`, so the number of iterations is logarithmic.

* **Space Complexity:** `O(1)`

  No extra space is used.

---

## Key Points

* Ugly numbers contain **only** the prime factors `2`, `3`, and `5`.
* Repeatedly divide by `2`, `3`, and `5`.
* If the remaining number is `1`, it is an ugly number.
* If any other prime factor exists, the remaining value will be greater than `1`.

---

## Pattern

This problem follows the **Prime Factorization / Repeated Division** pattern.

Similar problems include:

* Power of Two
* Power of Three
* Power of Four
* Happy Number
* Perfect Number

---

## Takeaways

* Handle non-positive numbers first (`n <= 0`).
* Continuously divide by allowed prime factors.
* The final answer depends on whether the remaining value is exactly `1`.
* This approach is simple, efficient, and uses constant extra space.
