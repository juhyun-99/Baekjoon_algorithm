import sys
import math
input = sys.stdin.readline
n = int(input())

arr = []
x_arr = []
y_arr = []
for _ in range(n):
    x, y = map(int,input().split())
    arr.append((x,y))
    x_arr.append(x)
    y_arr.append(y)

s_arr = []
for x in x_arr:
    for y in y_arr:
        s_arr.append((x,y))
s_arr = list(set(s_arr))

ans = []
for i in s_arr:
    tmp = []
    for j in arr:
        tmp.append(abs(j[0] - i[0]) + abs(j[1] - i[1]))
    tmp.sort()
    ans.append(tmp)

for i in range(n):
    if i == 0:
        print(i, end =' ')
        continue
    ans2 = 1e9
    for j in ans:
        ans2 = min(ans2, sum(j[:i + 1]))
    print(ans2, end =' ')
