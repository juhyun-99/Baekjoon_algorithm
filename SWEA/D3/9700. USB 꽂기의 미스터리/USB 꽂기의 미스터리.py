t = int(input())
for tc in range(1, t + 1):
    p, q = map(float, input().split())
    s1 = (1-p)*q
    s2 = p*q*(1-q)

    ans = 'YES' if s1 < s2 else "NO"
    #print(s1,s2)
    print(f'#{tc} {ans}')