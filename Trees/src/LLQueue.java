public class LLQueue {
	private LLNode front;
	private LLNode rear;
	
	public LLQueue(){
		this.front=null;
		this.rear=null;
	}
	public LLQueue createQueue(){
		return new LLQueue();
	}
	
	public boolean isEmpty(){
		return front==null;
	}
	
	public void Enqueue(BinaryTreeNode node){
		LLNode temp=new LLNode(node);
		if(rear!=null){
		rear.setNext(temp);
		rear=rear.getNext();
		}
		else{
			rear=temp;
			if(front==null)
			front=rear;
		}
	}
	public BinaryTreeNode Dequeue(){
		BinaryTreeNode node=null;
		if(isEmpty())return node;
		else{
			node=front.getData();
			front=front.getNext();
			return node;
		}
	}
}