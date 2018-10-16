%listas.[1,2,3,4,5,8,1].[1,[2,3],5,5].

%lista(L):- Cabeza = [1,2,3,4], Cola = [2,3,4], L = [Cabeza|Cola].

lista([1,3,9,4,2,8,7,12,14]).
imprimir([Ca|Co]):-write(Ca),nl,imprimir(Co).
%imprimir2([Ca|Co]:-imprimir2(Co),nl,write(Ca).
imprimir([]).

contar([],0):-!.
contar([_|Co],K):-contar(Co,K1), K is K1+1.

%no pongo el caso de que esté vacía.

pertenece([Ca|_],Ca):-!.
pertenece([_|Co],E):-pertenece(Co,E).
