import sys, heapq

input = sys.stdin.readline
n = int(input())

q = []

for i in range(n):
    li = list(map(int, input().split()))

    if not q:
        for j in li:
            heapq.heappush(q, j)

    else:
        for j in li:
            if q[0] < j:
                heapq.heappush(q, j)
                heapq.heappop(q)

print(q[0])