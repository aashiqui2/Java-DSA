import java.util.Stack;

public class PalindromeLinkedList {
  class Node {
    int data;
    Node next;

    Node(int dataue) {
      data = dataue;
      next = null;
    }
  }

  Node head;

  public void insertAtLast(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      return;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
  }

  public void display() {
    System.out.println("Printing the linked list");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }

    System.out.println();
  }

  // ? Approach 1(stack)
  // public boolean isPalindrome(Node head) {
  // Stack<Integer> myStack = new Stack<>();
  // Node temp = head;
  // boolean status = false;

  // // Pushing the elements of Linked List to stack
  // while (temp != null) {
  // myStack.push(temp.data);
  // temp = temp.next;
  // }
  // temp = head;

  // while (temp != null) {
  // int element = myStack.pop();
  // if (temp.data == element) {
  // status = true;
  // temp = temp.next;
  // } else {
  // status = false;
  // break;
  // }
  // return status;
  // }

  // ? Approach 2(Two pointer)
  public boolean isPalindrome(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if (fast != null) {
      slow = slow.next;
    }
    slow = reverseList(slow);

    while (slow != null) {
      if (slow.data != head.data)
        return false;
      slow = slow.next;
      head = head.next;
    }
    return true;
  }

  public  Node reverseList(Node head) {
    Node prev = null;
    while (head != null) {
      Node next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    PalindromeLinkedList ll = new PalindromeLinkedList();
    // 1->Null
    ll.insertAtLast(1);
    // 1->2->Null
    ll.insertAtLast(2);
    // 1->2->1->Null
    ll.insertAtLast(1);

    // 1->2->1->2->Null
    ll.insertAtLast(2);
    // 1->2->1->2->1->Null
    ll.insertAtLast(1);

    ll.display();
    if (ll.isPalindrome(ll.head)) {
      System.out.println("Palindrome Linked List");
    } else {
      System.out.println("Not a Palindrome Linked List");
    }

    PalindromeLinkedList ll2 = new PalindromeLinkedList();
    ll2.insertAtLast(1);
    ll2.insertAtLast(2);
    ll2.insertAtLast(5);
    ll2.insertAtLast(6);
    ll2.display();
    if (ll2.isPalindrome(ll2.head)) {
      System.out.println("Palindrome Linked List");
    } else {
      System.out.println("Not a Palindrome Linked List");
    }

  }
}
//! Question Link(234)-> https://leetcode.com/problems/palindrome-linked-list/description/