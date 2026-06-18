class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ll1 {

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
    
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node addOne(Node head){
        head = reverse(head);
        Node curr = head;
        int carry = 1;

        while(curr != null && carry > 0){
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            if(curr.next == null && carry > 0){
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }
        return reverse(head);
    }

    static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            if(temp.next != null){
                System.out.print("-> ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);


    }
}
