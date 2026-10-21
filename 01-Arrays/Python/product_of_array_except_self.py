""" 
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
 """

def product_except_self(nums: list[int]) -> list[int]:
    n = len(nums)
    answer = [1] * n

    # Step 1: Calculate left products
    for i in range(1, n):
        answer[i] = answer[i - 1] * nums[i - 1]

    # Step 2: Calculate right products and multiply
    right_product = 1
    for i in range(n - 1, -1, -1):
        answer[i] *= right_product
        right_product *= nums[i]

    return answer

if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    print(f"Product Except Self: {product_except_self(nums)}")  
    # Output: [24, 12, 8, 6]