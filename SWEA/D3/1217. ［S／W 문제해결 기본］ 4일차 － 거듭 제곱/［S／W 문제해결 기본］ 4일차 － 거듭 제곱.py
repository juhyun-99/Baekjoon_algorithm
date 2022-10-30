def f(x, y):
    if y == 1:
        return x
    return f(x,y-1) * x
for tc in range(1, 11):
    t = int(input())
    N, M = map(int, input().split())
    print(f'#{tc} {f(N,M)}')


