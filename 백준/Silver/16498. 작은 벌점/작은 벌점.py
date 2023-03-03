import sys

input = sys.stdin.readline

ac, bc, cc = map(int, input().split())
a = sorted(list(map(int, input().split())))
b = sorted(list(map(int, input().split())))
c = sorted(list(map(int, input().split())))


def search(i, arr):
    start = 0
    end = len(arr) - 1
    cnt = 1e19
    tmp = 0
    while start <= end:
        mid = (start + end) // 2

        if abs(i - arr[mid]) < cnt:
            cnt = abs(i - arr[mid])
            tmp = arr[mid]

        if arr[mid] == i:
            tmp = i
            break

        elif arr[mid] > i:
            end = mid - 1

        else:
            start = mid + 1
    return tmp


ans = 1e19
for i in a:
    j = search(i, b)
    k = search(i, c)
    ans = min(ans, abs(max(i, j, k) - min(i, j, k)))

for i in b:
    j = search(i, a)
    k = search(i, c)
    ans = min(ans, abs(max(i, j, k) - min(i, j, k)))

for i in c:
    j = search(i, a)
    k = search(i, b)
    ans = min(ans, abs(max(i, j, k) - min(i, j, k)))
print(ans)
