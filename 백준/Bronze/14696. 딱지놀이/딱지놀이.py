import sys
input = sys.stdin.readline
N = int(input())

for _ in range(N):
    a_arr = list(map(int, input().split()))[1:]
    b_arr = list(map(int, input().split()))[1:]
    win = 'D'
    for i in range(4, 0, -1):
        if a_arr.count(i) > b_arr.count(i):
            win = 'A'
            break
        elif a_arr.count(i) < b_arr.count(i):
            win = 'B'
            break
        else:
            continue
    print(win)