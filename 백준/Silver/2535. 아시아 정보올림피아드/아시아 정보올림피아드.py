import sys
input = sys.stdin.readline
arr = []
n = int(input())
for _ in range(n):
    arr.append(list(map(int,input().split())))

arr.sort(key = lambda x : x[2], reverse = True)
dic = {}
cnt = 0
for i in arr:
    if dic.get(i[0], 0) == 2:
        continue
    else:
        dic[i[0]] = dic.get(i[0],0)+1
        print(i[0], i[1])
        cnt+=1
    if cnt==3:
        break
