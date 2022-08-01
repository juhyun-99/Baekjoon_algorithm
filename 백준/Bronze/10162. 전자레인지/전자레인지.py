a = 5*60
b = 1*60
c = 10

n = int(input())
a_cnt = 0
b_cnt = 0
c_cnt = 0
while n > 0:
    if n >= a:
        n-=a
        a_cnt+=1
    elif n >= b:
        n-=b
        b_cnt+=1
    else:
        n-=c
        c_cnt+=1
        
if n!=0:
    print(-1)
else:
    print(a_cnt,b_cnt,c_cnt)
        