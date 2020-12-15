import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;



public class Main {

	/**
	 * Se afiseaza toti studentii care participa la o disciplina.
	 * @param array Lista de studenti.
	 * @param disciplina Disciplina citita de la tastatura.
	 */
	
	public static void ListaStudentilorInrolatiLaODisciplina(Student[] array, String disciplina) {
		List<String> StudentiENGLEZA = new ArrayList<String>();
		List<String> StudentiFRANCEZA = new ArrayList<String>();
		List<String> StudentiSPANIOLA = new ArrayList<String>();
		List<String> StudentiROMANA = new ArrayList<String>();
		List<String> StudentiMATEMATICA = new ArrayList<String>();
		List<String> StudentiINFORMATICA = new ArrayList<String>();
		List<String> StudentiFIZICA = new ArrayList<String>();
		List<String> StudentiISTORIE = new ArrayList<String>();
		List<String> StudentiGEOGRAFIE = new ArrayList<String>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (Student student : array) {
			for (String curs : student.getListaCursuri()) {
				if (curs.equals("ENGLEZA"))
					StudentiENGLEZA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("FRANCEZA"))
					StudentiFRANCEZA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("SPANIOLA"))
					StudentiSPANIOLA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("ROMANA"))
					StudentiROMANA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("MATEMATICA"))
					StudentiMATEMATICA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("INFORMATICA"))
					StudentiINFORMATICA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("FIZICA"))
					StudentiFIZICA.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("ISTORIE"))
					StudentiISTORIE.add(student.getPrenume() + " " + student.getNume());
				if (curs.equals("GEOGRAFIE"))
					StudentiGEOGRAFIE.add(student.getPrenume() + " " + student.getNume());

			}
		}

		map.put("ENGLEZA", StudentiENGLEZA);
		map.put("FRANCEZA", StudentiFRANCEZA);
		map.put("SPANIOLA", StudentiSPANIOLA);
		map.put("ROMANA", StudentiROMANA);
		map.put("MATEMATICA", StudentiMATEMATICA);
		map.put("INFORMATICA", StudentiINFORMATICA);
		map.put("FIZICA", StudentiFIZICA);
		map.put("ISTORIE", StudentiISTORIE);
		map.put("GEOGRAFIE", StudentiGEOGRAFIE);

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();

			if (key.equals(disciplina))

				System.out.println("La cursul " + key + " participa urmatorii studenti: " + value.toString());

		}

	}
	
	/**
	 * Se afiseaza toti studentii care nu au platit taxa de studiu.
	 * @param array Lista de studenti.
	 */

	public static void ListaStudentilorCareNuAuPlatitTaxaCursurilor(Student[] array) {
		List<String> a = new ArrayList<String>();

		for (Student student : array) {
			if (student.vSoldTrecut() == false) {
				a.add(student.getPrenume() + " " + student.getNume());
			}
		}

		System.out.println("Lista studentilor care nu au platit taxa de studiu: ");
		System.out.println(a.toString());

	}

	public static void ListStudentilorCareNuAuSuficientePrezente(Student[] array) {
		List<String> a = new ArrayList<String>();

		for (Student student : array) {
			if (student.vNumarPrezenteTrecut() == false) {
				a.add(student.getPrenume() + " " + student.getNume());
			}
		}

		System.out.println("Lista studentilor care nu au suficiente prezente: ");
		System.out.println(a.toString());
	}

	/**
	 * Se afiseaza toti studentii care nu au promovat la o disciplina.
	 * @param array Lista de studenti.
	 * @param disciplina Disciplina citita de la tastatura.
	 */
	
	public static void ListaStudentilorCareNuAuPromovatLaODisciplina(Student[] array, String disciplina) {

		List<String> StudentiENGLEZA = new ArrayList<String>();
		List<String> StudentiFRANCEZA = new ArrayList<String>();
		List<String> StudentiSPANIOLA = new ArrayList<String>();
		List<String> StudentiROMANA = new ArrayList<String>();
		List<String> StudentiMATEMATICA = new ArrayList<String>();
		List<String> StudentiINFORMATICA = new ArrayList<String>();
		List<String> StudentiFIZICA = new ArrayList<String>();
		List<String> StudentiISTORIE = new ArrayList<String>();
		List<String> StudentiGEOGRAFIE = new ArrayList<String>();

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (Student student : array) {

			for (String curs : student.getListaCursuri()) {
				if (student.vMedieMicaTrecut() == false) {
					if (curs.equals("ENGLEZA"))
						StudentiENGLEZA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("FRANCEZA"))
						StudentiFRANCEZA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("SPANIOLA"))
						StudentiSPANIOLA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("ROMANA"))
						StudentiROMANA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("MATEMATICA"))
						StudentiMATEMATICA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("INFORMATICA"))
						StudentiINFORMATICA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("FIZICA"))
						StudentiFIZICA.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("ISTORIE"))
						StudentiISTORIE.add(student.getPrenume() + " " + student.getNume());
					if (curs.equals("GEOGRAFIE"))
						StudentiGEOGRAFIE.add(student.getPrenume() + " " + student.getNume());
				}
			}
		}

		map.put("ENGLEZA", StudentiENGLEZA);
		map.put("FRANCEZA", StudentiFRANCEZA);
		map.put("SPANIOLA", StudentiSPANIOLA);
		map.put("ROMANA", StudentiROMANA);
		map.put("MATEMATICA", StudentiMATEMATICA);
		map.put("INFORMATICA", StudentiINFORMATICA);
		map.put("FIZICA", StudentiFIZICA);
		map.put("ISTORIE", StudentiISTORIE);
		map.put("GEOGRAFIE", StudentiGEOGRAFIE);

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();

			if (key.equals(disciplina))

				System.out.println("La cursul " + key + " nu au trecut urmatorii studenti: " + value.toString());

		}
	}

	public static void MediaDePrezenteLaOMaterie(Student[] array, String Discipline) {

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Numarul de studenti pe care doriti sa ii inscrieti: ");
		int NR = 0;
		boolean isnumber = false;
		do {
			if (in.hasNextInt()) {
				NR = in.nextInt();
				isnumber = true;
			} else {
				System.out.println("Eroare, trebuie sa adaugati numarul de studenti pe care doriti sa ii inscrieti:");
				isnumber = false;
				in.next();
			}
		} while (isnumber != true);
		Student[] array = new Student[NR];
		int k = 1;
		for (int i = 0; i < NR; i++) {

			System.out.println("Setati datele studentului " + k);
			k++;
			array[i] = new Student();

		}

		System.out.println("=====Cerinte=====");

		//System.out.println("Cursul la care vreti sa aflati studentii care participa: ");

		String curs = in.nextLine();

		//ListaStudentilorInrolatiLaODisciplina(array, curs);

		ListaStudentilorCareNuAuPlatitTaxaCursurilor(array);
		
		
		ListStudentilorCareNuAuSuficientePrezente(array);
		
		
		System.out.println("Cursul la care vreti sa aflati cine nu a trecut: ");

		String curs1 = in.nextLine();
		ListaStudentilorCareNuAuPromovatLaODisciplina(array,curs1);
		
		
		
		
				
		
		
		
		try {
		      BufferedWriter fisier = new BufferedWriter(new FileWriter("output.txt"));
	
		      for (int i = 0; i < NR; i++)
		    	  fisier.write(array[i].toString()+"\n");		      
		      
		      fisier.close();
		    } catch (IOException e) {
		      System.out.println("A aparut o eroare");
		      e.printStackTrace();
		    }
		

	}
}
