import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) throws Exception {
        String answer = "";
        ArrayList<Music> foundMusicList = new ArrayList<>();
        m = replace(m);
        for(String musicinfo : musicinfos){
            String[] infos = musicinfo.split(",");
            Music music = new Music(infos[0], infos[1], infos[2], replace(infos[3]), m);
            //music.check();
            if(music.isfindCode(m)) foundMusicList.add(music);
        }
        Collections.sort(foundMusicList);
        if(foundMusicList.size() == 0) answer = "(None)";
        else answer = foundMusicList.get(0).title;
        return answer;
    }

    private String replace(String target){
        target = target.replace("C#", "c");
        target = target.replace("D#", "a");
        target = target.replace("F#", "f");
        target = target.replace("G#", "g");
        target = target.replace("A#", "a");
        target = target.replace("B#", "b");
        target = target.replace("E#", "e");
        return target;
    }
    public class Music implements Comparable<Music> {
        int startTime;
        int playTime;
        String title;
        String code;
        
        public Music(String start, String end, String title, String code, String m)  throws Exception {
            int[] startT = Arrays.stream(start.split(":")).mapToInt(Integer::parseInt).toArray();
            this.startTime = startT[0]*60 + startT[1];
            //if(end.equals("00:00")) end = "24:00";
            int[] endT = Arrays.stream(end.split(":")).mapToInt(Integer::parseInt).toArray();
            int endTime = endT[0]*60 + endT[1];
            this.playTime = endTime - this.startTime;
            //if(m.contains("E#") || m.contains("B#")) throw new Exception();
            this.title = title;
            for(int i=0; i<=this.playTime; i++){
                this.code += code.charAt(i%code.length())+"";
            }
            //this.code = (code.length() >= m.length()) ? code.repeat(2) : code.repeat((m.length()/code.length())+1);
        }
        
        public void check(){
            if(this.playTime <= 1) return;
            else if(this.code.length() >= this.playTime) this.code = this.code.substring(0, this.playTime-1);
        }
        
        public boolean isfindCode(String target){
            return code.contains(target);
        }
        
        @Override
        public int compareTo(Music music){
            if(this.playTime > music.playTime) return -1;
            else if(this.playTime < music.playTime) return 1;
            else {
                if(this.startTime < music.startTime) return -1;
                else if(this.startTime > music.startTime) return 1;
                else return 0;
            }
        }
    }
}