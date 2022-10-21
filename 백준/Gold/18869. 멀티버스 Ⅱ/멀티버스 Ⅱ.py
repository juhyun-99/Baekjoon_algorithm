import sys
import math
input = sys.stdin.readline

M, N = map(int, input().split())
ans = {}

for _ in range(M):
    planets = list(map(int, input().split())) #행성 입력받기
    sort_planets = sorted(list(set(planets))) #행성 중복을 제거하고 정렬해주기

    num_planets = {sort_planets[i] : i for i in range(len(sort_planets))} #정렬해준 행성들에 순서매겨주기

    str_planets = [str(num_planets[num]) for num in planets] #원래 입력받은 행성에 정렬해준 딕셔너리의 value를 가지고 순서를 써준다.
    num = str(''.join(str_planets)) #행성순서

    if num in ans:
        ans[num] += 1 #딕셔너리에 같은 행성순서가 있으면 +=1
    else:
        ans[num] = 1 #딕셔너리에 행성순서가 없으면 만들어주기


cnt = 0
for i in ans:
    if ans[i] >= 2:
        cnt += math.comb(ans[i], 2) # 몇 쌍인지 구하기
print(cnt)