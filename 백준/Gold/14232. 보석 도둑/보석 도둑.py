n = int(input())

cnt = 0
ans = []
for i in range(2, int(n ** 0.5) + 1):
    while n % i == 0:
        ans.append(i)
        n //= i

if n != 1:
    ans.append(n)

print(len(ans))
print(*ans)