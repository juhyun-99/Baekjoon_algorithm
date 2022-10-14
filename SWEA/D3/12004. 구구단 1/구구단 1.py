T = int(input())

for test_case in range(1, T + 1):
    TC = int(input())
    ans = 'No'
    arr = []
    
    for i in range(1, 10):
        if TC % i == 0:
            arr.append(i)
    for i in arr:
        if 1 <= i <= 9:
            if 1 <= TC // i <= 9:
                ans = 'Yes'
                break
    
    print(f"#{test_case} {ans}")