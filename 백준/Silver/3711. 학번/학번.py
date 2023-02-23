import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    g = int(input())
    arr = [int(input()) for _ in range(g)]
    for i in range(1, 999999):
        tmp = []
        for j in range(g):
            tmp.append(arr[j] % i)

        if g == len(set(tmp)):
            print(i)
            break