package binarySeachTrees;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Mayank on 6/18/16.
 */
class BinarySTree {

    /* Class containing left and right child of current node and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(int key){
        root = insertRecord(root, key);
    }

    public Node insertRecord(Node root, int key){

        if(root==null){
            root = new Node(key);
            return root;}

        if(key<root.key){
            root.left=insertRecord(root.left,key);
        }

        if(key>root.key){
            root.right=insertRecord(root.right,key);
        }

        return root;

    }

    public boolean search(Node root, int key){

        if(root == null)
            return false;

        if(root.key == key)
            return true;

        if(key < root.key)
            return search(root.left, key);

        else if(key > root.key)
            return search(root.right, key);

        return false;
    }

    public void delete(int key){
        root=deleteRec(root,key);
    }

    public Node deleteRec(Node root, int key){

        if(root == null){
            return root;
        }

        if (key<root.key){
            root.left=deleteRec(root.left,key);
        }

        else if (key>root.key){
            root.right=deleteRec(root.right,key);
        }

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)  or largest in the left subtree !!
            root.key = maxValue(root.left);

            // Delete the inorder successor
            root.left = deleteRec(root.left, root.key);
        }
        return root;

    }

    public int minValue(Node root){
        int minv;
        minv=root.key;
        while (root.left !=null){
            minv=root.left.key;
            root=root.left;
        }
        return minv;
    }

    public int maxValue(Node root){
        int maxv=root.key;
        while (root.right!=null){
            maxv=root.right.key;
            root=root.right;}
        return maxv;
        }
    




    void inorder()  {
        inorderRec(root);
    }


    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }


    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySTree tree = new BinarySTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();
        tree.delete(70);
        System.out.println(tree.search(tree.root,20));





    }
}