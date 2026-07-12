# Rank Transform of an Array

## Problem Statement

Given an integer array `arr`, replace each element with its **rank**.

The rank represents how large the element is compared to the other elements.

### Rules

- Rank starts from **1**.
- The larger the element, the larger the rank.
- Equal elements receive the same rank.
- Ranks should be as small as possible.

---

## Example 1

### Input

```text
arr = [40,10,20,30]
```

### Output

```text
[4,1,2,3]
```

### Explanation

| Element | Rank |
|---------:|-----:|
| 10 | 1 |
| 20 | 2 |
| 30 | 3 |
| 40 | 4 |

Result:

```text
[4,1,2,3]
```

---

## Example 2

### Input

```text
arr = [100,100,100]
```

### Output

```text
[1,1,1]
```

### Explanation

All elements are equal, so they all receive the same rank.

---

## Example 3

### Input

```text
arr = [37,12,28,9,100,56,80,5,12]
```

### Output

```text
[5,3,4,2,8,6,7,1,3]
```

### Explanation

| Sorted Unique Elements | Rank |
|------------------------|-----:|
| 5 | 1 |
| 9 | 2 |
| 12 | 3 |
| 28 | 4 |
| 37 | 5 |
| 56 | 6 |
| 80 | 7 |
| 100 | 8 |

Replacing every element with its corresponding rank gives:

```text
[5,3,4,2,8,6,7,1,3]
```

---

# Approach

## Intuition

The rank of an element depends on its position among the **unique sorted values**.

1. Create a copy of the original array.
2. Sort the copied array.
3. Assign ranks to each unique element.
4. Store the mapping in a `HashMap`.
5. Replace every element in the original array using the stored rank.

---

## Algorithm

1. Clone the original array.
2. Sort the cloned array.
3. Initialize `rank = 1`.
4. Traverse the sorted array:
   - If the element is not already present in the map:
     - Assign the current rank.
     - Increment the rank.
5. Traverse the original array.
6. Replace every element with its rank from the map.
7. Return the modified array.

---

# Java Solution

```java
class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
```

---

# Dry Run

### Input

```text
arr = [40,10,20,30]
```

### Step 1: Clone and Sort

```text
sorted = [10,20,30,40]
```

### Step 2: Assign Ranks

| Number | Rank |
|--------:|-----:|
| 10 | 1 |
| 20 | 2 |
| 30 | 3 |
| 40 | 4 |

HashMap:

```text
{
10=1,
20=2,
30=3,
40=4
}
```

### Step 3: Replace Elements

| Original | Rank |
|----------|-----:|
| 40 | 4 |
| 10 | 1 |
| 20 | 2 |
| 30 | 3 |

### Final Output

```text
[4,1,2,3]
```

---

# Complexity Analysis

| Operation | Time Complexity |
|-----------|----------------:|
| Clone Array | O(n) |
| Sort Array | O(n log n) |
| Build HashMap | O(n) |
| Replace Elements | O(n) |
| **Total Time Complexity** | **O(n log n)** |

### Space Complexity

- Sorted array: **O(n)**
- HashMap: **O(n)**

**Overall Space Complexity:** **O(n)**

---

# Key Points

- Sort a copy of the array to determine the order of unique values.
- Use a `HashMap` to store the rank of each unique element.
- Duplicate values receive the same rank automatically.
- Replace each element in the original array using the stored mapping.
- Efficient solution with **O(n log n)** time complexity.
