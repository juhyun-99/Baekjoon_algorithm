import sys
input = sys.stdin.readline

N = int(input())
arr = [int(input()) for _ in range(N)]
arr.sort()
rank = [i for i in range(1,N+1)]
ans = 0
for i in range(N):
    ans += abs(rank[i]-arr[i])

print(ans)