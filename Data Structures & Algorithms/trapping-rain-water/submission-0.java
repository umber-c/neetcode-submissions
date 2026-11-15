class Solution {
    public int trap(int[] height) {

        int leftMax = -1;
        int rightMax = -1; 
        int finalArea = 0;

        for (int i = 0; i < height.length; i++){
            if (height[i] > 0 && leftMax == -1){
                leftMax = i;
                continue;
            }

            if (leftMax == -1){
                continue;
            }

            if(height[i] >= height[leftMax]){
                rightMax = i;

                finalArea += area(height, leftMax, rightMax);

                leftMax = rightMax;
            }

            if (leftMax == -1){
                return 0;
            }

        }

        int reverseRight = height.length; 
        int reverseLeft = -1;

        for (int i = height.length - 1; i >= 0; i--){

            if (height[i] > 0 && reverseRight == height.length){
                reverseRight = i;
                continue;
            }

              if (reverseRight == height.length) {
                continue;
            }

            if (height[i] > height[reverseRight]){
                reverseLeft = i;

                finalArea += area(height, reverseLeft, reverseRight);

                reverseRight = reverseLeft;
            }
        }
        return finalArea;
        
    }
    public int area(int[]height, int leftMax, int rightMax){

        int waterlevel = Math.min(height[leftMax], height[rightMax]);
        int width = rightMax - leftMax - 1;
        int count = 0;

        for (int i = leftMax + 1; i < rightMax; i++){
            if (height[i]>0){
                count += height[i];
            }
        }

        int finalArea = waterlevel * width - count;
        return finalArea;

    }
}
