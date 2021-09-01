package trees;

import java.util.List;

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

    public Integer height(ElementNode<T> tree) {
        if (tree == null) {
            return null;
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
        return object +  right;
    }

    public String preOrderRight() {
        var object = this.object.toString();
        var right = (this.rightNode!=null) ? this.rightNode.preOrderRight() : "";
        object = object + " " + right;
        var left = (this.leftNode!=null) ? this.leftNode.preOrderRight(): "";
        if (left.length() == 0) {
            return object;
        }
        return object  + left;
    }

    public boolean heightBalanced(ElementNode<T> root) {

        if (root == null) {
            return true;
        }
        var leftHieght = height(root.leftNode);
        var rightHieght = height(root.rightNode);
        if (leftHieght == null | rightHieght == null){
            return false;
        }
        var left = (leftHieght- rightHieght) <= 1 ? heightBalanced(root.leftNode) : false;
        if (!left) {
            return false;
        }
        var right = heightBalanced(root.rightNode);
        return left&right;
    }




    public boolean symmetricalTree(ElementNode<T> root) {

        return root.leftNode.preOrderRight().equals(root.rightNode.preOrder());
    }


    public static void main(String[] args) {
        var root = new ElementNode<Integer>(10);
        root.add(20);
        root.add(25);
        root.add(15);
        root.add(8);
        root.add(6);
        root.add(4);

        System.out.println(root.preOrderRight());
    }
}
