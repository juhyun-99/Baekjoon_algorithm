import sys
input = sys.stdin.readline

def f(n): #배열의 합의 약수 구하기
    num = []
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            num.append(i)
            if i * i != n:  # 제곱수 예외 처리
                num.append(n // i)
    return num

t = int(input())  # 1 ~ 10개
for ss in range(t):
    n = int(input())  # 수업기간 1~100000
    arr = list(map(int, input().split()))

    s = sum(arr) # 배열의 합
    num = f(s) # 합의 약수 배열
    num.sort()

    ans = 0
    for i in num:
        arrsum = 0
        tf = True

        for j in range(n):
            arrsum += arr[j]
            if arrsum > i:
                tf = False
                break

            elif arrsum == i:
                arrsum = 0

        if tf:
            ans = n - (s//i)
            break

    print(ans)