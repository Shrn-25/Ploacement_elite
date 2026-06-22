#!/bin/python3



#
# Complete the 'matrixRotation' function below.
#
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY matrix
#  2. INTEGER r
#

def matrixRotation(matrix, r):
    # Write your code here
    R=len(matrix)
    C=len(matrix[0])

    A=[]
    for a in range(0,int(min(R,C)/2)):
        temp=[]
        j=a
        i=a
        #print(" i  j ")
        for i in range (a,R-a-1):
            #print(i," ",j," d ",)
            temp.append(matrix[i][j])
        i+=1
        for j in range (a,C-a-1):
            #print(i," ",j," l ")
            temp.append(matrix[i][j])
        j+=1
        for i in range (R-a-1,a,-1):
            #print(i," ",j," u ")
            temp.append(matrix[i][j])
        i-=1
        for j in range (C-a-1,a,-1):
            #print(i," ",j," r  ")
            temp.append(matrix[i][j])
        
         
        A.append(temp)   
    #print(A)
    for a in A:
        k=r%len(a)
        a[:] = a[-k:] + a[:-k]
            
    #print(A)   
    
    for layer in range(0,len(A)):
        
        temp = A[layer]
        idx = 0
        i=layer
        j=layer
    
        for i in range(layer, R-layer-1):
            #print(i," ",j," d ",temp[idx])
            matrix[i][j] = temp[idx]
            idx += 1
    
        i+=1
        for j in range(layer, C-layer-1):
            #print(i," ",j," d ",temp[idx])
            matrix[i][j] = temp[idx]
            idx += 1
    
        j+=1
        for i in range(R-layer-1, layer, -1):
            #print(i," ",j," d ",temp[idx])
            matrix[i][j] = temp[idx]
            idx += 1
    
        i-=1
        for j in range(C-layer-1, layer, -1):
            #print(i," ",j," d ",temp[idx])
            matrix[i][j] = temp[idx]
            idx += 1
            
            
    #for i in matrix:
        #print(i,'\n')

if __name__ == '__main__':
    first_multiple_input = input().rstrip().split()

    m = int(first_multiple_input[0])

    n = int(first_multiple_input[1])

    r = int(first_multiple_input[2])

    matrix = []

    for _ in range(m):
        matrix.append(list(map(int, input().rstrip().split())))
    
    matrixRotation(matrix, r)
