import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = tuple(map(int, input().split()))

max_sum = float('-inf')
start = 0
cur_sum = 0

for end, val in enumerate(arr):
    cur_sum += val
    if end - start + 1 == K:
        max_sum = max(max_sum, cur_sum)
        cur_sum -= arr[start]
        start+=1

print(max_sum)