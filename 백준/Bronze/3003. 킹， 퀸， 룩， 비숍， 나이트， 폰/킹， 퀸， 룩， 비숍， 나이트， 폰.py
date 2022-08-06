arr = [1,1,2,2,2,8]
arr2 = list(map(int,input().split()))
arr3=[]
for i in range(len(arr)):
    arr3.append(arr[i]-arr2[i])

print(*arr3)