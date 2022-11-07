T = int(input())

for tc in range(1, T + 1):
    N, M, K = map(int, input().split())
    arr = list(map(int, input().split()))
    make = 0
    tf = True
    for i in range(max(arr) + 1):
        if i != 0 and i % M == 0:
            make += K
        if i in arr:
            if make > 0:
                make -= 1
            else:
                tf = False
                break

    if tf:
        print(f'#{tc} Possible')
    else:
        print(f'#{tc} Impossible')
