import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def recur(cur, prv):
    if cur == n:
        return 0

    if dp[cur][prv] != -1:
        return dp[cur][prv]

    ret = 100000000000000
    for i in range(3):
        if i == prv:
            continue
        ret = min(ret, recur(cur + 1, i) + arr[cur][i])
        dp[cur][prv] = ret

    return ret

n = int(input())
arr = [list(map(int,input().split())) for i in range(n)]
dp = [[-1] * 3 for _ in range(n)]

ans = 1e19
for i in range(3):
    ans = min(recur(0, i), ans)
print(ans)