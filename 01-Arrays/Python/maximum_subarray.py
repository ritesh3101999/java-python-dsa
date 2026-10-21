""" 
=====================================================================================================================================================
Question: Given an integer array nums, find the subarray with the largest sum, and return its sum.

Constraint: You must write an algorithm that runs in $O(n)$ time.
=====================================================================================================================================================
Examples
=====================================================================================================================================================
Example 1:

Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
Explanation: The subarray [4, -1, 2, 1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
=====================================================================================================================================================
Complexity Analysis
=====================================================================================================================================================
Time Complexity: O(n) 
— We iterate through the array exactly once, tracking the current subarray sum and the maximum sum found so far (Kadane's Algorithm).
Space Complexity: O(1) auxiliary space 
— We only use two integer variables to track the sums, requiring constant extra space.
=====================================================================================================================================================
 """

def max_sub_array(nums: list[int]) -> int:
    max_sum = nums[0]
    current_sum = 0
    
    for num in nums:
        # If the current running sum drops below zero, reset it.
        # A negative prefix will only drag down the sum of future subarrays.
        if current_sum < 0:
            current_sum = 0
            
        current_sum += num
        max_sum = max(max_sum, current_sum)
        
    return max_sum

if __name__ == "__main__":
    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    print(f"Maximum Subarray Sum: {max_sub_array(nums)}")  
    # Output: 6