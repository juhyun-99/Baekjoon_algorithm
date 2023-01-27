import sys

input = sys.stdin.readline

n = int(input())
arr = [0] + list(map(int, input().split())) + [0]
left = [0] + [0] * (n + 1)
right = [0] * (n + 1) + [0]


def gcd(a, b):
    if b == 0:
        return a

    while a % b != 0:
        a, b = b, a % b
    return min(a, b)


for i in range(1, n + 1):
    left[i] = gcd(max(arr[i - 1], left[i - 1]), min(arr[i - 1], left[i - 1]))

for i in range(n, 0, -1):
    right[i] = gcd(max(arr[i + 1], right[i + 1]), min(arr[i + 1], right[i + 1]))

# print(arr)
# print(left)
# print(right)

ans = 0
idx = 0

for i in range(1, n + 1):
    g = gcd(max(left[i], right[i]), min(left[i], right[i]))
    # print(g)

    if arr[i] % g != 0:
        if ans < g:
            ans = g
            idx = arr[i]

if ans == idx == 0:
    print(-1)
    exit()

print(ans, idx)
