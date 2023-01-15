tf = 0
a, b, c, n = map(int, input().split())
for i in range(51):
    if tf == 1:
        break
    for j in range(51):
        if tf == 1:
            break
        for k in range(51):
            if (i*a + b*j + c*k) == n:
                tf = 1
                break

print(tf)