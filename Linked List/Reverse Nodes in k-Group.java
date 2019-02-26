/*
25
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
12/10/2018 15:43 - 16:42
*/

// need to work more to figure out the pattern
为了反转这个单链表，我们先让头结点的next域指向结点2，再让结点1的next域指向结点3，最后将结点2的next域指向结点1，就完成了第一次交换，顺序就变成了Header-结点2-结点1-结点3-结点4-NULL，然后进行相同的交换将结点3移动到结点2的前面，然后再将结点4移动到结点3的前面就完成了反转。

代码：JAVA转载自https://blog.csdn.net/u012848330/article/details/51570232

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode root = new ListNode(-1);
    root.next = head;
    ListNode res = root;
    ListNode temp = head;
    int i = 0;
    while(temp != null){
        i++;
        temp = temp.next;
    }  //i的最终结果就是链表中所有节点的总个数
    while(i >= k){
        for(int j = 0 ; j < k-1; j++){  //按上面分析中讲的思路进行反转链表的操作
            ListNode node = root.next;  //如果以k个结点为一组进行反转，就要进行k-1次翻转操作
            root.next = head.next;         //比如k=3，就是两次操作：将2翻转到1前面+将3翻转到1前面
            head.next = root.next.next;
            root.next.next = node;
        }  //for循环里面是一次翻转操作
        root = head;  
        head = head.next;   //以k为一组，就要将head移动到已经反转过的结点后面继续以k个结点为一组进行反转
        i-=k;                       //此时一共i个结点减去已经反转过的k个结点得到剩余节点个数
    }
    return res.next;

--------------------- 
作者：tzyshiwolaogongya 
来源：CSDN 
原文：https://blog.csdn.net/tzyshiwolaogongya/article/details/79889012 
版权声明：本文为博主原创文章，转载请附上博文链接！