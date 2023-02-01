import sys
input = sys.stdin.readline
n,k = map(int,input().split())
arr = [0] + list(map(int,input().split()))

s = [0] * (n + 1)
cnt = 0
dic = {}

for i in range(1, n + 1):
    tmp = s[i - 1] + arr[i]
    cnt += dic.get(tmp - k, 0)
    s[i] = tmp
    if s[i] == k:
        cnt += 1
    dic[s[i]] = dic.get(s[i],0) + 1

print(cnt)