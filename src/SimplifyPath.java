/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        Deque<String> dirs = new ArrayDeque<String>();
        for (String split: splits){
            if (!split.isEmpty()){
                if (split.equals("..")){
                    if (!dirs.isEmpty()) dirs.removeLast();
                }else if (split.equals(".")){
                    continue; //do nothing
                }else{
                    dirs.offerLast(split);
                }
            }
        }
        
        StringBuilder newPath = new StringBuilder();
        for (String s: dirs){
            newPath.append('/');
            newPath.append(s);
        }
        return newPath.length() == 0? "/": newPath.toString();
    }
}
