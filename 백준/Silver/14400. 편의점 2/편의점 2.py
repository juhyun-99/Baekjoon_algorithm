import sys
input = sys.stdin.readline

n = int(input())
x, y = [], []

for i in range(n):
    x1, y1 = map(int, input().split())
    x.append(x1)
    y.append(y1)

x.sort()
y.sort()

midX = x[n//2]
midY = y[n//2]

ans = 0
for i in range(n):
    ans += abs(x[i] - midX)
    ans += abs(y[i] - midY)

print(ans)