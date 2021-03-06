import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Aplicatia actioneaza ca o baza de date, se va cere adaugarea unui numar de studenti. Adaugand ulterior informatii despre fiecare, pentru a prezenta o analiza a studentilor inscrisi.
 * @author Adrian
 *
 */


/*
 * La fiecare Student se cere:
 * -Numele, Prenumele.
 * -Fiecarui student i se genereaza un unic Student ID.
 * -Anul in care este (I-IV)
 * -cursuri la care doriti sa inrolati studentul. 
 * Cursurile sunt urmatoarele: (ENGLEZA,FRANCEZA,SPANIOLA,ROMANA,MATEMATICA,INFORMATICA,FIZICA,CHIMIE,ISTORIE,GEOGRAFIE), Studentul poate fi inrolat la unul sau mai multe cursuri. Se va apasa "Q" pentru a termina.
 * Studentul trebuie sa aiba peste 5 la fiecare materie la care este inrolat pentru a putea absolvi.
 * Fiecare curs costa 500 de lei. Studentul trebuie sa plateasca in totalitate taxele pentru a absolvi.
 * -Numarul total de prezente. 
 * Studentul trebuie sa aiba un numar de 7 prezente pentru a putea absolvi, el dispune de o reducere a numarului de ore daca lucreaza (-3 prezente obligatorii).
 *
 */



public class Student {

	private int studentId;
	private String prenume;
	private String nume;
	private int grade;
	private Cursuri cursuri;
	private int taxaStudiu;
	private boolean Angajat;
	private int numarPrezente;
	List<Integer> note=new ArrayList<Integer>();
	Map <Cursuri,List<Integer>> map=new HashMap<Cursuri,List<Integer>>();
	private int sold;
	private static int COSTCURS=500;
	private boolean medieMica=false;
	private List<String> listaCursuri=new ArrayList<String>();


	Student()
	{
		Scanner cin =new Scanner(System.in);
		
		System.out.print("Prenumele Studentului: ");
		this.prenume=cin.nextLine();
		
		System.out.print("Numele Studentului: ");
		this.nume=cin.nextLine();
		
		System.out.println("1 - Anul I\n2 - Anul II\n3 - Anul III\n4 - Anul IV\nIntroduceti anul studentului: ");
		boolean isnumber=false;
		do
		{
		if (cin.hasNextInt()) {
			this.grade = cin.nextInt();
			if (this.grade>0 && this.grade<5)
			{
			isnumber=true;
			}
			else
			{
				System.out.println("Anul poate sa fie doar intre 1 si 4");
				isnumber=false;
			}
			
			
		}
		else
		{
			System.out.println("Alegeti un an intre 1 si 4:");
			isnumber=false;
			cin.next();
		}
			
		}while (isnumber==false);
		CreateCursuriForStudent();
		
		
		
		System.out.println("Numarul de prezente");
		
		boolean isnumb=false;
		do
		{
		if (cin.hasNextInt()) {
			this.numarPrezente=cin.nextInt();
			if (this.numarPrezente > 0 && this.numarPrezente <= this.listaCursuri.size()*10)
			{
			isnumb=true;
			}
			else
			{
				System.out.println("numarul de prezente poate sa fie intre intervalul 0 - " + this.listaCursuri.size()*10);
				isnumb=false;
			}
			
			
		}
		else
		{
			System.out.println("Alegeti un an intre 0- " + this.listaCursuri.size()*10);
			isnumb=false;
			cin.next();
		}
			
		}while (isnumb==false);
				
		System.out.println("Studentul este sau nu angajat: true-DA / false-NU ");

		boolean isnumber1=false;
		do
		{
		if (cin.hasNextBoolean()) {
			this.Angajat=cin.nextBoolean();
			isnumber1=true;
			
		}
		else
		{
			System.out.println("Afisati true pentru a sugera ca studentul lucreaza, false altfel");
			isnumber1=false;
			cin.next();
		}
			
		}while (isnumber1==false);
		
		checkAngajat();
		
		platireaTaxei();
	
		System.out.println("Id-ul Studentului generat: ");
		CreateRandomStudentId();
		
		System.out.println("\n");
		
		rezultatStudent();
		
		System.out.println("\n");

	}

	public void checkAngajat()
	{
		if (this.isAngajat())
			System.out.println("Studentul este angajat, deci are o reducere in ceea ce priveste numarul minim de prezente");
		else
			System.out.println("Studentul NU este angajat, deci NU are o reducere in ceea ce priveste numarul minim de prezente");
		
		
		
		
	}
	public void CreateRandomStudentId() {
		ThreadLocalRandom.current().ints(0, 100).distinct().limit(1).forEach(System.out::println);

	}
	
	public void CreateCursuriForStudent()
	{
		Cursuri c=null;
		int sum;
		do {
			System.out.print("Cursul la care doriti sa inscrieti studentul (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			int ok=0;
			for (Cursuri curs:this.getCursuri().values())
			{
				//Daca cursul este gasit, tinem minte acest curs in "c" si schimbam ok in 1;
				if (course.equals(curs.toString()))
				{
					this.sold=this.sold + COSTCURS;
					c=curs; 
					ok=1;
				}
				
			}
			
			if (ok==1)
			{
				System.out.println("Am inrolat studentul la materia: " + c );
				System.out.println("Scrieti cele trei note pentru materia "+ c);
				System.out.println("Prima nota la materia "+ c);
				int primaNota=in.nextInt();
				System.out.println("A doua nota la materia "+ c);
				int aDouaNota=in.nextInt();
				System.out.println("A treia nota la materia "+ c);
				int aTreiaNota=in.nextInt();
				note.clear();
				note.add(primaNota);
				note.add(aDouaNota);
				note.add(aTreiaNota);
				
				map.put(c,note);
				
				sum=0;
				sum=mediaDupaMaterie(map,c);
				
				System.out.println("Media la materia " + c + " este " + sum/3);
				
				if (sum/3<5)
					medieMica=true;
				
				listaCursuri.add(c.toString());
				
				
				
				
			}
			else
			{
				if (!course.equals("Q"))
				{
				System.out.println("Nu exista aceasta materie, incercati sa inrolati studentul la una dintre urmatoarele materii:\nENGLEZA,\r\n"
						+ "FRANCEZA,\r\n"
						+ "SPANIOLA,\r\n"
						+ "ROMANA,\r\n"
						+ "MATEMATICA,\r\n"
						+ "INFORMATICA,\r\n"
						+ "FIZICA,\r\n"
						+ "CHIMIE,\r\n"
						+ "ISTORIE,\r\n"
						+ "GEOGRAFIE");
				}
				
				else
					System.out.println("Am reusit sa inrolam studentul la materiile dorite!");
			}
			
			if (!course.equals("Q")) {
				
			} else {
				break;
				}
		} while (1 != 0 );
	}
	
	public int mediaDupaMaterie(Map<Cursuri,List<Integer>> map, Cursuri course)
	{
		int sum1=0;
	/*	for (Map.Entry<Cursuri, List<Integer>> entry:map.entrySet())
			
		{
			
			for (Cursuri curs:this.getCursuri().values())
			{ 
				if (course.toString().equals(curs.toString()));
					{
						sum=0;
						for (int nota:map.get(course))
						{
							sum=sum+nota;
						}
					}
		}
		}
		*/

	for(int nota:map.get(course))
					sum1+=nota;
		
		return sum1;
		
		
	}
	
	public void verificareSold() {
		System.out.println("Studentul are de platit suma de: " + this.sold + " lei");
	}
	
	// Pay tuition
	public void platireaTaxei() {
		verificareSold();
		System.out.print("Suma pe care studentul o plateste in lei");
		Scanner in = new Scanner(System.in);
		boolean isnumber=false;
		do
		{
		if (in.hasNextInt()) {
			int payment = in.nextInt();
			if (payment<=COSTCURS*listaCursuri.size())
			{
			isnumber=true;
			this.sold -= payment;
			System.out.println("Multumim pentru suma de: " + payment + " lei");
			
			}
			else
			{
				System.out.println("Nu se poate plati mai mult decat " + COSTCURS*listaCursuri.size() + " lei, pentru donatii contactati secretariatul. \n Alegeti o suma intre 0 -" + COSTCURS*listaCursuri.size());
				isnumber=false;
			}
			
			
		}
		else
		{
			System.out.println("Alegeti o suma intre 0 - " + COSTCURS*listaCursuri.size());
			isnumber=false;
			in.next();
		}
			
		}while (isnumber==false);
		
		verificareSold();
	}
	
	public void formule()
	{
		//System.out.println();
	}
	
	public void IterateThroughHashMap()
	{
		for (Map.Entry<Cursuri,List<Integer>> entry : map.entrySet())
		{
			//
		}
	}
	public void prezLucrator()
	{
		if (this.Angajat==true)
			this.numarPrezente=this.numarPrezente+3;
	}
	//true, daca a platit toate cursurile
	public boolean vSoldTrecut()
	{
		if (this.sold!=0)
			return false;
		return true;
	}
	//true, daca are media mai mare decat 5
	public boolean vMedieMicaTrecut()
	{
		if (this.medieMica==true)
			return false;
		return true;
	}
	//true, daca are minim 5 prezente
	public boolean vNumarPrezenteTrecut()
	{
		if (this.numarPrezente<7)
			return false;
		return true;
	}
	
	public boolean verificareAbsolvent()
	{
		if (this.sold!=0)
			return false;
		if (this.medieMica==true)
			return false;
		if (this.numarPrezente<7)
			return false;
		
		return true;
	}
	
	public void rezultatStudent()
	{
		if (verificareAbsolvent()==true)
		{
			System.out.println("Studentul a trecut");
		}
		else
		{
			System.out.println("Studentul nu a trecut, neavand una (sau mai multe) dintre cele trei:\n(1) Media la toate materiile peste 5\n(2) Nu a platit taxa cursurilor\n(3) Nu a obtinut numarul minim de prezente");
		}

	}
	
	

	public int getStudentId() {
		return studentId;
	}

	/**
	 * 
	 * @param studentId Fiecare student primeste un random student ID.
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getPrenume() {
		return prenume;
	}

	/**
	 * 
	 * @param prenume Prenumele studentului.
	 */
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getNume() {
		return nume;
	}

	/**
	 * 
	 * @param nume Numele studentului.
	 */
	
	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getGrade() {
		return grade;
	}

	/**
	 * 
	 * @param grade Nota studentului la o materie.
	 */
	
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Cursuri getCursuri() {
		return cursuri;
	}

	/**
	 * 
	 * @param cursuri Multimea de cursuri la care este inrolat studentul.
	 */
	public void setCursuri(Cursuri cursuri) {
		this.cursuri = cursuri;
	}

	public int getTaxaStudiu() {
		return taxaStudiu;
	}

	public void setTaxaStudiu(int taxaStudiu) {
		this.taxaStudiu = taxaStudiu;
	}

	public boolean isAngajat() {
		return Angajat;
	}

	public void setAngajat(boolean angajat) {
		Angajat = angajat;
	}

	public List<Integer> getNote() {
		return note;
	}

	public void setNote(List<Integer> note) {
		this.note = note;
	}

	public Map<Cursuri, List<Integer>> getMap() {
		return map;
	}

	public void setMap(Map<Cursuri, List<Integer>> map) {
		this.map = map;
	}

	public int getNumarPrezente() {
		return numarPrezente;
	}

	/**
	 * 
	 * @param numarPrezente Numarul total de prezente.
	 */
	public void setNumarPrezente(int numarPrezente) {
		this.numarPrezente = numarPrezente;
	}

	public int getSold() {
		return sold;
	}

	/**
	 * 
	 * @param Soldul curent
	 */
	
	public void setSold(int sold) {
		this.sold = sold;
	}

	public static int getCOSTCURS() {
		return COSTCURS;
	}

	/**
	 * 
	 * @param cOSTCURS Costul unui curs.
	 */
	public static void setCOSTCURS(int cOSTCURS) {
		COSTCURS = cOSTCURS;
	}

	public boolean isMedieMica() {
		return medieMica;
	}

	/**
	 * 
	 * @param medieMica Daca media este mica (media<5), ea se va stoca aici.
	 */
	
	public void setMedieMica(boolean medieMica) {
		this.medieMica = medieMica;
	}

	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", prenume=" + prenume + ", nume=" + nume + ", grade=" + grade
				+ ", cursuri=" + cursuri + ", taxaStudiu=" + taxaStudiu + ", Angajat=" + Angajat + ", numarPrezente="
				+ numarPrezente + ", note=" + note + ", map=" + map + ", sold=" + sold + ", medieMica=" + medieMica
				+ "]";
	}

	public List<String> getListaCursuri() {
		return listaCursuri;
	}

	public void setListaCursuri(List<String> listaCursuri) {
		this.listaCursuri = listaCursuri;
	}

	
	
	
	
	

}
