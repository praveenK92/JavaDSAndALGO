public class BinaryTreeOperations {
	static int diameter;
	
	// finding height of a tree by recursion
	public int HeightofBinaryTree(BinaryTreeNode root){
		if(root==null)return 0;
		int leftheight,rightheight;
		
		leftheight=HeightofBinaryTree(root.getLeft());  // left Height of tree
		rightheight=HeightofBinaryTree(root.getRight());  // right height of tree
		
		return Math.max(leftheight,rightheight)+1;
		/*if(leftheight>rightheight)return leftheight+1;
		else return rightheight+1;*/
	}
	// height of binary tree by iteration
	public int HeightOfBinaryTreeIteration(BinaryTreeNode root){
		if(root==null)return 0;
		BinaryTreeNode temp;
		int count=0;
		LLQueue Q=new LLQueue();
		Q.Enqueue(root);
		Q.Enqueue(null);
		while(!Q.isEmpty()){
			temp=Q.Dequeue();
			if(temp==null){
				count++;   // height=no. of levels
				Q.Enqueue(null);
			}
			else{
			if(temp.getLeft()!=null)Q.Enqueue(temp.getLeft());
			else if(temp.getRight()!=null)Q.Enqueue(temp.getRight());
			}
		}
		return count;
	}
	//Size of binary tree by simple iteration
	public int SizeofBinaryTree(BinaryTreeNode root){
		if(root==null)return 0;
		else
		return SizeofBinaryTree(root.getLeft())+SizeofBinaryTree(root.getRight())+1;
		// left size + right size +1
	}
	// no of nodes
	public int SizeofBinaryTreeIteration(BinaryTreeNode root){
		if(root==null)return 0;
		BinaryTreeNode temp;
		int size=0;
		LLQueue Q=new LLQueue();
		Q.Enqueue(root);
		while(!Q.isEmpty()){
			temp=Q.Dequeue();
			if(temp==null)continue;
			else{
				size++;  // each node visited increases size by 1
				if(temp.getLeft()!=null)Q.Enqueue(temp.getLeft());
				else if(temp.getRight()!=null)Q.Enqueue(temp.getRight());
			}
		}
		return size;
	}
	// diameter of a binary tree
	public static int Diameter(BinaryTreeNode root){
		if(root==null)return 0;
		int left=Diameter(root.getLeft());
		int right=Diameter(root.getRight());
		if(left+right>diameter)diameter=left+right+1;
		return Math.max(left,right)+1;
	}
	
	// deleting a binary tree
	public void DeleteBinaryTree(BinaryTreeNode root){
		if(root==null)return;
		DeleteBinaryTree(root.getLeft());
		DeleteBinaryTree(root.getRight());
		root=null;   // always delete a tree by its leaves
	}
	
}