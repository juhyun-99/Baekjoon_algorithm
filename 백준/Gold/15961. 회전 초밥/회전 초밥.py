import sys

input = sys.stdin.readline

n, d, k, c = map(int, input().split())

arr = [int(input()) for _ in range(n)]

s, e = 0, 0
ans = 0
dic = {}
while s < n:
    tmp = e % n

    dic[arr[tmp]] = dic.get(arr[tmp], 0) + 1

    if e - s < k:
        e += 1

    elif e - s == k:
        dic[arr[s]] -= 1
        if dic[arr[s]] == 0:
            del dic[arr[s]]
        e += 1
        s += 1
        a = len(dic.keys())
        if dic.get(c, 0) == 0:
            a += 1
        ans = max(ans, a)
print(ans)
