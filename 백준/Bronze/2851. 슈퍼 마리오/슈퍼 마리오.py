arr = []
for _ in range(10):
    arr.append(int(input()))

ans = 0
#완전탐색 생각
for i in arr:
    ans += i
    if ans >= 100:
        if abs(ans - 100) > abs((ans - i) - 100): #무엇이 더 100이랑 가까운지 구하기
            ans -= i
        break

print(ans)