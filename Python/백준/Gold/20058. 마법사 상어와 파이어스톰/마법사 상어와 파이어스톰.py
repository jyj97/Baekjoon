
# 백준 마법사 상어와 파이어스톰

from collections import deque


n, q = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(2**n)]
l = list(map(int, input().split()))
nn = 2**n

# 회전시키기
def rotate(start_x, start_y, size):
    # 격자 부분 추출
    subgraph = [a[start_y:start_y + size] for a in graph[start_x:start_x + size]]
    # 시계방향 90도 회전
    new_sub = [list(reversed(a)) for a in zip(*subgraph)]

    # 해당부분 교체해주기
    for i in range(start_x, start_x + size):
        for j in range(start_y, start_y + size):
            graph[i][j] = new_sub[i-start_x][j-start_y]


# 얼음 녹이기
def reduce():
    melt_list = []
    for i in range(nn):
        for j in range(nn):
            
            num = 0

            for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
                nx, ny = i + dx, j + dy

                if 0 <= nx < nn and 0 <= ny < nn:
                    if graph[nx][ny] > 0:
                        num += 1

            if num < 3 and graph[i][j] > 0:
                melt_list.append((i, j))

    for x, y in melt_list:
        graph[x][y] -= 1

    
    


## 제일 큰 덩어리 찾기
def bfs(x,y):
    
    queue = deque()
    queue.append((x,y))
    visited[x][y] = 1

    count = 1

    while queue:
        
        x,y = queue.popleft()
        
        for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
            nx, ny = x + dx, y + dy

            if 0 <= nx < nn and 0 <= ny < nn:
                if visited[nx][ny] == 0 and graph[nx][ny] > 0:
                    queue.append((nx,ny))
                    visited[nx][ny] = 1
                    count += 1
    return count

            



for k in range(q):
    size = 2**l[k]

    for i in range(0, nn, size):
        for j in range(0, nn, size):
            rotate(i, j, size)

    reduce()


visited = [[0]*nn for _ in range(nn)]
ice = 0
max_ice = 0

for i in range(nn):
    for j in range(nn):
         if graph[i][j] > 0:
            ice += graph[i][j]

            if visited[i][j] == 0:
               max_ice = max(max_ice, bfs(i,j))
    
print(ice)
print(max_ice)