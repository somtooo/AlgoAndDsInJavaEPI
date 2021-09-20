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

    public ElementNode<T> addRight(T data) {
        this.rightNode = new ElementNode<>(data);
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


    public String sumRootToLeaf(String data) {
        var object = data +this.object.toString();
        String left = (this.leftNode != null) ? this.leftNode.sumRootToLeaf(object) : object;

        String right = (this.rightNode != null) ? this.rightNode.sumRootToLeaf(object) : "";

        if (right.length() == 0) {
            return left;
        }
        return left + " + " + right;
    }
    public static void main(String[] args) {
        var root = new ElementNode<Integer>(10);
        var one = root.addLeft(8);
        var two = root.addRight(20);
        var three = one.addLeft(6);
        var four = one.addRight(9);
        var five = two.addLeft(15);
        var six = two.addRight(25);
        var seven = three.addLeft(4);
        var eight = three.addRight(7);
        System.out.println(root.sumRootToLeaf(""));
    }
}
