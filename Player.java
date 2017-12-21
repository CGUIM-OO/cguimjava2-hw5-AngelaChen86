package hw5;
import java.util.ArrayList;


public class Player{
	//constructor¬°Playerªºname¸òchips
	public Player(String name, int chips){
		this.name = name;
		this.chips = chips;
	}
	private String name;
	private int chips;
	private int bet;
	private ArrayList<Card>oneRoundCard;
	public void sayHello(){
		System.out.println("Hello,I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}
	public int makeBet(){
		bet = 5;
		while(bet == 0)
		{
			return 0;
		}
		return bet;
	}
	public void setOneRoundCard(ArrayList card){
		oneRoundCard=new ArrayList<Card>();
		oneRoundCard=card;
	}
	public boolean hitMe(){
		if(getTotalValue() < 17)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String getName(){
		return name;
	}
	public int getTotalValue(){
		int total = 0;
		int i;
		for(i = 0;i < oneRoundCard.size();i++)
		{
			if(oneRoundCard.get(i).getRank() == 11 || oneRoundCard.get(i).getRank() == 12 || oneRoundCard.get(i).getRank() == 13)
			{
				total = total + 10;
			}
			if(oneRoundCard.get(i).getRank() == 1)
			{
				if(total > 11)
				{
					total = total + 11;
				}
				else
				{
					total = total + 1;
				}
			}
			else
			{
				total = total + oneRoundCard.get(i).getRank();
			}
		}
		return total;
	}
	public int increaseChips(int d){
		chips = chips + d;
		return chips;
	}
	public int getCurrentChips(){
		return chips;	
	}
	
}
