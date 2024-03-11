#include <iostream>
#include <cstring>
using namespace std;
int w, h;
long ans;
int dx[] = {0, 0, 1};
int dy[] = {0, 1, 0};
long dp[101][101][3][2];
bool check(int nx, int ny){
    if(1 <= nx && nx <= w && 1 <= ny && ny <= h) return true;
    return false;
}

//백트
// void recursive(int x, int y, int d, int turn) {
//     //cout << x << " " << y << " " << turn<< endl;
//     if(x == w && y == h){
//         ans++;
//         return;
//     }

//     for (int i = 1; i <= 2; i++)
//     {
//         int dir = d;
//         int t = turn;
//         if(x == 1 && y == 1) dir = i;
//         int nx = x + dx[i];
//         int ny = y + dy[i];
//         if(!check(nx, ny)) continue;
//         if(dir != i){
//             if(turn == 1) continue;
//             t = 1;
//         }
//         else{
//             t = 0;
//         }
//         recursive(nx, ny, i, t);
//     }
// }

//함수 형태
// long recursive(int x, int y, int d, int turn) {
//     //cout << x << " " << y <<" " << d << " " << turn << endl;
//     if(x == w && y == h){
//         return 1;
//     }

//     long long ret = 0;
//     for (int i = 1; i <= 2; i++)
//     {
//         int dir = d;
//         int t = turn;
//         if(x == 1 && y == 1) dir = i;
//         int nx = x + dx[i];
//         int ny = y + dy[i];
//         if(!check(nx, ny)) continue;
//         if(dir != i){
//             if(turn == 1) continue;
//             t = 1;
//         }
//         else{
//             t = 0;
//         }
//         ret += recursive(nx, ny, i, t);
//     }
//     return ret;
// }


//메모
long long recursive(int x, int y, int d, int turn) {
    //cout << x << " " << y <<" " << d << " " << turn << endl;
    
    if(x == w && y == h){
        return 1;
    }

    if(dp[x][y][d][turn] != -1) return dp[x][y][d][turn];
    dp[x][y][d][turn] = 0;
    for (int i = 1; i <= 2; i++)
    {
        int dir = d;
        int t = turn;
        if(x == 1 && y == 1) dir = i;
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(!check(nx, ny)) continue;
        if(dir != i){
            if(turn == 1) continue;
            t = 1;
        }
        else{
            t = 0;
        }
        dp[x][y][d][turn] += recursive(nx, ny, i, t);
    }
    return dp[x][y][d][turn] % 100000;
}


int main()
{
    cin >> w >> h;
    memset(dp, -1, sizeof(dp));
    // recursive(1, 1, 0, 0); //x, y, 방향, 직전에 돌았는지 체크
    // cout << ans % 100000 ;
    //cout << ans;
    cout << recursive(1, 1, 0, 0); //x, y, 방향, 직전에 돌았는지 체크
}