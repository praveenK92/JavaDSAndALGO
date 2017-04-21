
public class DLL_List {
	
	public class DLLNode{
		private int data;
		private DLLNode next;
		private DLLNode previous;
		public DLLNode(int data){
			this.data=data;
		}
		public void setData(int data){
			this.data=data;
		}
		public int getData(){
			return this.data;
		}
		public void setNext(DLLNode next){
			this.next=next;
		}
		public DLLNode getNext(){
			return this.next;
		}
		public void setPrevious(DLLNode previous){
			this.previous=previous;
		}
		public DLLNode getPrevious(){
			return this.previous;
		}
	}
	public int getDLLLength(DLLNode headNode){
		int l=0;
		DLLNode current=headNode;
		if(current!=null){
			l++;
			current=current.getNext();
		}
		return l;
	}
	// Inserting a node in Doubly Linked List
	public DLLNode DLLInsert(DLLNode headNode,DLLNode nodeToInsert,int position){
		if(headNode==null)
			return nodeToInsert;
		int size=getDLLLength(headNode);
		if(position>size+1 || position<1){
			System.out.println("Position of node is invalid. Insert 1 to "+size);
			return headNode;
		}
		if(position==1){
			nodeToInsert.setNext(headNode);
			headNode.setPrevious(nodeToInsert);
			return nodeToInsert;
		}
		else{
			DLLNode previous=headNode;
			int c=1;
			while(c<position-1){
				previous=previous.getNext();
				c++;
			}
		DLLNode current=previous.getNext();
		nodeToInsert.setNext(current);
		if(current!=null){
			current.setPrevious(nodeToInsert);
		}
		previous.setNext(nodeToInsert);
		nodeToInsert.setPrevious(previous);
		}
		return headNode;		
	}
	// Deleting a Node
	public DLLNode DeleteNode(DLLNode headNode,int position){
		int size=getDLLLength(headNode);
		if(position>size || position<1){
			System.out.println("Position invalid. Valid input: 1 to "+size);
			return headNode;
		}
		if(position==1){
			DLLNode tempNode=headNode.getNext();
			headNode=null;
			tempNode.setPrevious(null);
			return tempNode;
		}
		else{
			DLLNode previousNode=headNode.getNext();
			int count=1;
			while(count<position){
				count++;
				previousNode=previousNode.getNext();
			}
			DLLNode currentNode=previousNode.getNext();
			DLLNode laterNode=currentNode.getNext();
			previousNode.setNext(laterNode);
			if(laterNode!=null){
				laterNode.setPrevious(previousNode);
			}
			currentNode=null;
		}
		return headNode;
	}
}
