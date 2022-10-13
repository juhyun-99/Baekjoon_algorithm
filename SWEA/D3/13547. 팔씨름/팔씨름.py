
T = int(input())

for test_case in range(1, T + 1):
    s = input()
    oc = s.count('o')
    co = 15 - len(s)
    ans = ''
    if oc + co >= 8:
        ans = 'YES'
    else: ans = 'NO'

    print(f'#{test_case} {ans}')