class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < goal.length; i ++){
            if(num1 < cards1.length && goal[i].equals(cards1[num1])){
                num1++;
                continue;
            }
            
            if(num2 < cards2.length && goal[i].equals(cards2[num2])){
                num2++;
                continue;
            }
            
            answer = "No";
            
        }
        return answer;
    }
}