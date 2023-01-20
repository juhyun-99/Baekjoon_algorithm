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
    num.sort(reverse = True)

    ans = 0
    for i in num: #큰 약수부터 돌림 왜? - num//약수개 만큼 숫자가 남는데 약수가 클수록 합치는 횟수가 많다
        tmp = s // i  # 원소들의 합이 되어야할 값
        arrsum = 0  # 원소들의 합
        tf = True

        for j in range(n):
            arrsum += arr[j]
            if arrsum > tmp:
                tf = False
                break

            elif arrsum == tmp:
                arrsum = 0

        if tf:
            ans = n - i
            break

    print(ans)