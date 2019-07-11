valido(A,B,C):-A>0,B>0,C>0.
formaTriangulo(A,B,C):-(A+B)>C,(A+C)>B,(C+B)>A.
esEquilatero(A,B,C,R):-A==B,B==C,R = "Equilatero".
esEscaleno(A,B,C,R):- dif(A,B),dif(B,C),dif(A,C),R = "Escaleno".

esTriangulo(A,B,C,R):-valido(A,B,C),formaTriangulo(A,B,C),(esEquilatero(A,B,C,R);esEscaleno(A,B,C,R);R  = "Isosceles").
