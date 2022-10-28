N = int(input())
ans = 0
for k in range(1, N):
    light = k*(k+1)
    if light == N - 1:
        ans = k
        break
print(ans)