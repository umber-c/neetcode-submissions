class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> comb = new ArrayList<>();
        StringBuilder currcomb = new StringBuilder();

        helper(n, comb, currcomb, 0, 0);
        return comb;
    }

    private void helper(int n,List<String> comb, StringBuilder currcomb, int opencount, int closecount) {

        if (opencount == n && closecount == n){
            comb.add(currcomb.toString());
            return;
        }

        if (opencount < n){
            currcomb.append("(");
            helper(n, comb, currcomb, opencount+1, closecount);
            currcomb.deleteCharAt(currcomb.length() - 1);
        }

        if (opencount > closecount){
            currcomb.append(")");
            helper(n, comb, currcomb, opencount, closecount+1);
            currcomb.deleteCharAt(currcomb.length() - 1);
        }

        


    }
}
