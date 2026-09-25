# 📘 Recursion

## 1. What is Recursion?

**Recursion** is a technique where a **function calls itself** to solve a problem.

### Simple Definition

> A function calling itself is called **recursion**.

---

## 2. Basic Syntax

```java
void function() {

    // Base condition
    if (condition) {
        return;
    }

    // Recursive call
    function();
}
```

A recursive function mainly has **2 important parts**:

1. **Base Case** → Stops the recursion
2. **Recursive Case** → Calls the function again

---

## 3. Simple Example

Print numbers from `1` to `5`:

```java
public class Main {

    static void printNumbers(int n) {

        // Base Case
        if (n == 0) {
            return;
        }

        printNumbers(n - 1);

        System.out.println(n);
    }

    public static void main(String[] args) {
        printNumbers(5);
    }
}
```

### Output

```text
1
2
3
4
5
```

---

## 4. How Recursion Works

For:

```java
printNumbers(5);
```

The calls happen like this:

```text
printNumbers(5)
    ↓
printNumbers(4)
    ↓
printNumbers(3)
    ↓
printNumbers(2)
    ↓
printNumbers(1)
    ↓
printNumbers(0)
```

At `n == 0`, the **base case** stops further calls.

Then the previous calls return one by one.

---

## 5. Base Case

The **base case** is the condition that stops recursion.

Example:

```java
if (n == 0) {
    return;
}
```

### Why is it important?

Without a base case, the function keeps calling itself.

```text
Function
   ↓
Function
   ↓
Function
   ↓
Function
   ↓
...
```

This can cause:

```text
StackOverflowError
```

---

## 6. Recursive Case

The part where the function calls itself is called the **recursive case**.

```java
printNumbers(n - 1);
```

Here:

```text
n → n - 1
```

The problem becomes smaller in every call.

---

## 7. Simple Factorial Example

### Formula

```text
5! = 5 × 4 × 3 × 2 × 1
```

### Recursive Formula

```text
n! = n × (n - 1)!
```

### Java

```java
static int factorial(int n) {

    if (n == 0) {
        return 1;
    }

    return n * factorial(n - 1);
}
```

### Example

```java
System.out.println(factorial(5));
```

### Output

```text
120
```

---

## 8. Recursion Flow

For:

```java
factorial(5)
```

```text
5 × factorial(4)
       ↓
    4 × factorial(3)
           ↓
        3 × factorial(2)
               ↓
            2 × factorial(1)
                   ↓
                1 × factorial(0)
                       ↓
                       1
```

Then the results return:

```text
1
↓
1 × 1 = 1
↓
2 × 1 = 2
↓
3 × 2 = 6
↓
4 × 6 = 24
↓
5 × 24 = 120
```

---

## 9. Recursion and Stack

Each recursive function call is stored in the **call stack**.

```text
factorial(5)
factorial(4)
factorial(3)
factorial(2)
factorial(1)
factorial(0)
```

When the base case is reached, calls are removed from the stack one by one.

```text
factorial(0) → return
factorial(1) → return
factorial(2) → return
...
```

---

## 10. Recursion vs Loop

| Recursion | Loop |
|---|---|
| Function calls itself | Repeats using loop |
| Uses call stack | Usually less stack usage |
| Can be easier for tree/divide-and-conquer problems | Usually simpler for straightforward repetition |
| Can cause `StackOverflowError` | Usually avoids recursive stack growth |

---

## 11. Common Recursion Problems

Practice these in order:

```text
1. Print 1 to N
2. Print N to 1
3. Find factorial
4. Find sum of 1 to N
5. Find Fibonacci number
6. Reverse a number
7. Reverse a string
8. Find sum of digits
9. Find power of a number
10. Check palindrome
11. Find GCD
12. Binary search using recursion
```

---

## 12. Common Mistakes

### ❌ No Base Case

```java
static void fun(int n) {
    fun(n - 1);
}
```

This can cause:

```text
StackOverflowError
```

### ❌ Problem Does Not Become Smaller

The recursive call should normally move toward the base case.

```java
fun(n - 1);   // Good
```

instead of repeatedly calling:

```java
fun(n);       // No progress
```

---

# 🧠 Quick Memory Trick

```text
Recursion
   ↓
Function calls itself
   ↓
Base Case
   ↓
Stops recursion

Recursive Case
   ↓
Calls itself with a smaller/simpler problem
```

### ⭐ Interview One-Liner

> **Recursion is a technique where a function calls itself to solve a problem by breaking it into smaller subproblems until a base condition is reached.**

### ⭐ Most Important Points

```text
1. Function calls itself
2. Base case is mandatory
3. Recursive case performs the repeated call
4. Calls are stored in the call stack
5. Missing/incorrect base case can cause StackOverflowError
```
