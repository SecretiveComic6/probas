package Cliente;

import Modelo.ModeloVotos;
import Vistas.GraficaBarras;
import Vistas.GraficaPastel;
import Vistas.VotosVista;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class cliente {
    
    public static void main(String[] args) throws IOException {
        
        int brokerPort = 12345;
        String brokerHost = "localhost";
        
        VotosVista votosVista = new VotosVista();
        votosVista.setVisible(true);

        GraficaBarras graficaBarras = new GraficaBarras("Votos de Candidatos");
        graficaBarras.pack();
        graficaBarras.setVisible(true);

        votosVista.setGraficaBarras(graficaBarras);
        
        GraficaPastel graficaPastel = new GraficaPastel("Votos de Candidatos");
        graficaPastel.pack();
        graficaPastel.setVisible(true);
        
        votosVista.setGraficaPastel(graficaPastel);
        
        // Establecer conexión con el broker en lugar del servidor directamente
            try (Socket cliente = new Socket(brokerHost, brokerPort)) {
            ObjectOutputStream salidaDatos = new ObjectOutputStream(cliente.getOutputStream());

            ModeloVotos votos = new ModeloVotos();

            // Crear un objeto que contenga la acción votar y los datos
            AccionVoto accionVoto = new AccionVoto("votar", votos);

            // Enviar el objeto al broker
            salidaDatos.writeObject(accionVoto);
        }
        
    }
    
}
