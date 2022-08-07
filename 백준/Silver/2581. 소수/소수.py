import math
m = int(input())
n = int(input())
mi = 10001
def f(num):
    if num==1:
        return False
    for k in range(2,int(math.sqrt(num)+1)):
        if num%k == 0:
            return False
    return True
s = 0
cnt = 0
for i in range(m,n+1):
    if f(i) == True:
        s+=i
        cnt+=1
        if i<mi:
            mi = i
if cnt==0:
    print(-1)
else: 
    print(s)
    print(mi)