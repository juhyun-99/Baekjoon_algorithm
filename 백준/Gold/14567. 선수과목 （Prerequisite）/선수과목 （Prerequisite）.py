import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().split())

arr = [[] for _ in range(N + 1)]
num = [0] * (N + 1)
ans = [0] * (N + 1)
for _ in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)
    num[b] += 1

q = deque()
for i in range(1, N + 1):
    if num[i] == 0: #진입차수 0인 i 넣어주기
        q.append(i)
        ans[i] = 1

while q:
    v = q.popleft()
    for i in arr[v]:
        num[i] -= 1
        if num[i] == 0:
            q.append(i)
            ans[i] = ans[v] + 1

print(*ans[1:])

