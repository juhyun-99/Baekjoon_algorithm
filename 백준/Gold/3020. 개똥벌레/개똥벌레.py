import sys
input = sys.stdin.readline

n,h = map(int,input().split())

s = [0] * (h + 1)
s2 = [0] * (h + 1)
ans = 1e9
for j in range(n):
    num = int(input())

    if j % 2 == 0:
        s[1] += 1
        s[num + 1] -= 1

    else:
        s2[h] += 1
        s2[h - num] -= 1
    #print(s2)
ans = [0] * (h + 1)
ans2 = [0] * (h + 1)
ans2[h] = s2[h]
for i in range(1, h + 1):
    ans[i] = s[i] + ans[i - 1]
for i in range(h - 1, 0, -1):
    ans2[i] = s2[i] + ans2[i + 1]

for i in range(1, h + 1):
    ans[i] += ans2[i]

del ans[0]
print(min(ans),ans.count(min(ans)))