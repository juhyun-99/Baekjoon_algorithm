import sys
input = sys.stdin.readline
t = int(input())

for _ in range(t):
    k, n = map(int, input().split())  # 특정값, 학생수
    c1 = list(map(int, input().split()))
    c2 = list(map(int, input().split()))
    c3 = list(map(int, input().split()))
    c4 = list(map(int, input().split()))
    arr1 = []
    arr2 = []
    for i in range(n):
        for j in range(n):
            arr1.append(c1[i] + c2[j])
            arr2.append(c3[i] + c4[j])

    arr1.sort()
    arr2.sort()
    start = 0
    end = len(arr2) - 1
    ans = 1e9
    cnt = 1e9
    while start < len(arr1) and end >= 0:
        tmp = arr1[start] + arr2[end]
        a = abs(k - tmp)

        if a < cnt:
            ans = tmp
            cnt = a

        elif a == cnt:
            if ans > tmp:
                ans = tmp

        if tmp > k:
            end -= 1

        elif tmp < k:
            start += 1

        else:
            break
    print(ans)
