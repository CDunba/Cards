public class Hand {
		public int MAX_CARDS = 100;
		private Card[] myCards = new Card[MAX_CARDS];
		private int numCards;
		
		Hand() { //default constructor
			numCards=0;
		}
		
		void resetHand(){
			myCards = null ;							//remove all cards from the hand (in the simplest way).
		}
		
		public boolean takeCard(Card card){
			Card tmpCard = null ;
			if (numCards>=MAX_CARDS)
				return false ;     
			else
			{
				tmpCard =  new Card(card.getValue(),card.getSuit());
				myCards[numCards] = tmpCard ;
				numCards++;
				return true;				
			}			
		}
		
		public Card playCard(){
			  Card pCard = null;
			if (numCards !=0 )
			{
                 pCard = myCards[numCards-1] ;
                 numCards--;
			}
			 return pCard;				//returns and removes the card in the top occupied position of the array.
		}
		
		public String toString(){
			String CardString = "(" ;
			for (int i=0; i<numCards; i++)
			{
				CardString = CardString + myCards[i].toString() ;
				if (i!=numCards-1)
					CardString = CardString + ", " ;
			}
			return CardString + ")";                  //a stringizer that the client can use prior to displaying the entire hand.
		}
		
		//Insert Accessor for numCards here.
		
		Card inspectCard(int k){
			if(numCards>=k)
			    return myCards[k];                //Accessor for an individual card.
		    else
			    return new Card('O',Card.Suit.clubs) ; //Returns a card with errorFlag = true if k is bad.
		}

		public int getNumCards() {
			return numCards;
		}
	}
	
