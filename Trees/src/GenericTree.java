public class GenericTree {
	private int data;
	private GenericTree firstChild;
	private GenericTree nextSibling;
	
	public GenericTree(int data){
		this.data=data;
		firstChild=null;
		nextSibling=null;
	}
	public GenericTree(){
		this.data=Integer.MIN_VALUE;
		firstChild=null;
		nextSibling=null;
	}
	
	public void setData(int data){
		this.data=data;
	}
	public int getData(){
		return data;
	}
	
	public void setFirstChild(GenericTree child){
		firstChild=child;
	}
	public GenericTree getFirstChild(){
		return this.firstChild;
	}
	
	public void setNextSibling(GenericTree sibling){
		nextSibling=sibling;
	}
	public GenericTree getNextSibling(){
		return nextSibling;
	}
}
