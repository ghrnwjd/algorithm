import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            rankMap.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            String player = callings[i];
            int rank = rankMap.get(player);
            
            String prePlayer = players[rank-1];
            
            players[rank-1] = player; 
            players[rank] = prePlayer;
            
            rankMap.put(player, rank-1);
            rankMap.put(prePlayer, rank);
        }           
        return players;
              
    }
}
