--Definir una función maxDeTres que devuelve el máximo de sus argumentos enteros

maxDeTres :: Int -> Int -> Int -> Int
maxDeTres x y z
 |x > y && x > z = x
 |y > x && y > z = y
 |otherwise = z

main = print (maxDeTres 2 5 4)

--Otra forma

maxDeTres :: Int -> Int -> Int -> Int
maxDeTres x y z = if (x > y && x > z) then x
                  else if(y > x && y > z) then y
                  else z

main = print (maxDeTres 9 5 6)