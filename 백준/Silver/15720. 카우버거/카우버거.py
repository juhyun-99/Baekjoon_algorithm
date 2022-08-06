import sys
B,C,D = map(int,sys.stdin.readline().split())
blist = list(map(int,sys.stdin.readline().split()))
clist = list(map(int,sys.stdin.readline().split()))
dlist = list(map(int,sys.stdin.readline().split()))

blist.sort(reverse = True)
clist.sort(reverse = True)
dlist.sort(reverse = True)
set = min(B,C,D)
print(sum(blist)+sum(clist)+sum(dlist))

price = 0
for i in range(set):
    price += (blist[i]+clist[i]+dlist[i])*0.9
price+=sum(blist[set::])
price+=sum(clist[set::])
price+=sum(dlist[set::])

print(int(price))