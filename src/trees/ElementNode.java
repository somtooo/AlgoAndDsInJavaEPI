package trees;

import java.util.*;

public class ElementNode<T extends Comparable<T>> {
    private final T object;
    private ElementNode<T> rightNode;
    private ElementNode<T> leftNode;
    private int numOfNodes;
    private ElementNode<T> parent;


    public ElementNode(T object) {
        this.object = object;
        rightNode = null;
        leftNode = null;
    }

    public ElementNode(T object, ElementNode<T> parent) {
        this.object = object;
        this.parent = parent;
        rightNode = null;
        leftNode = null;
    }

    public ElementNode(T object, int numOfNodes) {
        this.object = object;
        this.numOfNodes = numOfNodes;
        rightNode = null;
        leftNode = null;
    }



    public static class Ancestor {
        private Integer looking;
        private boolean complete;
        private Integer lca;
        private boolean beLca;

        public Ancestor() {
            this.lca = null;
            this.beLca = false;
            this.looking = null;
            this.complete = false;
        }

        public Integer getLca() {
            return lca;
        }

        public void setLca(Integer lca) {
            this.lca = lca;
        }
        
        public void setBeLca(boolean s) {
            this.beLca = s;
        }
        
        public boolean getBeLca() {
            return beLca;
        }

        public void setLooking(Integer b) {
            this.looking = b;
        }


        public void setComplete(boolean b) {
            this.complete = b;
        }

        public Integer getLooking() {
            return looking;
        }

        public boolean isComplete() {
            return complete;
        }
    }


    public ElementNode<T> add(T data) {
        if (data.compareTo(this.object) < 0) {
            leftNode = (leftNode!=null) ? leftNode.add(data) : new ElementNode<T>(data);
        } else if (data.compareTo(this.object) > 0) {
            rightNode = (rightNode!=null) ? rightNode.add(data) : new ElementNode<T>(data);
        }
        return this;
    }

    public ElementNode<T> addLeft(T data) {
        this.leftNode = new ElementNode<>(data);
        return leftNode;
    }

    public ElementNode<T> addLeft(T data, ElementNode<T> parent) {
        this.leftNode = new ElementNode<>(data, parent);
        return leftNode;
    }

    public ElementNode<T> addLeft(T data, int num) {
        this.leftNode = new ElementNode<>(data, num);
        return leftNode;
    }

    public ElementNode<T> addRight(T data) {
        this.rightNode = new ElementNode<>(data);
        return rightNode;
    }

    public ElementNode<T> addRight(T data, ElementNode<T> parent) {
        this.rightNode = new ElementNode<>(data, parent);
        return rightNode;
    }

    public ElementNode<T> addRight(T data, int num) {
        this.rightNode = new ElementNode<>(data, num);
        return rightNode;
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

    public Integer lca(Integer a, Integer b, Ancestor lcA) {
        if (lcA.getLca() == null) {
            if (Integer.valueOf(this.object.toString()) == a){
                lcA.setLca(a);
                lcA.setLooking(b);
            } else if (Integer.valueOf(this.object.toString()) == b) {
                lcA.setLca(b);
                lcA.setLooking(a);
            }
        } else if (lcA.getLca() != null){
            if (lcA.getLooking() == Integer.valueOf(this.object.toString())) {
                lcA.setComplete(true);
                return lcA.getLca();
            }
        }


        if (this.leftNode!=null) {
            this.leftNode.lca(a,b,lcA);
        }

        if (lcA.isComplete()){
            return lcA.getLca();
        }


        if (lcA.getBeLca()) {
            lcA.setLca(Integer.valueOf(this.object.toString()));
            lcA.setBeLca(false);
        }
        
        if (this.rightNode!=null) {
            this.rightNode.lca(a,b,lcA);
        }

        if (lcA.isComplete()){
            return lcA.getLca();
        }

        if (Integer.valueOf(this.object.toString()) == lcA.getLca()) {
            lcA.setBeLca(true);
        }


        return null;
    }


    public Integer lcaWithParent(Integer a, Integer b, Ancestor lcA) {
        if (lcA.getLca() == null) {
            if (Integer.valueOf(this.object.toString()) == a){
                lcA.setLca(a);
                lcA.setLooking(b);
            } else if (Integer.valueOf(this.object.toString()) == b) {
                lcA.setLca(b);
                lcA.setLooking(a);
            }
        } else if (lcA.getLca() != null){
            if (lcA.getLooking() == Integer.valueOf(this.object.toString())) {
                lcA.setComplete(true);
                return lcA.getLca();
            }
        }


        if (this.leftNode!=null) {
            this.leftNode.lca(a,b,lcA);
        }

        if (lcA.isComplete()){
            return lcA.getLca();
        }


        if (lcA.getBeLca()) {
            System.out.println(this.object.toString());
            lcA.setLca(Integer.valueOf(this.object.toString()));
            lcA.setBeLca(false);
        }

        if (this.rightNode!=null) {
            this.rightNode.lca(a,b,lcA);
        }

        if (lcA.isComplete()){
            return lcA.getLca();
        }


        //Change this line to change lca to parent.
        if (Integer.valueOf(this.object.toString()) == lcA.getLca()) {
            lcA.setBeLca(true);
        }


        return null;
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


    public Integer sumRootToLeaf(Integer data) {

        var object = data * 0b10 + Integer.parseInt(this.object.toString(),2);
        Integer left = (this.leftNode != null) ? this.leftNode.sumRootToLeaf(object) : object;

        Integer right = (this.rightNode != null) ? this.rightNode.sumRootToLeaf(object) : 0b0;

        if (right == 0) {
            return left;
        }
        return left + right;
    }

    public boolean findRootWithSum(Integer data, Integer toCompare) {

        Integer object = data + Integer.parseInt(this.object.toString());
        if (toCompare.equals(object)) {
            return true;
        }
        boolean left = (this.leftNode != null) ? this.leftNode.findRootWithSum(object, toCompare) : false;
        if (left) {
            return true;
        }

        boolean right = (this.rightNode != null) ? this.rightNode.findRootWithSum(object, toCompare) : false;

        return right;

    }

    public String preOrderNoRec(ElementNode<Integer> root) {
        Deque<ElementNode<Integer>> stack = new LinkedList<>();
        stack.addFirst(root);
        StringBuilder ans = new StringBuilder();
        ans.append(root.object.toString()).append(" ");

        while (!stack.isEmpty()) {
            var left = stack.peek().leftNode;
            if (left!=null) {
                ans.append(left.object.toString()).append(" ");
                stack.addFirst(left);
                continue;
            }
            var right = stack.peek().rightNode;
            if (right!=null) {
                ans.append(right.object.toString()).append(" ");
                stack.removeFirst();
                stack.addFirst(right);
            } else {
                stack.removeFirst();

                if (stack.peek()!= null) {
                    stack.peek().leftNode = null;
                }
            }

        }

        return ans.toString();

    }

    public String inOrderNoRec(ElementNode<Integer> root) {
        Deque<ElementNode<Integer>> stack = new LinkedList<>();
        stack.addFirst(root);
        var builder = new StringBuilder();


        while (!stack.isEmpty()) {
            var left = stack.peek().leftNode;
            if (left != null) {
                stack.addFirst(left);
                continue;
            }

            var right = stack.peek().rightNode;
            if (right != null) {
                builder.append(stack.peek().object).append(" ");
                stack.removeFirst();
                stack.addFirst(right);
            } else {

                builder.append(stack.peek().object).append(" ");
                stack.removeFirst();

                if (stack.peek()!= null) {
                    stack.peek().leftNode = null;
                }
            }

        }

        return builder.toString();
    }

    public String kthNodeInorderTraversal(int nodeNum, int seen) {
        var numOfNodesInLeftSubtree = (this.rightNode!= null) ? (this.numOfNodes - (this.rightNode.numOfNodes+1)) : 0;
        if (nodeNum <= numOfNodesInLeftSubtree + seen) {
          var left =   (this.leftNode!=null) ? this.leftNode.kthNodeInorderTraversal(nodeNum, seen) : "";
          if (left.length()!= 0) {
              return left;
          }
        }else if (nodeNum == (numOfNodesInLeftSubtree + seen)+1) {
            return this.object.toString();
        }
        return (this.rightNode!= null) ? this.rightNode.kthNodeInorderTraversal(nodeNum, (numOfNodesInLeftSubtree+seen)+1) : "";
    }

    public String successor() {
        if (this.rightNode == null) {
            return backTrack();
        } else {
            return this.rightNode.preOrderShort();
        }
    }

    private String backTrack() {
        var parentNode = this.parent;
    if (parentNode != null) {
      if (parentNode.leftNode.object.toString().equals(this.object.toString())) {
        return parentNode.object.toString();
      } else {
        return parentNode.backTrack();
      }
        }
    return "";
    }

    private String preOrderShort() {
        return (this.leftNode != null) ? this.leftNode.preOrderShort() : this.object.toString();
    }

    public String inOrderWithParent() {
        ElementNode<T> left = (this.leftNode != null) ? this.leftNode : this.rightNode;
        StringBuilder ans = new StringBuilder();
        ElementNode<T> leftchild = left;
        ElementNode<T> rightchild = left;
    while (true) {
        if (left.leftNode != null && left.leftNode != leftchild) {
            left = left.leftNode;
            continue;
        }

        if (left.rightNode != rightchild) {
          ans.append(left.object.toString()).append(" "); // 28,271,0,6,561,17,3
        }

        if (left.rightNode != null && left.rightNode != rightchild) {
            left = left.rightNode;
        } else {
            if (left.parent == null) {
                break;
            }
            if (left.parent.rightNode == left) {
                rightchild = left;
                left = left.parent;

                leftchild = left.leftNode;
                continue;
            }
            leftchild = left;
            left = left.parent;

        }
        }
    return ans.toString();
    }

    public  ElementNode<T> treeFromTraversalData(List<T> preOrder, List<T> inorder) {
        var preOrderIndex = 0;
        ElementNode<T> root = new ElementNode<>(preOrder.get(preOrderIndex));
        preOrderIndex++;
        while (preOrderIndex < preOrder.size()) {
            root.helper(inorder,preOrder.get(preOrderIndex));
            preOrderIndex++;
        }
        return root;
    }

    public ElementNode<T> treeFromPreOrderData(List<T> preOrder) {
        ElementNode<T> root = new ElementNode<>(preOrder.get(0));
        root.buildPreOrderTree(1, preOrder);
        return root;
    }

    private int buildPreOrderTree(Integer i, List<T> preOrder) {
        if (i >= preOrder.size()) {
            return i;
        }
        var data = preOrder.get(i);
        if (data != null) {
            this.leftNode = new ElementNode<>(data);
            i++;
            i = this.leftNode.buildPreOrderTree(i, preOrder);
        }
        i++;

        data = preOrder.get(i);
        if (data != null) {
            this.rightNode = new ElementNode<>(data);
            i++;
            i = this.rightNode.buildPreOrderTree(i, preOrder);
        }
        return i;
    }


    private void helper(List<T> inorder, T preOrderObject) {
        String location = checkLocation(preOrderObject, inorder, this);

        if (location.equals("left")) {
            if (this.leftNode != null) {
                this.leftNode.helper(inorder,preOrderObject);
            } else {
                this.leftNode = new ElementNode<>(preOrderObject);
            }
        }

        else if (location.equals("right")) {
            if (this.rightNode != null) {
                this.rightNode.helper(inorder, preOrderObject);
            } else {
                this.rightNode = new ElementNode<>(preOrderObject);
            }
        }
    }

    private String checkLocation(T preOrderObject, List<T> inorder, ElementNode<T> tElementNode) {
        for (Object value : inorder ) {
            if (value.toString().equals(tElementNode.object.toString())) {
                return "right";
            } else if (value.toString().equals(preOrderObject.toString())) {
                return "left";
            }
        }

        return "";
    }

    public static void main(String[] args) {
//        var root = new ElementNode<Integer>(314,8);
//        var one = root.addLeft(6,4);
//        var two = root.addRight(6,2);
//        var three = one.addLeft(271,2);
//        var four = one.addRight(561,0);
//        var five = two.addLeft(2,0);
//        var six = two.addRight(0,0);
//        var seven = three.addLeft(28,0);
//        var eight = three.addRight(1,0);

        ElementNode<String> root = new ElementNode<String>("");
//        var one = root.addLeft(6,root);
//        var two = root.addRight(3,root);
//        var three = one.addLeft(271,one);
//        var four = one.addRight(561,one);
//        var five = two.addLeft(2,two);
//        var six = two.addRight(0,two);
//        var seven = three.addLeft(28,three);
//        var eight = three.addRight(1,three);
//        var nine = four.addRight(3, four);
//        var ten = nine.addLeft(17, nine);
//        System.out.println(root.inOrderWithParent());

        List<String> preOrder = new ArrayList<String>(
            Arrays.asList("A","B","C","D","E",null,null,"F",null,null,"G",null,null,"H","I",null,null,"J",null,null,"K","L","M",null,null,"N",null,null,"O",null,null)
        );

        List<String> inOrder = new ArrayList<String>(
            List.of("F","B","A","E","H","C","D","I","G")
        );

        System.out.println(root.treeFromPreOrderData(preOrder).preOrder());
    }
}
