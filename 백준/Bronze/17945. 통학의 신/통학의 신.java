import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //-1000~1000
        List<Integer> arr = new ArrayList<Integer>();
        int a =sc.nextInt(), b = sc.nextInt();
        for(int x = -1000; x <= 1000; x++){
            if(x*x + 2*x*a + b == 0){
                arr.add(x);
            }
        }
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++ ){
            System.out.printf("%d ",arr.get(i));
        }
    }
}