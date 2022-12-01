package br.senai.sp.jandira.testes;

import java.util.ArrayList;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.PlanoDeSaude;

public class TesteArrayList {

	public static void main(String[] args) {

//		//Vetor com 3 planos de saúde
//		PlanoDeSaude plano1 = new PlanoDeSaude();
//		plano1.setOperadora("Unimed");
//		plano1.setTipoDoPlano("Bronze");
//		
//		//Construtores da Classe
//		PlanoDeSaude plano3 = new PlanoDeSaude("Anil");
//		
//		PlanoDeSaude[] planos = {
//				plano1, 
//				new PlanoDeSaude("Porto Seguro"),
//				new PlanoDeSaude("Allianz", "Ouro")
//		};
//		
////		System.out.println(planos[0].getOperadora());
////		System.out.println(planos[1].getOperadora());
////		System.out.println(planos[2].getOperadora());
//		
//		ArrayList<String> cidades = new ArrayList<>();
//		cidades.add("Jandira");
//		cidades.add("São Paulo");
//		cidades.add("Itapevi");
//		cidades.add("Barueri");
//		cidades.add("Cotia");
//		
//		ArrayList<PlanoDeSaude> planos2 = new ArrayList<>();
//		
//		planos2.get(0).setTipoDoPlano("Basic");
//		planos2.add(new PlanoDeSaude("Ativia", "Advanced"));
//		planos2.add(new PlanoDeSaude("Bio Saúde"));
//      .add(new PlanoDeSaude("Blue Med", "Exclusive"));
//	
//		
//		
//		PlanoDeSaude planoNovo = new PlanoDeSaude();
//		planoNovo.setOperadora("Ameplan");
//		planoNovo.setTipoDoPlano("Prata");
//		
//		planos2.add(planoNovo);
//		System.out.println(planos2.get(4).getDadosDoPlano());
//		
//		int nota1 = 10;
//		Integer nota2 = 5;
//		
//		ArrayList<Double> precosList = new ArrayList<>();
//		precosList.add(5.9);
//		
////		System.out.println(planos2);
////		System.out.println(cidades.get(4));
////		System.out.println(cidades.size());
////	
//		PlanoDeSaudeDAO dao = new PlanoDeSaudeDAO();

//		dao.gravar(plano1);
//		dao.gravar(plano2);

//		System.out.println(dao.listarTodos());

		// Planos concretos:
		PlanoDeSaude plano1 = new PlanoDeSaude("Amil", "Basic");
		PlanoDeSaude plano2 = new PlanoDeSaude("Allianz", "Expert");
		PlanoDeSaude plano3 = new PlanoDeSaude("Unimed", "Prata");
		PlanoDeSaude plano4 = new PlanoDeSaude("Notredame", "Advanced");

		// Lista criada e adicionando os planos nele do tipo "PlanoDeSaude".
		ArrayList<PlanoDeSaude> planos = new ArrayList<>();
		planos.add(plano1);
		planos.add(plano2);
		planos.add(plano3);
		planos.add(plano4);
		
		int i = 0;
		while (i < planos.size()){
			System.out.println(planos.get(i).getOperadora());
			i++;
		}
		System.out.println("Saiu do looping!!");
	
		//Looping FOR
		
		Especialidade especialidade1 = new Especialidade("Cardiolista");
		Especialidade especialidade2 = new Especialidade("Clínico Geral");
		Especialidade especialidade3 = new Especialidade("Otorrinolaringologista");
		
		ArrayList<Especialidade> especialidades = new ArrayList<>();
		especialidades.add(especialidade1);
		especialidades.add(especialidade2);
		especialidades.add(especialidade3);
		
		for (Especialidade especialidade : especialidades) {
			System.out.println(especialidade.getDescricao());
		}
	}
}
