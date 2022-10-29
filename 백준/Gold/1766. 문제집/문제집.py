import sys
from queue import PriorityQueue
input = sys.stdin.readline

N, M = map(int, input().split())

arr = [[] for _ in range(N + 1)]
num = [0] * (N + 1)
visit = [0] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    arr[a].append(b)
    num[b] += 1

q = PriorityQueue()

for i in range(1, N + 1):
    if num[i] == 0:
        q.put(i)

while not q.empty():
    v = q.get()
    print(v, end=' ')
    for j in arr[v]:
        num[j] -= 1
        if num[j] == 0:
            q.put(j)
