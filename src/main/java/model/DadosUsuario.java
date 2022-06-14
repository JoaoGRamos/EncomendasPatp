package model;

public final class DadosUsuario {
    private static DadosUsuario instance;
    public Usuario usuario;

    private DadosUsuario(Usuario u) {
        this.usuario = u;
    }

    public static DadosUsuario getInstance(Usuario u) {
        if (instance == null) {
            instance = new DadosUsuario(u);
        }
        return instance;
    }
}

