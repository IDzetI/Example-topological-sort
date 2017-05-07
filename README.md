# Example-topological-sort
A task
You are given a file with a set of equalities (line by line). Some of them are presented in the form of clean assignments. X = integer_number, others in the form of a binary operation X = Y * Z or even X = Y + integer_number (only * or + characters are allowed). Your task is to calculate the value of the variable R and print it in the output.txt file. If this is not possible, type ERROR.

NB R does not necessarily depend implicitly on all variables.

The code on java implements the computation of the number P by means of the topolodical sort method.


Example #1<br>
input.txt<br>
A=3<br>
R=T*4 <br>
T=A+B<br>
B=2<br>

output.txt<br>
20

Example #2<br>
input.txt<br>
C=Q+W<br>
A=E+5<br>
R=C*W<br>
Q=3*5<br>
W=1+A<br>
E=4<br>

output.txt<br>
250


Example #3<br>
input.txt<br>
R=C+D<br>
A=B+C<br>
C=B*D<br>
D=B+A<br>
B=4<br>

output.txt<br>
ERROR
