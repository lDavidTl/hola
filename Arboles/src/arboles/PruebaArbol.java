package arboles;
import javax.swing.JOptionPane;
import arboles.Node;
import arboles.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 2929a
 */
public class PruebaArbol {
    
    
   
  public static void main(String[] args) throws SQLException {
      PruebaArbol pA = new PruebaArbol();
  ConexionSQL con = new ConexionSQL();
  con.conector();
  int id=1;//-------------- 
  
 Integer valor;
 String t;
 Node arbol=null;
 boolean conti = true, r;
 int resp;
 while ( conti )
 {
 if (arbol==null)
 {
 t = JOptionPane.showInputDialog(null, "Digite un elemento entero para la raiz del arbol:");
 valor=Integer.parseInt(t);
 System.out.println(valor);
 arbol = new Node(valor);
 }
 else
 {
 t = JOptionPane.showInputDialog(null, "Digite un elemento entero para el arbol:");
 valor=Integer.parseInt(t);
 System.out.println(valor);
 arbol.Adicionar(valor);
 }
 resp =Integer.parseInt(JOptionPane.showInputDialog(null, "Hay mas caracteres a introducir? 1: Si, 2: No"));
 conti = resp == 1;
 }

 System.out.println("Impresión del árbol en orden\n");
 arbol.printInOrder();
 //pA.consultaTabla();//----------------------------------
 
 System.out.println("Impresión del árbol en preorden\n");
  arbol.printPreOrder(id);
  pA.consultaTabla();//----------------------------------

 System.out.println("Impresión del árbol en postorden\n");
 arbol.printPosOrder();
 //pA.consultaTabla();//----------------------------------
 
 t = JOptionPane.showInputDialog(null, "Digite un elemento entero a buscar en el arbol:");
 valor=Integer.parseInt(t);
 r=arbol.buscar(valor);
 if ( r )
 System.out.println("El valor "+valor+" está en el arbol\n");
 else
 System.out.println("El valor "+valor+" no está en el arbol\n");
 
 }
  
  
  /*MÉTODO PARA REALIZAR UNA CONSULTA A UNA TABLA MYSQL*/
        private void consultaTabla() {
            ConexionSQL con = new ConexionSQL();
            con.conector();
            
        //Realizamos la consulta sql para mostrar todos los datos de la tabla estudiante
        ResultSet r = buscar("SELECT * FROM tabla ");
        try {
            
           
            /*
            Hacemos un While para recorrer toda la tabla estudiantes
            y así poder sacar todos los registros de la tabla
            */
            while (r.next()) {
                /*Se muestra los datos que queremos sacar por consola indicandole:
                        El tipo de dato (int,String...) de cada campo
                        El nombre de los campos de la tabla entre comillas doble " "
                */
                System.out.println(r.getString("preOrden"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PruebaArbol.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//mostrarTablaPropietarios
   
       
        //Este método lo uso para mostrar los datos de una tabla: (executeQuery)
    ResultSet buscar(String sql) {
        try {
            ConexionSQL con = new ConexionSQL();
            con.conector();
            PreparedStatement stm =  con.prepareStatement(sql);
            
            return stm.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PruebaArbol.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }//buscar
  
    
}
