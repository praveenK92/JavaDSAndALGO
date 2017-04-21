public class LLNode {
	private LLNode next;
	private int data;
	
	public LLNode(int data){
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
	public void setData(int data){
		this.data=data;
	}
	public int getData(){
		return this.data;
	}
	
}
