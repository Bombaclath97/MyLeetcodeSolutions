class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode, carry = 0) -> ListNode:
        currentValue = l1.val + l2.val + carry                          #we calculate the value for the node we are in
        carry = currentValue // 10                                      #and save the carry on value.
        toReturn = ListNode(currentValue % 10)                          
        if(l1.next != None or l2.next != None or carry != 0):           #Three stopping conditions: either list is now exhausted or the carry on value is 0
            if l1.next == None:
                l1.next = ListNode(0)                                   #Not setting next value to 0 gives AttributeError goddamnit Python collaborate with me smh
            if l2.next == None:
                l2.next = ListNode(0)
            toReturn.next = self.addTwoNumbers(l1.next, l2.next, carry) #Recursively calling a recursive structure = stonks
        return toReturn

