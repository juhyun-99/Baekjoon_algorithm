### 2차원 배열에서 행만 추출
```py
a = [[10, 20], [30, 40], [50, 60]]

b = [row[0] for row in a]
print(b) #[10, 30, 50]
```

### 리스트 컴프리핸션 전치행렬
```py
#list comprehension 전치행렬
listc = [[i for i in j] for j in zip(*lista)]
```
