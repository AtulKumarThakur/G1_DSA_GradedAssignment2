package Q2;

import java.util.ArrayList;
import java.util.List;

class Node {
	    int value;
	    Node left, right;

	    public Node(int value) {
	        this.value = value;
	        left = null;
	        right = null;
	    }
	}

	public class Main {
	    Node node;

	    public static Node convertToSkewedTree(Node root) {
	        List<Node> nodeList = new ArrayList<Node>();
	        inOrderTraversal(root, nodeList);
	        Node skewedRoot = nodeList.get(0);
	        Node prevNode = skewedRoot;
	        for (int i = 1; i < nodeList.size(); i++) {
	            Node currentNode = nodeList.get(i);
	            prevNode.right = currentNode;
	            prevNode.left = null;
	            prevNode = currentNode;
	        }
	        prevNode.left = null;
	        prevNode.right = null;
	        return skewedRoot;
	    }

	    private static void inOrderTraversal(Node root, List<Node> nodeList) {
	        if (root == null) {
	            return;
	        }
	        inOrderTraversal(root.left, nodeList);
	        nodeList.add(root);
	        inOrderTraversal(root.right, nodeList);
	    }

	    public static void main(String[] args) {
	        Main tree = new Main();
	        tree.node = new Node(50);
	        tree.node.left = new Node(30);
	        tree.node.right = new Node(60);
	        tree.node.left.left = new Node(10);
	        tree.node.right.left = new Node(55);

	        Node skewedRoot = convertToSkewedTree(tree.node);

	        while (skewedRoot != null) {
	            System.out.print(skewedRoot.value + " ");
	            skewedRoot = skewedRoot.right;
	        }
	    }
	}