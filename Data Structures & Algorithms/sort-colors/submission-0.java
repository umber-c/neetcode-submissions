class Solution {
    public void sortColors(int[] nums) {

        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            } else {
                continue;
            }

        }
        
          for(int j = k; j < nums.length; j++) {
           
            if (nums[j] == 1){
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k++;
            } else {
                continue;
            }

        }
    }
}