n = int(input())
if n == 1:
    print(0)
    exit()
sosu = [True] * (n + 1)
sosu[1] = False

for i in range(2, int(n ** 0.5) + 1):
    if not sosu[i]:
        continue
    for j in range(i * i, n + 1, i):
        sosu[j] = False
arr = []
for i in range(2, n + 1):
    if sosu[i]:
        arr.append(i)

s, e = 0, 0
ans = arr[0]
cnt = 0
while True:
    if ans < n:
        e += 1
        if e >= len(arr):
            break
        ans += arr[e]

    elif ans > n:
        ans -= arr[s]
        s += 1

    else:
        cnt += 1
        ans -= arr[s]
        s += 1

print(cnt)
