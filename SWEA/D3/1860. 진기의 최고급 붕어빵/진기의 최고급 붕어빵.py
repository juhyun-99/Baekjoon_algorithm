tc = int(input())

for t in range(tc):
    n, m, k = map(int,input().split())
    p = list(map(int,input().split()))
    bread = 0
    tf = True
    for i in range(max(p) + 1):
        if i != 0 and i % m == 0:
            bread += k
        if i in p:
            if bread < 1:
                tf = False
            else:
                bread -= 1
        if not tf:
            break
    ans = ''
    if tf:
        ans = 'Possible'
    else:
        ans = 'Impossible'
    print(f'#{t + 1} {ans}')
