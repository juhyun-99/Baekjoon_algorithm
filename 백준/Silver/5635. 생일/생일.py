import sys
input = sys.stdin.readline
n = int(input())
dic = []
for _ in range(n):
    name, d, m, y = input().strip().split()
    if len(m) == 1:
        m = '0' + m
    if len(d) == 1:
        d = '0' + d
    dic.append([name,y+m+d])
dic.sort(key=lambda x: x[1])
print(dic[-1][0])
print(dic[0][0])