# First Bad Version

## Problem Statement

You are given `n` versions of a product. Versions are numbered from `1` to `n`.

There is a function:

```java
boolean isBadVersion(int version);
```

which returns whether a version is bad.

Once a bad version appears, **all versions after it are also bad**.

Your task is to find the **first bad version** while minimizing the number of calls to `isBadVersion()`.

---

## Example 1

### Input

```text
n = 5
bad = 4
```

### Output

```text
4
```

### Explanation

```text
Version 1 → Good
Version 2 → Good
Version 3 → Good
Version 4 → Bad
Version 5 → Bad
```

The first bad version is **4**.

---

## Example 2

### Input

```text
n = 1
bad = 1
```

### Output

```text
1
```

---

# Approach 1: Linear Search

## Idea

Start checking versions from `1` to `n`.

- As soon as a bad version is found, return it.
- Since every version after it is also bad, there is no need to continue.

---

## Algorithm

1. Traverse from version `1` to `n`.
2. Call `isBadVersion(i)`.
3. If it returns `true`, return `i`.
4. If no bad version exists, return `-1`.

---

## Java Code (Linear Search)

```java
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        for (int i = 1; i <= n; i++) {

            if (isBadVersion(i))
                return i;
        }

        return -1;
    }
}
```

---

## Dry Run

### Input

```text
n = 5
bad = 4
```

| Version | isBadVersion() | Result |
|---------|----------------|--------|
|1|false|Continue|
|2|false|Continue|
|3|false|Continue|
|4|true|Return 4|

### Output

```text
4
```

---

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

# Approach 2: Binary Search (Optimal)

## Idea

Since all good versions come before all bad versions, the versions form a sorted pattern:

```text
Good Good Good Bad Bad Bad
```

Use Binary Search to find the first bad version.

- If `mid` is bad, the first bad version could be `mid` or to its left.
- Otherwise, search the right half.

---

## Algorithm

1. Initialize:
   - `low = 1`
   - `high = n`
2. While `low < high`:
   - Find `mid`.
   - If `isBadVersion(mid)` is true:
     - Search left (`high = mid`).
   - Else:
     - Search right (`low = mid + 1`).
3. Return `low`.

---

## Java Code (Binary Search)

```java
public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
```

---

## Dry Run

### Input

```text
n = 5
bad = 4
```

### Iteration 1

```text
low = 1
high = 5
mid = 3

isBadVersion(3) = false

Move Right
low = 4
```

---

### Iteration 2

```text
low = 4
high = 5
mid = 4

isBadVersion(4) = true

Move Left
high = 4
```

Now,

```text
low = 4
high = 4
```

Return **4**.

---

## Complexity

### Linear Search

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

### Binary Search

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

# Comparison

| Approach | Time Complexity | Space Complexity |
|----------|-----------------|------------------|
| Linear Search | `O(n)` | `O(1)` |
| Binary Search | `O(log n)` | `O(1)` |

---

## Key Takeaways

- The versions follow a sorted pattern:
  ```
  Good → Good → Good → Bad → Bad
  ```
- Linear Search is simple but inefficient.
- Binary Search minimizes the number of calls to `isBadVersion()`.
- Always compute the middle index safely:

```java
int mid = low + (high - low) / 2;
```

to avoid integer overflow.
