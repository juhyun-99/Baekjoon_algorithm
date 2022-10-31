x = input()
cnt = 0
while len(x) != 1:
    num = 0
    for i in x:
        num += int(i)
    x = str(num)
    cnt += 1

if int(x) % 3 == 0:
    print(cnt)
    print('YES')
else:
    print(cnt)
    print('NO')

