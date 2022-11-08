for tc in range(1, 11):
    T = int(input())
    s = input().rstrip()
    ss = input().rstrip()
    cnt = ss.count(s)

    print(f'#{T} {cnt}')