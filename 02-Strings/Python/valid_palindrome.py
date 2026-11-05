""" 
=====================================================================================================================================================
Question: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Constraint: You must write an algorithm that runs in $O(n)$ time and $O(1)$ extra space.
=====================================================================================================================================================
Examples
=====================================================================================================================================================
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
=====================================================================================================================================================
Complexity Analysis
=====================================================================================================================================================
Time Complexity: O(n) 
— We traverse the string using two pointers from the outside in, processing each character at most once.
Space Complexity: O(1) auxiliary space 
— We use two pointers and check in-place without creating a new filtered string.
=====================================================================================================================================================
 """

def is_palindrome(s: str) -> bool:
    left, right = 0, len(s) - 1
    
    while left < right:
        # Move left pointer to the next alphanumeric character
        while left < right and not s[left].isalnum():
            left += 1
        # Move right pointer to the previous alphanumeric character
        while left < right and not s[right].isalnum():
            right -= 1
            
        # Compare characters
        if s[left].lower() != s[right].lower():
            return False
            
        left += 1
        right -= 1
        
    return True

if __name__ == "__main__":
    s = "A man, a plan, a canal: Panama"
    print(f"Is Palindrome: {is_palindrome(s)}")  
    # Output: True