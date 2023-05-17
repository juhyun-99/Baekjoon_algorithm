t = int(input())
for tc in range(1, t + 1):

    s = input()
    ans = 'Exist'
    if '?' not in s:
        if len(s) % 2 == 0:
            for i in range(0, len(s)//2):
                # print(s[i], s[-i - 1])
                if s[i] != s[- i - 1]:
                    ans = 'Not exist'
                    break
        else:
            for i in range(0, len(s)//2):
                # print(s[i], s[-i - 1])
                if s[i] != s[- i - 1]:
                    ans = 'Not exist'
                    break

    else:
        if len(s) % 2 == 0:
            for i in range(0, len(s) // 2):
                # print(s[i], s[-i - 1])
                if s[i] != '?' and s[-i-1] != '?':
                    if s[i] != s[- i - 1]:
                        ans = 'Not exist'
                        break
        else:
            for i in range(0, len(s) // 2):
                # print(s[i], s[-i-1])
                if s[i] != '?' and s[-i - 1] != '?':
                    if s[i] != s[- i - 1]:
                        ans = 'Not exist'
                        break
    print(f'#{tc} {ans}')