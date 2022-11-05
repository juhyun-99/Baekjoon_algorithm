N, K = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(N)]
#arr[i][0] = 무게 , arr[i][1] = 가치

l = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        if j < arr[i - 1][0]:
            l[i][j] = l[i - 1][j]
        else:
            l[i][j] = max(l[i - 1][j], l[i - 1][j - arr[i - 1][0]] + arr[i - 1][1])

# print(*l, sep = '\n')

tmp = 0
for i in l:
    tmp = max(tmp, max(i))
print(tmp)