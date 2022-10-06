import sys
input = sys.stdin.readline

n, m = map(int, input().split())
alpha = [0] * m
DNA = []
for _ in range(n):
    dna = input().strip()
    DNA.append(dna)
dic = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
cnt = m * n
for i in range(m):
    for j in range(n):
        if DNA[j][i] == 'A':
            dic['A'] += 1
        elif DNA[j][i] == 'C':
            dic['C'] += 1
        elif DNA[j][i] == 'G':
            dic['G'] += 1
        else:
            dic['T'] += 1
    alpha[i] = max(dic, key = dic.get)
    if dic['A'] == n or dic['C'] == n or dic['G'] == n or dic['T'] == n:
        cnt -= n
    else:
        cnt -= dic[max(dic, key = dic.get)]
    dic['A'], dic['C'], dic['G'], dic['T'] = 0, 0, 0, 0

print(*alpha,sep = '')
print(cnt)
