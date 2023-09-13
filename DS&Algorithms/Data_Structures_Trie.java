/*************
 * Trie comes from the word Retrieval
 * The main purpose of this data structure is to retrieval stored information very fast
 *
 * Some of its applcations are :
 * Autocomplete words feature in google when you type in the correct word it suggests the complete word
 * Autocorrection, in word if theres an error in spelling, it wil suggest the correct word
 * These all methods are done with the Trie Data Structures
 */
public class Data_Structures_Trie
{
    private TrieNode root;
    private static class TrieNode
    {
        private TrieNode[] children; // alphabets from a to z
        private boolean isWord;
        public TrieNode()
        {
            this.children = new TrieNode[26]; // english alphabets from a - z
            this.isWord = false;
        }
    }

    public Data_Structures_Trie()
    {
        this.root = new TrieNode(); //first root is empty
    }

    public boolean search(String word)
    {
        return false;
    }
    public int get_index(char letter)
    {
        return letter - 'a';
    }

    public void insert_trie_node(String word)
    {
        if(word == null || word.isEmpty())
        {
            throw new IllegalArgumentException("Invalid Input");
        }

        word = word.toLowerCase(); // because we will be dealing with 'a' to 'z'

        TrieNode current = root;

        for(int i = 0; i < word.length(); i++)
        {
            char letter = word.charAt(i);
            int index = get_index(letter);

            if(current.children[index] == null)
            {
                TrieNode new_node = new TrieNode();
                current.children[index] = new_node;
                current = new_node;
            }
            else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public static void main(String[] args) {
        Data_Structures_Trie trie = new Data_Structures_Trie();

        trie.insert_trie_node("Cat");
        trie.insert_trie_node("Rat");
        trie.insert_trie_node("can");
        trie.insert_trie_node("son");

        System.out.println("Values inserted successfully!");
    }
}
