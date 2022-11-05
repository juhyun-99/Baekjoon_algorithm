n = int(input())

nums = []
s = []
b = []


for _ in range(n):
    num, ss, bb = map(int, input().split())
    tmp = []
    for i in str(num):
        tmp.append(int(i))
    nums.append(tmp)
    s.append(ss)
    b.append(bb)


def check(arr):
    for i in range(n):
        chk_s = 0
        chk_b = 0
        for j in range(3):
            for k in range(3):
                if arr[j] == nums[i][k]:
                    if j == k:
                        chk_s += 1 #숫자와 인덱스가 같을 때
                    else:
                        chk_b += 1
        if chk_s != s[i] or chk_b != b[i]:
            return False
    return True


# 여기 시점에선 입력 완료

cnt = 0
for i in range(1, 10):
    for j in range(1, 10):
        if i == j:
            continue
        for k in range(1, 10):
            if i == k or j == k:
                continue
            cur_number = []
            cur_number.append(i)
            cur_number.append(j)
            cur_number.append(k)

            if check(cur_number):
                cnt += 1
print(cnt)
# 123
# 123 1 0
# num[0][0] = 1, num[0][1] = 2, num[0][3] = 3, s[0] = 1, b[0] = 0