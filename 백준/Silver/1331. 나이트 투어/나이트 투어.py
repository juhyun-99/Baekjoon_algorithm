import sys
input = sys.stdin.readline
eng = ['A','B','C','D','E','F']
arr = [[0]*6 for _ in range(6)]
s_x = 0; s_y = 0

for _ in range(1):
    command = input().rstrip()
    for i in range(len(eng)):
        if command[0] == eng[i]:
            s_x = i
            s_y = 6 - int(command[1])
            arr[s_x][s_y] = 1
p_x = s_x; p_y = s_y

ans = True
for _ in range(35):
    command = input().rstrip()
    for i in range(len(eng)):
        if command[0] == eng[i]:
            if (abs(i-(p_x)) * abs((6-int(command[1])) - p_y)) == 2 and arr[i][6-int(command[1])] == 0:
                arr[i][6 - int(command[1])] = 1
                p_x = i
                p_y = 6-int(command[1])
            else:
                ans = False
                break
    if ans == False:
        break

if abs(p_x - s_x) * abs(p_y - s_y) != 2:
    ans = False
if sum(sum(arr,[])) !=36:
    ans = False

if ans:
    print('Valid')
else:
    print('Invalid')
