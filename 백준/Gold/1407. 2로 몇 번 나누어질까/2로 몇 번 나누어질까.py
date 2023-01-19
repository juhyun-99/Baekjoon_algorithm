
a, b = map(int, input().split())

def cnt(num):
    if num == 0:
        return 0
    
    elif num == 1:
        return 1

    elif num % 2 == 0: # 짝수일 때 1의 개수는 num//2개 + f(num // 2) * 2
        return cnt(num//2) * 2 + num // 2

    elif num % 2 == 1: #홀수일 때 f(num - 1) + 1개
        return cnt(num - 1) + 1

print(cnt(b) - cnt(a - 1))