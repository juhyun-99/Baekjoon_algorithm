t = int(input())
month = [0, 30, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day = [4,5,6,0,1,2,3]
for tc in range(1, t + 1):
    m, d = map(int, input().split())
    if m == 1:
        ans = day[(d - 1) % 7]
    else:
        ans = d
        for i in range(1, m):
            ans += month[i]
        ans = day[ans % 7]
    print(f'#{tc} {ans}')
