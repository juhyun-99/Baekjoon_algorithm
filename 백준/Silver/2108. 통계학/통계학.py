from collections import Counter
import sys
n = int(input())
arr=[]

for i in range(n):
    num = int(sys.stdin.readline())
    arr.append(num)

print(round(sum(arr)/n))
arr.sort()
print(arr[n//2])

mode = Counter(arr).most_common()
mode_value = 0

if len(mode) == 1:
    mode_value = mode[0][0]
elif mode[0][1] == mode[1][1]:
    mode_value = mode[1][0]
else:
    mode_value = mode[0][0]

print(mode_value)
print(max(arr)-min(arr))