S = input()+' '
S = list(S)
stack=[]
i = 0
while i<len(S):
    if S[i]=='<':
        if stack:
            while stack:
                print(stack.pop(),end='')
        print(*S[i:S.index('>')+1],sep='',end='')
        del S[i:S.index('>')+1]
    elif S[i] != ' ' and S[i] != '<' and S[i] != '>':
        stack.append(S[i])
        i+=1
    elif S[i] == ' ':
        if stack:
            while stack:
                print(stack.pop(),end='')
            print(' ',end='')
        i+=1