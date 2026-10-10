/* 
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
*/

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums){
        HashSet<Integer> seen = new HashSet<>();
        
        for(int num:nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Contains Duplicate: " + containsDuplicate(nums)); // Output: true
    }
}
