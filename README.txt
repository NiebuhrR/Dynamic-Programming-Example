Let  E = {A, B, C}. The element of E have the following multiplication table:

	    |	A	B	C
	--------------------------
	A   |	B	B	A
	B   |	C 	B	A
	C   | 	A	C	C

Thus, AB = B, BA = C, and so on. Note that the multiplication defined by this 
table is neither commutative nor associative. 

There are multiple ways to parenthesising a word according to the multiplication
table. For example, if w = ABBA, then there are five ways of bracketing which produce
the following values:

	(A(B(BA))) = B	(A((BB)A)) = A	((AB)(BA)) = A	((A(BB))A) = C	(((AB)B)A) = C

There are two ways of bracketing an A and two to get a C, whereas there is only one
way to get a B. 

The purpose of this project is to design and implement efficient algorithms to answer 
the bracketing questions. In particular, the program would eventually output information
as such:

Bracketing values for ABBAA (2 ways)B (1 way)C (2 ways)