class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){

            int j = i + 1;
            int k = nums.length-1;

            while (j < k){

                if(nums[j] + nums[k] == -nums[i]){
                    //return answer
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (nums[j] + nums[k] > -nums[i]){
                    k--;
                }
                else {  
                    j++;
                }
            }

        }

        return new ArrayList<>(result);
    }
}
