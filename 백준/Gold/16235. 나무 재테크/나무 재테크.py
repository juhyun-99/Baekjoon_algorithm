import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

n,m,k= map(int,input().split()) # m 나무 구매 k년 이후
a = [[5] * n for _ in range(n)]
arr = [list(map(int, input().split())) for _ in range(n)]
tree = [[deque([]) for _ in range(n)] for _ in range(n)]

for _ in range(m):
    x, y, age = map(int,input().split())
    tree[x - 1][y - 1].append(age)

ans = m
for year in range(k):

    for i in range(n):
        for j in range(n):
            if tree[i][j]:
                tmp = deque([])
                die = 0
                while tree[i][j]:
                    v = tree[i][j].popleft()
                    if a[i][j] >= v:  # 봄
                        tmp.append(v + 1)
                        a[i][j] -= v
                    else:
                        die += v//2
                        ans -= 1

                tree[i][j] = tmp
                a[i][j] += die #여름
    
    tmp = []
    for i in range(n):
        for j in range(n):
            for age in tree[i][j]:
                if age % 5 == 0:
                    for m in range(8):
                        nx = i + dx[m]
                        ny = j + dy[m]
                        if 0 <= nx < n and 0 <= ny < n:
                            tmp.append((nx,ny))
                            ans += 1

            a[i][j] += arr[i][j]

    for i in tmp:
        x, y = i
        tree[x][y].appendleft(1)

print(ans)