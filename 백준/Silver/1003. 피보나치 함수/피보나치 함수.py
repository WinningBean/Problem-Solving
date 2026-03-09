value = [int(input()) for _ in range(int(input()))]
result = [[1,0]]
for i in range(max(value)):
    result.append([result[i][1],sum(result[i])])
for i in value:
    print(result[i][0], result[i][1])