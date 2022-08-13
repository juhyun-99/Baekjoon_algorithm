def fac(num):
    if num <= 1:
        return 1
    else:
        return num*fac(num-1)

N = int(input())
nf = str(fac(N))
cnt = 0
for i in range(len(nf)-1,-1,-1):
    if nf[i] =='0':
        cnt+=1
    else:
        break

print(cnt)