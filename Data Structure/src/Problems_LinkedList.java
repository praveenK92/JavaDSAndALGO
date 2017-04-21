public class Problems_LinkedList {
	//Finding the middle element
	public ListNode MiddleElement(ListNode head){
		if(head==null){
			System.out.println("Linked List not proper.");
			return head;
		}
		ListNode ptr1=head,ptr2=head;
		while(ptr1.getNext()!=null){
			ptr1=ptr1.getNext();
			if(ptr1.getNext()!=null){
				ptr2=ptr2.getNext();
				ptr1=ptr1.getNext();
			}
		}
		return ptr2;
	}
	//Reversing the given Linked List
	public ListNode ReverseLinkedList(ListNode head){
		ListNode temp=null,nextNode=null;
		while(head!=null){
			nextNode=head.getNext();
			head.setNext(temp);
			temp=head;
			head=nextNode;			
		}
		return temp;
	}
	// finding the loop & getting the node from where it starts
	public ListNode LoopDetect(ListNode head){
		ListNode fastptr=head,slowptr=head;
		int i=0;
		while(fastptr!=null || fastptr.getNext()!=null){
			slowptr=slowptr.getNext();
			fastptr=fastptr.getNext().getNext();
			if(slowptr==fastptr)
			{
				i=1;
				break;
			}
		}
		if(i==0)
			return null;
		slowptr=head;
		while(slowptr!=fastptr){
			slowptr=slowptr.getNext();
			fastptr=fastptr.getNext();
		}
		return slowptr;
	}
	// Loop length
	public int LoopLength(ListNode head){
		ListNode fastptr=head,slowptr=head;
		int c=0;
		boolean i=false;
		while(fastptr!=null || fastptr.getNext()!=null){
			slowptr=slowptr.getNext();
			fastptr=fastptr.getNext().getNext();
			if(slowptr==fastptr)
			{
				i=true;
				break;
			}
		}
		if(i){
			fastptr=fastptr.getNext();
			while(slowptr!=fastptr){
				fastptr=fastptr.getNext();
				c++;
			}
			return c;
		}
		return 0;
	}
	// find even or odd
	public boolean Even(ListNode head){
		while(head!=null && head.getNext()!=null){
			head=head.getNext().getNext();
			if(head==null)
				return true;
		}
		return false;
	}
	
	// merge 2 sorted linked lists into another sorted
	public ListNode MergeList(ListNode a,ListNode b){
		ListNode result;
		if(a==null)return b;
		if(b==null)return a;
		if(a.getData()<=b.getData()){
			result=a;
			result.setNext(MergeList(a.getNext(),b));
		}else{
			result=b;
			result.setNext(MergeList(b.getNext(),a));
		}
		return result;
	}
	// Josephus Circle
	public static void GetJosephusPosition(int N,int M){
		ListNode p=new ListNode(1);
		ListNode q;
		p.setData(1);
		q=p;
		for(int i=2;i<=N;++i){
			ListNode temp=new ListNode(i);
			p.setNext(temp);
			p=temp;
			/*p=p.getNext();
			p.setData(i);*/
		}
		p.setNext(q);
		p=q;
		for(int c=N;c>1;c--){
			for(int i=0;i<M-1;++i)
				p=p.getNext();
			p.setNext(p.getNext().getNext());	
		}
		System.out.println("Last player left standing (Josephus Postion) is: "+p.getData());
	}
	
	public static void main(String[] args) {
		GetJosephusPosition(5,3);
		}

}