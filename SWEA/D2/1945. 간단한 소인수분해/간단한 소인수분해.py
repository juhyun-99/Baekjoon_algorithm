T = int(input())
arr = [2, 3, 5, 7, 11]
for tc in range(1, T + 1):
    ans = [0] * 5
    N = int(input())
    for i in range(5):
        while True:
            if N % arr[i] == 0:
                ans[i] += 1
                N //= arr[i]
            else:
                break
    print(f'#{tc} ', end='')
    print(*ans)


