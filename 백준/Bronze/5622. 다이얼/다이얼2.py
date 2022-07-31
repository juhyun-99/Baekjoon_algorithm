a = input()
arr2 = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
cnt = 0
for elem in a:
    for i in range(len(arr2)):
      if elem in arr2[i]:
        cnt+=(i+3)
print(cnt)
  
