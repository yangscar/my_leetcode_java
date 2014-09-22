/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    private final String[] dict = new String[] { " ", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        char[] letters = new char[digits.length()];
        dfs(ans, digits, 0, letters);
        return ans;
    }
    private void dfs(List<String> ans, String digits, int index, char[] letters ){
        if (index == digits.length()){
            ans.add(new String(letters));
            return;
        }
        
        String numLetters = dict[digits.charAt(index)-'0'];
        for (int i=0; i<numLetters.length(); ++i){
            letters[index] = numLetters.charAt(i);
            dfs(ans, digits, index+1, letters);
        }
        
    }
}
