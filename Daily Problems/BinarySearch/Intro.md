# 🔎 Binary Search — Introduction

## 🔹 What is Binary Search?

**Binary Search** is a searching technique used to find an element in a **sorted array**.

It works by repeatedly **dividing the array into two halves**.

---

## 🔹 How it Works?

Example:

```text
Array = [10, 20, 30, 40, 50, 60, 70]
Target = 50
```

First, check the middle element:

```text
[10, 20, 30, 40, 50, 60, 70]
              ↑
             40
```

Since:

```text
50 > 40
```

Search only the **right half**.

```text
[50, 60, 70]
 ↑
50 → Found
```

---

## 🔹 Basic Steps

```text
1. Find the middle element
2. Compare it with the target
3. If equal → Found
4. If target is smaller → Search left half
5. If target is greater → Search right half
6. Repeat
```

---

## 🔹 Simple Java Example

```java
int[] arr = {10, 20, 30, 40, 50, 60, 70};
int target = 50;

int low = 0;
int high = arr.length - 1;

while (low <= high) {

    int mid = low + (high - low) / 2;

    if (arr[mid] == target) {
        System.out.println("Found");
        break;
    }
    else if (arr[mid] < target) {
        low = mid + 1;
    }
    else {
        high = mid - 1;
    }
}
```

Output:

```text
Found
```

---

## 🔹 Important Point

Binary Search works on **sorted data**.

```text
[10, 20, 30, 40, 50] ✅
```

---

## 🔹 Time Complexity

```text
Binary Search → O(log n)
```

---

## 🎯 Interview One-Liner

> **Binary Search finds an element in a sorted array by repeatedly dividing the search range into two halves.**

## 🧠 Quick Revision

```text
Sorted Array
     ↓
Find Middle
     ↓
Compare
     ↓
Left Half / Right Half
     ↓
Repeat
```
