import sys
input = sys.stdin.readline

arr = [True] * 1000001
arr[1] = False

#에라토스테네스
for i in range(2, int(1000000**0.5) + 1):
    if not arr[i]:
        continue
    for j in range(i*i,1000001,i):
        arr[j] = False

pr = ''
while True:
    n = int(input())
    if n == 0:
        break
    for k in range(3, n//2 + 1, 2):
        if arr[k] and arr[n - k]: #k도 True, n-k도 True이면
            print(f'{n} = {k} + {n - k}')
            break
print(pr)