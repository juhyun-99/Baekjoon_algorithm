a, b, c, d, e, f = map(int, input().split())
#완탐 생각
#x,y는 -999 ~ 999
#4000000번
for x in range(-999,1000):
    for y in range(-999,1000):
        if(a*x + b*y == c) and (d*x + e*y == f):
            print(x, y)
            exit()