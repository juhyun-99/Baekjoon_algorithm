import sys
input = sys.stdin.readline

n = int(input())
arr = map(int,input().split())
ans = {}

def f(n):
    global ans
    dic = {}
    for i in range(2, int(n ** 0.5) + 1):
        while n % i == 0:
            dic[i] = dic.get(i,0) + 1
            ans[i] = ans.get(i,0) + 1
            n //= i

    if n != 1:
        dic[n] = dic.get(n,0) + 1
        ans[n] = ans.get(n, 0) + 1
    return dic

arr2 = []
num = 1
for i in arr:
    arr2.append(f(i))

for i in ans:
    ans[i] //= n

    num *= (i**ans[i])
# print(ans)
# print(num)
cnt = 0
for dic in arr2:
    for j in ans:
        tmp = dic.get(j,0)
        if tmp < ans[j]:
            cnt += (ans[j] - tmp)

print(num, cnt)