T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for tc in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    cnt = 0
    for i in range(N-2):
        s = arr[i:i + 3]
        if (s[1]-s[0])*(s[1]-s[2]) < 0:
            cnt+=1
    print(f"#{tc} {cnt}")