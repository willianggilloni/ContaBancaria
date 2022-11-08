package contaBancaria.model;

public abstract class Conta {

		private int numero;
		private int agencia;
		private int tipo;
		private String titular;
		private float saldo;
		
		public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
			this.numero = numero;
			this.agencia = agencia;
			this.tipo = tipo;
			this.titular = titular;
			this.saldo = saldo;
		}
		
		public Conta() {
			
		}
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getAgencia() {
			return agencia;
		}

		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}
		
		public boolean sacar(float valor) {
			
			if(getSaldo()< valor) {
				System.out.println("Saldo insuficiente!");
			return false;
			}
			
			setSaldo(getSaldo() - valor);
			return true;
		}
		
		public void depositar(float valor) {
			this.setSaldo(this.getSaldo() + valor);
		}
		public void visualizar() {
			
			String tipo = "";
			
			switch(this.tipo) {
			case 1:
				tipo = "Conta Corrente";
				break;
			case 2:
				tipo = "Conta Poupança";
				break;
			}
			System.out.println("\n************************************************");
			System.out.println("Dados da conta");
			System.out.println("\n************************************************");
			System.out.println("\nNumero da conta: " + getNumero());
			System.out.println("\nNumero da agencia: " + this.agencia);
			System.out.println("\nTipo da conta: " + tipo);
			System.out.println("\nTitular da conta: " + this.titular);
			System.out.println("\nSaldo da conta: " + this.saldo);
		}
		
}
