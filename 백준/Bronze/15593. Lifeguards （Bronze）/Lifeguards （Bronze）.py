n = int(input()) #1 ~ 100

time = [0] * 1001
arr = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    arr.append(tmp)
    for i in range(tmp[0], tmp[1]):
        time[i] += 1

ans = 0
for tmp in arr:
    for i in range(tmp[0], tmp[1]):
        time[i] -= 1 # 빼주기
    ans = max(ans, 1001 - time.count(0))
    for i in range(tmp[0], tmp[1]):
        time[i] += 1 #다음 계산을 위해 다시 되돌려놓기

print(ans)