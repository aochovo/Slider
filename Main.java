/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg003Slider;



import java.util.ArrayList;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class Main extends Application implements ChangeListener{
Label lbl_texto;
Button btn_cambiar;
Slider opacidad;
Image imagen;
ImageView cappuccino;
   public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception  {
            VBox v=new VBox(20);
        Scene scene=new Scene(v, 300, 500);
	opacidad = new Slider(0, 1, 1);
         /*
        Slider slider=new Slider(min, max, valor);
        Primero creamos el Slider. Tiene tres parámetros:
        min: valor minimo a donde llega el Slider.
        max: valor maximo a donde llega el Slider.
        valor: valor en el cual quieres queempiece el Slider por defecto.
        */
	opacidad.setShowTickLabels(true);
         /*
        Con este metodo, nos permite enseñarnos los valores establecidos en min y max.
        */
        opacidad.setShowTickMarks(true);
         /*
        Con este metodo, nos permite enseñarnos los valores establecidos en min y max.
        */
       imagen=new Image(getClass().getResourceAsStream("cappuccino.jpg"));
       cappuccino = new ImageView (imagen);
       cappuccino.setX(50);
       cappuccino.setY(50);
       cappuccino.setFitHeight(300);
       cappuccino.setFitWidth(300);
       lbl_texto=new Label();
       lbl_texto.setText("OPACIDAD");

               
        opacidad.valueProperty().addListener(this);
        /*
        Aqui le metemos al Slider un listenner para que este atento a cuaquier cambioque se produzca en la barra.
        */
        v.getChildren().addAll(cappuccino,lbl_texto, opacidad);         
        primaryStage.setScene(scene);
        primaryStage.show();	
	}

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
       Double nivel_opacidad=opacidad.getValue();
       cappuccino.setOpacity(nivel_opacidad);
       /*
       Primero con getValue conseguimos un float que indica en que nivel se encuentra el Sider
       Luego le seteamos a la imagen el nivel de opacidad conseguio anteriormente.
       */
    }
}
