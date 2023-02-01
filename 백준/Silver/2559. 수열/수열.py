n,k = map(int,input().split())
arr = [0] + list(map(int,input().split()))

s = [0] * (n + 1)
for j in range(1, k + 1):
    s[k] += arr[j]
ans = s[k]
for i in range(k + 1, n + 1):
    s[i] = s[i - 1] + arr[i] - arr[i - k]
    ans = max(ans, s[i])
print(ans)