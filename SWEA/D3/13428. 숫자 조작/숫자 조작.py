T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    N = input()
    if len(N) == 1:
        print(f"#{tc} {N} {N}")
        continue
    ans = [N]
    arr = list(N)
    for i in range(len(N) - 1):
        for j in range(i + 1, len(N)):
            arr[i], arr[j] = arr[j], arr[i]
            s = ''.join(arr)
            if s[0] == '0':
                arr[i], arr[j] = arr[j], arr[i]
                continue
            ans.append(s)
            arr[i], arr[j] = arr[j], arr[i]
    ans.sort()


    print(f"#{tc} {ans[0]} {ans[-1]}")