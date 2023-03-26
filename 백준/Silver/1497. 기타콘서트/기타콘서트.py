import sys
input = sys.stdin.readline

def dfs(num):
    global ans
    global cnt

    if len(arr) > 0:
        #print(*arr)
        can = [0] * m
        for i in range(len(arr)):
            for j in range(m):
                if guitar[arr[i]][j] == 'Y':
                    can[j] = 1

        if sum(can) > cnt and sum(can) != 0:
            ans = len(arr)
            cnt = sum(can)

        elif sum(can) == cnt:
            ans = min(ans, len(arr))

        if arr[-1] == garr[n - 1]:
            return

    for i in range(num, n):
        arr.append(garr[i])
        dfs(i + 1)
        arr.pop()

n, m = map(int,input().split())
garr = []
guitar = {}

ans = 1e19
cnt = -1
for _ in range(n):
    g, c = input().rstrip().split()
    garr.append(g)
    guitar[g] = c
arr = []
dfs(0)

if ans == 1e19:
    print(-1)
else:
    print(ans)