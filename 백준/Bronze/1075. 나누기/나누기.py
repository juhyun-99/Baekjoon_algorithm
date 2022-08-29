N = input()
nn = N[0:-2]+'00'
F = int(input())
nn = int(nn)
while nn%F!=0:
    nn+=1

nn=str(nn)
print(nn[-2:])