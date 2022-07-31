s = input()
arr = ['c=','c-','dz=','d-','lj','nj','s=','z=']
cnt = 0

for i in range(len(arr)):
    cnt+=s.count(arr[i])
    if arr[i] in s:
        s = s.replace(arr[i],' ')
s = s.replace(' ','')
cnt += len(s)

print(cnt)