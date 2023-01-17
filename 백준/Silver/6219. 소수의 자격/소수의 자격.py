a, b, d = map(int, input().split())
cnt = 0
sosu = [True] * (b + 1)
sosu[1] = False
for i in range(2, int(b ** 0.5) + 1):
    if not sosu[i]:
        continue

    for j in range(i * i, b + 1, i):
        sosu[j] = False

for i in range(a, b + 1):
    if sosu[i]:
        if str(d) in str(i):
            cnt += 1

print(cnt)