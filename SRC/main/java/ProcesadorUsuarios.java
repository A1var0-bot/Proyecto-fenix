import java.util.List;
/*
Clase encarga de procesar cadenas de texto para clasificar usuarios
dependiendo de su rol.
*/
public class ProcesadorUsuarios { 
    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

     /**
     Procesa una lista de cadenas con formaro "nombre:rol" y devuelve un resumen clasificado.
    * * @param usuarios lista de Strings con el formato "nombre:ID_ROL".
    * @return una cadena formateada con los nombres de admins e invitados.
    */

    public String procesarLista(List<String> usuarios) {

        String admins = "";
        String invitados = "";

        for (var u : usuarios) {
            String[] parts = u.split(":"); 
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) { // AdminÑ
                    admins = procesarAdmin(admins, nombre);
                }
                else if (rol == ROL_INVITADO) {                    
                     invitados = procesarInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String procesarAdmin(String admins, String nombre) {
        admins += nombre + ",";
        return admins;
    }

    private String procesarInvitado(String invitados, String nombre) {
        // Invitado
        invitados += nombre + ",";
        return invitados;
    }
}