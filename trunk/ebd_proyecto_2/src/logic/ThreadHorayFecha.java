package logic;

import java.util.Calendar;

import javax.swing.JLabel;

class ThreadHorayFecha extends Thread {
	 private JLabel fecha;
	 private JLabel hora;
	
     ThreadHorayFecha(JLabel hor,JLabel fech) {
    	 	hora=hor;
    	 	fecha=fech;
    	 	
      }
 
      public void run() {
    	  String horasYminutos = Calendar.HOUR_OF_DAY+" : "+Calendar.MINUTE;
    	  hora.setText(horasYminutos);
    	  hora.repaint();
    	  String fechadiamesanio = Calendar.DATE+"/"+Calendar.MONTH+"/"+Calendar.YEAR;
    	  fecha.setText(fechadiamesanio);
    	  fecha.repaint();
    	  try {
			sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      }
}