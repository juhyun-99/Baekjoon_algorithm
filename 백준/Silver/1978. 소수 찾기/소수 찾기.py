import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

sosu = [True] * 1001
sosu[1] = False

for i in range(2, int(1000 ** 0.5) + 1):
    if sosu[i] == False:
        continue
    for j in range(i * i, 1001, i):
        sosu[j] = False

# print(sosu)
cnt = 0
for i in arr:
    if sosu[i]:
        cnt += 1

print(cnt)
