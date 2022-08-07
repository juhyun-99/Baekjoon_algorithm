import math
n = int(input())
arr = list(map(int,input().split()))
cnt = 0
def f(num):
    if num==1:
        return False
    for k in range(2,int(math.sqrt(num)+1)):
        if num%k == 0:
            return False
    return True

for i in arr:
    if f(i)==True:
        cnt+=1

print(cnt)