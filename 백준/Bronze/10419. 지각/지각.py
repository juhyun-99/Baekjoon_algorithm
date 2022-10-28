T = int(input())

for _ in range(T):
    time = int(input())
    ans = 0
    for t in range(1, time):
        s = t * t
        if s+t <= time:
            ans = t
        else:
            break
    print(ans)