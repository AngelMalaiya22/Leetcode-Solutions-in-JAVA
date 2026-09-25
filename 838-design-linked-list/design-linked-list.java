class MyLinkedList {

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node root;
    private int size;

    public MyLinkedList() {
        root = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = root;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = root;
        root = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node curr = root;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }

        Node curr = root;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}