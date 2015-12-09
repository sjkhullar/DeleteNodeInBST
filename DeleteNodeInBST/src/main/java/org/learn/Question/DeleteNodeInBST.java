
package org.learn.Question;
import org.learn.PrepareTree.Node;

public class DeleteNodeInBST {
	public static void inorder(Node root) {		
		if(root == null)
			return;
		inorder(root.left);
		System.out.printf("%d ",root.data);
		inorder(root.right);		
	}
	
	private static int min(Node node) {
		if(node.left == null) {
			return node.data;
		}
		return min(node.left);
	}
	public static Node deleteNodeInBST(Node node, int data) {
		if(null == node) {
			System.out.println("Element is not there in binary search tree");
			return null;
		}
		if(data < node.data) {
			node.left = deleteNodeInBST(node.left, data);
		} else if(data > node.data) {
			node.right = deleteNodeInBST(node.right, data);
		} else { //case for equality
			//Now we see that whether we can directly delete the node
			//[Scenario 3]
			if(node.left != null && node.right != null) {
				int minInRightSubTree = min(node.right);
				node.data = minInRightSubTree;
				node.right = deleteNodeInBST(node.right,minInRightSubTree);
			} else { //either one child or leaf node 
				//[Scenario 1 and Scenario 2]
				if(node.left == null && node.right == null) {
					node = null;
				} else {//one child case
					Node deleteNode = node;
					node = (node.left != null) ? (node.left) : (node.right);
					deleteNode = null;
				}
			}
		}
		return node;
	}
}
