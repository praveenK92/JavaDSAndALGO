// Singly Linked List
public class Linked_List {
	public class ListNode{
		private int data;
		private ListNode next;
		public ListNode(int data){
			this.data=data;
		}
		public void setData(int data){
			this.data=data;
		}
		public void setNext(ListNode next){
			this.next=next;
		}
		public ListNode getNext(){
			return this.next;
		}
	}
	public int ListLength(ListNode head){
		int l=0;
		ListNode current=head;
		while(current!=null){
			l++;
			current=current.getNext();
		}
		return l;
	}
	// inserting a node
	public ListNode InsertInLinkedList(ListNode head,ListNode nodeToInsert,int position){
		if(head==null)
			return nodeToInsert;
		int size=ListLength(head);
		if(position>size+1 || position<1){
			System.out.println("Position of node is invalid. Insert 1 to "+size);
			return head;
		}
		if(position==1){
			nodeToInsert.setNext(head);
			return nodeToInsert;
		}
		else{
			ListNode previous=head;
			int c=1;
			while(c<position-1){
				previous=previous.getNext();
				c++;
			}
		ListNode current=previous.getNext();
		nodeToInsert.setNext(current);
		previous.setNext(nodeToInsert);
		}
		return head;		
	}
	// delete a node
	public ListNode DeleteNodeFromLinkedList(ListNode headNode,int position){
		int size=ListLength(headNode);
		if(position>size || position<1){
			System.out.println("Position invalid. Valid input: 1 to "+size);
			return headNode;
		}
		if(position==1){
			ListNode tempNode=headNode.getNext();
			headNode=null;
			return tempNode;
		}
		else{
			ListNode previousNode=headNode.getNext();
			int count=1;
			while(count<position){
				count++;
				previousNode=previousNode.getNext();
			}
			ListNode currentNode=previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode=null;
		}
		return headNode;
	}
	// Delete the whole list
	public void DeleteLinkedList(ListNode head){
		ListNode aux,iter=head;
		while(iter!=null){
			aux=iter.getNext();
			iter=null;
			iter=aux;
		}
	}
}
