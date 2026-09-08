class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();

        helper(nums, currSubset, subset);
        return subset;
    }
    private void helper ( int[] nums,List<Integer>currSubset, List<List<Integer>> subset){

        //base condition

        if (currSubset.size() == nums.length){
            subset.add(new ArrayList<>(currSubset));
            return;
        }

        for (int j = 0; j < nums.length; j++){

            if (currSubset.contains(nums[j])){
                continue;
            }
            currSubset.add(nums[j]);
            helper(nums, currSubset, subset);
            currSubset.remove(currSubset.size() - 1);
        }
    }
}
