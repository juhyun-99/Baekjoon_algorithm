tc = int(input())

for t in range(1, tc + 1):
    x, y = 1, 1
    arr = []
    n = int(input())
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            arr.append([i, n // i])
    ans = 1e19
    for tmp in arr:
        dx, dy = tmp[0], tmp[1]
        ans = min(ans, (dx-x + dy - y))

    print(f'#{t} {ans}')