#include <iostream>
#include <cstring>
using namespace std;
int n, ans;
int dp[1001][3][2][2];
 
//백트
// void recursive(int cur, int cnt, int two, bool tf){
//     if(cnt > 2 || two >= 2) return;
    
//     if(cur == n){
//         if(tf) ans++;
//         return;
//     }

//     recursive(cur + 1, 0, 0, tf); //설치안함
//     recursive(cur + 1, cnt + 1, 0, tf); //1짜리 설치
//     recursive(cur + 1, cnt + 1, two + 1, true); //2짜리 설치 : 총갯수 늘리고, 2개짜리 늘리고, true
// }

//함수형태
// int recursive(int cur, int cnt, int two, bool tf){
//     if(cnt > 2 || two >= 2) return 0;
    
//     if(cur == n){
//         if(tf) return 1;
//         else return 0;
//     }

//     return recursive(cur + 1, 0, 0, tf) + recursive(cur + 1, cnt + 1, 0, tf)
//      + recursive(cur + 1, cnt + 1, two + 1, true); //2짜리 설치 : 총갯수 늘리고, 2개짜리 늘리고, true
// }

//메모이제이션 추가
long recursive(int cur, int cnt, int two, int tf){
    if(cnt > 2 || two >= 2) return 0;
    
    if(dp[cur][cnt][two][tf] != -1) return dp[cur][cnt][two][tf];

    if(cur == n){
        if(tf) return 1;
        else return 0;
    }

    dp[cur][cnt][two][tf] = (int) ((recursive(cur + 1, 0, 0, tf) + recursive(cur + 1, cnt + 1, 0, tf)
     + recursive(cur + 1, cnt + 1, two + 1, 1)) % 1000000007); //2짜리 설치 : 총갯수 늘리고, 2개짜리 늘리고, true

    return dp[cur][cnt][two][tf];
}

int main()
{
    cin >> n;
    ans = 0;
    memset(dp, -1, sizeof(dp));
    cout << recursive(1, 0, 0, 0); //지점, 연속 총 갯수, 2개짜리 갯수, 2가 있는지 없는지
}