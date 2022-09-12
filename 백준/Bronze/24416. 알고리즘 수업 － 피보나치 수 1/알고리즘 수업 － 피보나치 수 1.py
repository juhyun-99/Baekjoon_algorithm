cnt = 0
cnt2 = 0
N = int(input())
def fib(n):
    global cnt 
    if(n==1 or n==2):
        cnt+=1
        return 1
    else:
        return fib(n-1)+fib(n-2)

d = [0]*100
d[1] = 1
d[2] = 1
for i in range(3,N+1):
    d[i] = d[i-2]+d[i-1]
    cnt2+=1

fib(N)
print(cnt, cnt2)