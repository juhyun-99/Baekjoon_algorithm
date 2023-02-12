import sys
input = sys.stdin.readline

n, x = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
cnt = 0

for i in range(n - 1, -1, -1):
    if arr[i] == x:
        cnt += 1
        arr.pop()
    else:
        break
# print(arr)
s, e = 0, len(arr) - 1
left = 0
while s <= e:
    if s == e:
        left += 1
        break
    tmp = arr[s] + arr[e]
    #print(s, e)
    if tmp * 2 >= x:
        e -= 1
        s += 1
        cnt += 1
    else:
        left += 1
        s += 1

print(cnt + left // 3)