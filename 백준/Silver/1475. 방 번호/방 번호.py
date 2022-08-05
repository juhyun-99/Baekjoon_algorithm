import math
n = input()
arr=[0]*10
for i in n:
    if int(i)==9:
        arr[6]+=1
        continue  
    arr[int(i)] +=1

a = arr[6]
del arr[6]

if max(arr) < math.ceil(a/2):
    print(math.ceil(a/2))
else:
    print(max(arr))