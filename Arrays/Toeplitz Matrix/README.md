# 766. Toeplitz Matrix

## Problem Statement

Given an `m × n` integer matrix `matrix`, return `true` if the matrix is a **Toeplitz matrix**. Otherwise, return `false`.

A matrix is called a **Toeplitz matrix** if every diagonal from **top-left to bottom-right** contains the same element.

---

## Example 1

### Input

```text
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
```

### Output

```text
true
```

### Explanation

Original Matrix:

```text
1 2 3 4
5 1 2 3
9 5 1 2
```

Diagonals:

```text
1
5 5
9

2 2
1 1 1
3 3
4
```

Every diagonal contains identical values, so the matrix is a Toeplitz matrix.

---

## Example 2

### Input

```text
matrix = [
  [1,2],
  [2,2]
]
```

### Output

```text
false
```

### Explanation

Main diagonal:

```text
1
  2
```

Since `1 != 2`, the matrix is **not** a Toeplitz matrix.

---

## Approach

A Toeplitz matrix has one important property:

For every element (except those in the first row or first column),

```text
matrix[i][j] == matrix[i-1][j-1]
```

This means each element must be equal to its **top-left neighbor**.

Traverse the matrix starting from the second row and second column. If any element differs from its top-left neighbor, return `false`. Otherwise, return `true`.

---

## Algorithm

1. Get the number of rows `m` and columns `n`.
2. Start traversing from row `1` and column `1`.
3. Compare each element with its top-left neighbor.
4. If they are different, return `false`.
5. If all comparisons succeed, return `true`.

---

## Java Solution

```java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
```

---

## Dry Run

### Input

```text
1 2 3
4 1 2
5 4 1
```

### Comparisons

| Current Cell | Top-Left Cell | Result |
|--------------|---------------|--------|
| `matrix[1][1] = 1` | `matrix[0][0] = 1` | ✅ |
| `matrix[1][2] = 2` | `matrix[0][1] = 2` | ✅ |
| `matrix[2][1] = 4` | `matrix[1][0] = 4` | ✅ |
| `matrix[2][2] = 1` | `matrix[1][1] = 1` | ✅ |

All comparisons match.

Output:

```text
true
```

---

## Visual Representation

Original Matrix:

```text
1 2 3 4
5 1 2 3
9 5 1 2
```

Matching diagonals:

```text
↘ 1

↘ 5 → 5

↘ 2 → 2

↘ 1 → 1 → 1

↘ 3 → 3

↘ 2

↘ 4

↘ 9
```

Each diagonal contains the same value.

---

## Complexity Analysis

- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(1)`

---

## Key Takeaways

- A Toeplitz matrix has equal elements on every **top-left to bottom-right** diagonal.
- Only compare each element with its **top-left neighbor**.
- The first row and first column do not need comparison because they have no top-left neighbor.
- Efficient solution uses constant extra space.

**Condition:**

```text
matrix[i][j] == matrix[i - 1][j - 1]
```
