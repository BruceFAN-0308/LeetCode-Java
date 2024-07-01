package com.bruce.LC.dfs;


import java.util.*;

public class LC212 {

    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieTree trie = new TrieTree();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j);
            }
        }


        return ans;

    }

    private void dfs(char[][] board, TrieTree now, int i, int j) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0
                || !now.children.containsKey(board[i][j])) {
            return;
        }
        TrieTree trieTree = now.children.get(board[i][j]);
        if (!Objects.equals(trieTree.word, "") && !ans.contains(trieTree.word)) {
            ans.add(trieTree.word);
        }

        char c = board[i][j];
        board[i][j] = '#';
        dfs(board, trieTree, i, j + 1);
        dfs(board, trieTree, i, j - 1);
        dfs(board, trieTree, i + 1, j);
        dfs(board, trieTree, i - 1, j);
        board[i][j] = c;
    }


    static class TrieTree {
        String word = "";
        Map<Character, TrieTree> children = new HashMap<>();

        public void insert(String word) {
            TrieTree current = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieTree());
                }
                current = current.children.get(c);
            }
            current.word = word;
        }
    }

    public static void main(String[] args) {
        for (String word : new LC212().findWords(new char[][]{
                {'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}
        }, new String[]{"oaa", "oa"})) {
            System.out.println(word);
        }
    }
}
