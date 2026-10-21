/* 
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
— We iterate through the array exactly once using Kadane's Algorithm.
Space Complexity: O(1) auxiliary space 
— We only use a couple of primitive variables to track sums, which takes constant space.
=====================================================================================================================================================
*/

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        
        for (int num : nums) {
            // If the current running sum drops below zero, reset it.
            if (currentSum < 0) {
                currentSum = 0;
            }
            
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums)); 
        // Output: 6
    }
}