import sys

input = sys.stdin.readline

n = int(input())
arr1 = [0] + list(map(int, input().split()))
arr2 = [0] + list(map(int, input().split()))
s1 = [0] * (n + 1)
s2 = [0] * (n + 1)
dic = {}
ans = 0
for i in range(1, n + 1):
    s1[i] = arr1[i] + s1[i - 1]
    s2[i] = arr2[i] + s2[i - 1]
    tmp = s2[i] - s1[i]
    if tmp == 0:
        ans += 1
    ans += dic.get(tmp, 0)
    dic[tmp] = dic.get(tmp,0) + 1
    #print(i, ans)

# print(s1)
# print(s2)
print(ans)