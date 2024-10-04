def dfs(idx, visited, graph):
    if visited[idx] == True:
        return
    
    visited[idx] = True
    print(idx, end = " ")

    for node in graph[idx]:
        dfs(node, visited, graph)


from collections import deque
def bfs(idx, visited, graph):
    if visited[idx] == True:
        return
    
    queue = deque()
    queue.append(idx)

    while(queue):
        tmp = queue.popleft()
        if visited[tmp] == True:
            continue

        visited[tmp] = True
        print(tmp, end = " ")

        for node in graph[tmp]:
            queue.append(node)



n, m, v = map(int,input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    tmp_a, tmp_b = map(int, input().split())
    graph[tmp_a].append(tmp_b)
    graph[tmp_b].append(tmp_a)

for idx in range(n+1):
    graph[idx].sort()

visited_dfs = [False] * (n+1)
visited_bfs = [False] * (n+1)
dfs(v, visited_dfs, graph)
print()
bfs(v, visited_bfs, graph)