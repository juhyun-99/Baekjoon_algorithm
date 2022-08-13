import math
import sys

def f(num):
    for k in range(2,int(math.sqrt(num)+1)):
        if num%k==0:
            return False
            break
    return True

while True:
    n = int(sys.stdin.readline().rstrip())
    tf = False
    if n==0:
        break
    for k in range(3,n,2):
        if f(k) and f(n-k):
            print(f'{n} = {k} + {n-k}')
            tf = True
            break
    if tf==False:
        print("Goldbach's conjecture is wrong.")
        
