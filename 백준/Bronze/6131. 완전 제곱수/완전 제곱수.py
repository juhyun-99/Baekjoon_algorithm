# 1<=b<=a<=500
# 1 <= N <= 1000
#완전탐색 생각
cnt = 0
n = int(input())
for b in range(1, 501):
    for a in range(b, 501):
        if a*a == b*b + n:
            cnt += 1

print(cnt)