T = int(input())

for i in range(T):
    a, b = map(int, input().split())

    top, bottom = 1,1
    for i in range(a, 0, -1):
        bottom *= i
    for i in range(b, b-a, -1):
        top *= i

    print(top//bottom)
