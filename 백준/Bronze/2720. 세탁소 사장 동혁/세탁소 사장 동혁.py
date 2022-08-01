T = int(input())
for i in range(T):
    n = int(input())
    q = n//25
    d = (n%25)//10
    ni = ((n%25)%10)//5
    p = (((n%25)%10)%5)//1
    
    print(q,d,ni,p)