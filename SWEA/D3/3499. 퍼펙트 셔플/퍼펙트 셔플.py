from collections import deque
t = int(input())
for tc in range(t):
    n = int(input())
    arr = list(input().split(' '))
    if n % 2 == 0:
        arr1 = deque(arr[:n//2])
        arr2 = deque(arr[n//2:])
    else:
        arr1 = deque(arr[:n // 2 + 1])
        arr2 = deque(arr[n // 2 + 1:])
    # print(arr1)
    # print(arr2)
    ans = []
    for i in range(n):
        if i % 2 == 0:
            ans.append(arr1.popleft())
        else:
            ans.append(arr2.popleft())

    print(f'#{tc + 1}', end= ' ')
    print(*ans)