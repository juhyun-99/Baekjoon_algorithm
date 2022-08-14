n = int(input())
if n==0:
    print(0)
    exit()
else:
    ans=''
    while n:
        if n%-2:
            ans+='1'
            n=n//-2+1
        else:
            ans+='0'
            n//=-2

ans = list(ans)
ans.reverse()
ans =''.join(ans)
print(ans)
