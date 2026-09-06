class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();

        helper(0, nums, curSet, subsets);

        return subsets;
    }

    public void helper(int i, int[] nums, List<Integer> curSet,List<List<Integer>> subsets){

        if(i >= nums.length){
            subsets.add(new ArrayList<>(curSet));
            return;
        }

        curSet.add(nums[i]);
        helper(i+1,nums,curSet,subsets);

        curSet.remove(curSet.size() - 1);

        helper(i + 1, nums, curSet, subsets);
    }
}
