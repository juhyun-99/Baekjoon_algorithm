import sys
from collections import deque
input = sys.stdin.readline

n, m= map(int, input().split())
arr = [[] for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

def bfs(start):
    visit = [0 for _ in range(n + 1)]
    visit[start] = 1
    num = [0 for _ in range(n + 1)]
    q = deque()
    q.append(start)
    while q:
        tmp = q.popleft()
        for i in arr[tmp]:
            if visit[i] == 0:
                visit[i] = 1
                num[i] = num[tmp] + 1
                q.append(i)
    return sum(num)

ans = []
for i in range(1, n + 1):
    ans.append(bfs(i))

print(ans.index(min(ans)) + 1)