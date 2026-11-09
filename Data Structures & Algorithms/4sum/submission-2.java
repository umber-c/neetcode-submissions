class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> answer = new ArrayList<>();

        //answer.add(List.of(nums[i], nums[j], nums[left], nums[right]));
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]){ //did i just do this val or no?
                continue;
            }
            for (int j = nums.length-1; j > i; j--){
                if (j < nums.length - 1 && nums[j] == nums[j+1]){
                    continue;
                }

                int left = i + 1;
                int right = j - 1;
                long remainingTarget = (long) target - nums[i] - nums[j];

                while (left < right){
                    long sum = (long) nums[left] + nums[right];

                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                    } else if (right < j - 1 && nums[right] == nums[right + 1]) {
                        right--;
                    } else if (sum < remainingTarget) {
                        left++;
                    } else if (sum > remainingTarget) {
                        right--;
                    } else {
                        answer.add(List.of(nums[i], nums[left], nums[right], nums[j]));
                        left++;
                        right--;
                    }

                }

            }
        }
        return answer;
    
    }
}