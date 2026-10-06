/*
 * Problem: Two Sum
 *
 * Given an integer array nums and an integer target,
 * return the indices of the two numbers such that they
 * add up to target.
 *
 * Example:
 * Input:
 * nums = [2, 7, 11, 15]
 * target = 9
 *
 * Output:
 * [0, 1]
 *
 * Explanation:
 * nums[0] + nums[1] = 2 + 7 = 9
 *
 * Approach:
 * Use a HashMap to store each number and its index.
 * For every number, calculate the required value:
 *
 * required = target - current number
 *
 * If required is already in the map, we have found
 * the two numbers.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int required = target - nums[i];

            // Check if the required number already exists
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }

            // Store number and its index
            map.put(nums[i], i);
        }

        // No solution found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
