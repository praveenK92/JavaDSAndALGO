public class Queues {
	private int front;
	private int rear;
	private int size;
	private int array[];
	
	private Queues(int size){
		this.size=size;
		front=-1;
		rear=-1;
		array=new int[size];
	}
	private Queues(){
		this.size=1000;
		front=-1;
		rear=-1;
		array=new int[this.size];
	}
	public Queues createQueue(int size){
		return new Queues(size);
	}
	public boolean isEmpty(){
		return front==-1;
	}
	public boolean isFull(){
		return (rear+1)%size==front;
	}
	public int getSize(){
		return (rear-front+1+size)%size;
	}
	public void Enqueue(int data){
		if(isFull())return;
		else
		{
			rear=(rear+1)%size;
			array[rear]=data;
			if(front==-1)front=rear;
		}
	}
	public int Dequeue(){
		if(isEmpty()){
			return Integer.MIN_VALUE;
		}else{
			int data=array[front];
			if(front==rear){ 
				front=-1;
				rear=-1;
			}
			else
				front=(front+1)%size;
			return data;
		}
	}
}
