public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode(int data){
		this.data=data;
		left=null;
		right=null;
	}
	public BinaryTreeNode(){
		data=Integer.MIN_VALUE;
		left=null;
		right=null;
	}
	
	public void setData(int data){
		this.data=data;
	}
	public int getData(){
		return this.data;
	}
	public void setLeft(BinaryTreeNode left){
		this.left=left;
	}
	public void setRight(BinaryTreeNode right){
		this.right=right;
	}
	public BinaryTreeNode getLeft(){
		return left;
	}
	public BinaryTreeNode getRight(){
		return right;
	}
}
