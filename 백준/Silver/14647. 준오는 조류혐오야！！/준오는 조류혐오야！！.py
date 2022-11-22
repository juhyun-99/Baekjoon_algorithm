import sys
input = sys.stdin.readline
n, m = map(int, input().split())
ma = []
ans = 0
mm = 0
for _ in range(n):
    arr = list(map(int,input().split()))
    ma.append(arr)
    cnt = 0
    for i in arr:
        for j in str(i):
            if j == '9':
                cnt += 1
                ans += 1
    mm = max(cnt, mm)

for i in range(m):
    cnt = 0
    for j in range(n):
        for s in str(ma[j][i]):
            if s == '9':
                cnt += 1

    mm = max(cnt, mm)

print(ans - mm)