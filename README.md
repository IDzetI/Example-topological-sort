# Example-topological-sort
A task
You are given a file with a set of equalities (line by line). Some of them are presented in the form of clean assignments. X = integer_number, others in the form of a binary operation X = Y * Z or even X = Y + integer_number (only * or + characters are allowed). Your task is to calculate the value of the variable R and print it in the output.txt file. If this is not possible, type ERROR.

NB R does not necessarily depend implicitly on all variables.

The code on java implements the computation of the number P by means of the topolodical sort method.


Example #1
input.txt<br>
A=3
R=T*4 
T=A+B
B=2

output.txt
20

Example #2
input.txt
C=Q+W
A=E+5
R=C*W
Q=3*5
W=1+A
E=4

output.txt
250


Example #3
input.txt
R=C+D
A=B+C
C=B*D
D=B+A
B=4

output.txt
ERROR
