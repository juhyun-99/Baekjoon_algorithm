import math
sosu = []

def issosu(i):
    if i < 2:
        return False
    for j in range(2, int(math.sqrt(i)) + 1):
        if i % j == 0:
            return False
    return True

for i in range(2, 1000000): #100만 이하의 모든 소수 구하기
    if issosu(i):
        sosu.append(i)

n = int(input())
for _ in range(n): #입력받은 숫자와 100만 이하의 소수로 나누어 떨어지는지 계산
    ans = "YES"
    s = int(input())
    for num in sosu:
        if s % num == 0:
            ans = "NO"
            break
    print(ans)

