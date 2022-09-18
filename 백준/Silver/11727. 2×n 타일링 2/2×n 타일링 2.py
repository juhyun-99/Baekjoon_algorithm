n = int(input())
dp = [0]*(n+3)
dp[1] = 1;dp[2] = 3
for i in range(3,n+1):
    dp[i] = dp[i-1] + 2*dp[i-2]

print(dp[n]%10007)
#참고 ; https://jaemin8852.tistory.com/158
