n, t = map(int, input().split())
answer = []
for i in range(n):
    s, l, c = map(int, input().split())
    bus = [s+(l*i) for i in range(c)]
    #print(bus)
    if bus[-1] < t:
        continue
    start = 0 #인덱스 지점
    end = c-1
    result = 0 #찾은 결과 인덱스
    while start<=end:
        mid = (start+end)//2
        #print(mid)
        if bus[mid] >= t:
            result = mid
            end = mid-1
        else:
            start = mid+1
    answer.append(bus[result]-t)
if answer:
    print(min(answer))
else:
    print(-1)