n = int(input())

num = 1
for i in range(0,200000000):
  if n <= num:
    print(i+1)
    break
  else:
    num += 6*(i+1)
