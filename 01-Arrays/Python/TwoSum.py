""" QUESTIONS: Two Sum (LeetCode #1)

Given an array of integers `nums` and an integer `target`, 
return indices of the two numbers such that they add up to `target`. 

Assume:
- Exactly one solution exists.
- You may not use the same element twice.

Example:
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

=================================================================================================
COMPLEXITY ANALYSIS:
=================================================================================================
Time Complexity: O(n)
- We iterate through the array of length N once.
- Checking 'if needed in seen' and inserting into a python dictionary takes O(1) average time.
- Total time is proportional to the number of elements: O(n).

Space Complexity: O(n)
- We store numbers in a dictionary 'seen'.
- In the worst case, we store up to N elements before finding the pair.
================================================================================================= """


def two_sum(nums, target):
    # Dictionary to remember visited numbers: {number: index}
    seen = {}

    for i in range(len(nums)):
        current = nums[i]
        needed = target - current

        # 1. Check if the complement is already in the dictionary
        if needed in seen:
            return [seen[needed], i]

        # 2. If not found, save current number and it's index
        seen[current] = i

    return []

# -- Testing the code --
if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    result = two_sum(nums, target)
    print("Result:", result) # Expected: [0, 1]