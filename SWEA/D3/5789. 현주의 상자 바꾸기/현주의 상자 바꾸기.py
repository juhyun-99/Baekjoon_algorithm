t = int(input())

for tc in range(1, t + 1):
    n, q = map(int,input().split())
    arr = [0] * n
    for i in range(q):
        l, r = map(int,input().split())
        for j in range(l - 1, r):
            arr[j] = i + 1

    print(f'#{tc}', end =' ')
    print(*arr)
