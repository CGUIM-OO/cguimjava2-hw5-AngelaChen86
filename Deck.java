package hw5;
import java.util.ArrayList;
import java.util.Random;
//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
public class Deck {
	//�s�Wprivate field ArrayList<Card> card
	private ArrayList<Card> cards;
	//�s�Wprivate field ArrayList<Card> usedcard
	private ArrayList<Card> usedCard;
	//�s�W�@��private fieled nUsed
	private int nUsed = -1;
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		usedCard =new ArrayList<Card>();
		int i;
		int rank;
		for (i = 1; i <= nDeck; i++) 
		{
			for (Card.Suit suit : Card.Suit.values()) 
			{
				for (rank = 1; rank <= 13; rank++)
				{
					Card card = new Card(suit,rank);
					card.add(card);
				}
			}
		}
		shuffle();
	}
	//�N�Ҧ����P���L�X
	public void printDeck() {
		for(Card a:cards)
		{
			a.printCard();
		}
	}
	//�p�GnUsed�P�ιL�@���N+1�A��P��n�Χ�52�i�N�~�P
	public Card getOneCard() {
		nUsed = nUsed + 1;
		if(nUsed == 52)
		{
			usedCard.clear();
			shuffle();
		}
		usedCard.add(cards.get(nUsed));
		return cards.get(nUsed);
	}
	public void shuffle() {
		ArrayList<Card> NewCard = new ArrayList<Card>();
		Random rnd = new Random();
		Card c;
		int i;
		for (i = 0; i <=nUsed; i++) 
		{
			cards.add(usedCard.get(i));	
			do 
			{
				c = cards.get(rnd.nextInt(52));
			} 
			while(NewCard.contains(c));
			NewCard.add(c);
		}
		cards.clear();
		cards = NewCard;
		nUsed = 0;
	}
	public ArrayList<Card> getAllCards() {
		return cards;
	}
	public Card getOneCard(boolean l) {
		return null;
	}
}