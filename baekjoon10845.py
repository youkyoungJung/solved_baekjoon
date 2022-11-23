#python 객체지향문법
#연결리스트

#node->next
#data, data

import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data) -> None:
        self.data = data
        self.next = None

class Queue:
    def __init__(self) -> None:
        self.start = None
        self.end = None
        self.size = 0

    def push(self, data):
        self.size += 1
        node = Node(data)

        if not self.start:
            self.start = node
            self.end = node
            return

        self.end.next = node
        self.end = node
    
    def pop(self):
        if not self.start:
            return -1
        self.size -= 1
        tmp = self.start
        self.start = self.start.next
        if not self.start:
            self.end = None
        ret = tmp.data
        del tmp
        return ret

    def empty(self):
        return +(not self.start)

    def front(self):
        return self.start.data if self.start else -1

    def back(self):
        return self.end.data if self.end else -1

q = Queue()

n = int(input())
for _ in range(n):
    qry = input().split()
    if qry[0] == 'push':
        q.qush(qry[1])
    elif qry[0] == 'pop':
        print(q.pop())
    elif qry[0] == 'size':
        print(q.size)
    elif qry[0] == 'empty':
        print(q.empty())
    elif qry[0] == 'front':
        print(q.front())
    else:
        print(q.back())