h = int(input())
arr = [1,0]

if h <= 1:
    print(arr[h])
else:
    if h%2==0:
        print('8'*(h//2))
    else:
        print('4',end='')
        print('8'*((h-1)//2))