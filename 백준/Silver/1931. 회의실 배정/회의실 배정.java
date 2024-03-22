import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Meeting{
	int start;
	int end;
	Meeting(int start , int end){
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]";
	}
	
}
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		List<Meeting> arr = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		arr.sort(Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart));

		int start = arr.get(0).start;
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
