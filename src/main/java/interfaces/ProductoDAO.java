package interfaces;

import java.util.ArrayList;

import entities.CategoriaDTO;
import entities.ProductoDTO;

public interface ProductoDAO {

	//REGISTRAR PRODUCTO
	public int registrarProducto(ProductoDTO p);

	//ACTUALIZAR PRODUCTO
	public int actualizarProducto(ProductoDTO p);
	
	//ELIMINAR PRODUCTO
	public int eliminarProducto(String p);

	//LISTAR PRODUCTOS
	public ArrayList<ProductoDTO> listaProductos();
	
	//LISTAR PRODUCTOS LIKE
	public ArrayList<ProductoDTO>listaXlike(String p);
	
	//BUSCAR PRODCUTOS
	public ProductoDTO buscarProducto(String p);
	
	//LISTAR CATEGORIAS
	public ArrayList<CategoriaDTO> listaCategorias();

}
