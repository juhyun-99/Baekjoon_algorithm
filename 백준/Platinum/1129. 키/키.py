import sys

input = sys.stdin.readline

n = int(input())
arr = sorted(list(map(int, input().split())))
diff = 0
for i in range(2, n):
    diff = max(arr[i] - arr[i - 2], diff)
#print(diff)
left, right = [], []
idx = 0
tmp = arr[0]
for i in range(n):
    # print(arr[i], tmp, arr[i] - tmp)
    if arr[i] - tmp > diff:
        value = left.pop()
        right.append(value)
        tmp = value
    left.append(arr[i])
    # print(left, right)

result = left + right[::-1]

print(*result)