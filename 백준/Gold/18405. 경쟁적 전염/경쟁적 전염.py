#bfs, 간선의 비용 1
from collections import deque
#값 입력받음(K번까지가능)
n,k = map(int, input().split())
graph = []
data = [] #바이러스에 대한 정보를 담는 리스트
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        #해당위치에 바이러스가 존재하는경우
        if graph[i][j] != 0:
            #(바이러스종류, 시간, 위치x, 위치y)삽입
            data.append((graph[i][j], 0, i, j))
#정렬 이후에 큐로 옮기기(낮은 번호의 바이러스가 먼저 증식하므로)
data.sort()
q = deque(data)

#s: 초, (x, y)좌표
ts, tx, ty = map(int, input().split())

#바이러스가 퍼져나갈 수 있는 4가지의 위치
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

#bfs
while q:
    virus, s, x, y = q.popleft()
    #정확히 s초가 지나거나, 큐가 빌 때까지 반복
    if s == ts:
        break
    #현재 노드에서 주변 4가지 위치를 각각확인
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        #해당 위치로 이동할 수 있는 경우
        if 0 <= nx and nx < n and 0 <= ny and ny < n:
            #아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s+1, nx, ny))
print(graph[tx-1][ty-1])