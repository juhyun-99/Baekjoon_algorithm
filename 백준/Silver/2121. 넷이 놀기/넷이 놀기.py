import sys
input = sys.stdin.readline

n = int(input())
a, b = map(int, input().split())
dic = {}

for _ in range(n):
    x, y = map(int,input().split())
    if dic.get(x,0) == 0:
        dic[x] = [y]
    else:
        dic[x].append(y)

ans = 0

for x in dic:
    for y in dic[x]:
        if (y + b in dic[x]) and (x + a) in dic and (y in dic[x + a]) and y + b in dic[x + a]:
            ans += 1

print(ans)
