a = input()
arr = [11,2,3,4,5,6,7,8,9,10]
arr2 = ['','','ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
cnt = 0
for elem in a:
    for i in range(2,len(arr2)):
      if elem in arr2[i]:
        cnt+=arr[i]
print(cnt)