import sys
n = int(input())
arr=[]
for _ in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))

f=sorted(arr,key = lambda x:(x[0],x[1]))

for i in f:
    print(i[0],i[1])