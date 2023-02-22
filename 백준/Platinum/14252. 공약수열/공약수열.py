import sys

input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
arr.sort()


def get_gcd(a, b):
    a, b = max(a, b), min(a, b)
    while a % b != 0:
        a, b = b, a % b
    return b


def count(a, b):
    for i in range(a + 1, b):
        if get_gcd(a, i) == get_gcd(i, b) == 1:
            return 1
    return 2


ans = 0
for i in range(n - 1):
    a, b = arr[i], arr[i + 1]
    g = get_gcd(a, b)
    if g > 1:
        ans += count(a, b)
print(ans)