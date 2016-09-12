

/**
 * Created by Mayank on 9/6/16.
 */
public class TestDemo {

    int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
    }


    void zerosInEnd(int[] arr){
        int count = 0;  // Count of non-zero elements


        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // here count is incremented
            }




        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < arr.length)
            arr[count++] = 0;
    }


    public boolean isPrime(int n){
        if(n%2==0){
            return false;
        }
        int temp;
        for(int i=2;i<n/2;i++){
            System.out.println(i);
            temp=n%i;
            if(temp==0){
               return false;
            }
        } return true;
    }




    public static void main(String[] args) {
        TestDemo t1 = new TestDemo();
        int arr[] = {1, 2, 3};
        int length=arr.length;
        System.out.println(t1.count(arr,length,4));

        int[] array= {1,0,9,0,5,7,10,0,12,0,0,-29};
        for (int i:
             array) {
            System.out.print(i + " ");

        }
        t1.zerosInEnd(array);
        System.out.println("After pushing Zeros in end \n");
        for (int i:
                array) {
            System.out.print(i + " ");

        }
        System.out.println(t1.isPrime(21));


    }
}
