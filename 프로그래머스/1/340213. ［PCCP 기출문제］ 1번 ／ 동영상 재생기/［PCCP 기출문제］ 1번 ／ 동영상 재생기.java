import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] total = video_len.split(":");
        String[] now = pos.split(":");
        String[] start = op_start.split(":");
        String[] end = op_end.split(":");
        
        int[] totalInt = Arrays.stream(total).mapToInt(Integer::parseInt).toArray();
        int[] nowInt = Arrays.stream(now).mapToInt(Integer::parseInt).toArray();
        int[] startInt = Arrays.stream(start).mapToInt(Integer::parseInt).toArray();
        int[] endInt = Arrays.stream(end).mapToInt(Integer::parseInt).toArray();
        
        int totalSec = totalInt[0] * 60 + totalInt[1];
        int nowSec = nowInt[0] * 60 + nowInt[1];
        int startSec = startInt[0] * 60 + startInt[1];
        int endSec = endInt[0] * 60 + endInt[1];
        
        if (nowSec < 10) {
            nowSec = 0;
        }
        
        if(startSec <= nowSec && nowSec <= endSec) {
            nowSec = endSec;
        }

        if (nowSec > totalSec - 10) {
            nowSec = totalSec;
        }
        
        for(String cmd : commands) {
            switch (cmd) {
                case "next":
                    nowSec += 10;
                    break;
                case "prev":
                    nowSec -= 10;
                    break;
            }
            
            if (nowSec < 10) {
                nowSec = 0;
            }
            
            if(startSec <= nowSec && nowSec < endSec) {
                nowSec = endSec;
            }

            if (nowSec > totalSec) {
                nowSec = totalSec;
            }

            if (nowSec > totalSec - 10) {
                nowSec = totalSec;
            }
        }
        
        int[] ans = new int[]{nowSec / 60, nowSec % 60};
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", ans[0])).append(":").append(String.format("%02d", ans[1]));
        
        return sb.toString();
    }
}
