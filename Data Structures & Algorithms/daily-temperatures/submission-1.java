class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> room = new Stack<>();

        for (int i = 0; i < n; i++){
            int temp = temperatures[i];

            while (!room.isEmpty()){
                int j = room.peek();
                int k = temperatures[j];

                if (temp > k){
                    room.pop();
                    result[j] = i - j;
                }else {
                    break;
                }
            }
            room.push(i);
        }

        return result;
        
    }
}
