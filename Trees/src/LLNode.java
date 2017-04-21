public class LLNode {
	private LLNode next;
	private BinaryTreeNode data;
	
	public LLNode(BinaryTreeNode data){
		this.data=data;
		next=null;
	}
	public LLNode(){
		next=null;
		
	}
	
	public void setNext(LLNode temp){
		next=temp;
	}
	public LLNode getNext(){
		return this.next;
	}
	public void setData(BinaryTreeNode data){
		this.data=data;
	}
	public BinaryTreeNode getData(){
		return data;
	}
	
}
