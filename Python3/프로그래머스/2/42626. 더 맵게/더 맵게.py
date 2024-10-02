import heapq
def mix(arr):
    a = heapq.heappop(arr)
    b = heapq.heappop(arr)
    tmp = a + (2 * b)
    heapq.heappush(arr, tmp)
    return

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while True:
        if len(scoville) < 2 and scoville[0] < K:
            return -1
        elif all(i >= K for i in scoville):
            return answer
        else:
            mix(scoville)
            answer += 1
