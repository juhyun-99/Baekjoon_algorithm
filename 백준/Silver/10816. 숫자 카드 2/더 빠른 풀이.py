N=int(input())
lst=list(map(int,input().split()))
M=int(input())
lst2=list(map(int,input().split()))
from collections import Counter 
cnt=Counter(lst)
ans=[]
for i in lst2:
    ans.append(cnt[i]) 
print(*ans)
