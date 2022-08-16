N,A,B = map(int,input().split())
for i in range(1,11):
    X,Y = map(int,input().split())
  
    A += X*3 
    if Y>=6-X:
        B += X*3+3*(6-X)
    else :
        B += X*3+3*Y

    if N+i<=8 and A>=66 and B>=130:
        print('Nice')
        exit()
        break

print("Nae ga wae")