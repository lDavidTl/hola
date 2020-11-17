package arboles;
import javax.swing.JOptionPane;
import arboles.Node;
import arboles.ConexionSQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author 2929a
 */
public class PruebaArbol {
   
  public static void main(String[] args) throws SQLException {
  ConexionSQL con = new ConexionSQL();
  con.conector();
   
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
 if (resp == 1 )
 conti=true;
 else
 conti=false;
 }
 //--- metodo mostrar -----
   //-----------------------------------------------------------      
  /*
   String SQL = "select * from tabla";
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery(SQL);
  System.out.println(rs.getString(SQL));
*/
   //-----------------------------------------------------------
    
 System.out.println("Impresión del árbol en orden\n");
 arbol.printInOrder();
 System.out.println("Impresión del árbol en preorden\n");
 arbol.printPreOrder();
 System.out.println("Impresión del árbol en postorden\n");
 arbol.printPosOrder();
 t = JOptionPane.showInputDialog(null, "Digite un elemento entero a buscar en el arbol:");
 valor=Integer.parseInt(t);
 r=arbol.buscar(valor);
 if ( r )
 System.out.println("El valor "+valor+" está en el arbol\n");
 else
 System.out.println("El valor "+valor+" no está en el arbol\n");

 }
    
}
