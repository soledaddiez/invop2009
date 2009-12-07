import modelo.Producto;

public class TestLoteOptimo{
	public static void main(String [] args){
		int diasDelPeriodo = 1;
		System.out.println(CantidadAPedir.calcularCantidadAPedir(Producto.PRODUCTO_AGUA_500_CC, diasDelPeriodo) + " botellas");
	}
}
