n = int(input())
sosu = [True] * (n + 1)
sosu[1] = False

c = [0] * (n + 1)
c[1] = 1
cnt = 1
for i in range(2, n + 1):
    if sosu[i] == False:
        continue
    cnt += 1
    c[i] = cnt
    for j in range(i * i, n + 1, i):
        sosu[j] = False
        c[j] = cnt

print(cnt)
print(*c[1:])