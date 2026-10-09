# 🔙 Backtracking Introduction

## 🔹 What is Backtracking?

**Backtracking** is an algorithmic technique that builds a solution step by step and goes back whenever a choice cannot lead to a valid solution.

It follows the idea:

**Choose → Explore → Undo → Try Another Choice**

---

## 🔹 How Backtracking Works

```text
Start
  ↓
Choose an option
  ↓
Explore the choice
  ↓
Is it valid?
  ├── Yes → Continue
  └── No  → Go back
                ↓
          Try another choice
```

---

## 🔹 Simple Example

Suppose we want to generate all possible combinations of `A` and `B` of length 2.

Possible combinations:

```text
AA
AB
BA
BB
```

We choose one character at a time. After exploring one choice, we go back and try another.

---

## 🔹 Simple Java Example

```java
class Main {
    static void generate(String result, int n) {
        if (result.length() == n) {
            System.out.println(result);
            return;
        }

        generate(result + "A", n);
        generate(result + "B", n);
    }

    public static void main(String[] args) {
        generate("", 2);
    }
}
```

### 🔹 Output

```text
AA
AB
BA
BB
```

### 🔹 Explanation

- Start with an empty string.
- Add `A` and explore.
- Then add `B` and explore.
- Stop when the string length becomes `2`.

This example demonstrates recursive exploration of choices. More complex backtracking problems also check constraints and undo changes when a choice fails.

---

## 🔹 Common Backtracking Problems

```text
1. N-Queens Problem
2. Sudoku Solver
3. Rat in a Maze
4. Permutations
5. Combinations
6. Subsets
7. Word Search
8. Generate Parentheses
```

---

## 🔹 Backtracking vs Recursion

| Recursion | Backtracking |
|---|---|
| A function calls itself | Explores choices and reverses decisions when needed |
| Used for many types of problems | Commonly used for constraint and search problems |
| May or may not explore choices | Usually explores multiple possible choices |

**Note:** Backtracking commonly uses recursion, but recursion does not always involve backtracking.

---

## 🧠 Quick Revision

```text
Backtracking
     ↓
Choose
     ↓
Explore
     ↓
Check Constraints
     ↓
Undo the Choice
     ↓
Try Another Choice
```

### ⭐ Interview One-Liner

> **Backtracking is an algorithmic technique that explores possible solutions step by step and reverses choices when they cannot lead to a valid solution.**
