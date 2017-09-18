public class Card {
	private char value;
	private Suit suit;
	private boolean errorFlag;
	
	
	public static enum Suit {
		clubs, diamonds, hearts, spades
	}
	
	// Constructor with 2 parameters
	Card(char value, Suit suit){	
		set(value,suit);
		}
	
	// Overload this to cope with a client that wants to instantiate without parameters and use 'A' and 'spades' as the 
	// default value and suite when not supplied.
	Card(){	
		set('A',Suit.spades);	
		}

	// toString for returning current Values
	public String toString(){
		if (errorFlag)
			 return "** Illegal ** ";
		else
	        return value + " of " + suit ;
	}
	
	public char getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
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
	

	boolean equals(Card card){
		if (errorFlag == card.errorFlag)
			return true; 
		if (this.suit == card.getSuit() && value == card.getValue())
        	return true;
        return false ;
	}
	
	private boolean isValid(char value, Suit suit){

		if (value >= '2' && value <='9')
              return true;
		else if (value=='A'|| value=='T' || value=='J'|| value=='Q'||value=='K')
			  return true;
		else	  
              return false;			//a private helper method that returns true or false, depending on the legality 
										//of the parameters.  Note that, although it may be impossible for suit to be 
										//illegal (due to its enum-ness), we pass it, anyway, in anticipation of 
										//possible changes to the type from enum to, say, char or int, someday.  We only 
										//need to test value, at this time.
	}
	
	

	public static void main(String[] args) {
		{ // Phase 1

			Card firstCard;
			Card secondCard;
			Card thirdCard;

			firstCard = new Card('A', Suit.spades);
			secondCard = new Card('X', Suit.spades);
			thirdCard = new Card('3', Suit.clubs);

			System.out.println(firstCard.toString());
			System.out.println(secondCard.toString());
			System.out.println(thirdCard.toString());

			firstCard.set('O', Suit.spades);
			secondCard.set('Q', Suit.spades);

			System.out.println(firstCard.toString());
			System.out.println(secondCard.toString());
			System.out.println(thirdCard.toString());
			
			if(firstCard.equals(firstCard))
				System.out.println("Equal");
			else
				System.out.println("Not Equal");
				
		}
		
		System.out.println("Phase 2");
		{ // Phase 2 
			
		    Card handcard1 = new Card('3',Suit.clubs);
		    Card handcard2 = new Card('T',Suit.clubs);
		    Card handcard3 = new Card('9',Suit.hearts);
		    
		    Hand myHand = new Hand();
		    
		    int i =0 ;
		    while (i< 1000)
		    {
		    	if(myHand.takeCard(handcard1))
		    	{
		    		if(myHand.takeCard(handcard2))
		    		{
		    			if(myHand.takeCard(handcard3))
		    			{
		    				// Needs to be improve ?
		    			}
		    			else
		    				break ;
		    		}	
				    else
				    {
				    	break ;
				    }
		    	}
		    	else 
		    		break ;
		    }
		    System.out.println("Hand full");
		    System.out.println("After deal");
		    System.out.println("Hand ="+ myHand.toString());
		    //Next, play each card in a loop, until the hand is empty. 
		    //Display the card played as it is played, and finally, display the (now empty) hand, 
		    // verifying that no cards remain. At some point in your program, test inspectCard() 
		    // with both legal and illegal int arguments
		    
		    System.out.println("Testing inspectCard()");
		    System.out.println(myHand.inspectCard(5).toString() );
		    System.out.println(myHand.inspectCard(500).toString() );
		    while(myHand.getNumCards()!=0)
		    { 
		    	
		    	System.out.println("Playing " +myHand.playCard().toString());
		    }
		}
		
	}
	}
