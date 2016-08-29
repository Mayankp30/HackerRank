import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Mayank on 7/6/16.
 */
/*
 * Complete the function below.
 */


public class Solution {

    static String gatherScores(int[] scores) {
        Map<Integer,Integer> myMap = new HashMap<>();
        Double maxValue = Math.pow(2,scores.length);
        int[] myTree = new int[maxValue.intValue()];
        boolean initial;
        initial=true;
        for(int s: scores){
        if(myMap.containsKey(s)){
        int value = myMap.get(s);
        myMap.put(s,++value);
        }
        else{
        if(initial){
        myTree[0]=s;
        myMap.put(s,1);
        initial=false;
        }
        else{
        insertScoreInTree(s,myTree,0,scores.length);
        myMap.put(s,1);
        }
        }

        }
        return buildStream(myTree,myMap);

        }

private static String buildStream(int[] myTree, Map<Integer,Integer> myMap){
        StringBuilder sb = new StringBuilder();

        for(int node: myTree){
            if(node>0){
                sb.append(node).append(":").append(myMap.get(node)).append(",");
            }else{
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
}

private static void insertScoreInTree(int freq,int[] tree, int start, int end) {
    if (tree[start] > 0) {
        if (tree[start] > freq) {
            insertScoreInTree(freq, tree, 2 * start + 1, end);
        } else {
            insertScoreInTree(freq, tree, 2 * start + 2, end);
        }
    } else {
        tree[start] = freq;
    }

}

    public static void main(String[] args) throws IOException{
        String res;

        int[] arr={4, 2, 5, 5, 6, 1, 4};
        res = gatherScores(arr);
        System.out.println(res);
    }
}


