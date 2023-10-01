class Solution
{
    public static Node addOne(Node head) 
    { 
        Node node = head.next;
		double n = head.data;
		while(node != null) {
			n = n * 10.0 + node.data;
			node = node.next;
		}
		n++;
		Node next = null;
		while(n != 0) {
			Node ans = new Node((int) (n % 10));
			ans.next = next;
			next = ans; 
			n = Math.floor(n / 10.0);
		}
		return next;
    }
}
//Time: O(n), Space: O(1)
//Not working where n is double

class Solution
{
    public static Node addOne(Node head) 
    { 
        Node h=head;
        Node last=null;
        while(head!=null){
            if(head.data!=9){
                last=head;
            }
            head=head.next;
        }
        if(last==null){
            Node n=new Node(1);
            n.next=h;
            while(h!=null){
                h.data=0;
                h=h.next;
            }
            return n;
        }
        last.data=last.data+1;
        last=last.next;
        while(last!=null){
            last.data=0;
            last=last.next;
        }
        return h;
    }
}
//Time: O(n), Space: O(1)
//Four scenarios are possible:
//1) All digits are 9. Handled by if(last==null)
//2) No digits are 9. Handled by last.data=last.data+1 and last while will never get executed
//3) 9 is present and it's the last digit. Handled by while(last!=null){}
//4) 9 is present and it's not the last digit. Handled by last.data=last.data+1 and last while will never get executed
//For other solutions: https://www.geeksforgeeks.org/add-1-number-represented-linked-list/