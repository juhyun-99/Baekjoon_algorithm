import java.util.*;
import java.io.*;


class Point implements Comparable<Point> {
    int x, y, idx;

    Point(int idx, int x, int y) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x != o.x) {
            return this.x - o.x;
        } else if (this.y != o.y) {
            return this.y - o.y;
        } else {
            return this.idx - o.idx;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", idx=" + idx +
                '}';
    }
}

public class Main {
    static Point[] arr, p;
    static boolean[] visit;
    static int n;
    static long ans = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        /*
         * n 범위가 크므로 굳이 고려하지 않아도 될 소는 고려하지 않아도 됨.
         *
         * */
        arr = new Point[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(i, x, y);
        }

        Arrays.sort(arr);

        TreeSet<Point> set = new TreeSet<>();
        for (int i = 0; i < Math.min(4, n); i++) {
            set.add(arr[i]);
            set.add(arr[n - 1 - i]);
        }
//        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, (p1, p2) -> p1.y - p2.y);
//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < Math.min(4, n); i++) {
            set.add(arr[i]);
            set.add(arr[n - 1 - i]);
        }
        p = set.toArray(new Point[set.size()]);
//        System.out.println(Arrays.toString(p));

        visit = new boolean[p.length];
        recursive(0, 0);
        System.out.println(ans);
    }

    private static void recursive(int cur, int start) {
        if(cur == 3){
            calc();//면적 계산
            return;
        }

        for (int i = start; i < p.length; i++) {
            visit[i] = true;
            recursive(cur + 1, i + 1);
            visit[i] = false;
        }
    }

    private static void calc() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < p.length; i++) {
            if(visit[i]) continue;
            minX = Math.min(minX, p[i].x);
            maxX = Math.max(maxX, p[i].x);
            minY = Math.min(minY, p[i].y);
            maxY = Math.max(maxY, p[i].y);
        }
        ans = Math.min(ans, (maxX - minX) * (maxY - minY));
    }
}
