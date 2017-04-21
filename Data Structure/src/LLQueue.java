public class LLQueue {
	private LLNode front;
	private LLNode rear;
	
	private LLQueue(){
		this.front=null;
		this.rear=null;
	}
	public LLQueue createQueue(){
		return new LLQueue();
	}
	
	public boolean isEmpty(){
		return front==null;
	}
	
	public void Enqueue(int data){
		LLNode temp=new LLNode(data);
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
	public int Dequeue(){
		int data=Integer.MIN_VALUE;
		if(isEmpty())return data;
		else{
			data=front.getData();
			front=front.getNext();
			return data;
		}
	}
}