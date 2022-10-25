T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]
    ans = 0
    for i in range(N):
        if i > N//2 :
            ans += sum(arr[i][N//2-(N-i-1):N//2+(N-i-1)+1])
        else:
            ans += sum(arr[i][N // 2 - i:N // 2 + i + 1])
    print(f'#{tc} {ans}')