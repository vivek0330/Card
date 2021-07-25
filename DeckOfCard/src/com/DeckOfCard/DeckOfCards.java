package com.DeckOfCard;

import java.util.Random;

public class DeckOfCards {
	private static String[] suit = { "Spades", "Hearts", "Diamond", "Clubs" };
	private static String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	private static String[][] deckOfCards = { suit, rank };

	public static void main(String[] args) {
		DeckOfCards deckOfCard = new DeckOfCards();
		System.out.println("******************************************");
		System.out.println("****   Deck of cards before shuffle   ****");
		System.out.println("******************************************");
		System.out.println(" "); // @single line Space
		deckOfCard.printDeckOfCards(deckOfCards);
		System.out.println(" "); // @single line Space
		System.out.println("******************************************");
		System.out.println("****   Deck of cards after shuffle   *****");
		System.out.println("******************************************");
		System.out.println(" "); // @single line Space
		deckOfCard.shuffleDeckOfCards(deckOfCards);
		deckOfCard.printDeckOfCards(deckOfCards);
		System.out.println(" "); // @single line Space
		System.out.println("************************");
		deckOfCard.distributeCards(deckOfCards);

	}

	/**
	 * This method prints the deck of cards
	 * 
	 * @param deckOfCards
	 */
	private void printDeckOfCards(String[][] deckOfCards) {
		for (int i = 0; i < deckOfCards.length; i++) {
			for (int j = 0; j < deckOfCards[i].length; j++) {
				System.out.print(deckOfCards[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * This method is distributing 9 cards to 4 players.
	 * 
	 * @param deckOfCards
	 */
	private void distributeCards(String[][] deckOfCards) {
		Card[] deck = new Card[52];
		int i = 0;
		for (String s : deckOfCards[0]) {
			for (String value : deckOfCards[1]) {
				deck[i++] = new Card(s, value);
			}
		}
		for (int p = 0; p < 4; p++) {
			int count = 0;
			int cardIndex = p;
			System.out.println("Player " + (p + 1));
			while (count < 9) {
				Card card = deck[cardIndex];
				System.out.println(card.getRank() + " of " + card.getSuit());
				count++;
				cardIndex += 4;
			}
			System.out.println("************************");
		}

	}

	/**
	 * This method shuffles the deck of cards
	 * 
	 * @param deckOfCards
	 */
	private void shuffleDeckOfCards(String[][] deckOfCards) {
		Random rand = new Random();
		for (int i = 0; i < deckOfCards.length; i++) {
			String[] tempArray = deckOfCards[i];
			for (int j = 0; j < tempArray.length; j++) {
				// Random for remaining positions.
				int r = j + rand.nextInt(tempArray.length - j);
				// swapping the elements
				String temp = tempArray[r];
				tempArray[r] = tempArray[j];
				tempArray[j] = temp;
			}
			deckOfCards[i] = tempArray;
		}
	}
}
