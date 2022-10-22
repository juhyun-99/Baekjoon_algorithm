
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    s = input()
    ss = {}
    ans = "Yes"
    for i in s:
        ss[i] = ss.get(i, 0) + 1
    for i in ss.values():
        if i != 2:
            ans = "No"
            break

    print(f"#{tc} {ans}")