package binarySeachTrees;
/**
 * Created by Mayank on 7/5/16.
 */


class TNode {
    int data;
    TNode left;
    TNode right;

    public TNode(int item){
        data = item;
        left = null;
        right = null;
    }
}

class searchNinsert {

    public static TNode insert(TNode root, int item){

        if(root == null)
            return new TNode(item);

        if(item < root.data)
            root.left = insert(root.left, item);

        else if(item > root.data)
            root.right = insert(root.right, item);

        return root;
    }

    public static void printInorder(TNode root){

        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data +" ");
        printInorder(root.right);
    }

    public static boolean search(TNode root, int item){

        if(root == null)
            return false;

        if(root.data == item)
            return true;

        if(item < root.data)
            return search(root.left, item);

        else if(item > root.data)
            return search(root.right, item);

        return false;
    }

    public static void main(String args[]){

        TNode root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);
        printInorder(root);

        if(search(root, 20))
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}
