stick = input()
stack = []
start = 0
cnt = 0 # 쪼개진 막대 갯수
while start < len(stick):
    if stick[start] == '(':
        if stick[start+1] !=')':
            stack.append('(') # 스택에 넣어준다.
            cnt+=1
        else: #레이저일 때
            cnt += len(stack)
    else :
        if stick[start-1] !='(':
            stack.pop()
    start+=1
    
print(cnt)