def solution(A,B):
    answer = 0

    A.sort(reverse = True)
    B.sort()
    
    answer = sum([A[i] * B[i] for i in range(len(A))])

    return answer