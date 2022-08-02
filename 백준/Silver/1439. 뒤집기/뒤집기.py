s = list(input())
cnt = 0
a = s[0]
for i in range(1,len(s)):
    if a != s[i]:
        cnt+=1
        a = s[i]

if cnt%2 == 1:
    if cnt>1:
        print(cnt-cnt//2)
    else : print(cnt)
else:
    print(cnt//2)
    