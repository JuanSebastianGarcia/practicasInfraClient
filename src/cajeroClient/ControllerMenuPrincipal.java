package cajeroClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ControllerMenuPrincipal {

	
	public Main mainClass=Main.getInstance();
	
	
	
	
	@FXML
    private Button btnCargarArchivo;

    @FXML
    private Button btnConsultarInformacion;

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnDepositarDinero;

    @FXML
    private Button btnRetirarDinero;

    @FXML
    private Button btnSalir;

    
    
    
    
    
    /*
     * METODO QUE INICIA LA OPCION QUE CARGA UN ARCHIVO
     */
    @FXML
    void btnCargarArchivoEvent(ActionEvent event) {

    	mainClass.buscarArchivoTxt();
    	
    }

    
    
    /*
     * METODO QUE INICIA LA OPCION QUE CONSULTA LA INFORMACION DE UN CLIENTE
     */
    @FXML
    void btnConsultarInformacionEvent(ActionEvent event) {

    	mainClass.consultarInformacion();
    }

    
    
    /*
     *METODO QUE INICIA LA OPCION PARA CREAR LA CUENTA DE UN CLIENTE 
     */
    @FXML
    void btnCrearCuentaEvent(ActionEvent event) {

    	mainClass.crearCuenta();
    }

    
    /*
     * METODO QUE INICIA LA OPCION PARA DEPOSITAR DINERO A LA CUENTA DE UN CLIENTE
     */
    @FXML
    void btnDepositarDineroEvent(ActionEvent event) {

    	mainClass.agregarDinero();
    }

    
    /*
     * METODO QUE INICIA LA OPCION PARA RETIRAR DINERO DE UNA CUENTA
     */
    @FXML
    void btnRetirarDineroEvent(ActionEvent event) {

    	mainClass.retirarDinero();
    }

    
    
    @FXML
    void btnSalirEvent(ActionEvent event) {


    		//DE ESTA MANERA SE CIERRA LA VENTANA
    		Object eventSource=event.getSource();
    		Node nodo=(Node)eventSource;
    		Scene oldScene=(Scene)nodo.getScene();
    		Window window=oldScene.getWindow();
    		Stage stage=(Stage)window;
    		stage.hide();

    	


    }
}
