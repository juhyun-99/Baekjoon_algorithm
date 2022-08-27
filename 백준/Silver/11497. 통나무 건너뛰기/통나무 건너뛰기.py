import sys
from queue import deque
T = int(input())
for _ in range(T):
    N = int(input())
    arr = list(map(int,sys.stdin.readline().split()))
    arr.sort(reverse = True)
    queue = deque([])
    queue.append(arr[0])
    for i in range(1,N):
        if i % 2 ==1:
            queue.append(arr[i])
        else:
            queue.appendleft(arr[i])
    num = abs(queue[0]-queue[-1])
    for i in range(N-1):
        num = max(num,abs(queue[i]-queue[i+1]))
    print(num)