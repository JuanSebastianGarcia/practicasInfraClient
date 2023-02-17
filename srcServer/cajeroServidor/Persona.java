package cajeroServidor;

public class Persona {

	//atributos 
		private String nombre;
		private String cedula;
		private double dineroActual;
		
		
		/*
		 * CONSTRUCTOR
		 */
		public Persona(String nombre,String cedula){
		
			this.nombre=nombre;
			this.cedula=cedula;
			
		}




		//___________METODOS GETTERS AND SETTER______________________//
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public double getDineroActual() {
			return dineroActual;
		}
		public void setDineroActual(double dineroActual) {
			this.dineroActual = dineroActual;
		}
		
}
