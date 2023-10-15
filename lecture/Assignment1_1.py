# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

def divideExp(coef, exp) :
    if exp == 0:
        return 1
    elif(exp % 2 == 0):
        temp = divideExp(coef, exp//2) % n
        return temp * temp % n
    else:
        return coef * divideExp(coef, exp-1) % n 
			
			
inp = list(map(int, input().split()))

M = inp[0] 
e = inp[1] 
d = inp[2] 
n = inp[3]

C = divideExp(M, e)
recoveryM = divideExp(C, d)

print(C)
print(recoveryM)

