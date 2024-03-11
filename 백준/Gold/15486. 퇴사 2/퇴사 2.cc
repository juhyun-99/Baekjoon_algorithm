#include <iostream>
#include <cstring>
using namespace std;
int n, ans;
int arr[1500001][2];
int dp[1500001];

int recursive(int cur) {
    if(cur > n) {
        return -999999;
    }

    if(cur == n) {
        return 0;
    }

    if (dp[cur] != -1) return dp[cur];

    dp[cur] = max(recursive(cur + arr[cur][0]) + arr[cur][1], recursive(cur + 1));
    return dp[cur];
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i][0] >> arr[i][1];
    }
    
    memset(dp, -1, sizeof(dp));
    cout << recursive(0);
}