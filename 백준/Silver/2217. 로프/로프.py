import sys
input = sys.stdin.readline
N = int(input())
weight = [int(input()) for _ in range(N)]
weight.sort()
value = weight[-1]
for i in range(N):
    value = max(value,(weight[i]*(N-i)))

print(value)