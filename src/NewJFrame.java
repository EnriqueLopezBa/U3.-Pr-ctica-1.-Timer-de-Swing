
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Enrique
 */
public class NewJFrame extends javax.swing.JFrame {

    Lienzo dibujar = new Lienzo();

    public NewJFrame() {
        initComponents();
        add(dibujar);
    }

    class Lienzo extends Canvas {

        Timer time = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont = new Random().nextInt(39);
            }
        });

        public Lienzo() {

//            setSize(new Dimension(300,300));
//            setLocation(0,0);
            setBounds(0, 0, 500, 350);
            setBackground(Color.white);
            time.start();
            hilo.start();
            hilo2.start();
        }
        int cont = 0;
        String cadenas[] = new String[]{"Cáete siete veces y levántate ocho", "El triunfo del verdadero hombre surge de las cenizas del error.", "Todo lo que puedas imaginar, es real.",
             "El fracaso no es una opción. Todo el mundo tiene que triunfar.", "Un objetivo sin un plan es solo un deseo.", "Lo que haces hoy puede mejorar todos tus mañanas", "Si dominamos nuestra mente, vendrá la felicidad.",
            "Cuanto más hacemos, más podemos hacer.", "Una meta es un sueño con una fecha límite.", "La esperanza es el sueño del hombre despierto",
            "Nunca podrás derrotar a la persona que nunca se rinde.", "Si no te gustan las cosas, ¡cámbialas! No eres un árbol.", "Si te piden que camines un kilómetro, camina dos.", "Para tener éxito, primero debemos creer que podemos hacerlo.",
            "Debes hacer las cosas que crees que no puedes hacer.", "La victoria no lo es todo: ¡es lo único!", "El secreto para salir adelante es comenzar.", "El poder de la imaginación nos hace infinitos.", "El secreto real del éxito es el entusiasmo",
            "La clave de tu futuro está escondida en tu vida diaria.", "El valor es el miedo que ha dicho sus oraciones y decidió seguir adelante de todos modos.", "Cuantas preocupaciones se pierden cuando alguien no decide ser algo, sino alguien.", "Asegúrate que tu peor enemigo no viva entre tus dos oídos.", "Todo tiene moral, sólo tienes que encontrarla.", "No me diga que el cielo es el límite cuando hay huellas en la luna",
            "No duermas para descansar, duerme para soñar. Porque los sueños están para cumplirse", "El fracaso es éxito si aprendemos de él.", "El mejor momento del día es ahora.", "Hacer que tu luz interior brille más brillante es ser quien realmente eres.", "Mantén tus mejores deseos cerca de tu corazón y observa lo que sucede.", "Lo importante no es lo que miras, sino lo que ves.", "Somos dueños de nuestro destino.",
            "Cuando haces lo correcto, obtienes la sensación de paz y serenidad. Hazlo una y otra vez.", "Ganar sin riesgo es triunfar sin gloria.", "Lo que haces marca la diferencia, y tienes que decidir qué tipo de diferencia quieres marcar.", "El éxito depende del esfuerzo.", "Las grandes ideas se enfrentan a menudo con la violenta oposición de las mentes mediocres.", "La fortuna favorece al valiente.", "Cuando estás agradecido, el miedo desaparece y aparece la abundancia."};

        int mov = -100;
        int tam = 0;

        private Color colorRandom() {
            return new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
        }

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {

                        if (mov < dibujar.getWidth()) {
                            mov += 5;
                        } else {
                            mov = (tam) * -1;
                        }

                        Thread.sleep(100);
                        dibujar.repaint();
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
              
        Color color;
        Thread hilo2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                try {
                      color = colorRandom();
                     
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                }
                
                }
            }
        });

        @Override
  public void update(Graphics g){
           super.paint(g);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            if(color !=null)
            g.setColor(color);
            tam = g.getFontMetrics().stringWidth(cadenas[cont]);
            g.drawString(cadenas[cont], mov, 100);
  }
        
        @Override
        public void paint(Graphics g) {
            update(g);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
