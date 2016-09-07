import javax.swing.JOptionPane;

public class Sede {
	
	private int[][] cuartos;
	private String nombre;
	private String direccion;
	private String ciudad;
	private int pisos;
	private int habxPisos;
	
	public Sede(String nombre,String direccion,String ciudad,int pisos,int habxPisos){
		cuartos=new int[pisos][habxPisos];
		for (int i = 0; i < pisos; i++) {
			for (int j = 0; j < habxPisos; j++) {
				cuartos[i][j]=0;
			}
		}
		
		this.nombre=nombre;
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.pisos=pisos;
		this.habxPisos=habxPisos;
		
	}
	
	public void ingresoHabitacion(){
		for (int i = 0; i < pisos; i++) {
			for (int j = 0; j < habxPisos; j++) {
				if(cuartos[i][j]==0){
					cuartos[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de huespedes"));
					JOptionPane.showMessageDialog(null, "Ingreso en el piso: "+i+" ,Y habitacion: "+j);
					return;
				}
			}
		}
	}
	
	public void retiroHabitacion(){
		int piso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el piso en el que se encuentra"));
		int habitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la habitacion en la que se encuentra"));
		cuartos[piso][habitacion]=0;
	}
	
	public int totalClientes(){
		int suma=0;
		for (int i = 0; i < pisos; i++) {
			for (int j = 0; j < habxPisos; j++) {
				suma+=cuartos[i][j];
			}
		}
		return suma;
	}
	
	public int habitacionesOcupadas(){
		int suma=0;
		for (int i = 0; i < pisos; i++) {
			for (int j = 0; j < habxPisos; j++) {
				if(cuartos[i][j]!=0){
					suma++;
				}
			}
		}
		return suma;
	}
	
	public double porcentajeOcupacion(){
		return (double)(habitacionesOcupadas()*100)/(double)(pisos*habxPisos);
	}
	
	
	
}
