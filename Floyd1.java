import java.io.*;
public class Floyd1
{
static int [ ][ ]floyd;
static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
public static void main()
{
int n=0;
try {
System.out.print(“Ingrese n (tamaño de la matriz n X n) : “);
n=Integer.parseInt(leer.readLine());
floyd=new int[n][n];
for (int i=0;i<n;i++)
for (int j=0;j<n;j++)
{
System.out.println(“Inserte la componente W(” + i + “)(” + j +”)”);
floyd[i][j]=Integer.parseInt(leer.readLine());
}
}
catch(Exception e){}
for (int k=0;k<=n-1;k++)
{
for (int i=0;i<=n-1;i++)
{for (int j=0;j<=n-1;j++)
if ((floyd[i][k]!=-1)&&(floyd[k][j]!=-1))
floyd[i][j]=funcionfloyd(floyd[i][j],floyd[i][k]+floyd[k][j]);}
}
System.out.println(“Matriz de adyacencia correspondiente: “);
for (int i=0;i<n;i++)
{
for (int j=0;j<n;j++)
System.out.print(” – “+floyd[i][j]);
System.out.println();
}
}
public static int funcionfloyd(int A, int B)
{
if ((A==-1)&&(B==-1))
return -1;
else if (A==-1)
return B;
else if (B==-1)
return A;
else if (A>B)
return B;
else return A;
}      }
Nota= En el de floyd, el resultado -1 en la matriz representa distancia NO FINITA. Es decir, no se puede llegar a ese destino desde el origen.
