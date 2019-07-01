--Definir una función menor que devuelve el menor de sus dos argumentos enteros.

menor :: Int -> Int -> Int
menor x y
 |x < y = x
 |otherwise = y

main = print (menor 3 2)

--Otra forma
menor :: Int -> Int -> Int
menor x y = if(x < y) then x
            else y

main = print (menor 3 2)