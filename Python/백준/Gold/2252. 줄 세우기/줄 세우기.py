n, m = map(int, input().split())

graph = [[] for _ in range(n + 1)]

count =  [0] * (n + 1)


for i in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    count[e] += 1

from collections import deque

q = deque()
for i in range(1, n + 1):
    if count[i] == 0:
        q.append(i)

while q:
    x = q.popleft()
    print(x, end = " ")

    for i in graph[x]:
        count[i] -= 1
        if count[i] == 0:
            q.append(i)