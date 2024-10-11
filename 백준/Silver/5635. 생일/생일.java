import java.io.*;
import java.util.*;

class Person{
    String name;
    int year;
    int month;
    int day;
    public Person(String name, int year, int month, int day){
        this.name= name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Person(name, year, month, day));
        }

        Collections.sort(list, (s1, s2) -> {
            if(s1.year != s2.year){
                return s1.year - s2.year;
            }else{
                if(s1.month != s2.month){
                    return s1.month - s2.month;
                }else return s1.day - s2.day;
            }
        });
        System.out.println(list.get(list.size() - 1).name);
        System.out.println(list.get(0).name);
    }
}
