import sys
import collections
input = sys.stdin.readline
arr = [[0] * 1001 for _ in range(1001)]

N = int(input())

for num in range(1, N + 1):
    a, b, w, h = map(int, input().split())
    for i in range(b, b + h):
        arr[i][a : (a + w)] = [num] * w


for num in range(1, N + 1):
    sum = 0
    for i in range(1001):
        sum += arr[i].count(num)
    print(sum)