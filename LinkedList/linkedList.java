class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class linkedList {
static Node intersectionPoint(Node head1, Node head2){
    Node ptr1=head1;
    Node ptr2=head2;

    if(ptr1==null || ptr2==null){
        return null;
    }

    while(ptr1!=ptr2){
        if(ptr1==null){
            ptr1=head2;
        }
        else{
            ptr1=ptr1.next;
        }

        if(ptr2==null){
            ptr2=head1;
        }
        else{
            ptr2=ptr2.next;
        }
    }
    return ptr1;
}

    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        Node head2 = new Node(40);
        head2.next = new Node(50);  
        head2.next.next = new Node(60);

        head2.next.next.next = head1.next; 

        Node ans = intersectionPoint(head1, head2);

        if (ans != null) {
            System.out.println("Intersection point: " + ans.data);
        } else {
            System.out.println("-1");
        }

    }
}
