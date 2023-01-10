arr = []
for _ in range(9):
    arr.append(int(input()))
arr.sort()
#완전탐색 생각
#7중 for문 사용해서 7명의 난쟁이의 합 다 구하기 <- 비효율
#9명에서 2명의 키만 빼서 100이 되면 그걸 제외한 난쟁이 키만 출력하는 방법으로 생각
for i in range(9):
    tf = False
    for j in range(i + 1, 9):
        if sum(arr) - arr[i] - arr[j] == 100:
            num1, num2 = arr[i], arr[j]
            arr.remove(num1)
            arr.remove(num2)
            tf = True
            break
    if tf:
        break

print(*arr, sep='\n')