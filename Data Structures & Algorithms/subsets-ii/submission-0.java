class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();

        helper(0, subsets, currSubset, nums);
        return subsets;
    }
    private void helper(int i, List<List<Integer>> subsets, List<Integer> currSubset, int[]nums){

        if (i >= nums.length){
            subsets.add(new ArrayList<>(currSubset));
            return;
        }

        currSubset.add(nums[i]);
        helper(i+1, subsets, currSubset, nums);
        currSubset.remove(currSubset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(i+1, subsets, currSubset, nums);

    }
}
