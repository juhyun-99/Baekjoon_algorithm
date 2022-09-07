import sys
input = sys.stdin.readline

N,K = map(int,input().split())
coins = []
for _ in range(N):
      coin = int(input())
      if coin <= K:
          coins.append(coin)

ans = 0
for i in range(len(coins)-1,-1,-1):
    if K == 0:
        break
    if K//coins[i] != 0:
        ans += K//coins[i]
        K = K%coins[i]
print(ans)
  