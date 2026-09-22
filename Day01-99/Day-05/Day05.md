# Day 5 - Backtracking & DFS

## Topics Practised
- Backtracking
- Recursion / DFS
- State management
- Grid traversal
- Constraint-based recursion
- String generation

## Questions Practised

### 1. Generate Parentheses
**Approach:**
- Use backtracking to build the string character by character.
- `open < n` → add `(`.
- `close < open` → add `)`.
- When `s.length() == 2*n`, store the valid combination.
- The constraints automatically prevent invalid parentheses.

### 2. Word Search
**Approach:**
- Start DFS from every cell.
- Match the current board character with `word[index]`.
- Mark the current cell as `#` to prevent reuse in the same path.
- Explore 4 directions: down, right, up, left.
- Restore the original character after DFS to backtrack.
- If `index == word.length()`, the word is found.