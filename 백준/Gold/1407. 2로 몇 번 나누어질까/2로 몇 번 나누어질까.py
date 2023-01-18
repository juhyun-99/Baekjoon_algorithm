'''
f(b) = f(1) + f(2) + .... f(b)
f(a-1) = f(1) + f(2) + ...f(a-1)
f(b) - f(a-1) = f(a) + f(a+1) ...f(b)
f(홀수) = 1
f(1) = 1, f(2) = 2, f(3) = 1, f(4) = 4, f(5) = 1, f(6) = 2, f(7) = 1
f(8) = 8, f(9) = 1, f(10) = f(5) + 1
cnt(2) = f(1) + f(2) = 3 = f(1) + f(1) * 2
cnt(3) = f(1) + f(2) + f(3) = f(1) + f(1) * 2 + 1
cnt(4) = f(1) + f(2) + f(3) + f(4) = f(1) + f(1) * 2 + 1 + f(1) * 2 * 2 = 2 + 2 ( f(1) + f(1) * 2 ) = 2 + 2 * (cnt(2))
cnt(짝수) = cnt(짝수 // 2) * 2 + 짝수 // 2
'''

a, b = map(int, input().split())

def cnt(num):
    if num == 0:
        return 0

    elif num == 1:
        return 1

    elif num % 2 == 0: # 짝수일때 1의 개수는 num//2개 + f(num // 2) * 2
        return cnt(num//2) * 2 + num // 2

    elif num % 2 == 1: #홀수 일 때 f(num - 1) + 1개
        return cnt(num - 1) + 1

print(cnt(b) - cnt(a - 1))