import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
m = max(arr)
appear = [0] * (m + 1)
score = [0] * (m + 1)

for i in arr:
    appear[i] = 1

for i in arr:
    for j in range(i * 2, m + 1, i):
        if appear[j] == 1:
            score[i] += 1
            score[j] -= 1

for i in arr:
    print(score[i], end =' ')