import sys
n = int(sys.stdin.readline().strip())
s = sys.stdin.readline().strip()
right = [0] * n

if s[-1] == 'E':
    right[-1] = 1

for i in range(n - 2, -1, -1):
    if s[i] == 'E':
        right[i] = right[i + 1] + 1
    else:
        right[i] = right[i + 1]

w, h, ans = 0, 0, 0

for i in range(n):
    if s[i] == 'W':
        w += 1
    elif s[i] == 'H':
        h += w
    elif s[i] == 'E':
        ans += h * (2**(right[i] - 1) - 1)

print(ans % 1000000007)