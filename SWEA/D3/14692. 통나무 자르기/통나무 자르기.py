
T = int(input())

for test_case in range(1, T + 1):
	l = int(input())
	ans=''
	if l%2==0:
		ans = 'Alice'
	else:ans = 'Bob'
	print(f'#{test_case} {ans}')
