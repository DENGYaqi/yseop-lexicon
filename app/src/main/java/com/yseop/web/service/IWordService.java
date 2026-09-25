package com.yseop.web.service;

import java.util.List;

import com.yseop.web.table.LeffSem;
import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;
import com.yseop.web.table.WordForm;

public interface IWordService {

    Word findById(Integer id);

    List<Word> findByLemma(String lemma);

    boolean addWord(Word word);

    void updateWord(Word word);

    void deleteWordById(Integer id);

    List<Word> findAllWords();

    void deleteAllWords();

    boolean isWordExist(Word user);

    boolean addWordComplete(Word word, List<Sense> sense, List<WordForm> wf, List<LeffSem> lfs);

    Word save(Word word);

    Long countWord();

    Word saveAndFlush(Word newWord);

}
