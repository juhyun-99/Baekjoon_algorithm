
T = int(input())
day = [0,31,28,31,30,31,30,31,31,30,31,30,31]

for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int,input().split())
    ans = 0
    if m1 ==m2:
        ans = d2-d1
    else:
        for i in range(m1+1, m2):
            ans+=day[i]
        ans += day[m1] - d1
        ans += d2
    print(f'#{test_case} {ans+1}')
    
