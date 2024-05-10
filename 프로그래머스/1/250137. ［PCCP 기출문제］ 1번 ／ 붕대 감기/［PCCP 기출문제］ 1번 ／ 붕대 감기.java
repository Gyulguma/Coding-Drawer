class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int second = 0;
        int success = 0;
        int hp = health;
        int time = 1;
        for(int i=0; i<attacks.length; i++){
            time = attacks[i][0] - second -1;
            //heal
            hp = hp + (time*bandage[1]) + ((time/bandage[0])*bandage[2]);
            if(hp >= health) hp = health;
            //attack
            hp -= attacks[i][1];
            second = attacks[i][0];
            time = second;
            if(hp <= 0) return -1;
        }
        if(hp <= 0) hp = -1;
        return hp;
    }
    
}