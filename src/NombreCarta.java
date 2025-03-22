public enum NombreCarta {
    AS(1), ll(2),lll(3),lV(4), V(5),Vl(6),Vll(7),
    Vlll(8), lX(9),X(10),PRINCIPE(10), REINA(10),REY(10);

    private final int valor;
    NombreCarta(int valor) {this.valor = valor;}
    public int getValor() {return valor;}}
