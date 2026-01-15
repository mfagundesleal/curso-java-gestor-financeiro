public class Conta {
    double saldo = 0;
    String proprietario = "";
    String tipoConta = "";
    double saldoInicial = 0;
    public double getSaldo(){
        return this.saldo;
    }
    public String getProprietario(){
        return this.proprietario;
    }
    public String getTipoConta(){
        return this.tipoConta;
    }
    public double getSaldoInicial(){
        return this.saldoInicial;
    }
    public void setProprietario(String nomeProprietario){
        this.proprietario = nomeProprietario;
    }
    public void setTipoConta(String nomeTipoConta){
        this.tipoConta = nomeTipoConta;
    }
    public void setSaldoInicial(double valorSaldoInicial){
        this.saldoInicial = valorSaldoInicial;
    }
    public void setSaldo(){
        this.saldo += this.saldoInicial;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }
    public void transferir(double valor){
      if(valor > this.saldo){
          System.out.println("Saldo insuficiente");
      }else{
          this.saldo -= valor;
      }
    }
}
