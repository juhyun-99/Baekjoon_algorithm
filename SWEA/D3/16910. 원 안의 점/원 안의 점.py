tc = int(input())
for t in range(tc):
    n = int(input())
    cnt = 0
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if (i*i + j*j) <= n*n:
                cnt += 1

    cnt = cnt*4
    cnt += n*4 + 1
    print(f'#{t+1} {cnt}')