class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            int check = nums[i];
            if (seen.contains(check)){
                return true;
            }

            seen.add(check);
        }
        return false;

        

    }
}