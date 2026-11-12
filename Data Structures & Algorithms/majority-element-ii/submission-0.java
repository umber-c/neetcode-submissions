class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;
        int condition = length / 3;
        int temp = 1;

        for (int i = 1; i <= length; i++){

            if (i == length || nums[i] != nums[i-1]) {
                
                if (temp > condition){
                    result.add(nums[i-1]);
                    temp = 1;
                }
                else {
                    temp = 1;
                }

            } else {
                temp++;
            }

        }

        return result;
    }
}