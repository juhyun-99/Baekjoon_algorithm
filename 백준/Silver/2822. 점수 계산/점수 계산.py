arr = []
for i in range(8):
    num = int(input())
    arr.append([i+1, num])
arr.sort(key = lambda x : x[1])
s = 0
ans = []
for i in range(3,8):
    ans.append(arr[i][0])
    s += arr[i][1]

print(s)
ans.sort()
print(*ans, sep = ' ')
