package binarySeachTrees;

/**
 * Created by Mayank on 7/7/16.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Scores {
    class BST {
        int key;
        int count;
        BST left;
        BST right;
        BST(int score) {
            key = score;
            count = 1;
        }
        public String toString(){
            return ""+key+":"+count;
        }
    }
    BST root;
    private BST add(int score, BST rt){
        if (rt == null) {
            return new BST(score);
        } else {
            if (rt.key == score) {
                rt.count++;
            } else if (rt.key < score) {
                rt.right = add(score, rt.right);
            } else {
                rt.left = add(score, rt.left);
            }
        }
        return rt;
    }

    public String getScores(){
        if (root == null) return "";
        StringBuilder ret = new StringBuilder();
        LinkedList<BST> queue = new LinkedList<BST>();
        queue.addLast(root);
        while (! queue.isEmpty() ) {
            BST node = queue.pollFirst();
            if (ret.length() > 0) {
                ret.append(",");
            }
            if (node != null) {
                ret.append(node.toString());
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        while (ret.charAt(ret.length()-1) ==',') {
            ret.deleteCharAt(ret.length()-1);
        }
        return ret.toString();
    }

    public void put(int score){
        root = add(score, root);
    }

    public static void main(String[] args) {
        Scores sol = new Scores();
        int[] input = {4, 2, 5, 5, 6, 1, 4};
        for (int i: input) {
            sol.put(i);
        }
        System.out.println(sol.getScores());
    }
}