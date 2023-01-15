n = int(input())
sam = []
i = 0
if n == 0:
    print('NO')
    exit()
while True:
    num = 3**i
    if num > n:
        break
    sam.append(num)
    i+=1
s = 0
def f(d, s):
    if d == -1:
        return s == n
    return f(d - 1, s + sam[d]) or f(d - 1, s)

if f(len(sam) - 1, s):
    print('YES')
else:
    print('NO')
