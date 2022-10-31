T = int(input())

for tc in range(1, T + 1):
    P, Q, R, S, W = map(int, input().split())

    a_price = W * P
    b_price = 0
    if W < R:
        b_price = Q
    elif W > R:
        b_price = Q + (W - R) * S
    ans = min(a_price, b_price)
    print(f'#{tc} {ans}')