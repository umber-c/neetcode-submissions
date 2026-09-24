class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //sliding window 

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            for (int j = i+1; j < temperatures.length; j++){
                if (temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }
                else if (j == temperatures.length - 1){
                    result[i] = 0;
                    break;
                }

            }

        }
        return result;

        
    }
}
