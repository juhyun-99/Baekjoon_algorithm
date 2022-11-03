import sys
input = sys.stdin.readline
n, m = map(int,input().split())
arr = list(map(int, input().split()))

value = []
start = 0
max_sum = float('-Inf')
cur_sum = 0
for end, val in enumerate(arr):
    cur_sum += val
    if end - start + 1 == m:
        max_sum = max(max_sum, cur_sum)
        cur_sum -= arr[start]
        start += 1

print(max_sum)