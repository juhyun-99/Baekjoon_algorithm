import sys
input = sys.stdin.readline
girl = [[i, 0] for i in range(1, 7)]
boy = [[i, 0] for i in range(1, 7)]

N, K = map(int, input().split())

for _ in range(N):
    sex, grade = map(int, input().split())
    if sex == 0:
        girl[grade - 1][1] += 1
    else:
        boy[grade - 1][1] += 1

room = 0
for g in girl:
    room += g[1] // K
    if (g[1] % K ) >= 1:
        room += 1

for b in boy:
    room += b[1] // K
    if (b[1] % K ) >= 1:
        room += 1
print(room)