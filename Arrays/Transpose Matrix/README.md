# 867. Transpose Matrix

## Problem Statement

Given a 2D integer matrix `matrix`, return the **transpose** of the matrix.

The **transpose** of a matrix is obtained by converting all the rows of the original matrix into columns.

---

## Example 1

### Input

```text
matrix = [
  [1,2,3],
  [4,5,6]
]
```

### Output

```text
[
  [1,4],
  [2,5],
  [3,6]
]
```

### Explanation

Original Matrix:

```text
1 2 3
4 5 6
```

Transpose:

```text
1 4
2 5
3 6
```

---

## Example 2

### Input

```text
matrix = [
  [1,2],
  [3,4],
  [5,6]
]
```

### Output

```text
[
  [1,3,5],
  [2,4,6]
]
```

---

## Approach

Since the transpose swaps rows with columns:

- If the original matrix has **m** rows and **n** columns,
- The transposed matrix will have **n** rows and **m** columns.

Create a new matrix of size `n × m` and place each element:

```
transpose[j][i] = matrix[i][j]
```

This works for both square and rectangular matrices.

---

## Algorithm

1. Find the number of rows `m` and columns `n`.
2. Create a new matrix `ans` of size `n × m`.
3. Traverse every element of the original matrix.
4. Store each element at its transposed position.
5. Return the new matrix.

---

## Java Solution

```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }

        return ans;
    }
}
```

---

## Dry Run

### Input

```text
1 2 3
4 5 6
```

### Initial Transposed Matrix (3 × 2)

```text
0 0
0 0
0 0
```

### Fill Values

- ans[0][0] = 1
- ans[1][0] = 2
- ans[2][0] = 3
- ans[0][1] = 4
- ans[1][1] = 5
- ans[2][1] = 6

Final Matrix:

```text
1 4
2 5
3 6
```

---

## Complexity Analysis

- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(m × n)`

---

## Key Takeaways

- Transpose swaps **rows** and **columns**.
- A new matrix is required for rectangular matrices.
- In-place transpose is only possible for square matrices (`N × N`).
- Mapping formula:

```text
matrix[i][j] → transpose[j][i]
```
