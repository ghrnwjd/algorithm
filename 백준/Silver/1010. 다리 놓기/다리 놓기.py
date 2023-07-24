import sys
# python 입력속도 빠르게 하기
input = sys.stdin.readline

t = int(input())
fac_lst = [1]
max_num = 1

for _ in range(t):
	n, m = map(int, input().split())
	
	if n == m:
		print(1)
		continue
	
	if n < m:
		n, m = m, n
	
	if max_num < n:
		while(n != len(fac_lst)):
			fac_lst.append(fac_lst[-1]*(len(fac_lst)+1))
		max_num = n
	
	print(int(fac_lst[n-1]/(fac_lst[n-m-1] * fac_lst[m-1])))
