/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author 2929a
 */
public class Node {
    private Integer valor;
 private Node Izdo;
 private Node Dcho;

 public Node(Integer valor)
 {
 this.valor = valor;
 Izdo=null;
 Dcho=null;
 }
 public Integer getValor() {
 return valor;
 }
 public void setValor(Integer valor) {
 this.valor = valor;
 }
 public Node getIzdo() {
 return Izdo;
 }
 public void setIzdo(Node left) {
 this.Izdo = left;
 }
 public Node getDcho() {
 return Dcho;
 }
 public void setDcho(Node right) {
 this.Dcho = right;
 }

 public void Adicionar(Integer valor)
 {
 if (valor < this.valor )
 {
 if ( Izdo != null )
 Izdo.Adicionar(valor);
 else
 Izdo = new Node(valor);
}
 
 else

{
 if ( Dcho != null
)
 Dcho.Adicionar (valor);
 else
 Dcho = new Node(valor);

}

}

 public void printInOrder() {
 if (Izdo != null) {
 Izdo.printInOrder();

}
 System.out.println(valor);
 if (Dcho != null) {
 Dcho.printInOrder();

}

}
 public void printPreOrder() {
 System.out.println(valor);
 if (Izdo != null) {
 Izdo.printPreOrder();

}
 if (Dcho != null) {
 Dcho.printPreOrder();

}

}
 public void printPosOrder() {
 if (Izdo != null) {
 Izdo.printPosOrder();

}
 if (Dcho != null) {
 Dcho.printPosOrder();

}
 System.out.println(valor);

}
 public boolean
buscar(Integer v)

{
 boolean resp=false
;
 if ( v != this.valor )

{
 if (v > this.valor){
 if ( Dcho != null
)
 resp=Dcho.buscar(v);

}
 else
{
 if ( Izdo != null )
 resp=Izdo.buscar(v);
 }
 }
 else
 resp=true;
 return resp;
 }
 @Override
 public String toString() {
 return "Node [valor=" + valor + ", Izdo=" + Izdo + ", Dcho=" + Dcho + "]";
 }
}
