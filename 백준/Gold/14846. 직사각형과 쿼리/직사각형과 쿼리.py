import sys
input = sys.stdin.readline

n = int(input())

arr = [[0] * (n + 1)] + [[0] + list(map(int, input().split())) for _ in range(n)]
prefix = [[[0 for _ in range(11)] for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        for k in range(1, 11):
            prefix[i][j][k] += (prefix[i - 1][j][k] + prefix[i][j - 1][k] - prefix[i - 1][j - 1][k])
        prefix[i][j][arr[i][j]] += 1

q = int(input())
for _ in range(q):
    x1, y1, x2, y2 = map(int, input().split())
    ans = 0
    for k in range(1, 11):
        if prefix[x2][y2][k] + prefix[x1 - 1][y1 - 1][k] - prefix[x2][y1 - 1][k] - prefix[x1 - 1][y2][k]:
            ans += 1
    print(ans)