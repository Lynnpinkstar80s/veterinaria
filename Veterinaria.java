package veterinaria;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.StringTokenizer;


public class Veterinaria {
 
String fecha, numeropago, nombremas;
  int identificacion, edadmas, valorcons;
  Boolean sexo ;

 void DividirCadenas(String linea){//No sé como indicarle que es exactamente de ese archivo que debo tomar las cadenas
        StringTokenizer st = new StringTokenizer(linea,";");
        
        while(st.hasMoreTokens()){
           fecha = st.nextToken();
           numeropago = st.nextToken();
           identificacion = Integer.parseInt(st.nextToken());
           nombremas = st.nextToken();
           edadmas=Integer.parseInt(st.nextToken());
           sexo=Boolean.parseBoolean(st.nextToken()); 
           valorcons=Integer.parseInt(st.nextToken());
           MostrarDatos();
           SonMachos();
           TotalPagos();
        }   
 }
void LeerArchivo(){
String linea;
        File arch = null;
        FileReader fr = null;
        BufferedReader br = null;
               
                try{
                    arch = new File("pagos.txt");
                    fr = new FileReader(arch);
                    br = new BufferedReader(fr);
                    while( (linea = br.readLine()) != null  ){
                    JOptionPane.showMessageDialog(null,"Error"+linea);
                    
                    }
                 
                }catch(IOException Ioe){
                        JOptionPane.showMessageDialog(null,"Error"+Ioe);
                }
                finally{
                    try {
                        if (fr != null)
                            fr.close();
                        
                    }catch(IOException ioe){
                        JOptionPane.showMessageDialog(null,""+ioe);
                    }
                }
            
        
    }
void EscribirArchivo()
    {
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        FileInputStream fis = null;
        DataInputStream entrada = null;
        FileWriter arch = null;
       
        
        try{
        fos = new FileOutputStream("pagos.dat",true);
        salida = new DataOutputStream(fos);
        fis = new FileInputStream("pagos2.txt");
        entrada = new DataInputStream(fis);
  
        while (true) { 

        fecha = entrada.readUTF();
        numeropago = entrada.readUTF();
        identificacion = entrada.readInt(); 
        nombremas = entrada.readUTF(); 
        edadmas=entrada.readInt(); 
        valorcons=entrada.readInt(); 
        sexo=entrada.readBoolean();        
        }
        
        }
        catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "No se encontró el archivo \n"+e);
        } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error \n"+e);
         } 
         finally {
         try {
         if (fos != null){
        fos.close();
        }
         if (salida != null) {
        salida.close();
        }
        }catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error \n"+e);
        }
     }   
    }
    

 
 
 void MostrarDatos(){
        JOptionPane.showMessageDialog(null, "Fecha\t\t"+fecha+"\t Número de Pago \t "+numeropago+"\n Identificacion \t"+ 
        identificacion+"\t Nombre de la Mascota \t\t"+nombremas+"Edad de la mascota\t\t"+edadmas+"Sexo\t\t"
        +sexo+"Valor de la consulta\t\t"+valorcons+"\t\t");
    }
 void SonMachos(){
     if(sexo==true)
         JOptionPane.showMessageDialog(null, "Estas mascotas son machos");
          JOptionPane.showMessageDialog(null, "Fecha\t\t"+fecha+"\t Número de Pago \t "+numeropago+"\n Identificacion \t"+ 
        identificacion+"\t Nombre de la Mascota \t\t"+nombremas+"Edad de la mascota\t\t"+edadmas+"Sexo\t\t"
        +sexo+"Valor de la consulta\t\t"+valorcons+"\t\t");
 }
 void TotalPagos(){
     int pagos=0;
     pagos=pagos+valorcons;
     JOptionPane.showMessageDialog(null, "El valor total de los pagos es: "+pagos+"");
 }

    public static void main(String[] args) {
       String cadena = null;
       Veterinaria mascota =new Veterinaria();
       mascota.DividirCadenas(cadena);
       mascota.LeerArchivo();
       mascota.EscribirArchivo();
       
    }
}
