public class DoOpTrees {
	static int preIndex;
	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7,8};
		BinaryTreeNode a=new BinaryTreeNode();
		a.setData(0);
		for(int i:arr){
		BinaryTreeNode b=new BinaryTreeNode();
		b.setData(i);
		if(a.getLeft()==null)a.setLeft(b);
		if(a.getRight()==null){
			a.setRight(b);
			a=a.getLeft();
		}
		}
	}
	
	public static BinaryTreeNode MirrorImage(BinaryTreeNode root){
		BinaryTreeNode temp;
		if(root!=null){
			MirrorImage(root.getLeft());
			MirrorImage(root.getRight());
			temp=root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);			
		}
		return root;
	}
	
	// BuildTree: given an inorder & preorder traversal build the binary tree
	public static BinaryTreeNode BuildTree(int preorder[],int inorder[],int inStrt,int inEnd){
		preIndex=0;
		BinaryTreeNode newNode=new BinaryTreeNode();
		if(inStrt>inEnd)return null;
		else if(newNode==null){
			System.out.println("Memory Error");
			return null;
		}
		
		newNode.setData(preorder[preIndex]);
		preIndex++;
		if(inStrt==inEnd)return newNode;
		int inIndex=Search(inorder,inStrt,inEnd,newNode.getData());
		
		newNode.setLeft(BuildTree(preorder,inorder,inStrt,inIndex-1));
		newNode.setRight(BuildTree(preorder,inorder,inIndex+1,inEnd));
		return newNode;
	}
	// Search is a helper function for BuildTree
	public static int Search(int a[],int s,int e,int data){
		for(int i=0;i<a.length;i++){
			if(a[i]==data)return i;
		}
		return -1;
	}
	// Lowest common ancestor of two nodes a & b
	public static BinaryTreeNode LCA(BinaryTreeNode root,BinaryTreeNode a,BinaryTreeNode b){
		if(root==null)return root;
		if(root==a || root==b)return root;
		
		BinaryTreeNode left,right;
		left=LCA(root.getLeft(),a,b);
		right=LCA(root.getRight(),a,b);
		
		if(left!=null && right!=null)return root;
		else return (left!=null)?left:right;
	}
	// every node has either 0 or 2 child
	// ILILL  I=Internal Node L=Leaf
	public static BinaryTreeNode BuildTreeFromPreOrder(char[] A,int i){
		if(A==null)return null;
		BinaryTreeNode node=new BinaryTreeNode();
		node.setData(A[i]);
		
		if(A[i]=='L'){
		node.setLeft(null);
		node.setRight(null);
		return node;
		}
		i++;
		node.setLeft(BuildTreeFromPreOrder(A,i));
		i++;
		node.setRight(BuildTreeFromPreOrder(A,i));
		return node;
	}
	
	
}