T = int(input())
k = []
for tc in range(1, T + 1):
    a,b,c,d = map(int,input().split())
    m = max(a,b,c,d)
    arr = [0] * (m + 1)
    ans = 0
    for i in range(a, b + 1):
        arr[i] += 1
    for j in range(c, d + 1):
        arr[j] += 1
        if arr[j] == 2:
            ans += 1
    if ans != 0:
        ans -= 1
    k.append(f"#{tc} {ans}")
print('\n'.join(k))