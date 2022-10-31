s = list(input())
ans = []
for i in range(1,len(s)-1):
    for j in range(i + 1,len(s)):
        first = s[ : i]
        second = s[i : j]
        third = s[j : ]
        first.reverse()
        second.reverse()
        third.reverse()
        tmp = first + second + third
        ans.append(''.join(tmp))
ans.sort()
print(ans[0])


