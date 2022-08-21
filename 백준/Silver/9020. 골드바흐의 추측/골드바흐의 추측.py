import math
import sys

def f(num):
    if num==1:
      return False
    for k in range(2,int(math.sqrt(num)+1)):
        if num%k==0:
            return False
            break
    return True

T = int(input())

for i in range(T):
    n = int(sys.stdin.readline().rstrip())

    a,b = n//2,n//2
    while a > 0:
        if f(a) and f(b):
            print(a,b)
            break
        else :
            a-=1
            b+=1
