public class Banco {
    private Pessoa cliente;
    private int numeroConta;
    private double saldo;


    public Banco(Pessoa cliente, int numeroConta, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;

    }

    public Pessoa getCliente() {
        return cliente;
    }

    public int getNumeroConta() {
        return numeroConta;

    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}

