import java.util.*;

class Solution {
    public long getMilSecByString(String time) {
        long val = 0;
        String[] split = time.split(":");
        val += (Long.parseLong(split[0]) * 60 * 60); // 시
        val += (Long.parseLong(split[1]) * 60); // 분
        val *= 1000;
        val += (Double.parseDouble(split[2]) * 1000); //(1초 = 1000밀리초)

        return val;
    }

    private static class Job {
        long startTime;
        long endTime;

        public Job(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int solution(String[] lines) {
        List<Job> jobList = new ArrayList<>();
        for (String line : lines) {
            String[] splits = line.split(" ");
            long end = getMilSecByString(splits[1]);
            long start = end - (long) (Double.parseDouble(splits[2].replace("s", "")) * 1000) + 1;

            Job job = new Job(start, end);
            jobList.add(job);
        }

        int ans = 1;
        for(int i = 0; i < jobList.size(); i++) {
            int cnt = 0;
            long end = jobList.get(i).endTime;
            for (Job job : jobList) {
                if(job.startTime < end + 1000 && job.endTime >= end) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}