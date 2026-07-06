//Simple code
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    // Insert at beginning
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Insert at end
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<T> temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        size++;
    }

    // Insert at specific position
    public void insertAtPosition(int position, T data) {

        if (position < 0 || position > size) {
            System.out.println("Invalid Position");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> temp = head;

        for (int i = 0; i < position - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Delete by value
    public void delete(T key) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head.data.equals(key)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> temp = head;

        while (temp.next != null && !temp.next.data.equals(key)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element Not Found");
        } else {
            temp.next = temp.next.next;
            size--;
        }
    }

    // Search
    public boolean search(T key) {

        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(key))
                return true;

            temp = temp.next;
        }

        return false;
    }

    // Reverse Linked List
    public void reverse() {

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Find Middle Node
    public T findMiddle() {

        if (head == null)
            return null;

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Detect Cycle (Floyd Algorithm)
    public boolean hasCycle() {

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    // Get Size
    public int size() {
        return size;
    }

    // Check Empty
    public boolean isEmpty() {
        return head == null;
    }

    // Display
    public void display() {

        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main Method
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.insertAtPosition(2, 25);

        System.out.println("Original List:");
        list.display();

        System.out.println("Size: " + list.size());

        System.out.println("Search 30: " + list.search(30));

        System.out.println("Middle Element: " + list.findMiddle());

        list.reverse();

        System.out.println("After Reverse:");
        list.display();

        list.delete(25);

        System.out.println("After Deleting 25:");
        list.display();

        System.out.println("Cycle Present: " + list.hasCycle());
    }
}
