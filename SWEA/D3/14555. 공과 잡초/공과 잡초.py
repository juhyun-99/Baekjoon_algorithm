T = int(input())
 
for test_case in range(1, T + 1):
    s = input()
    ans = 0
    for i in range(len(s)-1):
        if s[i] =='(' and (s[i+1] =='|' or s[i+1] ==')'):
            ans +=1
        elif s[i] =='|' and s[i+1] ==')':
            ans+=1
       
    print(f'#{test_case} {ans}')
