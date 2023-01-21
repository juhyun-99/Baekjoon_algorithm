c = int(input())
#기울기가 달라야함

def get_gcd(a,b):
    while a % b != 0:
        a, b = b, a % b
    return b

arr = [0] * 1001
arr[1] = 3

for i in range(2, 1001):
    cnt = 0
    for j in range(1, i + 1):
        if get_gcd(i, j) == 1:
            cnt += 1
    arr[i] = arr[i - 1] + cnt * 2

for _ in range(c):
    print(arr[int(input())])