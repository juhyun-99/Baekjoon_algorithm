input()
l=list(map(int,input().split()))
l.sort()
l.reverse()
for i in range(len(l)):
    l[i]+=i+1
print(max(l)+1)
