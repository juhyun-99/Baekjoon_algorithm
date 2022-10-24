import sys
input = sys.stdin.readline
K = int(input())

for i in range(1, K + 1):
    clas = list(map(int,input().split()))
    clas.remove(clas[0])
    clas.sort(reverse = True)
    print(f'Class {i}')
    ans = 0
  
    for j in range(len(clas)- 1):
        ans = max(ans, (clas[j] - clas[j+1]))
  
    print(f'Max {clas[0]}, Min {clas[-1]}, Largest gap {ans}')
