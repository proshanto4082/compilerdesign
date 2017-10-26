
package problemii;
import java.util.*;
public class ProblemII 
{
    public static void main(String[] args) 
    {
        String [] invalname = new String [50];
        String [] invalue = new String [50];
        String [] inmathexp = new String [50];
        String [][] val_namevalue = new String [50][50];
        String valname,value,mathexp;
        
        System.out.print("Number of Identifier: ");
        Scanner iden = new Scanner(System.in);
        int n = iden.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Identifier: ");
            Scanner in = new Scanner(System.in);
            valname = in.nextLine();
            invalname[i] = valname;
            System.out.print("Value: ");
            value = in.nextLine();
            invalue[i] = value;
            
        }
        
        System.out.println("Here,");
        for (int i = 0; i < n; i++) {
            System.out.println("    "+invalname[i]+"="+invalue[i]);
        }
        
        System.out.print("Number of math expression: ");
        Scanner mathex = new Scanner(System.in);
        int m = mathex.nextInt();
        
        for (int i = 0; i < m; i++) {
            Scanner exp = new Scanner(System.in);
            System.out.print((i+1)+". No Math Expression: ");
            String mathexpin = exp.nextLine();
            mathexp =mathexpin.replaceAll(" ","");
            inmathexp[i] = mathexp;
        }

        for (int e = 0; e < m; e++) {
            int l = 0;
            for (int i = 0; i < inmathexp[e].length(); i++) {
                for (int j = 0; j < n; j++) {
                    if (invalname[j].charAt(0) == inmathexp[e].charAt(i)) {
                        val_namevalue[e][l] = invalue[j];
                        l++;
                    }
                }
            }
        }

        for (int e = 0; e < m; e++)
        {
            if ( val_namevalue[e][inmathexp[e].length()/2] == null ) 
            {
                System.err.println((e+1)+". "+inmathexp[e]+" = Error!!!");
            }
            else
            {
                int result = Integer.parseInt(val_namevalue[e][0]);
                    for (int i = 0; i < inmathexp[e].length()/2; i++) 
                    {
                        int val = Integer.parseInt(val_namevalue[e][i+1]);
                        switch (inmathexp[e].charAt(2*i+1)) 
                        {
                            case '+':
                                result +=val;
                                break;
                            case '-':
                                result -=val;
                                break;
                            case '*':
                                result *=val;
                                break;
                            case '/':
                                result /=val;
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println((e+1)+". "+inmathexp[e]+" = "+result);
            }

        }
    }    
}
