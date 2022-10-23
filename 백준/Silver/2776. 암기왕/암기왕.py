import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    N = int(input())
    arr1 = sorted(list(set(map(int, input().split()))))
    M = int(input())
    arr2 = list(map(int, input().split()))
    ans = {}
    for i in arr2:
        if i in ans:
            continue
        start = 0
        end = len(arr1) - 1
        ans_num = 0
        while start <= end:
            mid = (start + end) // 2
            if arr1[mid] == i:
                ans[i] = ans.get(i,0) + 1
                break
            elif arr1[mid] > i:
                end = mid - 1
            else:
                start = mid + 1
    for i in arr2:
        if i in ans:
            print(ans[i])
        else:
            print(0)