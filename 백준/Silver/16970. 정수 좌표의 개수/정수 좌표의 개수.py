import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())


def get_gcd(a, b):
    a, b = max(a,b),min(a,b)
    if b == 0:
        return a
    while a % b != 0:
        a, b = b, a % b
    return b

ans = 0
for x1 in range(n + 1):
    for y1 in range(m + 1):
        for x2 in range(n + 1):
            for y2 in range(m + 1):
                if x1 == x2 and y1 == y2:
                    continue
                else:
                    x = x1 - x2
                    y = y1 - y2
                    if get_gcd(abs(x),abs(y)) == (k - 1):
                        ans += 1

print(ans//2)