public final class IMath {

   /** 
    * Retorna a aproximação inteira da raiz quadrada de x. 
    */
   public static int isqrt(int x) {
       int guess = 1;
       while (guess * guess < x) {
            guess++;
       }

	/*if (guess * guess > x)
		return guess -1;
	else*/
		return guess;
   }
}

