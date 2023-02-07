import math

n = int(input())
s = input()
right = [0] * n
if s[-1] == 'E':
    right[-1] = 1
for i in range(n - 2, -1, -1):
    if s[i] == 'E':
        right[i] = right[i + 1] + 1
    else:
        right[i] = right[i + 1]

w, h = 0, 0
ans = 0
for i in range(n):
    if s[i] == 'W':
        w += 1

    elif s[i] == 'H':
        h += w

    elif s[i] =='E':
        ans += h * (2**(right[i] - 1) - 1)

# print(w)
# print(h)
print(ans%1000000007)