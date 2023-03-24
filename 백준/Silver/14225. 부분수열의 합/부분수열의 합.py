import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
ans = []

def dfs(num, cnt):
    if cnt == n:
        return 0;
    num += arr[cnt]
    ans.append(num)
    dfs(num, cnt + 1)
    num -= arr[cnt]
    dfs(num, cnt + 1)

dfs(0,0)
a = set(ans)
for num in range(1, 2000000):
    if num not in a:
        print(num)
        break