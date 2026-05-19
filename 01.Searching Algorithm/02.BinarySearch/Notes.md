# All Necessary Conditions for `Binary Search`:

1. **Sorted Array** 
The array must be sorted in ascending or descending order. Binary search only works on ordered data.  
             |
2.  **Random Access**  
The data structure must allow direct access to elements using index (e.g., arrays, not linked lists).   
           |
3. **Stable Boundaries**  
Use correct `low`, `high`, and `mid` to avoid infinite loops or overflow (`mid = low + (high - low) / 2` is safe).

4. **Check Termination Carefully**           
Stop when `low > high` (recursive) or `low <= high` fails (iterative).

5. **Handle Duplicates Carefully** (optional) 
If the array has duplicates, and you want the first or last occurrence, special handling is required.
              |
6. **Array Type Consistency**
Works with any comparable type (int, String, etc.) as long as it's sorted.   
                                      |
7. **Compare Correctly**                      
Use `key < arr[mid]`, `key > arr[mid]`, `key == arr[mid]` — don’t assume all keys will be found. 
                  |
8. **Non-empty Array**                        
Must have at least one element. If empty, return `-1` or appropriate "not found" response.                        


# 🚫Common Mistakes to Avoid:

| Mistake                                      | Why it's wrong                                  |
| -------------------------------------------- | ----------------------------------------------- |
| Using binary search on unsorted arrays       | Result will be incorrect.                       |
| Incorrect mid calculation (`(low + high)/2`) | Risk of overflow for large indices.             |
| Not updating `low` or `high`                 | Causes infinite loop or stack overflow.         |
| Using it on linked list                      | Access is O(n), so binary search loses purpose. |



##  Example: Valid Use Case

```java
int[] sortedArray = {1, 3, 5, 7, 9, 11};
int key = 7;
// Binary search can be applied ✅
int[] unsortedArray = {9, 3, 1, 7, 5, 11};
int key = 7;
// ❌ Binary search won't work — must sort it first
```



