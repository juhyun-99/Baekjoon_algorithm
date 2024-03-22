import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    Meeting(int start , int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end != o.end){
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Meeting> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(arr);

        int end = arr.get(0).end;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int tmpStart = arr.get(i).start;
            int tmpEnd = arr.get(i).end;

            if(tmpStart >= end) {
                cnt++;
                end = tmpEnd;
            }
        }

        System.out.println(cnt);
    }
}
