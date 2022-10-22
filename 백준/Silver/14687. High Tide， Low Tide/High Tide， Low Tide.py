import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr.sort()

if len(arr) == 1:
    print(*arr)
    sys.exit()

if N % 2 == 0:
    arr_min = arr[0: N//2]
    arr_max = arr[N//2: ]
else:
    arr_min = arr[0: N // 2 + 1]
    arr_max = arr[N // 2 + 1:]

arr_min.sort(reverse=True)
ans = []

idx = 1

for i in arr_max:
    arr_min.insert(idx, i)
    idx += 2
print(*arr_min)