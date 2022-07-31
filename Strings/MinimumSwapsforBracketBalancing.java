package Strings;

public class MinimumSwapsforBracketBalancing {

    static int minimumNumberOfSwaps(String S){
       
        int open=0, close=0, imbalances=0, swaps=0;
        
        for(int i=0;i<S.length();i++)   // iterate through each character
        {
            if(S.charAt(i)=='[')    // when open brace is seen
            {
                open++;     // increment open counter.
                if(imbalances>0)        // if imbalances are more than 0
                {
                    swaps += imbalances;    // basically, all imbalances must be swapped 
                     // so add imbalances to swaps. 
                    imbalances--;       // and when u see an open brace u can match it with 1 imbalance i.e. 1 close brace.
                    // so imbalances will be decremented by 1.
                }
            }
            else     // when u see a close brace
            {
                close++;     // increment close count.
                
                imbalances=close-open;  // imbalance is when u see close brace without open brace.
                // so close-open will be imbalances.
            }
        }
        return swaps;
    }

    
}
