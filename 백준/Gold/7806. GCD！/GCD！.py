import sys
input = sys.stdin.readline

def f(num, di):
    for i in range(2, int(num ** 0.5) + 1):
        while num % i == 0:
            di[i] = di.get(i, 0) + 1
            num //= i
    if num != 1:
        di[num] = di.get(num, 0) + 1


while True:
    dic_n = {}
    dic_k = {}
    try:
        n, k = map(int, input().split())
        f(k, dic_k)
        #print(dic_k)
        ans = 1
        for i in dic_k:
            tmp = i
            while n >= tmp:
                dic_n[i] = dic_n.get(i, 0) + (n // tmp)
                tmp *= i
            #print(dic_n.get(i,0))
            if dic_n.get(i,0) == 0:
                continue
            ans *= i ** min(dic_n.get(i), dic_k[i])
    
        print(ans)
    except:
        break