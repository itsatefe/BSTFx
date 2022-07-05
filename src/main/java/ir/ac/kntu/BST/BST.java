package ir.ac.kntu.BST;

import java.util.ArrayList;
import java.util.List;

public class BST {
    private Node root;
    private int nodeCount;
    private int height;
    private int level;

    public BST(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public int getHeight() {
        return maxDepth(getRoot()) - 1;
    }


    public int getLevel() {
        return maxDepth(getRoot());
    }


    public void insert(int data) {
       this.root = insert(root, data);
    }

    public Node insert(Node root,int data){
        if (root == null) {
            root  = new Node(data);
            return root;
        }
       if (root.getData() > data) {
            root.setLeft(insert(root.getLeft(), data)) ;
        } else if(root.getData() < data){
            root.setRight(insert(root.getRight(), data));
        }
        return root;
    }

    //List<Node> FX search representation
    public List<Node> search(int data) {
        List<Node> path = new ArrayList<>();
        boolean result = search(root,data,path);
        if(result==false) System.out.println("false");
        else for(int i=0;i<path.size();i++){
            System.out.println(path.get(i).getData());
        }
        return path;
    }
    private boolean search(Node root,int data,  List path) {
        if (root == null ) return false;
        path.add(root);
        if(root.getData() == data) return true;
        if (search(root.getLeft(), data, path) || search(root.getRight(), data, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }


    private String inOrder = "";
    private String inOrder(Node node){
        if(node != null){
            inOrder(node.getLeft());
            inOrder = inOrder + "-" + node.getData();
            inOrder(node.getRight());
        }
        return inOrder;
    }

    public String getInOrder() {
        inOrder(this.root);
        return inOrder;
    }

    public static int maxData(Node node) {
        if (node.getRight() == null) {
            return node.getData();
        } else {
            return maxData(node.getRight());
        }
    }
    //fx
    public Node updatedData(Node node,int oldData,int newData) {
        root = remove(root, oldData);
        root = insert(root, newData);
        return root;
    }

    public Node remove(Node root,int data){
        if (root == null) return null;

        if (data > root.getData()) {
            root.setRight(remove(root.getRight(), data));
            return root;
        } else if (data < root.getData()) {
            root.setLeft(remove(root.getLeft(), data));
            return root;
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight()== null) {
                return root.getLeft();
            } else {
                int max = maxData(root.getLeft());
                root.setData(max);
                root.setLeft(remove(root.getLeft(), max)) ;
                return root;
            }
        }
    }
    public int getLeafCount()
    {
        return getLeafCount(root);
    }

    private int getLeafCount(Node node)
    {
        if (node == null)
            return 0;
        if (node.getLeft() == null && node.getRight() == null)
            return 1;
        else
            return getLeafCount(node.getLeft()) + getLeafCount(node.getRight());
    }

    private int maxDepth(Node node) //= height + 1
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.getLeft());
            int rDepth = maxDepth(node.getRight());
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}
