from collections import defaultdict

n = int(input())
s = list(map(str, input().split()))

#person = dict()
person = {string : 0 for string in s}

for _ in range(n):
    info = list(input().split())
    for i in info:
        person[i] += 1

# for i in info:
#     if i in person:
#         person[i] += 1
#     else:
#         person[i] = 1

#value값을 기준으로 오름차순 정렬한 딕셔너리
#x[1] : 값을 기준으로 정렬하겠다. x[0]: 키값 기준 정렬
#reverse = True => 내림차순 정렬
sort_dict = sorted(person.items(), key=lambda x:x[1], reverse=True) 

for key, value in sort_dict:
    print(key, value)

