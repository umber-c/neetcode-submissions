

class Solution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> combs = new ArrayList<>();
        List<Integer> curComb = new ArrayList<>();

        helper(1, curComb, combs, n, k);

        return combs;
    }

    private void helper(
        int i,
        List<Integer> curComb,
        List<List<Integer>> combs,
        int n,
        int k
    ) {

        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            return;
        }

        if (i > n) {
            return;
        }

        for (int j = i; j <= n; j++) {

            curComb.add(j);

            helper(j + 1, curComb, combs, n, k);

            curComb.remove(curComb.size() - 1);
        }
    }
}