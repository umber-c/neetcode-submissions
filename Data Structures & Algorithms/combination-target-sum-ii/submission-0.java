class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combs = new ArrayList<>();
        List<Integer> curComb = new ArrayList<>();

        helper(0, curComb, combs, nums, target, 0);

        return combs;
    }

    private void helper(
        int i,
        List<Integer> curComb,
        List<List<Integer>> combs,
        int[] nums,
        int target,
        int currSum
    ) {

        if (currSum == target) {
            combs.add(new ArrayList<>(curComb));
            return;
        }

        if (i >= nums.length) {
            return;
        }

        if (currSum > target) {
            return;
        }

        for (int j = i; j < nums.length; j++) {

            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            curComb.add(nums[j]);
            currSum += nums[j];

            helper(j+1, curComb, combs, nums, target, currSum);

            curComb.remove(curComb.size() - 1);
            currSum -= nums[j];
        }
    }
}