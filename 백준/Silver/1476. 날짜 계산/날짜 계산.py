earth,sun,moon = map(int,input().split())
year = 1
while True:
    if (year-earth)%15==0 and (year-sun)%28==0 and (year-moon)%19==0:
        break
    year+=1

print(year)