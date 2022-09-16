N = int(input())

if N%5==0: print(N//5)
else:
    ans = 0
    while N>0:
        N-=3
        ans+=1
        if N%5==0:
            ans+=N//5
            print(ans)
            break
        elif N==1 or N==2:
            print(-1)
            break
        elif N==0:
            print(ans)
            break
  
