arr = list(map(int, input().split()))
ans = 0

#완전탐색 생각
#숫자는 100보다 작거나 같은 자연수
for i in range(1, 1000001):
    cnt = 0
    for j in arr:
        if i % j == 0:
            cnt += 1

    if cnt >= 3:
        ans = i
        break

print(ans)