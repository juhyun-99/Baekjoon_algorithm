from collections import deque
for tc in range(1, 11):
    T = int(input())
    arr = list(map(int,input().split())) # 8개
    q = deque(arr)
    i = 1
    while q[-1] > 0:
        value = q.popleft() - i
        i += 1
        if i == 6:
            i = 1
        q.append(value)
    q.pop()
    q.append(0)
    print(f'#{T} ' ,end='')
    print(*list(q))