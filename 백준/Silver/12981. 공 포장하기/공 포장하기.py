rgb = list(map(int,input().split()))
cnt=0
m = min(rgb)
cnt = m
for i in range(len(rgb)):
    rgb[i] -= m
    cnt+= rgb[i]//3
    rgb[i] %= 3
    cnt+=rgb[i]//2
    rgb[i] %= 2

cnt+=max(rgb)
print(cnt)