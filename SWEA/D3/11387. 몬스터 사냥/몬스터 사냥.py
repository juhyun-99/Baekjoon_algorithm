t = int(input())

for tc in range(1, t + 1):
    d, l, n = map(int, input().split())
    ans = 0
    for i in range(n):
        ans += d * (1 + (i * l * 0.01))
    ans = int(ans)
    print(f'#{tc} {ans}')