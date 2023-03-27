import sys
input = sys.stdin.readline

def dfs():
    global ans

    if len(arr) == n:
        #print(*arr)
        tmp = price[:]
        p = 0

        for i in arr:
            p += tmp[i]
            for ad in dic[i]:
                a, d = ad[0] - 1, ad[1]
                tmp[a] -= d
                if tmp[a] <= 0:
                    tmp[a] = 1
        ans = min(ans, p)
        return

    for i in range(n):
        if visit[i]:
            continue
        arr.append(i)
        visit[i] = True
        dfs()
        visit[i] = False
        arr.pop()


n = int(input())
price = list(map(int, input().split()))
dic = {}

for i in range(n):
    p = int(input())
    tmp = []
    for _ in range(p):
        tmp.append(list(map(int,input().split())))
    dic[i] = tmp

arr = []
ans = 1e19
visit = [False] * n
dfs()
print(ans)