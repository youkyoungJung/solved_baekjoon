n = int(input())

start = 0 #지수 인덱스
end = int((2**63)**(0.5))+1
target = 0
while start <= end:
    mid = (start+end)//2

    if n > mid**2:
        start = mid + 1
    elif n <= mid**2:
        target = mid
        end = mid - 1
print(target)