import sys
input = sys.stdin.readline

def dfs(num):
    global ans
    if len(arr) == n:
        #print(*arr)
        cnt = 0
        for skill in skills:
            tf = True
            for sk in skill:
                if sk not in arr:
                    tf = False
            if tf:
                cnt += 1
        ans = max(cnt, ans)
        return

    for i in range(num, 2 * n + 1):
        arr.append(i)
        dfs(i + 1)
        arr.pop()

n, m, k = map(int,input().split())
skills = [list(map(int,input().split())) for _ in range(m)]
arr = []
ans = 0
dfs(1)

print(ans)