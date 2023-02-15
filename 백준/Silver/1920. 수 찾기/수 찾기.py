#binary_search
n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))
#a 정렬
a = sorted(a)

for i in range(m):
    target = b[i]

    start = 0 #인덱스 설정
    end = n-1
    result = 0
    while start <= end:
        mid = (start+end)//2
        if a[mid] == target:
            result = 1
            break
        elif a[mid] < target:
            start = mid + 1
        else:
            end = mid-1
    print(result)