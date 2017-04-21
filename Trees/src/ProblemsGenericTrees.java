public class ProblemsGenericTrees {
	
	public int SumOfAllElements(GenericTree root){
		if(root==null)return 0;
		
		return root.getData()+SumOfAllElements(root.getFirstChild())+SumOfAllElements(root.getNextSibling());
	}
	
	public boolean isIsomorphic(GenericTree root1,GenericTree root2){
		if(root1==null && root2==null)return true;
		if((root1==null && root2!=null) || (root1!=null && root2==null))
			return false;
		
		return isIsomorphic(root1.getFirstChild(),root2.getFirstChild()) && isIsomorphic(root1.getNextSibling(),root2.getNextSibling());
	}
	// count the no of children of a node
	public int CountChildren(GenericTree node){
		if(node==null)return 0;
		int count=0;
		GenericTree temp;
		temp=node.getFirstChild();
		while(temp!=null){
			count++;
			temp=temp.getNextSibling();
		}
		return count;
	}
	
	

}
