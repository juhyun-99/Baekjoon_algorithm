for a in range(1, 101):
    for b in range(2, a + 1):
        for c in range(b + 1, a + 1):
            for d in range(c + 1, a + 1):
                if a*a*a == b*b*b + c*c*c + d*d*d:
                    print(f'Cube = {a}, Triple = ({b},{c},{d})')