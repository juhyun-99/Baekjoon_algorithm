n = input()
a = len(n)
ans = 0
for i in range(a-1):
    ans += (10**i)*(i+1)*9

ans += (int(n) - (10**(a-1)) + 1) *a
print(ans)