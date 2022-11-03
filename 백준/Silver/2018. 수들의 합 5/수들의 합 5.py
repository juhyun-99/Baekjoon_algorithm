N = int(input())

start = 1
end = 1
cnt = 0
ans = 0
while end <= N + 1:
    if cnt < N:
        cnt += end
        end += 1
    elif cnt > N:
        cnt -= start
        start += 1
    else:
        ans += 1
        cnt += end
        end += 1

print(ans)

