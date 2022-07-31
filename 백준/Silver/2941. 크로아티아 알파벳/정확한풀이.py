s = input()
arr = ['c=','c-','dz=','d-','lj','nj','s=','z=']

for i in arr:
    s = s.replace(i,'*')

print(len(s))
