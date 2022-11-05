from collections import Counter

s = input()
dic = dict(Counter(s))
cnt = 0

for i in dic:
    if dic[i] % 2 !=0:
        cnt += 1

if cnt >= 2:
    print('I\'m Sorry Hansoo')
    exit()


dic = dict(sorted(dic.items()))
ans = ''
h_s = ''

if len(s) % 2 == 0:
    for i in dic:
        if dic[i] % 2 == 0:
            ans += (i * (dic[i] // 2))
    ans += ans[::-1]
else:
    for i in dic:
        if dic[i] % 2 == 0:
            ans += (i * (dic[i]//2))
        else:
            h_s = i
            ans += (i * (dic[i]//2))
    ans2 = ans[::-1]
    ans += (h_s) + ans2

print(ans)
