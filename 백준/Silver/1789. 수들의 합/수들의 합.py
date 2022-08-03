s = int(input())
sum_n = 0
n=1
while True:
    sum_n+=n
    if sum_n >s:
        break
    n+=1

print(n-1)