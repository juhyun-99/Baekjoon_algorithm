s = list(input())
t = list(input())
ans = 1
try:
    while t!=s:
        if t[-1]=='A':
            del t[-1]
        else:
            del t[-1]
            t.reverse()  

except:
    ans=0

print(ans)