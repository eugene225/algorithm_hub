class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertToSeconds(play_time);
        int advTime = convertToSeconds(adv_time);

        int[] timeLine = new int[playTime + 1];
        for (String log : logs) {
            String[] times = log.split("-");
            int start = convertToSeconds(times[0]);
            int end = convertToSeconds(times[1]);
            timeLine[start]++;
            if (end < playTime) timeLine[end]--;
        }

        for (int i = 1; i <= playTime; i++) {
            timeLine[i] += timeLine[i - 1];
        }

        long[] cumulativeViewers = new long[playTime + 1];
        for (int i = 1; i <= playTime; i++) {
            cumulativeViewers[i] = cumulativeViewers[i - 1] + timeLine[i];
        }

        long maxViewers = cumulativeViewers[advTime-1];
        int maxStartTime = 0;
        for (int start = 1; start + advTime <= playTime; start++) {
            long viewers = cumulativeViewers[start + advTime - 1] - cumulativeViewers[start - 1];
            if (viewers > maxViewers) {
                maxViewers = viewers;
                maxStartTime = start;
            }
        }

        return convertToTimeFormat(maxStartTime);
    }

    private int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    private String convertToTimeFormat(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
