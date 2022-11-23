#덱 - 스택과 큐의 성질 모두 가짐
#이중 연결리스트 이용
#prev <- node ->next
#data    data   data
import sys
input = sys.stdin.readline

# class Node:
#     def __init__(self, data) -> None:
#         self.data = data
#         self.prev = None
#         self.next = None

# class Deque:
#     def __init__(self) -> None:
#         self.size = 0
#         self.start = None
#         self.end = None
    
#     def push_front(self, data):
#         self.size += 1
#         node = Node(data)
#         if not self.start:
#             self.start = self.end = node
#             return
#         self.start.prev = node
#         node.next = self.start
#         self.start = node

#     def push_back(self,data):
#         self.size += 1
#         node = Node(data)
#         if not self.start:
#             self.start = self.end = node
#             return
#         self.end.next = node
#         node.prev = self.end
#         self.end = node

#     def pop_front(self):
#         if not self.start:
#             return -1
#         self.size -= 1
#         tmp = self.start
#         self.start = self.start.next
#         if not self.start:
#             self.end = None
#         else:
#             self.start.prev = None
#         ret = tmp.data
#         del tmp
#         return ret


#     def pop_back(self):
#         if not self.start:
#             return -1
#         self.size -= 1
#         tmp = self.end
#         self.end = self.end.prev
#         if not self.end:
#             self.start = None
#         else:
#             self.end.next = None
#         ret = tmp.data
#         del tmp
#         return ret

#     def empty(self):
#         return +(not self.start)

#     def front(self):
#         return self.start.data if self.start else -1

#     def back(self):
#         return slef.end.data if self.end else -1
# deq = Deque()
# n = int(input())

# for _ in range(n):
#     qry = input().split()
#     if qry[0] == 'push_back':
#         deq.push_back(qry[1])
#     elif qry[0] == 'push_front':
#         deq.push_front(qry[1])
#     elif qry[0] == 'pop_back':
#         print(deq.pop_back())
#     elif qry[0] == 'pop_front':
#         print(deq.pop_front())
#     elif qry[0] == 'size':
#         print(deq.size())
#     elif qry[0] == 'empty':
#         print(deq.empty())
#     elif qry[0] == 'front':
#         print(deq.front())
#     else:
#         print(deq.back())

from collections import deque
import sys
input = sys.stdin.readline

deq = deque()
n = int(input())

for _ in range(n):
    qry = input().split()
    if qry[0] == 'push_back':
        deq.append(qry[1])
    elif qry[0] == 'push_front':
        deq.appendleft(qry[1])
    elif qry[0] == 'pop_back':
        print(deq.pop() if deq else -1)
    elif qry[0] == 'pop_front':
        print(deq.popleft() if deq else -1)
    elif qry[0] == 'size':
        print(len(deq))
    elif qry[0] == 'empty':
        print(0 if deq else 1)
    elif qry[0] == 'front':
        print(deq[0] if deq else -1)
    else:
        print(deq[-1] if deq else -1)


