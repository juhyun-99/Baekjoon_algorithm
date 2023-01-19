n, a = map(int, input().split())
i = 0
while a**i <= n:
    i += 1

arr = [n//(a**j) for j in range(1, i)]
print(sum(arr))