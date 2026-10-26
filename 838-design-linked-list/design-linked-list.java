class MyLinkedList 
{
    private class Node {
        int val;
        Node next;
        Node(int val)
        {
            this.val= val;
        }
    }

    private Node head;
    private int size;
    public MyLinkedList() 
    {
        head= null;
        size= 0;
    }
    
    public int get(int index) 
    {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) 
    {
        Node newNode= new Node(val);

        newNode.next= head;
        head= newNode;
        size++;
    }
    
    public void addAtTail(int val) 
    {
        addAtIndex(size, val);   
    }
    
    public void addAtIndex(int index, int val) 
    {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }

        Node newNode= new Node(val);
        Node prev= head;
        for(int i=0; i<index-1; i++)
        {
            prev= prev.next;
        }

        newNode.next= prev.next;
        prev.next= newNode;
        size++;
        
    }
    
    public void deleteAtIndex(int index) 
    {
        if (index < 0 || index >= size) {
            return;
        }

        if(index == 0)
        {
            head= head.next;
        }
        else
        {
            Node prev= head;
            for(int i=0; i<index-1; i++)
            {
                prev= prev.next;
            }
            prev.next= prev.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */