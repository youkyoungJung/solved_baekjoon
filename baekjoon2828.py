import sys
input = sys.stdin.readline

n,m = map(int, input().split())
j = int(input())

s_basket = 1
e_basket = m

move = 0

for _ in range(j):
    apple = int(input())


    #사과가 바구니시작 앞
    if apple < s_basket:
        #move += abs(apple - s_basket)
        move += (s_basket-apple)
        s_basket = apple
        e_basket = (apple + m - 1) #바구니끝 재배열
        print("apple<s_basket: move, s, f :",move, s_basket, e_basket )
    #사과가 바구니끝 보다 뒤
    elif apple > e_basket:
        #move += abs(apple - f_basket)
        move += (apple - e_basket)
        e_basket = apple
        s_basket = (e_basket - m + 1)
        print("apple>s_basket: move ,s, f :",move, s_basket, e_basket )
    
print(move)

