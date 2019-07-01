--Dado dos números enteros A y B 
--encuentre el MCD (máximo  común divisor) entre ambos. 

mcd :: Int -> Int -> Int
mcd x 0 = x
mcd x y = mcd y (x `mod` y)

main = print (mcd 12 24)