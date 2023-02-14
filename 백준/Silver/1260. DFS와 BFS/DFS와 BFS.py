from collections import deque
import sys
input = sys.stdin.readline
n,m,v= map(int, input().split())
graph = [[] for i in range(n+1)]
#그래프 생성
for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
#정렬
for i in graph:
    i.sort()
#dfs
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end = " ")
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

#bfs
def bfs(graph, v, visited):
    q = deque([v])
    visited[v] = True

    while q:
        v = q.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                q.append(i)
                visited[i] = True


visited = [False]* (n+1)
dfs(graph, v, visited)
print()
visited = [False]* (n+1)
bfs(graph, v, visited)