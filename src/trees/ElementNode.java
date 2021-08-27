package trees;

public class ElementNode<T extends Comparable<T>> {
    private final T object;
    private ElementNode<T> rightNode;
    private ElementNode<T> leftNode;

    public ElementNode(T object) {
        this.object = object;
        rightNode = null;
        leftNode = null;
    }


    public ElementNode<T> add(T data) {
        if (data.compareTo(this.object) < 0) {
            leftNode = (leftNode!=null) ? leftNode.add(data) : new ElementNode<T>(data);
        } else if (data.compareTo(this.object) > 0) {
            rightNode = (rightNode!=null) ? rightNode.add(data) : new ElementNode<T>(data);
        }
        return this;
    }

    public int height(ElementNode<T> tree) {
        if (tree == null) {
            return 0;
        }
        int left = (tree.leftNode!=null)? tree.height(tree.leftNode)+1 :0;
        int right = (tree.rightNode!=null) ? tree.rightNode.height(tree.rightNode) + 1 : 0;
        return Math.max(left,right);
    }

    public String preOrder() {
        var object = this.object.toString();
        var left = (this.leftNode!=null) ? this.leftNode.preOrder() : "";
        object = object + " " + left;
        var right = (this.rightNode!=null) ? this.rightNode.preOrder(): "";
        if (right.length() == 0) {
            return object;
        }
        return object + " " + right;
    }

    public boolean heightBalanced(ElementNode<T> root) {
        if (root == null) {
            return true;
        }
        var left = (height(root.leftNode) - height(root.rightNode)) <= 1 && heightBalanced(root.leftNode);
        if (!left) {
            return false;
        }
        var right = heightBalanced(root.rightNode);
        return left&right;
    }
    public static void main(String[] args) {
        var root = new ElementNode<Integer>(20);
        root.add(40);
        root.add(30);
        root.add(45);
        root.add(25);
        root.add(35);

        root.add(15);
        root.add(17);

        root.add(19);
        root.add(16);
        root.add(11);
        root.add(14);
        root.add(8);
        root.add(4);
        root.add(9);


        System.out.println(root.heightBalanced(root));
    }
}
