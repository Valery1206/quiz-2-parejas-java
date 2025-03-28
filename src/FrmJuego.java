import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {

    private JButton btnRepartir;
    private JButton btnResultado;
    private JButton btnVerificar;
    private JPanel pnlJugador1;
    private JPanel pnlJugador2;
    private JTabbedPane tpJugadores;

    private Jugador jugador1, jugador2;

    public FrmJuego() {
        btnRepartir = new JButton();
        btnResultado = new JButton();
        btnRepartir = new JButton();
        btnVerificar = new JButton();
        tpJugadores = new JTabbedPane();
        pnlJugador1 = new JPanel();
        pnlJugador2 = new JPanel();

        setSize(600, 300);
        setTitle("Que comience el Juego de Cartas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlJugador1.setBackground(new Color(153, 255, 51));
        pnlJugador1.setLayout(null);
        pnlJugador2.setBackground(new Color(0, 255, 255));
        pnlJugador2.setLayout(null);

        tpJugadores.setBounds(10, 40, 550, 170);
        tpJugadores.addTab("Walter", pnlJugador1);
        tpJugadores.addTab("Doralba", pnlJugador2);

        btnRepartir.setBounds(10, 10, 100, 25);
        btnRepartir.setText("Repartir");
        btnRepartir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRepartirClick(evt);
            }
        });

        btnVerificar.setBounds(150, 10, 100, 25);
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVerificarClick(evt);
            }
        });
        btnResultado.setBounds(300,10,100,25);
        btnResultado.setText("Resultado");
        btnResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResultadoClick(evt);
            }
        });


        getContentPane().setLayout(null);
        getContentPane().add(tpJugadores);
        getContentPane().add(btnRepartir);
        getContentPane().add(btnVerificar);
        getContentPane().add(btnResultado);


        jugador1 = new Jugador();
        jugador2 = new Jugador();
    }

    private void btnRepartirClick(ActionEvent evt) {
        jugador1.repartir();
        jugador1.mostrar(pnlJugador1);

        jugador2.repartir();
        jugador2.mostrar(pnlJugador2);
    }

    private void btnVerificarClick(ActionEvent evt) {

        if (pnlJugador1.getComponentCount() == 0 && pnlJugador2.getComponentCount() == 0) {
            JOptionPane.showMessageDialog(null, "Quieres jugar sin agarrar cartas? Mal ahi.");

        }else {
            switch (tpJugadores.getSelectedIndex()) {
                case 0:
                 JOptionPane.showMessageDialog(null, jugador1.getGrupos() + "\nWalter saco: (" + jugador1.getPuntajeCartas() + ")");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, jugador2.getGrupos()+ "\nDoralba saco: (" + jugador2.getPuntajeCartas() + ")");
                    break;
            }        
        }
    }
    private void btnResultadoClick(ActionEvent evt) {
    
        if (pnlJugador1.getComponentCount() == 0 && pnlJugador2.getComponentCount() == 0) {
            JOptionPane.showMessageDialog(null, "ERROR: Por favor reparta las cartas.");

        }else if (jugador1.getPuntajeCartas() < jugador2.getPuntajeCartas()) {
            int Resta = Math.abs(jugador1.getPuntajeCartas() - jugador2.getPuntajeCartas());
            JOptionPane.showMessageDialog(null, "El jugador Walter ha ganado el juego con una diferencia de " + Resta + " Puntos.");
//Math.abs es para transformar mi numero a positivo ya que asi me daba negativo.

        }else if (jugador1.getPuntajeCartas() > jugador2.getPuntajeCartas()) {
            int Resta = Math.abs(jugador2.getPuntajeCartas() - jugador1.getPuntajeCartas());
            JOptionPane.showMessageDialog(null, "La jugadora Doralba ha ganado el juego con una diferencia de " + Resta + " Puntos.");
            
        }




    }

        
}

