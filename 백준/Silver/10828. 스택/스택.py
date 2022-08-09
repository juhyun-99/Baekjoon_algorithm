import sys
import re
N = int(input())
stack = []

for _ in range(N):
    s = sys.stdin.readline().strip()
    if len(s)>=6:
        stack.append(re.sub(r'[^0-9]', '', s))
    elif s=='pop':
        if len(stack)>0:
            print(stack[-1])
            del stack[-1]
        else: print(-1)
        
    elif s == 'size':
        print(len(stack))
      
    elif s == 'empty':
        if len(stack) == 0:
            print(1)
        else: 
            print(0)
        
    else:
        if len(stack)>0:
            print(stack[-1])
        else: print(-1)
