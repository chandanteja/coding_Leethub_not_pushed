/**
 * Qns: https://leetcode.com/problems/divisor-game/description/
 * 
 * For any number n,
it can be either even -
In this case, to satisfy the problem condition n%x==0, we have 2 choices,
either choose 1 because N%1 will always be 0
or choose N/2 ( eg 4%2 is 0, 10%5 is 0, 24%12 is 0)

You may say 24 has many options for x like 3, 4, 6, 8, 12. So why are we only considering N/2 in our choice.
To be more clear : The idea is to choose the largest possible x. Because it will cause N = N - x. Now why are we choosing the largest x ? Because we want to reduce the sample space for our opponent as much as possible. Thus, limiting his choices for x. If i choose any other random x, we are just giving our opponent more space to choose his x, and that won't be optimal for us.

or it can be odd,
In this case, to satisfy the problem condition n%x==0, we have only 1 choice,
choose 1 because N%1 will always be 0,
there is no other possible choice, ( eg 5%4 is 1 , 5%3 is 2, 5%2 is 1 ). It will never be 0

Now with this in mind,
Lets say i want to win, so i want to make my opponent loose, i want to limit his choices, so i can predict his move.
In this case, if alice succeds in sending odd number to Bob, she can predict that he will choose 1,
and because he received odd and odd-1 == even. Alice will again receive even

so Alice plays optimally.
She limits her opponent's choices by sending him an odd number.
This send odd to opponent can only be ensured if she herself chooses 1 as x or any odd largest odd divisor of n if exists. i.e if n=18 then x=1,2,3,6,9. Now if alice chooses x=9 then n-x=9 and she can complete in optimal moves as well.
Because if she chooses N/2 there's a risk that opponent will receive even number. ( eg N = 12 (even), 12/2 = 6 ( even ) `

So Alice always choose 1 as x and this forces her opponent to always choose 1 as x.

base cases are 2 always wins and 1 always loses.
Its pretty clear that if alice gets hold of even, she will make sure she always gets even, eventually reaching 2.

However, if alice receives odd number as input, she has only 1 choice. choose 1 as x.
Then her opponent will receive the even number. Then he will play optimally ( as explained above ) and make sure he wins.

Discussion: https://leetcode.com/problems/divisor-game/discussion/

 */

public class DivisorGame {
    public boolean divisorGame(int n) {
        if(n==1)
            return false;
        else
            return findWinner(n,1);
    }

    boolean findWinner(int n, int turnAlice)
    {
        if( n%2==0 && turnAlice==1)
            return true;
        else 
            return false;
    }

}

/**
 * 
 * Approach is in bottomm-up fashion, we calculate all the possible values till 'n' and the winnings by the player who start the game.
 * 
 * Discussion:  https://leetcode.com/problems/divisor-game/solutions/274608/simple-dp-java-solution/
 *              https://leetcode.com/problems/divisor-game/solutions/275073/java-dp-solution/
 * 
 */
class DivisorGameDP {

    /**
     * dp[i] (dp-state) : this indicates the result of the game when n=i and for the player who started the game.
     * 
     * @param N
     * @return
     */
    /*
     * Ex:
     * Let n=6, i=2 & j=1
     * i%j= 2%1=0, i-j=2-1=1 => dp[i-j] = dp[1] we need to check and as dp[1] is always false for the player who starts with n=1, if we can handover this situation to opponent, he loses => the player wins if opponent loses.
     * So, if I lose at n=1 and if n=2, i can make move in such a way that i can give '1' to opponent then he loses => I win. i.e the player who starts the game wins.
     */
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = false;  // bcz who ever start with n=0, always loses
        dp[1] = false;  // who starts with n=1 loses bcz  0<x<(n=1), we can't choose x.
        for(int i=2; i <= N; i++){
            for(int j=1; j < i; j++){       // We can optimize the 'j<i' case with 'j<= Sqrt(i)' i.e we can check for the numbers till sqrt(i) and if there is a possibility of winning in that range, we can win for the rest of the range above sqrt(i).
                if((i % j == 0) && (dp[i-j] == false)) {
                        dp[i] = true;   // here we update dp[i] bcz even if there is atleast one possibility of me winning then i choose that situation and handover the losing case to opponent.
                        break;
                }
            }
        }
        return dp[N];
    }
}
