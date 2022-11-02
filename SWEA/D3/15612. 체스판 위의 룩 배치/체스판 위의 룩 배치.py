T = int(input())

for tc in range(1, T + 1):
    arr = [list(input().rstrip()) for _ in range(8)]
    ans = 'yes'
    #가로
    for i in range(8):
        stack = []
        for j in range(8):
            if arr[i][j] == 'O':
                stack.append('O')
        if len(stack) != 1:
            ans = 'no'

    #세로
    for i in range(8):
        stack = []
        for j in range(8):
            if arr[j][i] == 'O':
                stack.append('O')
        if len(stack) != 1:
            ans = 'no'

    print(f'#{tc} {ans}')