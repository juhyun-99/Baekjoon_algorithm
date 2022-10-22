T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    D, A, B, F = map(int, input().split())
    time = D/(A+B)

    fly_B = D/(F + B)
    ans = F * fly_B

    ans += F * (time - fly_B)
    print(f"#{tc} {ans}")