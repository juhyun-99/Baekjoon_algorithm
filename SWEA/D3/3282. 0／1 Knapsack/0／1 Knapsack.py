t = int(input())

for tc in range(1, t + 1):
    n, k = map(int, input().split())  # 개수, 부피
    stuff = [0]  # v 부피, c 가치
    for _ in range(n):
        stuff.append(list(map(int, input().split())))

    arr = [[0] * (k + 1) for _ in range(n + 1)]
    ans = 0

    for i in range(1, n + 1):
        v, c = stuff[i]
        for j in range(1, k + 1):
            if j < v:
                arr[i][j] = arr[i - 1][j]

            else:
                arr[i][j] = max(arr[i - 1][j], arr[i - 1][j - v] + c)

        ans = max(max(arr[i]), ans)

    print(f'#{tc} {ans}')