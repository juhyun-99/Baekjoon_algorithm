import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                points.add(new int[]{list.get(i)[0], list.get(j)[1]});
            }
        }

        List<List<Integer>> distance = new ArrayList<>();

        for (int j = 0; j < points.size(); j++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(Math.abs(points.get(j)[0] - list.get(i)[0]) + Math.abs(points.get(j)[1] - list.get(i)[1]));
            }
            Collections.sort(tmp);
            distance.add(tmp);
        }
        sb.append("0 ");

        for (int i = 2; i <= n ; i++) {
            int ans = Integer.MAX_VALUE;
            for (List<Integer> tmp: distance) {
                int sum = 0;
                for (int j = 0; j < i; j++) {
                    sum += tmp.get(j);
                }
                ans = Math.min(ans, sum);
            }
            sb.append(ans + " ");
        }
        System.out.println(sb);

    }
}
