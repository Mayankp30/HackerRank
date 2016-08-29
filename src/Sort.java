
/**
 * Created by Mayank on 7/3/16.
 */
public class Sort {

    public void Sorter(String word, String sortseq){

        char[] sortOrder=sortseq.toCharArray();
        char[] sortTarget=word.toCharArray();

        int head = 0;

        for (char c : sortOrder)
        {
            for(int i = head; i < sortTarget.length; i++)
            {
                if(sortTarget[i] == c)
                {
                    // swap i with head
                    char temp = sortTarget[head];
                    sortTarget[head] = sortTarget[i];
                    sortTarget[i] = temp;//

                    head++;
                }
            }
        }
        System.out.println(sortTarget);

    }

    public void sentenceRev(String word){
        String[] words = word.split(" ");
        StringBuilder revb = new StringBuilder();

        for(int i = words.length-1; i > -1 ; i--)
        {
            revb.append(words[i]);
            revb.append(" ");
        }
        System.out.println(revb.toString());
    }


    boolean pall(String s){


       String clean = s.replaceAll("[, ;  :]","").toLowerCase();
       char[] word=clean.toCharArray();
       //System.out.println(clean);
       //System.out.println(word.length);


       int front=0;
       int rear=clean.length()-1;
       while(front<rear){
           if(word[rear]!=word[front]){
               return false;
           }++front;
           --rear;
       }
       return  true;
   }

    boolean unique(String word){  // jaishyam
        int length=word.length();  // 8
        boolean[] setChar = new boolean[256];
        for (int i = 0;i<length;i++){  // val =
            int val = word.charAt(i);
            System.out.println(val);
            if(setChar[val]){
                return false;
            }setChar[val]=true;
        }
        return true;
    }


    public static void main(String[] args) {
        Sort e1= new Sort();
        //e1.Sorter("arda","da");
        //System.out.println(e1.pall("A man, a plan, a canal: Panama"));
        //e1.sentenceRev("pani da rang");
        //e1.unique("jaishyam");
        String hey = "zayn";


    }
}
