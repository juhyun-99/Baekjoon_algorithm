import sys
input = sys.stdin.readline

num = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
arr = []
a = input().rstrip()
b = input().rstrip()
for i in range(len(a)):
    arr.append(num[ord(a[i]) - 65])
    arr.append(num[ord(b[i]) - 65])

l = len(a) * 2

while l != 2:
    n = []
    for i in range(l - 1):
        n.append((arr[i] + arr[i + 1]) % 10)
    l -= 1
    arr = n
n = map(str, n)
print(''.join(n))