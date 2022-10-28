for _ in range(10):
    s_len = int(input())
    cnt = 0
    arr = [list(input()) for _ in range(8)]
    # 가로
    for i in arr:
        end = 0
        li = []
        while end < 8:
            li.append(i[end])
            end+=1

            if len(li) == s_len:
                if li == li[::-1]:
                    cnt += 1
                del li[0]
    # 세로
    for i in range(8):
        end = 0
        li = []
        while end < 8:
            li.append(arr[end][i])
            end += 1
            if len(li) == s_len:
                if li == li[::-1]:
                    cnt += 1
                del li[0]
    print(f'#{_ + 1} {cnt}')

