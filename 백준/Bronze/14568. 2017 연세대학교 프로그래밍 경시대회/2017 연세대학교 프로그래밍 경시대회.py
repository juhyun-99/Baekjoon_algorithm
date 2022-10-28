N = int(input())

cnt = 0
for a in range(2, N, 2):
    for c in range(1, N):
        for b in range(c + 2, N):
            if a + c + b == N:
                cnt += 1
print(cnt)