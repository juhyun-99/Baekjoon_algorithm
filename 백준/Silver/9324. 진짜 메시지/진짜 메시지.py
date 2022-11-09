import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    dic = {}
    s = input().rstrip()
    chk = False
    ans = 'OK'
    for i in range(len(s)):
        if chk:
            chk = False
            continue
        dic[s[i]] = dic.get(s[i], 0) + 1
        if dic[s[i]] == 3:
            if i == len(s) - 1:
                ans = 'FAKE'
                break
            elif s[i] != s[i + 1]:
                ans = 'FAKE'
                break
            chk = True
            dic[s[i]] = 0
    print(ans)


