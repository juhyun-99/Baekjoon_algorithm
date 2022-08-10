import sys
T=int(input())
for _ in range(T):
    s = sys.stdin.readline().strip()
    stack=[]
    tf = True
    if len(s)%2 == 1:
        print('NO')
        continue
    else:
        for i in s:
            if i=='(':
                stack.append('(')
            else :
                if len(stack)>0:
                    stack.pop()
                else:
                    tf = False
            
    if len(stack)!=0 or tf == False:
        print('NO')
    else :
        print('YES')
      