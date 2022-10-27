t = int(input())
for _ in range(t):
    cnt = 0
    a, b, c = map(int, input().split())
    for i in range(a):
        for j in range(b):
            for k in range(c):
                if i==j==k:
                    cnt+=1

    print(cnt)