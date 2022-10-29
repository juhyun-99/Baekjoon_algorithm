from collections import deque
N, M = map(int,input().split())

student = [0] * (N + 1)
arr = [[] for _ in range(N + 1)]

for _ in range(M):
    a,b = map(int,input().split())
    arr[a].append(b)
    student[b] += 1

def sort():
    q = deque()
    for i in range(1, N + 1):
        if student[i] == 0:
            q.append(i)
    while q:
        num = q.popleft()
        print(num, end=' ')
        for i in arr[num]:
            student[i] -= 1
            if student[i] == 0:
                q.append(i)

sort()
