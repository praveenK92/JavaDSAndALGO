public class TreeTraversals {
	
	public void PreOrder(BinaryTreeNode root){
		if(root!=null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	public void PostOrder(BinaryTreeNode root){
		if(root!=null){
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}
	
	public void Inorder(BinaryTreeNode root){
		if(root!=null){
			Inorder(root.getLeft());
			System.out.println(root.getData());
			Inorder(root.getRight());
		}
	}
	
	public void LevelOrder(BinaryTreeNode root){
		BinaryTreeNode temp;
		if(root==null)return;
		LLQueue Q=new LLQueue();
		Q.Enqueue(root);
		while(!Q.isEmpty()){
			temp=Q.Dequeue();
			System.out.println(temp.getData());
			if(temp.getLeft()!=null){
				Q.Enqueue(temp.getLeft());
			}
			if(temp.getRight()!=null){
				Q.Enqueue(temp.getRight());
			}
		}
		
		
	}
}
