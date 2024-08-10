import java.util.Scanner;
import java.util.Stack;

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListReverseEvenSubpart {

    // Function to reverse the subparts of the list containing even integers
    public static Node reverseEvenSubpartsUsingStack(Node head) {
        if (head == null) return null;
        
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        
        while (head != null) {
            if (head.data % 2 == 0) {
                Stack<Node> stack = new Stack<>();
                
                // Push all even nodes onto the stack
                while (head != null && head.data % 2 == 0) {
                    stack.push(head);
                    head = head.next;
                }
                
                // Pop from the stack to reverse the order of even nodes
                while (!stack.isEmpty()) {
                    prev.next = stack.pop();
                    prev = prev.next;
                }
                prev.next = head;  // Connect to the remaining list
            } else {
                prev = head;
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Function to create a linked list from an array
    public static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements in the linked list:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Create the linked list from the input
        Node head = createLinkedList(arr);
        
        // Reverse even subparts using stack
        Node modifiedHead = reverseEvenSubpartsUsingStack(head);
        
        // Print the modified linked list which should be the original list restored
        System.out.println("Restored Original Linked List:");
        printList(modifiedHead);
    }
}
