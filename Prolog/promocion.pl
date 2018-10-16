parcial1(jorge,9).
parcial1(emanuel,2).
parcial1(rocio,5).
parcial1(carlos,1).

parcial2(jorge,7).
parcial2(emanuel,3).
parcial2(rocio,6).

%NOMBRE Y NOTA FINAL DE QUIENES PROMOCIONARON.

promocion(Nombre,NotaFinal):-parcial1(Nombre,P1),parcial2(Nombre,P2),P1>=7,P2>=7,NotaFinal is (P1+P2)/2.

%nombre de quienes tiene la materia cursada
cursada(Nombre):-parcial1(Nombre,P1),parcial2(Nombre,P2),(P1<7;P2<7),P1>=4,P2>=4.

%Alumnos que recursan la materia

recursan(Nombre):-parcial1(Nombre,P1),parcial2(Nombre,P2),P1<4,P2<4.

%Alumnos con la mayor nota

producto_carte(X,Y,W,Z):-promocion(X,Y),promocion(W,Z).
seleccion(X,Y,W,Z):-producto_carte(X,Y,W,Z), Y<Z.
proyeccion(X,Y):-seleccion(X,Y,_,_).
maximo(X,Y):-promocion(X,Y),not(proyeccion(X,Y)).
nota_maxima(X):-promocion(X,Y),maximo(X,Y).

%Alumnos Ausentes
%forma de ||, repetir la funcion
ausentes(Nombre):-parcial1(Nombre,_),not(parcial2(Nombre,_)).
ausentes(Nombre):-not(parcial1(Nombre,_)),parcial2(Nombre,_).
ausentes(Nombre):-not(parcial1(Nombre,_)),not(parcial2(Nombre,_)).

