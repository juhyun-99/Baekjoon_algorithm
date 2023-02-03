import sys
input = sys.stdin.readline
'''
S가 들어오면 +2
K가 들어오면 -1
'''


stri = [''] + list(input().rstrip()) #입력받은 문자열

S = [0] * len(stri) #누적합 구할 배열
dic = {} #누적합의 첫 인덱스를 저장할 딕셔너리

ans = -1 #정답
sc = [0] * len(stri)
kc = [0] * len(stri)
for i in range(1, len(stri)):
    if stri[i] == 'S':
        S[i] = S[i - 1] + 2
        sc[i]  = sc[i - 1] + 1
        kc[i] = kc[i - 1]

    elif stri[i] == 'K':
        S[i] = S[i - 1] - 1
        sc[i] = sc[i - 1]
        kc[i] = kc[i - 1] + 1

    else:
        S[i] = S[i - 1]
        sc[i] = sc[i - 1]
        kc[i] = kc[i - 1]

    if S[i] == 0:
        if sc[i] > 0 and kc[i] > 0:
            ans = max(ans, i)
    else:
        if dic.get(S[i], 0) != 0:
            tmp = dic[S[i]]
            if sc[i] - sc[tmp] > 0 and kc[i] - kc[tmp] > 0:
                ans = max(ans, i - tmp)

    if kc[i] > 0 or sc[i] > 0:
        if dic.get(S[i], 0) == 0:
            dic[S[i]] = i

#print(dic)
print(ans)
