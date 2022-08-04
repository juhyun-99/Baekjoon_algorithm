t = int(input())

for i in range(t):
    j,n = map(int,input().split())
    arr=[]
    cnt = 0
    remain = j
    for k in range(n):
        r,c = map(int,input().split())
        arr.append(r*c)
    arr.sort(reverse = True)

    for i in arr:
        remain -=i
        cnt+=1
        if remain <= 0:
            break
    print(cnt)