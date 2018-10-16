transporte(roma,20).
transporte(londres,30).
transporte(tunez,10).

alojamiento(roma,hotel,50).
alojamiento(roma,hostal,30).
alojamiento(roma,camping,10).
alojamiento(londres,hotel,60).
alojamiento(londres,hostal,40).
alojamiento(londres,camping,20).
alojamiento(tunez,hotel,40).
alojamiento(tunez,hostal,20).
alojamiento(tunez,camping,5).

multiplicar(P,X,Y):- P is X*Y.
sumar(S,X,Y):- S is X+Y.
menor(X,Y):-  X<Y.


viaje(C,S,H,Pv):-transporte(C,Pt),alojamiento(C,H,Pa),multiplicar(M,Pa,S),
    sumar(Pv,Pt,M).
viajeeconomico(C,S,H,Pmax):-viaje(C,S,H,P),menor(Pmax,P).
