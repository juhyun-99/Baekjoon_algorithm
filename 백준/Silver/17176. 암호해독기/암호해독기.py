import sys
from collections import Counter

input = sys.stdin.readline
n = int(input())
dic = dict(Counter(list(map(int, input().split()))))
s = input().rstrip()
al = {}
for i in s:
    if i.isupper():
        al[ord(i) - 64] = al.get(ord(i) - 64, 0) + 1
    elif i.islower():
        al[ord(i) - 70] = al.get(ord(i) - 70, 0) + 1
    else:
        al[0] = al.get(0, 0) + 1
ans = 'y'
for j in al:
    if j not in dic:
        ans = 'n'
        break
    elif al[j] != dic[j]:
        ans = 'n'
        break
print(ans)