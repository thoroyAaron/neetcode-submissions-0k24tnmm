class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left_speed = 1;
        int right_speed = Arrays.stream(piles).max().getAsInt();
        int middle_speed = 0;

        while(left_speed <= right_speed){
            middle_speed = (left_speed + right_speed) / 2;
            int time = calculate_speed(piles, middle_speed);
            if(time > h){
                left_speed = middle_speed + 1;
            }else{
                right_speed = middle_speed - 1;
            }
        }
        return left_speed;
    }

    private int calculate_speed(int[] piles, int speed){
        int time = 0;
        for(int i : piles){
            time = time + (int) Math.ceil((double)i / speed);
        }
        return time;
    }
}
