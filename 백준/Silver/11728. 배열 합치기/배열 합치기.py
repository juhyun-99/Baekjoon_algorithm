import sys
input= sys.stdin.readline

n,m = map(int,input().split())
arr1 = list(map(int,input().split()))
arr2 = list(map(int,input().split()))
num1,num2 = 0,0
while num1 < n and num2 < m:
    if arr1[num1] <= arr2[num2]:
        print(arr1[num1],end =' ')
        num1 += 1

    else:
        print(arr2[num2],end = ' ')
        num2 += 1

if num1 != n:
    print(*arr1[num1 : ],sep=' ')
else:
    print(*arr2[num2:], sep=' ')

