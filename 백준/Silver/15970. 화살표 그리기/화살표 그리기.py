import sys

input = sys.stdin.readline
n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
arr.sort(key=lambda x: (x[1], x[0]))
# print(arr)
ans = 0
for i in range(n):
    x, y = i - 1, i + 1
    if x < 0:
        ans += abs(arr[i][0] - arr[y][0])
    elif 0 <= x and y <= n - 1:
        if arr[x][1] == arr[i][1] and arr[y][1] == arr[i][1]:
            ans += min(abs(arr[i][0] - arr[y][0]), abs(arr[i][0] - arr[x][0]))

        elif arr[x][1] != arr[i][1]:
            ans += abs(arr[i][0] - arr[y][0])

        else:
            ans += abs(arr[i][0] - arr[x][0])
    elif y > n - 1:
        ans += abs(arr[i][0] - arr[x][0])

print(ans)

# 3 1 1 2 3 3 3