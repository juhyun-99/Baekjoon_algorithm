import sys
from queue import deque

N, K = map(int,input().split())
queue = deque([i for i in range(1,N+1)])
arr=[]
while queue:
    for i in range(K-1):
        queue.append(queue.popleft())
    arr.append(queue.popleft())
print('<',end='')
print(*arr, sep=', ',end='')
print('>')