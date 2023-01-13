#양  a
#염소 b

a, b, n, w = map(int,input().split())

#양 + 염소 n마리
#소비한 사료 w

num1, num2 = 0,0
cnt = 0
for i in range(1, n):
    if i * a + (n - i) * b == w:
        cnt += 1
        num1 = i
        num2 = n - i

if cnt != 1:
    print(-1)
else:
    print(num1, num2)