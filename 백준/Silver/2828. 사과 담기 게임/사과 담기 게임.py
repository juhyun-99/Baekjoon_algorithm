n,m = map(int,input().split())
apple = int(input())
start,end = 1,m

move=0
for i in range(apple):
    index = int(input())
    if index<start:
        end -=(start-index)
        move +=(start-index)
        start = index

    if index>end:
        start+=(index-end)
        move += (index-end)
        end = index


print(move)
  