
A, B = map(int, input().split())

tf = True
cnt = 0
while True:
    if B == A:
        break

    if str(B)[-1] == '1':
        B //= 10
        cnt += 1
    elif B % 2 == 0:
        B //= 2
        cnt += 1
    else:
        tf = False
        break
    if B < A:
        tf = False
        break

if tf:
    print(cnt+1)
else:
    print(-1)


