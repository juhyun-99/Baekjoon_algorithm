import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(map.containsKey(x)){
                map.get(x).add(y);
            }else{
                map.put(x, new ArrayList<>());
                map.get(x).add(y);
            }
        }
        int ans = 0;
        for (Integer x: map.keySet()) {
            List<Integer> list = map.get(x);
            for (int i = 0; i < list.size(); i++) {
                int y = list.get(i);
                if(list.contains(y + b) && map.containsKey(x + a) && map.get(x + a).contains(y) && map.get(x + a).contains(y + b)){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
