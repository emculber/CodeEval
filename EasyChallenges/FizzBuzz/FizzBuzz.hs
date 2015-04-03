import System.Environment (getArgs)

  main = do
  [inpFile] <- getArgs
  input <- readFile inpFile


