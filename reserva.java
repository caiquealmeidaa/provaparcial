
public class reserva {

	int pagamento;
    String nome;
    String cpf;
    String telefone;
    
    public String GetDados() {
    	
    	String aux = "";
    	aux += "Nome:"+nome+"\n";
    	aux += "CPF:"+cpf+"\n";
    	aux += "Pagamento:"+pagamento+"\n";
    	aux += "Telefone:"+telefone+"\n";
    	aux +="Preço à pagar:"+calPagamento()+"\n";
    	return aux;
    }
	
    public double calPagamento() {
    	double valor = 0;
    	if(pagamento==1) {
    		valor = 3200 - 320;
    		
    	}
    	else {
    		valor = 3200 + ((3200/100)*15);
    		
    		
    	}
    	
    	return valor;
    
    }
    
}
