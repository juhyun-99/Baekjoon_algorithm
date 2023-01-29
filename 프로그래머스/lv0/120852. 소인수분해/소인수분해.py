

def solution(n):
    answer = []
    for i in range(2,int(n ** 0.5) + 1):
        while n % i == 0:
            n //= i
            answer.append(i)
    
    if n != 1:
        answer.append(n)
    answer = list(set(answer))
    answer.sort()
    return answer

