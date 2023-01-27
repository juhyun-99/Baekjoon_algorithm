import sys
from bisect import bisect_left, bisect_right
input = sys.stdin.readline

t = int(input())
num = 2
s = []
while len(s) < 100000:
    tf = True
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            tf = False
            break
    if tf:
        s.append(num)
    num += 1

for _ in range(t):
    num = int(input())
    if num in s:
        print(0)
        continue

    l = bisect_left(s,num)
    ans = s[l] - s[l - 1]
    print(ans)