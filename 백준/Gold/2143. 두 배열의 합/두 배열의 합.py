import sys

input = sys.stdin.readline

t = int(input())
n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))
dic1 = {}
dic2 = {}
for i in range(n):
    for j in range(i, n):
        dic1[sum(arr1[i:j + 1])] = dic1.get(sum(arr1[i:j + 1]), 0) + 1
for i in range(m):
    for j in range(i, m):
        dic2[sum(arr2[i:j + 1])] = dic2.get(sum(arr2[i:j + 1]), 0) + 1
ans = 0
#
# print(dic1)
# print(dic2)
for i in dic1:
    if t - i in dic2.keys():
        ans += dic1[i] * dic2[t - i]

print(ans)
