dp=[0]*(41)
dp[1]=dp[2]=1
for i in range(3,41):
    dp[i]=dp[i-1]+dp[i-2]
#pas
n=int(input())
print(dp[n],n-2)
#dp[n]은 재귀를 했을 때 실행 횟수
#n-2는 dp를 썼을 때 실행 횟수
