class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++){
            int cnt = 0;
            for(int j = 0; j < photo[i].length; j++){
                for(int k = 0; k < name.length; k ++){
                    if(photo[i][j].equals(name[k])){
                        cnt += yearning[k];
                        break;
                    }
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}