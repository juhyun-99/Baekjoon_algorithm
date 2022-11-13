from collections import deque
import sys
input = sys.stdin.readline
n, m, r = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]


def operate(step):
    q = deque()
    # 상
    i = step
    for j in range(step, m - step):
        q.append(a[i][j])

    # 우
    j = m - step - 1
    for i in range(step + 1, n - step):
        q.append(a[i][j])

    # 하
    i = n - step - 1
    for j in range(m - step - 2, step - 1, -1):
        q.append(a[i][j])

    # 좌
    j = step
    for i in range(n - step - 2, step, -1):
        q.append(a[i][j])

    q.rotate(-r)

    # 상
    i = step
    for j in range(step, m - step):
        a[i][j] = q.popleft()

    # 우
    j = m - step - 1
    for i in range(step + 1, n - step):
        a[i][j] = q.popleft()

    # 하
    i = n - step - 1
    for j in range(m - step - 2, step - 1, -1):
        a[i][j] = q.popleft()

    # 좌
    j = step
    for i in range(n - step - 2, step, -1):
        a[i][j] = q.popleft()

for step in range(min(n, m) // 2):
    operate(step)

for i in range(n):
    print(*a[i])
