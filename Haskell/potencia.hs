--Escribir una función para hallar la potencia de un número.

potencia :: Int -> Int -> Int
potencia x 0 = 1
potencia x 1 = x
potencia x y = x * potencia y (x - 1)

main = print (potencia 2 2)