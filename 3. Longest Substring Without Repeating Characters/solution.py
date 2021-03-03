class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxSub = 0
        map = dict()

        beginning = 0
        for char_index in range(len(s)):
            #We check if we already found the character.
            if s[char_index] in map:
                #We already found it. Shift the beginning index to this value if we haven't surpassed it already 
                beginning = max(map[s[char_index]], beginning)
            #Let's see if the substring we are examining is our maxSub value -- Line 15 is stolen
            lengthOfSubstring = char_index - beginning + 1
            maxSub = max(maxSub, lengthOfSubstring)
            map[s[char_index]] = char_index + 1
        return maxSub


                
string = "abcabcbb"
print(Solution.lengthOfLongestSubstring(Solution, string))