import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
class Tree implements Comparable<Tree>{
    int height;
    int grow;

    public Tree(){}
    public Tree(int height, int grow){
        this.height = height;
        this.grow = grow;
    }

    @Override
    public int compareTo(Tree o) {
        return this.grow - o.grow;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                ", grow=" + grow +
                '}';
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Tree[] arr = new Tree[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Tree();
            arr[i].height = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i].grow = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[i].height + arr[i].grow * i;
        }
        
        System.out.println(ans);
    }
}
