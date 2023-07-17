import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("A+",4.3);
        map.put("A0",4.0);
        map.put("A-",3.7);
        map.put("B+",3.3);
        map.put("B0",3.0);
        map.put("B-",2.7);
        map.put("C+",2.3);
        map.put("C0",2.0);
        map.put("C-",1.7);
        map.put("D+",1.3);
        map.put("D0",1.0);
        map.put("D-",0.7);
        map.put("F",0.0);

        String s = sc.nextLine();
        System.out.println(map.get(s));
        
    }
}