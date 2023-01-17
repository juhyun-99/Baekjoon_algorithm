def sosu(num):
    if num == 1:
        return False

    cnt = 0
    for i in range(1, int(num ** 0.5) + 1):
        if num % i == 0:
            cnt += 1
    if cnt == 1:
        return True
    else:
        return False


n = list(input())
not_num = ['3','4','7']

for i in not_num:
    if i in n:
        print('no')
        exit()
first_num = int(''.join(n))

if not sosu(first_num):
    print('no')
    exit()

back_n = n[::-1]

for i in range(len(back_n)):
    if back_n[i] == '6':
        back_n[i] = '9'
    elif back_n[i] == '9':
        back_n[i] = '6'

new_num = int(''.join(back_n))

if sosu(new_num):
    print('yes')
else:
    print('no')