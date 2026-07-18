# Find Greatest Common Divisor of Array

## Problem Statement

Given an integer array `nums`, return the **greatest common divisor (GCD)** of the **smallest** and **largest** numbers in the array.

The **Greatest Common Divisor (GCD)** of two integers is the largest positive integer that divides both numbers without leaving a remainder.

---

## Example 1

### Input

```text
nums = [2,5,6,9,10]
```

### Output

```text
2
```

### Explanation

- Smallest element = **2**
- Largest element = **10**
- GCD(2, 10) = **2**

---

## Example 2

### Input

```text
nums = [7,5,6,8,3]
```

### Output

```text
1
```

### Explanation

- Smallest element = **3**
- Largest element = **8**
- GCD(3, 8) = **1**

---

## Example 3

### Input

```text
nums = [3,3]
```

### Output

```text
3
```

---

# Approach

1. Traverse the array once.
2. Find the **minimum** and **maximum** elements.
3. Compute the **GCD** of these two numbers using **Euclid's Algorithm**.
4. Return the GCD.

---

# Algorithm

1. Initialize:
   - `min = Integer.MAX_VALUE`
   - `max = Integer.MIN_VALUE`
2. Traverse the array:
   - Update the minimum element.
   - Update the maximum element.
3. Call the `gcd(min, max)` function.
4. Use Euclid's Algorithm:
   - While `b != 0`
     - `temp = a % b`
     - `a = b`
     - `b = temp`
5. Return `a`.

---

# Java Solution

```java
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
```

---

# Dry Run

### Input

```text
nums = [2,5,6,9,10]
```

### Step 1: Find Minimum and Maximum

| Element | Min | Max |
|---------|-----|-----|
|2|2|2|
|5|2|5|
|6|2|6|
|9|2|9|
|10|2|10|

Final:

```text
min = 2
max = 10
```

---

### Step 2: Find GCD

Initial:

```text
a = 2
b = 10
```

Iteration 1:

```text
temp = 2 % 10 = 2
a = 10
b = 2
```

Iteration 2:

```text
temp = 10 % 2 = 0
a = 2
b = 0
```

Loop stops.

Answer:

```text
2
```

---

# Euclid's Algorithm

The algorithm is based on the mathematical property:

```text
GCD(a, b) = GCD(b, a % b)
```

Example:

```text
GCD(48,18)

48 % 18 = 12
GCD(18,12)

18 % 12 = 6
GCD(12,6)

12 % 6 = 0

Answer = 6
```

---

# Complexity Analysis

- **Time Complexity:** `O(n + log(max))`
  - `O(n)` to find the minimum and maximum elements.
  - `O(log(max))` to compute the GCD using Euclid's Algorithm.

- **Space Complexity:** `O(1)`

---

# Key Takeaways

- Only the **smallest** and **largest** elements are required.
- Euclid's Algorithm is the most efficient method to compute GCD.
- The solution uses constant extra space and runs in linear time.

---
