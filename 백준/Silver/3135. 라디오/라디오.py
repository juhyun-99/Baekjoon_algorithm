a,b = map(int,input().split())
n = int(input())
cnt=0
change = abs(b-a)

for i in range(n):
    number = int(input())
    if number == b:
        cnt+=1
        change=0
        break
    if change > abs(number-b):
        change = abs(number-b)+1

print(cnt+change)