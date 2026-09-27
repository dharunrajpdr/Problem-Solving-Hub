# 👉 Two Pointer — Introduction

## 🔹 What is Two Pointer?

**Two Pointer** is a problem-solving technique where we use **two indexes/pointers** to traverse an array or string.

It is mainly used to make solutions **faster and avoid unnecessary loops**.

---

## 🔹 Basic Idea

```text
Array:
[1, 2, 3, 4, 5, 6]
 ↑              ↑
left           right
```

We use two variables:

```java
int left = 0;
int right = arr.length - 1;
```

Then we move the pointers based on the problem.

---

## 🔹 Simple Example

```java
int[] arr = {1, 2, 3, 4, 6};
int target = 6;

int left = 0;
int right = arr.length - 1;

while (left < right) {

    int sum = arr[left] + arr[right];

    if (sum == target) {
        System.out.println("Found");
        break;
    }
    else if (sum < target) {
        left++;
    }
    else {
        right--;
    }
}
```

Output:

```text
Found
```

---

## 🔹 How Two Pointer Works

For a sorted array:

```text
[1, 2, 3, 4, 6]
 ↑           ↑
left       right
```

If:

```text
sum < target
```

Move `left` forward:

```java
left++;
```

If:

```text
sum > target
```

Move `right` backward:

```java
right--;
```

If:

```text
sum == target
```

We found the answer.

---

## 🔹 Common Two Pointer Patterns

### 1️⃣ Opposite Direction

```text
left →       ← right
```

Usually starts from both ends.

Example:

```text
Palindrome
Two Sum
Container With Most Water
```

### 2️⃣ Same Direction

```text
slow → fast →
```

Both pointers move from left to right.

Example:

```text
Remove Duplicates
Move Zeroes
Fast and Slow Pointer
```

---

## 🔹 Advantages

```text
✔ Reduces unnecessary iterations
✔ Often reduces O(n²) to O(n)
✔ Uses less extra space
✔ Common in array and string problems
```

---
