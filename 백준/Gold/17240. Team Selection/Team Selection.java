import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    int num;
    public int score;
    public Person(int num, int score){
        this.num = num;
        this.score = score;
    }


    @Override
    public int compareTo(Person o) {
        return o.score - this.score;
    }


    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                ", score=" + score +
                '}';
    }
}
public class Main {
    static int n;
    static Person[][] arr;
    static int[][] unSort;
    static Integer[] candi;
    static int[] sel;
    static boolean[] visit;
    static int ans = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); //후보자
        unSort = new int[n][5];
        arr = new Person[5][n];
        sel = new int[5];

        /*
        * n이 완탐 돌리기에는 너무 큼
        *
        * 각 역할마다 절대로 후보가 될 수 없는 사람은 몇 명이나 될까
        * 역할군별 상위 5명을 뽑고 거기서 완탐
        *
        * */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                unSort[i][j] = tmp;
                arr[j][i] = new Person(i, tmp);
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        //역할군 별로 점수 높은 순으로 정렬
        for (int i = 0; i < 5; i++) {
            Arrays.sort(arr[i]);
            for (int j = 0; j < 5; j++) {
                set.add(arr[i][j].num); // 상위 5명
            }
            //System.out.println(Arrays.toString(arr[i]));
        }

        candi = set.toArray(new Integer[set.size()]);
        //System.out.println(Arrays.toString(candi));
        visit = new boolean[candi.length]; //조합으로 풀면안됨

        recursive(0);
        System.out.println(ans);

    }

    private static void recursive(int cur) {
        if(cur == 5){
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += unSort[sel[i]][i];
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < candi.length; i++) {
            if(visit[i]) continue;
            sel[cur] = candi[i];
            visit[i] = true;
            recursive(cur + 1);
            visit[i] = false;
        }
    }

}
