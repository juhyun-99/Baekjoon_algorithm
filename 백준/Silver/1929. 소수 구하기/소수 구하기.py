import math
m,n = map(int,input().split())
def f(num):
    if num==1:
        return False
    for k in range(2,int(math.sqrt(num)+1)):
        if num%k==0:
            return False
            break
    return True

for i in range(m,n+1):
    if f(i) ==True:
        print(i)