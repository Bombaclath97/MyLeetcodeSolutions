# Some notes

1. to check if a string is palindromic, we can basically check the last index and the first index and see if they are equal. Then we sandwich to the middle one(s). The problem arises in how are we supposed to decide which starting index and ending index we want for our substring. An idea could be to just map for each character in the string the greatest palindromic substring we can have with that character as starting index.
2. Let i be the starting index of the substring in exam. The worst case is that the biggest substring is the exact character we are examining, so we start by assuming that (worst case scenario = only truthful scenario). Then we can search our string for the last unchecked occurrence of the character, and we set that as our ending index. Recoursively check if our substring is palindromic or not. If it is, save it as the biggest substring, or else go next. 

This sounds extremely inefficient and, not gonna lie, kind of dumb. Just gotta think about is much MUCH more. Sorry Git

3. We can actually try with Dynamic Programming, since I already found two base cases. It should be somethin like this
```
Palindromic(i, j) is true if the substring(i, j) is palindromic, false otherwise

BASE CASES:
Palindromic(i, i) is always true
Palindromic(i, i+1) = (String[i] == String[i+1])
```

I'm not sure about this. This still sounds pretty complex and also kinda dumb. I'm gonna implement this and see if I'm onto something or not. Then I'm gonna look for some algorithms online (I'm sure someone came up with something like O(1) for this, but my puny little brain can't work it out, so guess I'm not gonna do it haha)