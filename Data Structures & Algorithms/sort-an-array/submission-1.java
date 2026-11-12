class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];

        mergeSort(nums, temp, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid + 1, right);

        // Merge the two sorted halves into temp.
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements from the left half.
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right half.
        while (j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy the sorted section back into nums.
        for (int index = left; index <= right; index++) {
            nums[index] = temp[index];
        }
    }
}