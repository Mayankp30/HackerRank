package demoPack;

import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Mayank on 7/28/16.
 */

public class Duplicate {

    static int duplicate(int[] array){
        HashSet<Integer> originalSet = new HashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();
        for(int i=0;i<array.length;i++){
         if(!originalSet.contains(array[i])){
             originalSet.add(array[i]);
         }else{
             duplicateSet.add(array[i]);
         }} return duplicateSet.size();
    }

    static HashMap<Integer, Integer> oddOneOut(int[] array){
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int num: array){
            if(myMap.containsKey(num)){
                myMap.put(num,myMap.get(num)+1);
            }else{
                myMap.put(num,1);
            }
        }
        return myMap;

    }

    public void intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1); // 1 4 5 7 7
        Arrays.sort(nums2);  // 2 3 4 7 7

        if(nums1.length==0 && nums2.length==0){
            System.out.println("Invalid");
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        int p1=0, p2=0;

        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]<nums2[p2]){
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                p2++;
            }else{
                list.add(nums1[p1]);
                p1++;
                p2++;

            }
        }
        for(int num : list){
            System.out.print(" " + num + " - ");
        }


    }


    public void arrayUnion(int[] nums1, int[] nums2){
        Arrays.sort(nums1); // 1 4 8
        Arrays.sort(nums2); // 2 6 8

        if(nums1.length==0  || nums2.length==0){
            System.out.println("invalid input");
        }
        int c1=0;
        int c2=0;


        while(c1<nums1.length && c2<nums2.length){
            if(nums1[c1]<nums2[c2]){
                System.out.print(nums1[c1]);
                c1++;
            }else if(nums1[c1]>nums2[c2]){
                System.out.print(nums2[c2]);
                c2++;
            } else{
                System.out.print(nums1[c1]);
                c1++;
                c2++;
            }
        }

        while(c1<nums1.length){
            System.out.print(nums1[c1++]);
        }


        while(c2<nums2.length){
            System.out.print(nums2[c2++]);
        }

    }


    public void Merger(List<Integer> list1, List<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        LinkedList<Integer> result = new LinkedList<>();
        while (!list1.isEmpty() && !list2.isEmpty())
        {
            Integer first1 = list1.get(0);
            Integer first2 = list2.get(0);

            if(first1 <= first2)
            {
                result.add(first1);
                list1.remove(first1);
            }
            else if(first2 < first1)
            {
                result.add(first2);
                list2.remove(first2);
            }
        }
        for (Integer i : list1) // add any remaining values from list1
            result.add(i);

        for (Integer i : list2) // add any remaining values from list2
            result.add(i);

        for (Integer i : result) // print the sorted list
            System.out.println(i);


    }

    int Highest(int[] array){
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>highest){
                third=secondHighest;
                secondHighest=highest;
                highest=array[i];
            }else if(array[i]>secondHighest){
                third=secondHighest;
                secondHighest=array[i];

            }else if(array[i]>third){
                third=array[i];
            }
        }
        return third;

    }

    void indexOfHighest(int[] array){
        int largest = Integer.MIN_VALUE;
        int  sec = Integer.MIN_VALUE;
        int largestIndex=0;
        int index2=0;

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > largest) // 12 10 44 5
            {
                largest=array[i];
                largestIndex=i;
            }
        }
        System.out.println("high index : " + largestIndex);
    }


    int binarySearch(int[] array, int x){

        int low=0;
        int high=array.length-1;
        while (low<=high){

            int middle = (high+low)/2;

            if(array[middle]==x){
                return middle;
            }else if(x<array[middle]){
                high=middle-1;
            }else if(x>array[middle]){
                low=middle+1;
            }
        }return -1;
    }


    public static void main(String[] args) {
        int[] arr1 ={1,4,8};
        int[] arr2 ={2,6,8};
        Duplicate duplicate = new Duplicate();
        duplicate.arrayUnion(arr1,arr2);



    }


}
