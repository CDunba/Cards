import Card.Suit;


public class Deck{
	 public final int MAX_CARDS=6*52; //initialized to allow a maximum of six packs (6×52 cards).
	 private static Card[] masterPack; //fix
	 masterPack= new Card[52];
	 
	 //put logic in loop that adds 52 cards to masterPack
	 value= masterPack[0].getValue();
     masterPack[0].set('2', Card.Suit.diamonds);	      
     System.out.println(masterPack[0].toString());
	    

     private Card[]cards;
	 private int topCard;
	 private int numPacks;
	 
	 public Deck(int numPacks){
		
	 }
	 
	 public void init(int numPacks){
		 System.out.print(numPacks); 
	 }
	 public void shuffle(){
		
	 }

	 public Card dealCard(){
		 
	 }
	 
	 public int getTopCard(){
		 
	 }
	 
	 public Card inspectCard(int k){
		 
	 }
	 
	 private static void allocateMasterPack(){
		 
	 }
}
