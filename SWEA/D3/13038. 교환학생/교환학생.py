from collections import deque

T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    lst = deque(map(int, input().split()))
    result = 1e9
    for i in range(7):
        lst.rotate(1)
        day = cnt = 0

        while day < n:
            if lst[cnt % 7]:
                day += 1
            cnt += 1
        result = min(result, cnt)
    print(f"#{tc} {result}")