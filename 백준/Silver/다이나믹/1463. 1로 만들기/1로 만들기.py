import sys;input = sys.stdin.readline
N = int(input())
cache = {1: 0, 2: 1} #리스트 대신에 딕셔너리를 사용해 연산 속도 줄이기

def dp(n):
    #n이 캐시에 있는 경우 값을 반환
    if n in cache:
        return cache[n]
	
    #3,2로 나눈 몫에 나머지를 더해서 최솟값을 구한다.
    #나머지를 더하는 이유는
    # 11인 경우 3으로 나눌 때 2을 먼저 빼고 나눠야 하기 때문에 나머지인 2를 더한다(1을 두번 뺀다).
    cnt = 1 + min(dp(n//3) + n%3, dp(n//2) + n%2)
    cache[n] = cnt
    return cnt
    
print(dp(N)) 
