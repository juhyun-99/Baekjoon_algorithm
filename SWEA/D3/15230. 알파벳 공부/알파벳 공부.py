
T = int(input())
s = 'abcdefghijklmnopqrstuvwxyz'
for test_case in range(1, T + 1):
    ss = input()
    ans = 0
    for i in range(len(ss)):
        if ss[i] == s[i]:
            ans +=1
        else:
            break
    print(f'#{test_case} {ans}')