n = int(input())

def get_gcd(a, b):
    while a % b != 0:
        a, b = b, a % b
    return min(a, b)

for _ in range(n): #100개
    arr = list(map(int, input().split())) #100개
    ans = 0
    for i in range(len(arr) - 1):
        for j in range(i + 1, len(arr)):
            ans = max(ans ,get_gcd(max(arr[i],arr[j]),min(arr[i],arr[j])))
    print(ans)