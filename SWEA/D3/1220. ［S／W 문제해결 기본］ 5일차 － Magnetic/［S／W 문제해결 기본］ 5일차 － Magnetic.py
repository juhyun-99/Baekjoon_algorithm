for tc in range(1, 11):
    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]

    cnt = 0
    for i in range(100):
        x, y = 0, i
        stack = []

        while x < N:
            if not stack and arr[x][y] == 1:
                stack.append(1)
            elif stack and arr[x][y] == 2:
               cnt+=stack.pop()
            x += 1
    print(f'#{tc} {cnt}')



