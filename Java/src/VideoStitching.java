import java.util.Arrays;

public class VideoStitching{

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            else{
                return a[1]-b[1];
            }
        });

        int res = 0;
        int end = 0;
        for(int i = 0; i < clips.length; i++){
            int max = -1;
            int j = i;
            for(; j < clips.length; j++){
                if(clips[j][0] <= end) max = Math.max(max, clips[j][1]);
                else break;
            }
            if(max == -1) return -1;
            i = j-1;
            end = max;
            res++;
            if(end >= T) break;
        }
        if(end < T) return -1;
        return res;
    }

    public static void main(String[] args) {
        int[][] clips = {{0,4}, {2, 8}};
        VideoStitching test = new VideoStitching();
        System.out.println(test.videoStitching(clips, 5));
    }

}