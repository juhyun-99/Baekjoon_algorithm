N = int(input())
cnt= 0
for num in range(1, N + 1):
    t = sum([int(c) for c in str(num)])
    if num % t == 0:
        cnt += 1
print(cnt)

