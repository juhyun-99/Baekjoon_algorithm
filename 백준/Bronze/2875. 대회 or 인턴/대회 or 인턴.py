#대회 : 여2 남1 원칙
#k명은 인턴쉽 반드시 참여해야함
#많은 팀 만드는 것이 최선

n, m, k = map(int, input().split())#여, 남, 인턴쉽 인원
#완탐생각
cnt = 0
ans = 0
for i in range(0, k + 1):
    #여학생이 i명 인턴으로 참여
    new_g = n - i #남은 여학생 수
    new_b = m - (k - i) #남은 남학생 수

    ans = max(ans, min(new_g//2, new_b))

print(ans)