import sys
input = sys.stdin.readline

x, y = map(int, input().split())
x_arr = [0]
y_arr = [0]

n = int(input())
for _ in range(n):
    num, p = map(int, input().split())
    if num == 0:
        y_arr.append(p)
    else:
        x_arr.append(p)
x_arr.append(x)
y_arr.append(y)
x_arr.sort(reverse = True)
y_arr.sort(reverse = True)

x_ans = []
y_ans = []
for i in range(len(x_arr) - 1):
    x_ans.append(x_arr[i] - x_arr[i + 1])
for i in range(len(y_arr) - 1):
    y_ans.append(y_arr[i] - y_arr[i + 1])

print(max(x_ans)*max(y_ans))

