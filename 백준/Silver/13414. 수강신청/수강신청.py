import sys
from collections import deque
input = sys.stdin.readline

K, L = map(int,input().split())

student = {}
for i in range(L):
    s = input().rstrip()
    student[s] = i

d2 = sorted(student.items(), key = lambda x : x[1])

for i in d2:
    print(i[0])
    K -= 1
    if K == 0:
        break