t = int(input())

for tc in range(1, t + 1):
    n = int(input())

    ans = 0
    for _ in range(n):
        p, x = input().split()
        ans += float(p) * int(x)
    print(f'#{tc} {ans}')