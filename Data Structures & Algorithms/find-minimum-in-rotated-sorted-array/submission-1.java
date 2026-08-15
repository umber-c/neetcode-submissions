class Solution {
    public int findMin(int[] nums) {

        int counter = nums[0];
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < counter){
                counter = nums[i];
            }

           
        }
        return counter;

       
    }
    
}
