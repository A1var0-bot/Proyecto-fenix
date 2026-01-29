import java.util.List;

public class ProcesadorUsuarios {
    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (var u : usuarios) {
            String[] parts = u.split(":"); 
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) { // Admin
                    admins = procesarInvitado(admins, nombre);
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
        invitados = procesarAdmin(invitados, nombre);
        return invitados;
    }
}