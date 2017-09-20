public class Deck {
	public static final int MAX_CARDS = 6 * 52; // initialize it to allow a
												// maximum of six packs (6×52
												// cards).
	private static Card[] masterPack; 
	private Card[] cards = new Card[MAX_CARDS];
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
		// Make shuffle better by shuffling multiple times
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