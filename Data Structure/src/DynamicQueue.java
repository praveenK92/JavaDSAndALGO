public class DynamicQueue {
	private int front;
	private int rear;
	private int size;
	private int array[];
	
	private DynamicQueue(int size){
		this.size=size;
		front=-1;
		rear=-1;
		array=new int[size];
	}
	private DynamicQueue(){
		this.size=1000;
		front=-1;
		rear=-1;
		array=new int[this.size];
	}
	public DynamicQueue createDynQueue(int size){
		return new DynamicQueue(size);
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
		if(isFull())resizeQueue();
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
	private void resizeQueue(){
		int newsize=size*2;
		int newarray[]=new int[newsize];
		int j=front;
		/* some problem here...
		 * */
		System.arraycopy(array,0, newarray, 0, size);
		for(int i=0;i<=rear;i++){
			newarray[i+size]=array[i];
		}
		rear+=size;
		array=newarray;
		size=newsize;
	}
}
