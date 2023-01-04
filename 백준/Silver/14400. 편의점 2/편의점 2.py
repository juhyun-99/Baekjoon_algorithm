#14400
import sys
input = sys.stdin.readline

#완전탐색
#x,y = -100만 ~100만
# 201만 * 201만 = 시간초과

n = int(input())
x_arr = []  
y_arr = []

for _ in range(n):
    x,y = map(int,input().split())
    x_arr.append(x)
    y_arr.append(y)

#정렬
x_arr.sort()
y_arr.sort()

if n % 2 == 0: #짝수개일 때 중간 값이 두개
    ans1,ans2 = 0,0
    for x in x_arr:
        ans1 += abs(x - x_arr[n//2 - 1])
        ans2 += abs(x - x_arr[n//2])
    for y in y_arr:
        ans1 += abs(y - y_arr[n//2 - 1])
        ans2 += abs(y - y_arr[n//2])
    ans = min(ans1,ans2)

else: #홀수개일 때
    ans = 0
    for x in x_arr:
        ans += abs(x - x_arr[n//2])
    for y in y_arr:
        ans += abs(y - y_arr[n//2])
print(ans)