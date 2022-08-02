num = 1
while True:
    cnt = 0
    l,p,v = map(int,input().split())
    if l==p==v==0:
        break
    if v%p > l:
        cnt += ((v//p)*l)+l
    else:
        cnt += ((v//p)*l)+(v%p)
    print(f"Case {num}: {cnt}")
    num+=1
  
  