import sys; input=sys.stdin.readline
dp = [0]*491
dp[1] = 1; dp[2]=1
for i in range(3,491):
    dp[i] = dp[i-2]+dp[i-1]
while True:
    num = int(input())
    if num ==-1:
        break
    print(f"Hour {num}: {dp[num]} cow(s) affected")
  