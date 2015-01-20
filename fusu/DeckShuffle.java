// Deck Shuffling
// http://www.fusu.us/2013/06/p5-deck-shuffling.html
// The thing is the shuffle should happen in such a way that every possible
// reordering is equally likely. Simply use random() to get a random index
// is not good engouh for equally likely.
// Fisher-Yates shuffle is widly used in image encryption. We generate random
// index by modifying the start number with the random length.
// The core algorithm is like random() * (endpos - startpos + 1) + startpos
public class DeckShuffle {
    public int[] deckShuffle(int[] decks) {
        if (decks == null || decks.length == 0) {
            return null;
        }
        for (int i = 0; i < decks.length; i++) {
            int j = getRandom(i, decks.length - 1);
            swap(decks, i, j);
        }
        return decks;
    }
    
    private int getRandom(int start, int end) {
        return start + (int)(Math.random() * (end - start + 1));
    }
    
    private void swap(int[] decks, int i, int j) {
        int temp = decks[i];
        decks[i] = decks[j];
        decks[j] = temp;
    }
    
    public static void main(String[] args) {
        DeckShuffle solution = new DeckShuffle();
        int[] decks = new int[]{1, 2, 3, 4, 5};
        int[] result = solution.deckShuffle(decks);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}