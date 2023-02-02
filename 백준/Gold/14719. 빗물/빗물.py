import sys
input = sys.stdin.readline

h,w = map(int,input().split())
arr = [0] + list(map(int,input().split()))
left = [0] * (w + 1)
left[1] = arr[1]
right = [0] * (w + 1)
for i in range(2, w):
    left[i] = max(left[i - 1], arr[i - 1])


right[w] = arr[w]
for i in range(w - 1, 0, -1):
    right[i] = max(right[i + 1], arr[i + 1])
ans = 0
for i in range(2, w):
    tmp = min(left[i],right[i]) - arr[i]
    if tmp <= 0:
        continue
    ans += min(left[i],right[i]) - arr[i]

# print(arr)
# print(left)
# print(right)
print(ans)