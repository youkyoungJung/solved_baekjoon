import java.util.*;

class Solution {
    
    public static class Music{
        int idx;
        int play;
        
        public Music(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            map.put(key, map.getOrDefault(key, 0) + plays[i]);
        }
        
        ArrayList<String> mapToGenres = new ArrayList<>();
        for(String item : map.keySet()){
            mapToGenres.add(item);
        }
        mapToGenres.sort(((o1, o2) -> map.get(o2) - map.get(o1)));
        
        
        for(String item : mapToGenres){
            ArrayList<Music> musics = new ArrayList<Music>();
            for(int i = 0; i < genres.length; i++){
                if(item.equals(genres[i])){
                    musics.add(new Music(i, plays[i]));
                }
            }
            
            musics.sort(((o1, o2) -> {
                if(o1.play == o2.play){
                    return o1.idx - o2.idx;
                }
                return o2.play - o1.play; 
            }));
            
            answer.add(musics.get(0).idx);
            if(musics.size() != 1){
                answer.add(musics.get(1).idx);
            }
        }
        
        return answer.stream().mapToInt(m->m).toArray();
    }
}