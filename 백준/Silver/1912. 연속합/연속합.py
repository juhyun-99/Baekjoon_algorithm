import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
s = [0] * n
s[0] = arr[0]
for i in range(1, n):
    s[i] = max(s[i - 1] + arr[i] , arr[i])

#print(s)
print(max(s))