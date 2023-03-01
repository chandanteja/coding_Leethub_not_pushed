/**
 * 
 * Qns: https://leetcode.com/problems/n-th-tribonacci-number/description/
 * 
 * tn= tn-1+tn-2+tn-3
 * t=0
 * t1=1
 * t2=1
 */

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int res=0;
        if(n==0 || n==1)
            return n;
        else if(n==2)
            return 1;
    else {
        int a=0,b=1,c=1;
        for(int i=3;i<=n;i++) {
            res=c+b+a;
            a=b;
            b=c;
            c=res;
        }
    }
        return res;
    }
    
}
