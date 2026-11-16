class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < position.length; i++){
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        int fleet = 0;
        double maxTime = 0;

        for (int i = position.length - 1; i >=0; i--){
            int velocity = map.get(position[i]);

            double time = (double) (target - position[i]) / velocity;

            if(time > maxTime){
                fleet++;
                maxTime = time;
            }
        }
        return fleet;
        
    }
}
