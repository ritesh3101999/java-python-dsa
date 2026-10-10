""" 
======================================================================================================
Given an integer array nums, return true if any value appears at least twice in the array, 
and return false if every element is distinct.

======================================================================================================
Example 1:
Input: nums = [1, 2, 3, 1]
Output: true

Example 2:
Input: nums = [1, 2, 3, 4]
Output: false

======================================================================================================
COMPLEXITY ANALYSIS
======================================================================================================
Time Complexity: O(n)
- We iterate through the array once and check/insert elements into a Hash Set
in constant time on average.

Space Complexity: O(n)
- In the worst-case scenario (all element are unique), the Hash Set will store all n elements.
======================================================================================================
 """

def contains_duplicate(nums: list[int]) -> bool:
    seen = set()

    for num in nums:
      if num in seen:
        return True

      seen.add(num)

    return False

if __name__ == "__main__":
   nums = [1, 2, 3, 1]
   print(f"Contains Duplicate: {contains_duplicate(nums)}") # Output: True
