import sys
input = sys.stdin.readline

n = int(input())
st = input().rstrip()
s, e = 0, 0
dic = {}
ans = 0
while e < len(st):
    dic[st[e]] = dic.get(st[e], 0) + 1
    tmp = len(dic.keys())

    if tmp <= n:
        ans = max(ans, e - s + 1)
        # print(e, s)

    elif tmp > n:
        dic[st[s]] -= 1
        if dic[st[s]] == 0:
            del dic[st[s]]
        s += 1
    e += 1

print(ans)
