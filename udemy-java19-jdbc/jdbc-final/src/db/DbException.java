package db;

public class DbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }

}

// evita a criação de vários try-catch diferentes no programa
// encapsula as excecoes sql