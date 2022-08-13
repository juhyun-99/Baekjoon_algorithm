import math
T = int(input())

def lcm(a,b):
  return a*b //math.gcd(a,b)

for _ in range(T):
    a,b = map(int,input().split())
    print(lcm(a,b))
