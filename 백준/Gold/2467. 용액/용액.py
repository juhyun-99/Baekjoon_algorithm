from bisect import bisect_left
import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

s, e = 0, n - 1
ans = 1e19
ans1, ans2 = 0, 0
while s < e:
    tmp = arr[s] + arr[e]

    if abs(tmp) < ans:
        ans1 = arr[s]
        ans2 = arr[e]
        ans = abs(tmp)

    if tmp < 0:
        s += 1
    elif tmp > 0:
        e -= 1
    else:
        break
print(ans1, ans2)
