n = int(input())
sosu = [True] * (n + 1)
sosu[1] = False

for i in range(2, int(n ** 0.5) + 1):
    if not sosu[i]:
        continue
    for j in range(i * i, n + 1, i):
        sosu[j] = False

s = []
for i in range(2, n + 1):
    if sosu[i]:
        s.append(i)

arr = [0] * (n + 1)
arr[0] = 1
for i in s:
    for j in range(i,n + 1):
        arr[j] = (arr[j] + arr[j - i]) % 123456789

print(arr[n])

