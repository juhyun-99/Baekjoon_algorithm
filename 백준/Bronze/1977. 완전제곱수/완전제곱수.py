arr = [i*i for i in range(1, 101)]

M = int(input())
N = int(input())
ans = []
for i in arr:
    if i > N:
        break
    if i >= M:
        ans.append(i)

if not ans:
    print(-1)
else:
    print(sum(ans))
    print(min(ans))