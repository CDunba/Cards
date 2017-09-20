public class Deck {
	public static final int MAX_CARDS = 6 * 52; // initialize it to allow a
												// maximum of six packs (6×52
												// cards).
	private static Card[] masterPack; /*
										 * = { new
										 * Card('A',Card.Suit.spades),new
										 * Card('A',Card.Suit.clubs),new
										 * Card('A',Card.Suit.diamonds),new
										 * Card('A',Card.Suit.hearts), new
										 * Card('2',Card.Suit.spades),new
										 * Card('2',Card.Suit.clubs),new
										 * Card('2',Card.Suit.diamonds),new
										 * Card('2',Card.Suit.hearts), new
										 * Card('3',Card.Suit.spades),new
										 * Card('3',Card.Suit.clubs),new
										 * Card('3',Card.Suit.diamonds),new
										 * Card('3',Card.Suit.hearts), new
										 * Card('4',Card.Suit.spades),new
										 * Card('4',Card.Suit.clubs),new
										 * Card('4',Card.Suit.diamonds),new
										 * Card('4',Card.Suit.hearts), new
										 * Card('5',Card.Suit.spades),new
										 * Card('5',Card.Suit.clubs),new
										 * Card('5',Card.Suit.diamonds),new
										 * Card('5',Card.Suit.hearts), new
										 * Card('6',Card.Suit.spades),new
										 * Card('6',Card.Suit.clubs),new
										 * Card('6',Card.Suit.diamonds),new
										 * Card('6',Card.Suit.hearts), new
										 * Card('7',Card.Suit.spades),new
										 * Card('7',Card.Suit.clubs),new
										 * Card('7',Card.Suit.diamonds),new
										 * Card('7',Card.Suit.hearts), new
										 * Card('8',Card.Suit.spades),new
										 * Card('8',Card.Suit.clubs),new
										 * Card('8',Card.Suit.diamonds),new
										 * Card('8',Card.Suit.hearts), new
										 * Card('9',Card.Suit.spades),new
										 * Card('9',Card.Suit.clubs),new
										 * Card('9',Card.Suit.diamonds),new
										 * Card('9',Card.Suit.hearts), new
										 * Card('T',Card.Suit.spades),new
										 * Card('T',Card.Suit.clubs),new
										 * Card('T',Card.Suit.diamonds),new
										 * Card('T',Card.Suit.hearts), new
										 * Card('J',Card.Suit.spades),new
										 * Card('J',Card.Suit.clubs),new
										 * Card('J',Card.Suit.diamonds),new
										 * Card('J',Card.Suit.hearts), new
										 * Card('Q',Card.Suit.spades),new
										 * Card('Q',Card.Suit.clubs),new
										 * Card('Q',Card.Suit.diamonds),new
										 * Card('Q',Card.Suit.hearts), new
										 * Card('K',Card.Suit.spades),new
										 * Card('K',Card.Suit.clubs),new
										 * Card('K',Card.Suit.diamonds),new
										 * Card('K',Card.Suit.hearts) }
										 */

	Card[] cards = new Card[MAX_CARDS];
	private int topCard;
	private int numPacks;

	static private boolean constructed = false;

	public Deck(int numPacks) {
		if (!constructed) {
			allocateMasterPack();
			constructed = true;
		}
        init(numPacks) ;
	}

	void init(int numPacks) {
		topCard = 0 ;
		for (int i = 0; i < numPacks; i++) {
			for (int j = 0; j < masterPack.length; j++) {
				cards[(i*52) + j] = masterPack[j];
			}
		}
		this.numPacks = numPacks;
		this.topCard = numPacks * 52;
	}

	void shuffle() {
		int shuffleTime = (int) (Math.random() * 26 * 10) ;
		for( int i=0;i<shuffleTime;i++)
		{
			int top, bottom ;
			top = (int) (Math.random() * topCard) ;
			bottom = (int) (Math.random() * topCard) ;
			Card tmpCard = cards[bottom];
			cards[bottom] = cards[top]; 
			cards[top] = tmpCard ;
		}

	}

	Card dealCard() {
		topCard--;
		return cards[topCard];
	}

	public int getTopCard() {
		return topCard;
	}

	Card inspectCard(int k) {
		if (k < 0 || k >= (numPacks * 52))
			return new Card('X', Card.Suit.spades);
		else
			return cards[k];
	}

	static void allocateMasterPack() {
		Card card[] = new Card[52];
		char[] values={'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
		for (int j = 0; j < 4; j++)
		  for (int i = 0; i < 13; i++) {
				if (j == 0)
					card[(j * 13) + i] = new Card(values[i] , Card.Suit.clubs) ;
				else if (j ==1)
					card[(j * 13) + i] = new Card(values[i] , Card.Suit.diamonds) ;
			    else if (j ==2)
					card[(j * 13) + i] = new Card(values[i] , Card.Suit.hearts) ;
			    else if (j ==3)
					card[(j * 13) + i] = new Card(values[i] , Card.Suit.spades) ;
		}
		masterPack = card;
	}
}
