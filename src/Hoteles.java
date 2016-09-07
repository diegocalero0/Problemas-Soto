import javax.swing.JOptionPane;

public class Hoteles {

	Sede EdificioA,EdificioB;
	int totalRegistrados, habOcupadas;
	
	public void crearSedeA(){
		String nombre;
		String ciudad;
		String direccion;
		int pisos,habxPisos;
		
		nombre=JOptionPane.showInputDialog("Ingrese un nombre de la sede A");
		ciudad=JOptionPane.showInputDialog("Ingrese una ciudad de la sede A");
		direccion=JOptionPane.showInputDialog("Ingrese la direccion de la sede A");
		pisos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pisos de la sede A"));
		habxPisos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitaciones por piso de la sede A"));
		
		EdificioA = new Sede(nombre,direccion,ciudad,pisos,habxPisos);
		
	}
	
	public void crearSedeB(){
		String nombre;
		String ciudad;
		String direccion;
		int pisos,habxPisos;
		
		nombre=JOptionPane.showInputDialog("Ingrese un nombre de la sede B");
		ciudad=JOptionPane.showInputDialog("Ingrese una ciudad de la sede B");
		direccion=JOptionPane.showInputDialog("Ingrese la direccion de la sede B");
		pisos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de pisos de la sede B"));
		habxPisos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitaciones por piso de la sede B"));
		
		EdificioB = new Sede(nombre,direccion,ciudad,pisos,habxPisos);
		
	}
	
	public void registro(){
		String sede=JOptionPane.showInputDialog("Ingrese la sede en la que se desea registrar");
		if(sede.equalsIgnoreCase("A")){
			EdificioA.ingresoHabitacion();
		}else{
			EdificioB.ingresoHabitacion();
		}
	}
	
	public void salida(){
		String sede=JOptionPane.showInputDialog("Ingrese la sede en la que se registra la salida");
		if(sede.equalsIgnoreCase("A")){
			EdificioA.retiroHabitacion();
		}else{
			EdificioB.retiroHabitacion();
		}
	}
	
	public void consultaClientes(){
		int totalEnA,totalEnB,totalRegistrados;;
		totalEnA=EdificioA.totalClientes();
		totalEnB=EdificioB.totalClientes();
		totalRegistrados=totalEnA+totalEnB;
		JOptionPane.showMessageDialog(null,"Ocupacion en A: "+totalEnA+" personas\n"
				+"Ocupacion en B: "+totalEnB+" personas\n"
				+"Total de clientes registrados: "+totalRegistrados);
	}
	
	public void porcentajes(){
		JOptionPane.showMessageDialog(null, "Sede A: "+EdificioA.porcentajeOcupacion()+"%\n"
				+"Sede B: "+EdificioB.porcentajeOcupacion()+"%");
	}
	
	public void habOcupadas(){
		int ocupadasA = EdificioA.habitacionesOcupadas();
		int ocupadasB = EdificioB.habitacionesOcupadas();
		int ocupadasTotal = ocupadasA+ocupadasB;
		JOptionPane.showMessageDialog(null, "Habitaciones ocupadas en A: "+ocupadasA+"\n"
				+"Habitaciones ocupadas en B: "+ocupadasB+"\n"
				+"Habitaciones ocupadas en total: "+ocupadasTotal);
	}
	
	public static void main(String[] args) {
		Hoteles h = new Hoteles();
		int opcion;
		h.crearSedeA();
		h.crearSedeB();
		
		do{
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Elija entre las siguientes "
					+ "opciones presionando el numero que corresponda:\n"
					+"1. Registro de nuevo huesped.\n"
					+"2. Retiro de huesped.\n"
					+"3. Ver cantidad de clientes.\n"
					+"4. Ver porcentaje de ocupacion.\n"
					+"5. Ver cantidad de habitaciones ocupadas.\n"
					+"0. Salir de la aplicacion"));
			
			switch(opcion){
			case 1: h.registro();
				break;
			case 2: h.salida();
				break;
			case 3: h.consultaClientes();
				break;
			case 4: h.porcentajes();
				break;
			case 5: h.habOcupadas();
				break;
			
			}
		}while(opcion!=0);
		
	}

}
