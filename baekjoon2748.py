n = int(input())

# def fib(n):
#         if n == 0:
#             return 0
#         elif n == 1:
#             return 1
#         return fib(n-1)+fib(n-2)

init_list = [0]*(n+1)
init_list[1] = 1

for i in range(2, n+1):
    init_list[i] = init_list[i-1] + init_list[i-2]
print(init_list[n])
