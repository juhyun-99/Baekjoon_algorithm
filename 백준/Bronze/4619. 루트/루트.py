while True:
    B, N = map(int, input().split())
    if B == N == 0:
        break
    m = float('Inf')
    ans = 1
    for i in range(1, 1000001):
        if i ** N >= B:
            if i ** N - B < B - (i - 1) ** N:
                ans = i
            else:
                ans = i - 1
            break

    print(ans)