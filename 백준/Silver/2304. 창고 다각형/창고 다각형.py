import sys
input = sys.stdin.readline
n = int(input())

arr = [0] * 1001
left = [0] * 1001
right = [0] * 1002
m_a = 0
for i in range(n):
    a, b = map(int,input().split())
    m_a = max(m_a, a)
    arr[a] = b

for i in range(1, m_a + 1):
    left[i] = max(left[i - 1], arr[i])
for i in range(m_a, 0, -1):
    right[i] = max(right[i + 1], arr[i])
ans = 0
for i in range(1, m_a + 1):
    ans += min(left[i], right[i])

print(ans)