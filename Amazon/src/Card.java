
public class Card {
	private final Suit suit;
	private final int value;
	private final String rank;
	
	public enum Suit {
		SPADES(1),
		DIAMONDS(2),
		CLUBS(3),
		HEARTS(4);
		private final int value;
		private Suit (int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}

	public Card(Suit suit, int value, String rank) {
		this.suit = suit;
		switch (value) {
			case 11: 
			this.value = 10;
			this.rank = "J";
			break;
			case 12: 
			this.value = 10;
			this.rank = "Q";
			break;
			case 13: 
			this.value = 10;
			this.rank = "K";
			break;
			case default: 
			this.value = value;
			this.rank = String.valueOf(value);
			break;
		}
		this.value = value;
		this.rank = rank;
	}

	public Suit getSuit() { return this.suit; }
	public int getValue() { return this.value; }
	public String getRank() { return this.rank; }
}

public class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, int value, String rank) {
		super(suit, value, rank);
	}

	public int getValue() {
		int value = super.getValue();
		if (value == 1) {
			return 11;
		} else if (value < 10 ) {
			return value;	
		}
		return 10;
	}

	public boolean isAce() {
		return super.getValue() == 1;
	}
}

public class Deck {
	Stack<Card> deck;

	public enum GameType {
		Classic, BlackJack;
	}

	public Deck(GameType gameType) {
		this.deck = new Stack<gameType.value()>();
		
		for (Suit suit : Suit.values()) {
			for (int i=1; i<=13; i++) {
				deck.push(new Card(suit, i));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public Card getCard() {
		return deck.pop();
	}
}

public class Hand {
	private List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public Card removeCard(int i) {
		return hand.remove(i);
	}

	public int getTotalValue() {
		int r = 0;
		for (Card card: hand) {
			r +=  card.getValue();
		}
		return r;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Card card : hand) {
			sb.append(card.suit + card.rank);
		}
		return sb.toString();
	}
}

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Simple BlackJack!");

		Scanner in = new Scanner(System.in);
		boolean inplay = true;
		boolean newgame = true;
		while (newgame) {
			Deck deck = new Deck(GameType.BlackJack);
			deck.shuffle();

			Hand dealer = new Hand();
			Hand player = new Hand();

			dealer.addCard(deck.getCard());
			player.addCard(deck.getCard());
			dealer.addCard(deck.getCard());
			player.addCard(deck.getCard());

			System.out.println("Your cards are: \n"+player.toString());
			while (inplay) {
				System.out.println("Hit, get a card [h] or Stand, skip turn [s]");
				String s = in.nextLine();
				
				if (s.equalsIgnoreCase("h")) {
					player.addCard(deck.getCard());
					System.out.println("Your cards are: \n"+player.toString());

					if (player.getTotalValue() > 21) {
						System.out.println("Busted! Hand is greater than 21. Dealer wins.");
						inplay = false;
					}
				} else if (s.equalsIgnoreCase("s")) {
					int v = dealer.getTotalValue();
					while (v < 17)
						dealer.addCard(deck.getCard());

					if (v > 21) {
						System.out.println("Dealer Busted! Hand is greater than 21. You win.");
					} else if (v < player.getTotalValue()) {
						System.out.println("You win.");
					} else {
						System.out.println("Dealer wins.");
					}
					inplay = false;
				}
			}
			while (!inplay) {
				System.out.println("New game? [y] or [n]");
				String t = in.nextLine();
				if (t.equalsIgnoreCase("y")) {
					inplay = true;
				} else if (t.equalsIgnoreCase("n")) {
					newgame = false;
					inplay = true;
				}
			}
		}
	}
}