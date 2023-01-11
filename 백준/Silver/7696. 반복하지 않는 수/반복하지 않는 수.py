import sys
input = sys.stdin.readline
i = 1
arr = []
while len(arr) < 1000000:
    tf = True
    check = [False] * 10

    for s in str(i):
        if check[int(s)] == False:
            check[int(s)] = True
        else:
            tf = False
            break
    if tf:
        arr.append(i)
    i += 1

while True:
    n = int(input())
    if n == 0:
        exit()
    print(arr[n - 1]) #0 ~ 1000000