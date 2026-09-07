class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int currSum;
        List<List<Integer>> combs = new ArrayList<>();
        List<Integer> curComb = new ArrayList<>();
        helper(0, curComb, combs, nums, target,0);
        return combs;
    }

    private void helper (int i, List<Integer> curComb, List<List<Integer>> combs, int[] nums, int target, int currSum){
        

        if (currSum == target){ //if the SUM = target so we gotta figure out that
            combs.add(new ArrayList<>(curComb));
            return;
        }

        if (i >= nums.length){
            return;
        }

        if (currSum > target){
            return;
        }

        for (int j = i; j < nums.length; j++){
            curComb.add(nums[j]);
            currSum += nums[j];
            helper(j, curComb, combs, nums, target,currSum);
            curComb.remove(curComb.size() - 1);
            currSum -= nums[j];
        }
    }

}
