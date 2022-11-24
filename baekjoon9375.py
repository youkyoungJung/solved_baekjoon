#haedgear ; x, hat, turban 3 
#eyewear ; x, sun 2 

#3*2-1(1: 아무것도 안입은 상태)
#(hat)(turban)(sun)(hat, sun)(turban,sun)

for _ in range(int(input())):
    d = dict()
    for _ in range(int(input())):
        cloth, typ = input().split()
        if typ not in d:
            d[typ] = 1 
        else:
            d[typ] += 1

    result = 1
    for val in d.values():
        result *= val+1
    print(result-1)
