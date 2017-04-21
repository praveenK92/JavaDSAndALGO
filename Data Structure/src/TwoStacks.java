public class TwoStacks {
/*	private int topOne,topTwo,size;
	private int[] dataArray;
	
	public TwoStacks(int size){
		if(size<2)throw new IllegalStateException("Size < 2 not permissible");
		this.size=size;
		topOne=-1;
		topTwo=this.size;
	}
	public void push(int ID,int data){
		if(topOne==topTwo-1)throw new StackOverflowException("Array is full");
		if(ID==1)
			dataArray[++topOne]=data;
		else if(ID==2)
			dataArray[++topTwo]=data;
		else return;
	}
	public int pop(int ID){
		if(ID==1){
			if(topOne==-1)throw new EmptyStackException("First Stack is empty");
			int temp=dataArray[topOne];
			topOne--;
			return temp;
		}
		else if(ID==2){
			if(topTwo==this.size)throw new EmptyStackException("Second Stack is empty");
			int temp=dataArray[topTwo];
			dataArray[topTwo++]=null;
			return temp;
		}
		else return null;
	}
	public int top(int ID){
		if(ID==1){
			if(topOne==-1)throw new EmptyStackException("First Stack is empty");
			return dataArray[topOne];
		}
		else if(ID==2){
			if(topTwo==this.size)throw new EmptyStackException("Second Stack is empty");
			return dataArray[topTwo];
		}
		else return null;
	}
	public boolean isEmpty(int ID){
		if(ID==1)
			return topOne==-1;
		else if(ID==2)
			return topTwo==this.size;
		else
			return true;
*/	}