import sys
input = sys.stdin.readline
n,k,b = map(int,input().split())
start = 1
end = 1
arr = [1] * (n + 1)
for _ in range(b):
    arr[int(input())] = 0
#print(arr)
ans = 100001
cnt = 0
cnt_b = 0 #부서진 것 개수
while end <= n:
    tmp = end - start + 1
    if arr[end] == 0:
        cnt += 1

    if  tmp == k:
        #print(start, end, cnt)
        ans = min(ans, cnt)
        if arr[start] == 0:
            cnt -= 1
        start += 1
        end += 1

    elif tmp < k:
        end += 1

    else: # cnt > k
        if arr[start] == 0:
            cnt -= 1
        start += 1
print(ans)