/**
 * 
 * https://leetcode.com/problems/subtree-of-another-tree/   --> qns
 * 
 * https://leetcode.com/problems/subtree-of-another-tree/discuss/1339706/Real-linear-time-and-space-solution          --> SOlution in O(n).
 * 
 * https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/  --> refer this for naive soln. This is O(mn) solution where 
 * 
 *  m -- #of nodes in tree1
 *  n -- #of nodes in tree2
 * 
 * Another logic is first serialize both given trees into strings.
 * While  serializing, do preorder traversal.
 * 
 * After that append both strings into one string and do KMP search on that same algo.
 * Infact apply longest prefix which is also suffix concept on appended string and fill array.
 * 
 * Now after doing that check if lps[i] = length of pattern(subtree). If there is lps[i]=length of pattern return true
 * else false;
 * 
 * T.C: O(n)
 * S.C: O(n)
 * 
 */

package Amazonlist;

public class OneTreeIsSubtreeOfOther {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder preRoot = new StringBuilder();
        StringBuilder preSubRoot = new StringBuilder();
        preOrder(root,preRoot);
        preOrder(subRoot,preSubRoot);
        // converting string builder to string
        // text is larger tree
        // pattern is subtree.
        String text = preRoot.toString();
        String pattern = preSubRoot.toString();
        return kmp(text,pattern);
    }
    private void preOrder(TreeNode node , StringBuilder sb){
        if(node==null){
          sb.append(",!");
          return;
        }
        sb.append(","+node.val);
        preOrder(node.left,sb);
        preOrder(node.right,sb);
    }
    private boolean kmp(String text , String pattern){


        StringBuilder sb = new StringBuilder();

        // converting string back to stringbuilder.
        for(char ch : pattern.toCharArray()) sb.append(ch);
        // appending a delimiter b/w text and pattern strings
        sb.append("#");
        // we append text and pattern to same string.
        for(char ch : text.toCharArray()) sb.append(ch);
        String str = sb.toString();     // convert stringbuilder to string
        // find lps[]

        int lps[] = new int[str.length()];
        lps[0] = 0;
        int i = 1 , len = 0;
        while(i<str.length()){
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len>0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // after finding lps, check if lps[i] = length of pattern, if found return true
        // else false.
        for(i=0;i<lps.length;i++){
            if(lps[i]==pattern.length()) return true;
        }
        return false;
    }
    
}
