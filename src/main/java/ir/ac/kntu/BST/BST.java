package ir.ac.kntu.BST;

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
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void insert(int data){
        Node node = new Node(data);
        //do recursive parent = FindLocation()
        //if data <= parent.getData() parent.SetLeft(node)
        //if data > parent.getData() parent.SetRight(node)
    }

    public void remove(int data){
        Node node = new Node(data);
        //do recursive parent = FindLocation()

        //bayad deghat she age node miani hazf shod baste b inke bache rast ya chap dare
        //yeki az bacheha ro bezarim jaye pedar
    }

    public int CalHeight(){
        // mohasebe ertefaa
        return 0;
    }
}
