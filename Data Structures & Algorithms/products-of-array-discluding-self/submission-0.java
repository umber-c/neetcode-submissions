class Solution {
    public int[] productExceptSelf(int[] nums) {

        int prod = 1;
        int zeros = 0;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++; 
            } else {
                prod *= nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 1) {
                result[i] = 0; 
            } else if (zeros == 1) {
                if (nums[i] == 0) {
                    result[i] = prod; 
                } else {
                    result[i] = 0;    
                }
            } else {
                result[i] = prod / nums[i]; 
        }
       
    }
    return result;
}

}
