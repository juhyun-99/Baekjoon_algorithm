t = int(input())

for tc in range(1, t + 1):
    n, a, b = map(int, input().split())
    no_sub = n - max(a,b)
    ans_max = min(a,b)
    ans_min = ans_max - no_sub
    if ans_min < 0:
        ans_min = 0
    print(f'#{tc} {ans_max} {ans_min}')
