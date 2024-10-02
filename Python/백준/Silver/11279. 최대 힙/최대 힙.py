import heapq
import sys


n = int(sys.stdin.readline())

li = []

for _ in range(n):
    num = int(sys.stdin.readline())
    if num != 0:
        heapq.heappush(li, num * -1)

    else:
        if not li:
            print(0)
        else:
            print(heapq.heappop(li) * -1)