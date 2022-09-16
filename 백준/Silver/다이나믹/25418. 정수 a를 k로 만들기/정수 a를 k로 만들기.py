A,K = map(int,input().split())

cnt = 0
while A!=K:
    if K%2==1:
        K-=1
    else:
        if K/2 >= A:
            K = int(K/2)
        else:
            K-=1
    cnt+=1
print(cnt)
