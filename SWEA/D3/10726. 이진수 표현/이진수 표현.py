T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    num = str(bin(M)[2:])
    n_num = '0' * (30 - len(num)) + num
    ans = '1' * N
    if n_num[-N:] == ans:
        print(f'#{tc} ON')
    else:
        print(f'#{tc} OFF')