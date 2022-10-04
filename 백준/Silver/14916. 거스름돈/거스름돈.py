n = int(input())
cnt = 0
while n > 0:
    if (n%5) % 2 == 0:
        k = n//5
        cnt += k
        n -= 5 * k
        cnt += n//2
        break
    else:
        n -= 2
        cnt += 1

if n < 0:
    print(-1)
else:
    print(cnt)