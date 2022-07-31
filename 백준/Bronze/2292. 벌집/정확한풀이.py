n = int(input())

num = 1
cnt = 1

#입력한 숫자가 num보다 작아지면 종료 
while n > num:
    num += 6*cnt
    cnt += 1
print(cnt)
