package br.com.vsoft.model;

public class Porte {

		int id;
		String Descricao;
		
		//Metodos de acesso
		public 	Porte()
		{
			super();
		}
		
		public Porte(int pId, String pDescricao)
		{
			super();
			setId(pId);
			setDescricao(pDescricao);
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int pId) {
			id = pId;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String pDescricao) {
			Descricao = pDescricao;
		}
		
		@Override
		public String toString() {
			
			StringBuilder tBuilder = new StringBuilder();
			tBuilder.append("[");
			tBuilder.append(getId());
			tBuilder.append(",");
			tBuilder.append(getDescricao());
			tBuilder.append("]");
			return super.toString();
		}
		
		

}
