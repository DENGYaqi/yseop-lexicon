package com.yseop.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yseop.web.repository.WordRepository;
import com.yseop.web.table.LeffSem;
import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;
import com.yseop.web.table.WordForm;

@Service("wordService")
public class WordService implements IWordService {

    @Autowired
    private WordRepository wordRepository;

    private static List<Word> words;

    /**
     * Find all words.
     */
    @Override
    public List<Word> findAllWords() {
        List<Word> words = wordRepository.findAll();
        return words;
    }

    @Override
    public Word findById(Integer id) {
        Word word = new Word();
        try {
            word = wordRepository.findWordById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return word;
    }

    @Override
    public List<Word> findByLemma(String lemma) {
        List<Word> words = wordRepository.findAll();
        List<Word> found = new ArrayList<Word>();
        words.forEach(w -> {
            if (w.getLemma().equalsIgnoreCase(lemma)) {
                found.add(w);
            }
        });
        return found;
    }

    @Override
    public synchronized boolean addWord(Word word) {
        // find if this word existe in database.
        List<Word> list = wordRepository.findByLemma(word.getLemma());
        System.out.print(list);
        if (list.size() > 0) {
            return false;
        } else {
            Word newWord = wordRepository.save(word);
            System.out.print(newWord);
            return true;
        }
    }

    @Override
    public synchronized Long countWord() {
        return wordRepository.count();
    }

    @Override
    public synchronized boolean addWordComplete(Word word, List<Sense> senses, List<WordForm> wordForms, List<LeffSem> leffSems) {
        List<Word> list = wordRepository.findByLemma(word.getLemma());
        if (list.size() > 0) {
            return false;
        } else {
            word.setSenses(senses);
            word.setLeffSems(leffSems);
            word.setWordForm(wordForms);
            wordRepository.save(word);
            return true;
        }
    }

    @Override
    public void updateWord(Word word) {
        wordRepository.save(word);
    }

    @Override
    public void deleteWordById(Integer id) {
        wordRepository.delete(findById(id));
    }

    @Override
    public void deleteAllWords() {
        words.clear();
    }

    @Override
    public boolean isWordExist(Word word) {
        return findByLemma(word.getLemma()) != null;
    }

    @Override
    public Word save(Word word) {
        wordRepository.save(word);
        return word;
    }

    @Override
    public Word saveAndFlush(Word newWord) {
        return wordRepository.saveAndFlush(newWord);
    }

}
