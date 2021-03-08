# Just notes I'm taking for the task.

## 08 mar 2021 - 
Just started working on this. So, we have 2 arrays which we know are sorted, and want to calculate the median between the two. The median average is the value that separates the upper half from the lower half of a data sample (in our case, an array).

In the bigger picture, we have three cases:
1. An array is empty. In this case, we simply calculate the median over the non-empty array. We then go to either case 2 or 3;
2. The total number of elements divided by two is odd, so we get the value of the element at that index as median value;
3. The total number of elements divided by two is even, so we sum the value of the element at that index minus 1 and the value of the element at that index, we divide it by two, and get this value as median value.

Obviously merging the two arrays is useless, as we would get complexity O(n + m). 

The main idea I'm thinking as of now, is scrolling both lists at the same time, incrementing the index of the array with the lowest value considered. This should have complexity O(log(n + m))

Quick ascii art for reference to my future self ---

(Length of First) + (Length of Second) = 4. 
Median = (element at (i+j = 1) + element at (i+j = 2)) / 2

First-----------Second---
| 1 | 3 |-------| 2 | 4 |
--i---------------j------             
i + j = 0, but we are considering element First[0], as it is less than Second[0], so we increment i and do it again

First-----------Second---
| 1 | 3 |-------| 2 | 4 |
------i-----------j-----           
i + j = 1, we have to get this value. We save Second[0], as it's less than First[1], and we increment J for the same reason

First-----------Second---
| 1 | 3 |-------| 2 | 4 |
------i---------------j--           
i + j = 2, we have to get this value. We save First[1], as it's less than Second[1]. We got our two values, 2 and 3. We can stop iterating

Median = (2 + 3) / 2 = 2.5
Value checks out. We are onto something. Let's go baby.