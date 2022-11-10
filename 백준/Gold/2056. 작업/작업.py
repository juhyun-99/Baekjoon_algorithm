import sys
from collections import deque
input = sys.stdin.readline
N = int(input())

arr = [0] * (N + 1)
time = [0] * (N + 1)
num = [[] for _ in range(N + 1)]

for i in range(1, N + 1):
    command = list(map(int, input().split()))
    time[i] = command[0]
    arr[i] = command[1]
    if arr[i] != 0:
        for j in command[2:]:
            num[j].append(i)

q = deque([])
dp = [0] * (N + 1)
for i in range(1, N + 1):
    if arr[i] == 0:
        q.append(i)
        dp[i] = time[i]

while q:
    v = q.popleft()
    for i in num[v]:
        arr[i] -= 1
        dp[i] = max(dp[i], dp[v] + time[i])
        if arr[i] == 0:
            q.append(i)
#print(dp)
print(max(dp))
