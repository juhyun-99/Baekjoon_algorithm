import sys

input = sys.stdin.readline

def factorization(x):
    for i in range(2, int(x ** 0.5) + 1):
        while x % i == 0:
            div.append(i)
            x //= i
    if x != 1:
        div.append(x)


for t in range(int(input())):
    n, k = map(int, input().split())

    tmp = 0
    number = k + 0
    div = []

    # k를 소인수분해하기
    factorization(k)

    #print(div)
    div2 = list(set(div))
    # 소인수 분해한걸 배열에 담아서 하나씩 계산해주기
    answer = []

    for a in range(len(div2)):
        t = div2[a]
        tmp = 0
        while n >= t:
            tmp += n//t
            t*=div2[a]
        #print(tmp)

        #print(div.count(div2[a]))
        answer.append(tmp//div.count(div2[a]))

    print(min(answer))
