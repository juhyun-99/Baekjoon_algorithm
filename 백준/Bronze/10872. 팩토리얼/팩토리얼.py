n = int(input())
if n==0:
    s=1
else:
    s=n
for i in range(n-1,0,-1):
    s*=i

print(s)
  