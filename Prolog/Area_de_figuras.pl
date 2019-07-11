triangulo(8,4).
cuadrado(4).
rectangulo(9,4).
circulo(4).

es_figura(triangulo).
es_figura(cuadrado).
es_figura(rectangulo).
es_figura(circulo).

es_distinto(X,Y,W,Z):-dif(X,Y),dif(X,W),dif(X,Z).


area_figura(F,A):-es_figura(F),es_distinto(F,cuandrado,rectangulo,circulo),triangulo(B,H), A is (B*H)/2.
area_figura(F,A):-es_figura(F),es_distinto(F,triangulo,rectangulo,circulo),cuadrado(L), A is L*L.
area_figura(F,A):-es_figura(F),es_distinto(F,triangulo,cuadrado,circulo),rectangulo(B,H), A is B*H.
area_figura(F,A):-es_figura(F),es_distinto(F,triangulo,cuadrado,rectangulo),circulo(R), A is pi*(R*R).
