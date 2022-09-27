A,B,V = map(int,input().split())
if V <= A:
    print(1)
    exit()
else:
    day = 1
    V = V - A
    day += (V//(A-B))
    if V%(A-B) > 0:
        day+=1
print(day)