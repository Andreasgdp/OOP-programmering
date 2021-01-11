package Ole;

class TestFjernvarme
{
	public static void main()
	{
			
		Forbruger	ole  = new Forbruger("Ole",67,1000);
		Forbruger	lene = new Forbruger("Lene",212,1000);
		Distrikt	biskorupvej = new Distrikt("Biskorupvej", (float) 12.5);
	
		ole.aflaesMaaler(990);
		ole.aflaesMaaler(25);
		lene.aflaesMaaler(220);
		lene.aflaesMaaler(250);
		biskorupvej.setForbruger(ole);
		biskorupvej.setForbruger(lene);

		ole.aflaesMaaler(125);
	

		System.out.println("Oles forbrug:  "+ole.beregnForbrug());
		System.out.println("Lenes forbrug: "+lene.beregnForbrug());

		int etTal = 212; 
	
		float pris = biskorupvej.afregnForbruger(etTal);
		
		if (pris >= 0)
			System.out.println("Prisen for maaler "+etTal+"'s forbrug:  "+pris);
		else
			System.out.println("Maaleren fandtes ikke.");

	}
}