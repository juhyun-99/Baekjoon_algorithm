N = int(input())
cnt = 0
for i in range(1,N+1):
    num = list(map(int,str(i)))
    if i<100:
        cnt += 1
    else:
        if num[0]-num[1]==num[1]-num[2]:
            cnt+=1
print(cnt)
        