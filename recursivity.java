/**************************************************************

Autor: Diego Elizondo Benet
Fecha: 16 de Marzo 2020
Doy mi palabra que he realizado esta actividad con integridad academica.
***************************************************************/
import java.io.*;

class Principal{
   public static void main(String arg[]){
      System.out.println("seleccionar opcion del menu (1,2,3 o 4)");
      int menu = Lectura.readInt();
      while(menu != 5){
         if(menu == 1){
            //.1
            System.out.println("ingresar cantidad de los primeros numeros pares para sumar");
            int n = Lectura.readInt()*2; //Al numero lo multiplico por 2 para que en el metodo reste de 2 en 2.
            System.out.println("la suma es: "+sumaPrimos(n)+"\n");
         }
         if(menu == 2){
            //2
            System.out.println("Ingresar String s");
            String s = Lectura.readString();
            System.out.println("Ingresar character que se desea contar en el string s");
            char c = Lectura.readChar();
            String m = invertir(s); //String generado que es inverso al String s
            //Seccion a)
            System.out.println("cantidad del caracter '"+c+"'"+" en el String '"+s+"'"+" es: "+contarCaracter(s,c));
            //Seccion b)
            System.out.println("String inverso es: "+m);
            //Seccion c)
            System.out.println("cantidad de vocales es: "+vocales(s)+"\n");
         }
         if(menu == 3){
            //3
            System.out.println("Ingresar numero p");
            int p = Lectura.readInt();
            System.out.println("numero promedio de p = "+promedio(p)+"\n");
         }
         if(menu == 4){
            //4
            System.out.println("Ingresar primer numero");
            int num1 = Lectura.readInt();
            System.out.println("Ingresar segundo numero");
            int num2 = Lectura.readInt();
            System.out.println("el maximo comun divisor de '"+num1+"' y '"+num2+"' es: "+mcd(num1,num2)+"\n");
         }
      System.out.println("seleccionar opcion del menu (1,2,3,4 o 5 para SALIR)");
      menu = Lectura.readInt();
      }
   }
   //método recursivo que calcule la suma de los primeros N números pares naturales.
   public static int sumaPrimos(int n){
      if(n==0) //caso base.
         return 0;
      else
         return n+sumaPrimos(n-2); //n-2 para que siempre los numeros sean pares
   }
   //contar caracter
   public static int contarCaracter(String s, char c){
      if(s.isEmpty()) //caso base, si el string esta vacio se termina.
         return 0;
      else if(s.charAt(0) == c) //comparas la primera letra del String 's' con el caracter 'c'
         return 1+contarCaracter(s.substring(1),c); //Si es la misma letra, se le agrega 1 y se llama al metodo quitandole esa letra del String 's'
      else
         return contarCaracter(s.substring(1),c); //Si no es la misma, solamente se llama al mismo metodo sin la primera letra del String 's'
   }
   //String invertido
   public static String invertir(String s){
      if(s.isEmpty()) //caso base
         return "";
      else
         return ""+s.substring(s.length()-1)+invertir(s.substring(0,s.length()-1)); //Agarra la ultima letra del string, y se llama a el mismo sin esa ultima letra.
   }
   //cantidad de vocales
   public static int vocales(String s){
      if(s.isEmpty()) //caso base
         return 0;
      else if(s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u' ||
              s.charAt(0) == 'A' || s.charAt(0) == 'E' || s.charAt(0) == 'I' || s.charAt(0) == 'O' || s.charAt(0) == 'U') //compara si la primera letra es vocal
         return 1 + vocales(s.substring(1)); //Si es vocal, se le agrega 1 y se llama al metodo quitandole esa letra del String 's'
      else
         return vocales(s.substring(1)); //si no es vocal, solamente se llama al mismo metodo sin la primera letra del String 's'
   }
   //promedio de p
   public static int promedio(int p){
      if(p <= 0) //caso base cuando p es igual o menor que 0
         return 0;
      else if((p%10)%2 == 0) //condicion de si el ultimo digito es par
         return -(p%10) + promedio(p/10); //si es par, restas ese ultimo digito y se llama a el mismo quitandole ese digito al numero 'p'.
      else
         return p%10 + promedio(p/10); //si es impar, sumas el ultimo digito y se llama a el mismo quitandole ese digito al numero 'p'.
   }
   //maximo comun divisor
   public static int mcd(int num1, int num2){
   if (num1 == 0) //caso base
      return num2; 
   if (num2 == 0 || num1 == num2) //caso base y condicional si los dos numeros son iguales, lo hemos terminado.
      return num1; 
   if (num1 > num2) 
      return mcd(num1-num2, num2); //si num1 es mayor que num2, se le resta a num1 el valor de num2.
   else
      return mcd(num1, num2-num1); //si num2 es mayor que num1, se le resta a num2 el valor de num1.
   }
}

// CLASE LECTURA
class Lectura{
	
	public static int readInt(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				int num2=Integer.parseInt(num);
			return num2;
	}
	
	public static float readFloat(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				float num2=Float.parseFloat(num);
			return num2;
	}
	
	public static byte readByte(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				byte num2=Byte.parseByte(num);
			return num2;
    }
    
    public static boolean readBoolean(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				boolean num2=Boolean.getBoolean(num);
			return num2;
	}
	
	public static double readDouble(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				double num2=Double.parseDouble(num);
			return num2;
	}
	
	public static long readLong(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				long num2=Long.parseLong(num);
			return num2;
	}
	
	public static short readShort(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				short num2=Short.parseShort(num);
			return num2;
	}
	
	public static char readChar(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
				char num2=num.charAt(0);
			return num2;
	}
	public static String readString(){
		String num;
		DataInputStream w=new DataInputStream(System.in);
			try{
				num=w.readLine();
				}
				catch(IOException e){num="0";}
			return num;
	}
}

// FIN CLASE LECTURA