package edu.unah.poo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.poo.model.Cliente;
import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.FacturaVenta;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.Lote;
import edu.unah.poo.model.Pescado;
import edu.unah.poo.model.Producto;
import edu.unah.poo.model.Proveedor;
import edu.unah.poo.service.ServiceCliente;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceFacturaVenta;
import edu.unah.poo.service.ServiceLimpieza;
import edu.unah.poo.service.ServiceLote;
import edu.unah.poo.service.ServicePescado;
import edu.unah.poo.service.ServiceProducto;
import edu.unah.poo.service.ServiceProveedor;

@Controller
public class Controlador {
	@Autowired
	ServiceCliente serviceCliente;
	
	@Autowired
	ServiceEmpleado serviceEmpleado;
	
	@Autowired
	ServicePescado servicePescado;
	
	@Autowired
	ServiceProveedor serviceProveedor;
	
	@Autowired
	ServiceLimpieza serviceLimpieza;
	
	@Autowired
	ServiceLote serviceLote;
	
	@Autowired
	ServiceProducto serviceProducto;
	
	@Autowired
	ServiceFacturaVenta serviceFacturaVenta;
	
	
	@GetMapping("/principal/General")
	public String paginaGeneral() {
		return "paginaGeneral"; //retornar la pagina
	}

//=================================================================================================	
// Cliente 
//=================================================================================================
// HTML Cliente
//=================================================================================================
	
	@GetMapping("/cliente/crearCliente")
	public String refistrarCliente() {
		return "registrarCliente";
	}
	
	@GetMapping("/cliente/detalle/{id}")
	public String detalleCliente(@PathVariable("id") int id, 
			                     Model model) {
		Cliente cliente = this.serviceCliente.buscarCliente(id);
		model.addAttribute("cliente", cliente);
		return "buscarCliente";
	}
	
	
	@RequestMapping(value ="/cliente/crearCliente", method= RequestMethod.POST)
	public String crearCliente(@RequestParam(name = "id") int idCliente,
			                    @RequestParam(name = "nombre") String nombre,
			                    @RequestParam(name = "direccion") String direccion,
			                    @RequestParam(name = "telefono") String telefono,
			                    @RequestParam(name = "pasword") String pasword) {
		
		Cliente cliente = new Cliente(idCliente, nombre, direccion, telefono, pasword);	
		this.serviceCliente.crearCliente(cliente);
		return "registrarCliente";	
	}
	
	@RequestMapping(value ="/cliente/listarClientes", method= RequestMethod.GET)
	public String listadoCliente(Model model){
		List<Cliente> clientes = this.serviceCliente.listarClientes();
		model.addAttribute("clientes", clientes);
		return "ListadoClientes";
	}
	
	@RequestMapping(value ="/cliente/buscarCliente", method= RequestMethod.GET)
	public Cliente buscarCliente(@RequestParam(name = "id") int idCliente) {
		return this.serviceCliente.buscarCliente(idCliente);
	}
	
//=================================================================================================	
// Empleado
//=================================================================================================	
// HTML Empleado
//=================================================================================================
	
	@GetMapping("/empleado/crearEmpleado")
	public String registrarEmpleado() {
		return "registrarEmpleado";
	}
	
	@GetMapping("/empleado/detalle/{id}")
	public String buscarEmpleado(@PathVariable("id") int id, 
			                     Model model) {
		Empleado empleado = this.serviceEmpleado.buscarEmpleado(id);
		model.addAttribute("empleado", empleado);
		return "buscarEmpleado";
	}
	
	
	@RequestMapping(value ="/empleado/crearEmpleado", method= RequestMethod.POST)
	public String crearEmpleado(@RequestParam(name = "id") int idEmpleado,
			                    @RequestParam(name = "nombre") String nombre,
			                    @RequestParam(name = "puesto") String puesto,
			                    @RequestParam(name = "direccion") String direccion,
			                    @RequestParam(name = "fechaContrato") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaContrato,
			                    @RequestParam(name = "fechaNacimiento") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaNacimiento,
			                    @RequestParam(name = "numeroContrato") int numeroContrato,
			                    @RequestParam(name = "pasword") String pasword) { 
		
		Empleado empleado = new Empleado(idEmpleado, nombre, puesto, direccion, fechaContrato, fechaNacimiento, numeroContrato, pasword);	
		this.serviceEmpleado.crearEmpleado(empleado);
		return "registrarEmpleado";
	}
	
	@RequestMapping(value ="/empleado/listarEmpleados", method= RequestMethod.GET)
	public String listadoEmpleado(Model model){
		List<Empleado> empleados = this.serviceEmpleado.listarEmpleados();
		model.addAttribute("empleados", empleados);
		return "ListadoEmpleados";
	}
	
	@RequestMapping(value ="/empleado/buscarEmpleado", method= RequestMethod.GET)
	public Empleado buscarEmpleado(@RequestParam(name = "id") int idEmpleado) {
		return this.serviceEmpleado.buscarEmpleado(idEmpleado);
	}
	
	
	
//=================================================================================================	
// Pescado
//=================================================================================================	
// HTML Pescado
//=================================================================================================
	
	@GetMapping("/pescado/crearPescado")
	public String registrarPescado() {
		return "registrarPescado";
	}
	
	@GetMapping("/pescado/detalle/{id}")
	public String detallePescado(@PathVariable("id") int id, 
			                     Model model) {
		Pescado pescado = this.servicePescado.buscarPescado(id);
		model.addAttribute("pescado", pescado);
		return "buscarPescado";
	}	
	
	
	
	
	
	@RequestMapping(value = "/pescado/crearPescado", method= RequestMethod.POST)
	public String crearPescado(@RequestParam(name = "id") int idPescado,
			                    @RequestParam(name = "tipo") String tipo,
			                    @RequestParam(name = "color") String color,
			                    @RequestParam(name = "nombre") String nombre,
			                    @RequestParam(name = "tamanio") double tamanio) {
		
		Pescado pescado = new Pescado(idPescado, tipo, color, nombre, tamanio);
		this.servicePescado.crearPescado(pescado);
		return "registrarPescado";		
	}
	
	@RequestMapping(value = "/pescado/listarPescados", method= RequestMethod.GET)
	public String listadoPescado(Model model){
		List<Pescado> pescados = this.servicePescado.listarPescados();
		model.addAttribute("pescados", pescados);
		return "ListadoPescados";
	}
	
	@RequestMapping(value="/pescado/buscarPescado", method= RequestMethod.GET)
	public Pescado buscarPescado(@RequestParam(name = "id") int idPescado) {
		return this.servicePescado.buscarPescado(idPescado);
	}
		

	
	
//=================================================================================================	
// Proveedor
//=================================================================================================	
// HTML Proveedor
//=================================================================================================
	
	@GetMapping("/proveedor/crearProveedor")
	public String registrarProveedor() {
		return "registrarProveedor";
	}
	
	@GetMapping("/proveedor/detalle/{id}")
	public String detalleProveedor(@PathVariable("id") int id, 
			                     Model model) {
		Proveedor proveedor = this.serviceProveedor.buscarProveedor(id);
		model.addAttribute("proveedor", proveedor);
		return "buscarProveedor";
	}
	
	
	@RequestMapping(value = "/proveedor/crearProveedor", method= RequestMethod.POST)
	public String crearProveedor(@RequestParam(name = "id") int idProveedor,
			                        @RequestParam(name = "nombre") String nombre,
			                        @RequestParam(name = "telefono") String telefono,
			                        @RequestParam(name = "pasword") String pasword) {
		
		Proveedor proveedor = new Proveedor(idProveedor, nombre, telefono, pasword);
		this.serviceProveedor.crearProveedor(proveedor);
		return "registrarProveedor";
	}
	
	@RequestMapping(value = "/proveedor/listarProveedores", method= RequestMethod.GET)
	public String listarProveedores(Model model){
		List<Proveedor> proveedores = this.serviceProveedor.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		return "ListadoProveedores";
	}
	
	@RequestMapping(value= "/proveedor/buscarProveedor", method= RequestMethod.GET)
	public Proveedor buscarProveedor(@RequestParam(name = "id") int idProveedor) {
		return this.serviceProveedor.buscarProveedor(idProveedor);
	}
		

	
	
	
	
//=================================================================================================	
// Limpieza
//=================================================================================================
// HTML Limpieza
//=================================================================================================
			
	
	@GetMapping("/limpieza/crearLimpieza")
	public String registrarLimpieza() {
		return "registrarLimpieza";
	}
	
	@GetMapping("/limpieza/detalle/{id}")
	public String detalleLimpieza(@PathVariable("id") int id, 
			                     Model model) {
		Limpieza limpieza = this.serviceLimpieza.buscarLimpieza(id);
		model.addAttribute("limíeza", limpieza);
		return "buscarLimpieza";
	}
	
	
	@RequestMapping(value = "/limpieza/crearLimpieza", method= RequestMethod.POST)
	public String crearLimpieza(@RequestParam(name = "id") int idLimpieza,
			                      @RequestParam(name = "horaInicio") String horaInicio,  
	                              @RequestParam(name = "horaFinal") String horaFinal,
	                              @RequestParam(name = "cantidadEmpleados") int cantidadEmpleados,
	                              @RequestParam(name = "idEmpleado") int idEmpleado) {
	
		
		Empleado e = this.serviceEmpleado.buscarEmpleado(idEmpleado);
		Limpieza limpieza = new Limpieza(idLimpieza, horaInicio, horaFinal, cantidadEmpleados, e);
		this.serviceLimpieza.crearLimpieza(limpieza);
		return "registrarLimpieza";	
	}
	
	@RequestMapping(value = "/limpieza/buscarLimpieza", method= RequestMethod.GET)
	public Limpieza buscarLimpieza(@RequestParam(name = "id") int idLimpieza) {
		return this.serviceLimpieza.buscarLimpieza(idLimpieza);
	}
	
	@RequestMapping(value = "/limpieza/listarLimpiezas", method= RequestMethod.GET)
	public String listarLimpiezas(Model model){
		List<Limpieza> limpiezas = this.serviceLimpieza.listarLimpiezas();
		model.addAttribute("limpiezas", limpiezas);
		return "ListadoLimpiezas";
	}
	
	/*@RequestMapping(value = "/limpieza/listarLotesLimpiados", method = RequestMethod.GET)
	public List<Lote> lotesLimpiados(@RequestParam(name = "id") int idLimpieza){
		return this.serviceLimpieza.buscarLimpieza(idLimpieza).getLotesLimpiados();
	}*/
	
	@RequestMapping(value = "/limpieza/obtenerEmpleado", method = RequestMethod.GET)
	public String obtenerEmpleado(@RequestParam(name = "id") int idLimpieza) {
		String datos="";
		datos = " ID: " + this.serviceLimpieza.buscarLimpieza(idLimpieza).getEmpleado().getIdEmpleado() +
				" Nombre: " + this.serviceLimpieza.buscarLimpieza(idLimpieza).getEmpleado().getNombre() +
				" Puesto: " + this.serviceLimpieza.buscarLimpieza(idLimpieza).getEmpleado().getPuesto();
		return datos;
	}
	
//=================================================================================================	
// Lote
//=================================================================================================	
// HTML Lote
//=================================================================================================
			
	@GetMapping("/lote/crearLote")
	public String registrarLote() {
		return "registrarLote";
	}
	
	@GetMapping("/lote/detalle/{id}")
	public String detalleLote(@PathVariable("id") int id, 
			                     Model model) {
		Lote lote = this.serviceLote.buscarLote(id);
		model.addAttribute("lote", lote);
		return "buscarLote";
	}
	
	@RequestMapping(value = "/lote/crearLote", method = RequestMethod.POST)
	public String crearLote(@RequestParam(name = "id") int idLote,
			              @RequestParam(name = "estado") String estado,
                          @RequestParam(name = "calidad") int calidad,
                          @RequestParam(name = "peso") double peso,
                          @RequestParam(name = "precio") double precio,
			              @RequestParam(name = "idEmpleado") int idEmpleado,
			              @RequestParam(name = "idLimpieza") int idLimpieza,
			              @RequestParam(name = "idPescado") int idPescado,
			              @RequestParam(name = "idProveedor") int idProveedor) {
		
		Empleado e = this.serviceEmpleado.buscarEmpleado(idEmpleado);
		Limpieza l = this.serviceLimpieza.buscarLimpieza(idLimpieza);
		Pescado pes = this.servicePescado.buscarPescado(idPescado);
		Proveedor pro = this.serviceProveedor.buscarProveedor(idProveedor);
		Lote lote = new Lote(idLote, estado, calidad, peso, precio, e, l, pes, pro);
	    this.serviceLote.crearLote(lote);
		return "registrarLote";
	}
	
	@RequestMapping(value = "/lote/listarLotes", method = RequestMethod.GET)
	public String listadoLotes(Model model){
		List<Lote> lotes = this.serviceLote.listarLotes();
		model.addAttribute("lotes", lotes);
		return "ListadoLotes";
	}
	
	@RequestMapping(value = "/lote/obtenerEmpleado", method = RequestMethod.GET)
	public Empleado obtenerEmpleadoLote(@RequestParam(name = "id") int idLote) {
		return this.serviceLote.buscarLote(idLote).getEmpleado();
	}
	
	@RequestMapping(value = "/lote/obtenerLimpieza", method = RequestMethod.GET)
	public Limpieza obtenerLimpiezaLote(@RequestParam(name = "id") int idLote) {
		return this.serviceLote.buscarLote(idLote).getLimpieza();
		
	}
	
//=================================================================================================	
// Producto
//=================================================================================================	
// HTML Pescado
//=================================================================================================
			
	@GetMapping("/producto/crearProducto")
	public String registrarProducto() {
		return "registrarProducto";
	}
	
	@GetMapping("/producto/detalle/{id}")
	public String detalleProducto(@PathVariable("id") int id, 
			                      Model model) {
		Producto producto = this.serviceProducto.obtenerProducto(id);
		model.addAttribute("producto", producto);
		return "buscarProducto";
	}
	
	
	
	@RequestMapping(value = "/producto/crearProducto", method = RequestMethod.POST)
	public String crearProducto(@RequestParam(name = "id") int idProducto,
			                      @RequestParam(name = "peso") double peso,
			                      @RequestParam(name = "precio") double precio,
			                      @RequestParam(name = "descripcion") String descripcion,
	                              @RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE) LocalDate fecha,
			                      @RequestParam(name = "cantidadLatas") int cantidadLatas,
			                      @RequestParam(name = "idPescado") int idPescado,
			                      @RequestParam(name = "idLote") int idLote) {
		
		Pescado p = this.servicePescado.buscarPescado(idPescado);
		Lote l = this.serviceLote.buscarLote(idLote);
		Producto producto = new Producto(idProducto, peso, precio, descripcion, fecha, cantidadLatas, p, l);
		this.serviceProducto.crearProducto(producto);
		return "registrarProducto";
	}
	
	@RequestMapping(value = "/producto/buscarProducto", method = RequestMethod.GET)
	public Producto buscarProducto(@RequestParam(name = "id") int idProducto) {
		return this.serviceProducto.obtenerProducto(idProducto);
	}
	
	@RequestMapping(value = "/producto/listarProductos", method = RequestMethod.GET)
	public String listadoProductos(Model model){
		List<Producto> productos = this.serviceProducto.listarProductos();
		model.addAttribute("productos", productos);
		return "ListadoProductos";
	}
	
	@RequestMapping(value = "/producto/obtenerTipoPescadoProducto", method = RequestMethod.GET)
	public String pescadoEnProducto(@RequestParam(name = "id") int idProducto) {
		return this.serviceProducto.obtenerProducto(idProducto).getPescado().getTipo();
	}	
	
	@RequestMapping(value = "/producto/agregarMas", method = RequestMethod.POST)
	public String agregarCantidadMas(@RequestParam(name = "id") int idProducto,
			@RequestParam(name = "cantidad") float cantidad) {

		int acumulador = 0;
		Producto p = this.serviceProducto.obtenerProducto(idProducto);
		acumulador += p.getCantidadLatas() + cantidad;
		this.serviceProducto.actualizarCantidadExistente(acumulador, idProducto);
		return "paginaGeneral";
	}
	
	
	
//=================================================================================================	
// FacturaVenta
//=================================================================================================	
// HTML FacturaVenta
//=================================================================================================
		
	@RequestMapping(value = "/facturaVenta/crearFacturaVenta", method = RequestMethod.GET)
	public FacturaVenta crearFacturaVenta(@RequestParam(name = "id") int idVenta,
			                              @RequestParam(name = "idEmpleado") int idEmpleado,
                                          @RequestParam(name = "idCliente") int idCliente,
			                              @RequestParam(name = "fecha") String fecha,
			                              @RequestParam(name = "lugar") String lugar) {
		Empleado e = this.serviceEmpleado.buscarEmpleado(idEmpleado);
		Cliente c = this.serviceCliente.buscarCliente(idCliente);
		FacturaVenta factura = new FacturaVenta(idVenta, e, c, fecha, lugar);
		this.serviceFacturaVenta.crearFacturaVenta(factura);
		return factura;
	}
	
	@RequestMapping(value = "/facturaVenta/buscarFactura", method = RequestMethod.GET)
	public FacturaVenta obtenerFactura(@RequestParam(name = "id") int idVenta) {
		return this.serviceFacturaVenta.buscarFactura(idVenta);
	}
	
	@RequestMapping(value = "/facturaVenta/listarFacturas", method = RequestMethod.GET)
	public List<FacturaVenta> listadoFacturas(){
		return this.serviceFacturaVenta.listarFacturas();
	}
	
	@RequestMapping(value = "/facturaVenta/eliminarFacturaVenta", method = RequestMethod.GET)
	public void eliminarFacturaVenta(@RequestParam(name = "idFacturaVenta") int idFacturaVenta) {
		FacturaVenta tmpFacturaVenta = this.serviceFacturaVenta.buscarFactura(idFacturaVenta);
		this.serviceFacturaVenta.eliminarFacturaVenta(tmpFacturaVenta);
		return;

	}
		
//=================================================================================================	
// Contenido
//=================================================================================================	
// HTML Contenido
//=================================================================================================
	/*	
	
	@RequestMapping(value = "/contenido/crearContenido", method = RequestMethod.GET)
	public Contenido agregarContenido(@RequestParam(name = "idProducto") int idProducto,
			                          @RequestParam(name = "idFactura") int idFactura,
			                          @RequestParam(name = "cantidad") int cantidad,
			                          @RequestParam(name = "precio") double precio) {
		
	
		Contenido contenido = new Contenido(idProducto, idFactura, cantidad, precio);
		this.serviceContenido.crearContenido(contenido);
		return contenido;
	}
	
	@RequestMapping(value = "/contenido/buscarContenido", method = RequestMethod.GET)
	public Contenido obtenerContenido(@RequestParam(name = "idProducto") int idProducto,
			                          @RequestParam(name = "idFactura") int idFactura) {
		
		IdContenido idContenido = new IdContenido(idProducto, idFactura);
		return this.serviceContenido.buscarContenido(idContenido);
	}
	
	@RequestMapping(value = "/contenido/listarContenido", method = RequestMethod.GET)
	public List<Contenido> contenido(){
		return this.serviceContenido.listarContenido();
	}
	*/

	
/*	
	@RequestMapping(value = "/producto/actualizarInventario", method = RequestMethod.POST)
	public String actualizarInventario(@RequestParam(name = "id") int idPedido) {

		Pedido p = this.servicePedido.buscarPedido(idPedido);
		Cliente c = this.serviceCliente.buscarCliente(p.getCliente().getIdCliente());
		this.serviceCliente.actualizarLimiteCreditoCliente(acumulador, c.getIdCliente());
		List<Lista> tmpListasPedido = this.serviceLista.obtenerListasProductos();

		for (int i = 0; i < tmpListasPedido.size(); i++) {

			if (tmpListasPedido.get(i).getIdPedido() == idPedido) {

				this.actualizarCantidad(tmpListasPedido.get(i).getCantidad(), tmpListasPedido.get(i).getIdProducto());
			}

		}

		return "paginaGeneral";
	}
*/	
	
	
}
