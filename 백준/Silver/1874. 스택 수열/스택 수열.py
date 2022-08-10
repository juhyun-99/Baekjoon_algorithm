n = int(input())
stack = []
start = 0
arr=[]
tf = True
for _ in range(n):
    num = int(input())
    if num > start:
        for i in range(start,num):
            stack.append(i+1)
            arr.append('+')
        stack.pop()
        arr.append('-')
        start = num
    if num < start:
        if stack[-1] !=num:
            tf = False
        else:
            stack.pop()
            arr.append('-')

if tf ==False:
    print('NO')
else :
    print(*arr,sep='\n')
    