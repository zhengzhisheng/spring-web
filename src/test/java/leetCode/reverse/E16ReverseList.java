package leetCode.reverse;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E16ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newListNode = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = newListNode;
            newListNode = head;
            head = next;
        }
        return newListNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        E16ReverseList test = new E16ReverseList();
        ListNode result = test.ReverseList(head);
        System.out.println(result.next.data);


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1",1);
        concurrentHashMap.put("2",1);
        concurrentHashMap.size();
        Lock lock = new ReentrantLock();
        lock.lock();
//        Thread.sleep(1);
//        lock.wait();

    }

}
