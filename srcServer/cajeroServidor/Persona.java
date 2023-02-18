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




		
		/*
		 * METODO QUE REALIZA EL PROCESO DE RETIRAR DINERO A UN USUARIO
		 */
		public String retirarDinero(double cantidadDinero) {
			
			String respuesta="lo sentimos, no tiene dinero suficiente";
			
			if(cantidadDinero<=dineroActual){
				dineroActual-=cantidadDinero;
				respuesta="retiro exitoso";
			}

			
			return respuesta;
		}



		/*
		 * METODO QUE AGREGA EL DINERO A LA CUENTA DEL USUARIO
		 */
		public String depositarDinero(double cantidadDinero) {
			
			
			dineroActual+=cantidadDinero;
			
			
			return "el dinero ha sido depositado";
		}




	
		
		
		
		
		@Override
		public String toString() {
			return "Persona [nombre=" + nombre + ", cedula=" + cedula + ", dineroActual=" + dineroActual + "]";
		}

		
		
}
