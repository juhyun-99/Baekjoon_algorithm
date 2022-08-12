T = int(input())
for _ in range(T):
    arr = input()
    arr+=' '
    stack=[]
    for i in arr:
        if i!=' ':
            stack.append(i)
        else:
            while stack:
                print(stack.pop(),end='')
            print(' ',end='')