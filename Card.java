
public class Card {
	private char value;
	private Suit suit;
	private boolean errorFlag;
	Card currentCard;
	
	public enum Suit {
		clubs, diamonds, hearts, spades
	}
	
	Card(char value, Suit suit){	
		set('A',Suit.spades);	
		this.value=value;
		this.suit=suit;
		set(value,suit);
			}
	

	public String toString(){
		if (errorFlag)
			 return "** Illegal ** ";
		else
	        return value + " of " + suit ;
	}
	
	boolean set(char value, Suit suit){ // a mutator that accepts the legal values established in the earlier section. 
   		this.suit = suit;
   	 	if(isValid(value,suit)){
			this.value = value;
    		errorFlag=false;
    		return true;
   	 	}
   	 	else
		{
			errorFlag=true;
		}
		return false;					// When bad values are passed, errorFlag is set to true and other values can be 
										//left in any state (even partially set). If good values are passed, they are 
										//stored and errorFlag is set to false.  Make use of the private helper, listed 
										//below.
	}
	
	//Insert Accessors for suit and value here. 
	
	//Insert Accessor for errorFlag here.
	
	boolean equals(Card card){ 		
		boolean Check = false;  
        if (card.equals(currentCard)) {
        	Check = true;
            System.out.println("Cards are the same.");
                }
            
        if (Check == false) {
                System.out.println("Cards different");
            }
        
        Check = false;// returns true if all the fields (members) are identical and false, otherwise.
		return true;
	}
	
	private boolean isValid(char value, Suit suit){

		if (value >= '2' && value <='9')
              return true;
		else if (value=='A'|| value=='T' || value=='Q'||value=='K')
			  return true;
		else	  
              return false;			//a private helper method that returns true or false, depending on the legality 
										//of the parameters.  Note that, although it may be impossible for suit to be 
										//illegal (due to its enum-ness), we pass it, anyway, in anticipation of 
										//possible changes to the type from enum to, say, char or int, someday.  We only 
										//need to test value, at this time.
	}
	
	
	public static void main(String[] args) {
		Card firstCard ;
		Card secondCard ;
		Card thirdCard ;
		
		firstCard =new Card( 'A', Suit.spades);

		secondCard = new Card ('X', Suit.spades);
		
		thirdCard = new Card ('3', Suit.clubs) ;
		System.out.println( firstCard.toString());
		System.out.println( secondCard.toString());
		System.out.println( thirdCard.toString());
		
		firstCard.set('O',Suit.spades);
		secondCard.set('Q', Suit.spades); 
		System.out.println( firstCard.toString());
		System.out.println( secondCard.toString());
		System.out.println( thirdCard.toString());
		
		//test Hand
		Card card=new Card ('3', Suit.clubs) ;
		
		Card.Hand.takeCard(firstCard);
	}
	public class Hand {
		public int MAX_CARDS =100;
		private Card[] myCards;
		private int numCards;
		
		Hand() { //default constructor
			
		}
		void resetHand(){
			myCards = null;							//remove all cards from the hand (in the simplest way).
		}
		
		public boolean takeCard(Card card){
			Card c = new Card('3', Suit.clubs);
			myCards[0]=c;
			int i;
			for (i=0;i<myCards.length;i++){			// adds a card to the next available position in the myCards array.  
				if(myCards[i]==null){				//This is an object copy, not a reference copy, since the source 
				}									//  of the Card might destroy or change its data after our Hand gets 
			}										//it -- we want our local data to be exactly as it was when we received it.
			if(myCards[i]==c[0]){
			return true;				
			}			
			else {						 
			return false;				
			}
		}
		
		Card playCard(int a){
			 return card;				//returns and removes the card in the top occupied position of the array.
		}
		
		Card playCard(int a, int a){
			return card;				//returns and removes the card in the top occupied position of the array.
		}
		
		String toString(){
			return "";                  //a stringizer that the client can use prior to displaying the entire hand.
		}
		
		//Insert Accessor for numCards here.
		
		Card inspectCard(int k){
			return card;                //Accessor for an individual card.  Returns a card with errorFlag = true if k is bad.
		}
	}
	public class Deck{
		 public static final int MAX_CARDS=6*52; //initialize it to allow a maximum of six packs (6×52 cards).
		 private static Card[] masterPack;
	}

	}

