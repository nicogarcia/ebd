package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ThreadHorayFecha extends Thread {
	 private JLabel fecha;
	 private JLabel hora;
	 private Date dia;
	
     public ThreadHorayFecha(JLabel hor,JLabel fech) {
    	 	hora=hor;
    	 	fecha=fech;
      }
 
      public void run() {
    	  while(true){
	    	  hora.setText(getHoraActual());
	    	  hora.repaint();
	    	  fecha.setText(getFechaActual());
	    	  fecha.repaint();
	    	  try {
				sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	  }
      }
      
      //Metodo usado para obtener la fecha actual
      //@return Retorna un <STRING> con la fecha actual formato "yyyy-MM-dd"
      public static String getFechaActual() {
          Date ahora = new Date();
          SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
          return formateador.format(ahora);
      }

      //Metodo usado para obtener la hora actual del sistema
      //@return Retorna un <STRING> con la hora actual formato "hh:mm"
      public static String getHoraActual() {
          Date ahora = new Date();
          SimpleDateFormat formateador = new SimpleDateFormat("HH:mm");
          return formateador.format(ahora);
      }
}