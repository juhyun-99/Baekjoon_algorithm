from itertools import permutations
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    n = input()
    num = int(n)
    length = len(n)
    num_list = []
    check = 0
    
    if len(n) == 1:
        print(f'#{tc} impossible')
        continue
 
    for i in permutations(n):
        temp = ''
        for j in i:
            temp += j
        if temp[0] != '0':
            if int(temp) not in num_list:
                num_list.append(int(temp))
 
    for i in range(1, len(num_list)):
        if num_list[i] % num_list[0] == 0:
            check = 1
            break
 
    if check == 1:
        print(f'#{tc} possible')
    else:
        print(f'#{tc} impossible')