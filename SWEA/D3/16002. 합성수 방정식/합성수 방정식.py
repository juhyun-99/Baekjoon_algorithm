def is_prime(n):
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


tc = int(input())
for t in range(1, tc + 1):
    num = int(input())

    for k in range(num, 1000000001):
        if not is_prime(k) and not is_prime(k-num):
            print(f'#{t} {k} {k-num}')
            break