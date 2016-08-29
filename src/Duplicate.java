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




/*
        int[] result = new int[list.size()];
        int i = 0 ;
        for (int s : list){
            result[i++]=s;
        }
        return result;*/

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

            if(first1 < first2)
            {
                result.add(first1);
                list1.remove(first1);
            }
            else if(first2 < first1)
            {
                result.add(first2);
                list2.remove(first2);
            }
            else // if first1 == first2 then default to first1
            {
                result.add(first1);
                list1.remove(first1);
            }
        }
        for (Integer i : list1) // add any remaining values from list1
            result.add(i);

        for (Integer i : list2) // add any remaining values from list2
            result.add(i);

        for (Integer i : result) // print the sorted list
            System.out.println(i);


    }



    public static void main(String[] args) {
        int[] myArray={1,-5,4,8,11};
        //System.out.println(usingMPS(myArray));
        Duplicate duplicate = new Duplicate();
        int[] num1= {1,4,5,7,7};
        int[] num2= {2,3,4,7,7};
        //duplicate.intersect(num1,num2);
        int[] array1 = {1,4,8,10,12,12,12};
        int[] arrar2 = {2,6,8,10,12};
        //duplicate.arrayUnion(array1,arrar2);
        int[] random = {1,4,5,6,7,8};
        //        duplicate.arrayUnion(array1,arrar2);
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(10);
        list.add(12);
        list.add(14);


        List<Integer> list2 = new LinkedList<>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(13);
        list.add(14);
        list.add(17);
        list.add(19);




        //duplicate.Merger(list,list2);
        duplicate.Merger(list,list2);
    }


}
