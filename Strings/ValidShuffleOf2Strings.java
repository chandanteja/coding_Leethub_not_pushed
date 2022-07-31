/*
    https://www.programiz.com/java-programming/examples/check-valid-shuffle-of-strings 
    question is little ambiguous

    version-1:
    
    2 strings are given. check if 3rd string is shuffle of s1 and s2. "ORDER DOESNT MATTER".
    then the approach is similar to anagram approach. it will be like this:
        1. check len of s1 + len of s2 
            if != len s3 then shuffle is not possible. result string has some extra chars then s1+s2. 
            else follow steps 2 to 5
                2. take a map.
                3. iterate through s1. store char in map and increment the count for each char in s1
                4. iterate through s2. store char in map and increment the count for each char in s2
                5. iterate through s3. decrement the count of each char in s3 in map.
                6. now iterate through map and see if the count of any string is not 0, or if some char of s3 is not present in map.
                    7. in either case its not a valid shuffle.
                    8. else it is a valid shuffle.
    
    
    version-2:

    here "ORDER MATTERS"

    so then the approach is:
    1. check if len(s1)+len(s2)!=len(result) ==> not shuffle.
    else
        2. i-pointer to s1, j-pointer to s2, k-pointer to result.
        3. as order is important here, we will iterate through each char in s1 and each char in s2 and compare with each char in res.
        4. if it matches with s1 char then inc i + inc k 
        5. if it matches with s2 char then inc j + inc k
        6. if it doesnt match with s1 char or s2 char, it means it has a char which is not in both s1 and s2
        7. so not a valid shuffle.

    https://www.youtube.com/watch?v=qN_vwYtvFUM     --> watch this video.
    
*/

package Strings;

public class ValidShuffleOf2Strings {

    
// int main()
// {
//     string s1="XY";
//     string s2="12";
//     string res="X1Y3";

//     int l1=s1.length(), l2=s2.length(), reslen=res.length();

//     if(l1+l2!=reslen) // res shud be a shuffle of s1 and s2 https://www.youtube.com/watch?v=qN_vwYtvFUM
//         cout<<"Not a valid shuffle\n";
    
//     else
//     {
//         int i=0, j=0, k=0; // i-> pointer to chars in s1. j->pointer to chars in s2. k->pointer to chars in res
//         // as order is important here, we will iterate through each char in s1 and each char in s2 and compare with
//         // each char in res.
//         // if it matches with s1 char then inc i + inc k 
//         // if it matches with s2 char then inc j + inc k
//         // if it doesnt match with s1 char or s2 char, it means it has a char which is not in both s1 and s2
//         // so not a valid shuffle.


//         while(k<reslen)
//         {
//             if(i<l1 && s1[i]==res[k]) // char of res matching with s1's char
//             {
//                 i++;
//                 k++;
//             }
//             else if(j<l2 && s2[j]==res[k])// char of res matching with s2's char
//             {
//                 j++;
//                 k++;
//             }
//             else // char of res not matching with s1 or s2's char
//             {
//                 break;  // then break.
//             }
//         }

//         if(i<l1 || j<l2) // when it breaks out of loop, i or j will not increment so it will be less than l1 or l2. means its not valid shuffle.
//             cout<<"Not valid shuffle\n";
//         else  // else its valid shuffle.
//             cout<<"Its a valid shuffle\n";
        
//         return (0);

//     }

// }
    
}
