n = int(input())

while n>1:
  if n%2==0:
    print(2)
    n = n // 2
  if n%2==1:
    for i in range(2,n+1):
      if n%i==0 and n!=1:
        n = n // i
        print(i)
        break