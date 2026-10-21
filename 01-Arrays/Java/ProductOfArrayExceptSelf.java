/* 
=====================================================================================================================================================
Question: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

Constraint: You must write an algorithm that runs in $O(n)$ time and without using the division operation.
=====================================================================================================================================================
Examples
=====================================================================================================================================================
Example 1:

Input: nums = [1, 2, 3, 4]
Output: [24, 12, 8, 6]

Example 2:

Input: nums = [-1, 1, 0, -3, 3]
Output: [0, 0, 9, 0, 0]
=====================================================================================================================================================
Complexity Analysis
=====================================================================================================================================================
Time Complexity: O(n) 
— We make two passes through the array (one for prefixes, one for suffixes), taking linear time.
Space Complexity: O(1) auxiliary space 
— The output array does not count towards extra space complexity according to standard interview constraints.
=====================================================================================================================================================
*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;

        int[] answer = new int[n];

        // Step 1: Calculate left products and store in answer array
        answer[0] = 1;
        for(int i = 1; i < n; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        // Step 2: Calculate right products on the fly and multiply with left products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Product Except Self: " + Arrays.toString(productExceptSelf(nums))); 
        // Output: [24, 12, 8, 6]
    }
}
