package com.yseop.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.yseop.web.exceptionAndError.CustomErrorType;
import com.yseop.web.service.IConceptService;
import com.yseop.web.service.IRelService;
import com.yseop.web.service.ISenseService;
import com.yseop.web.service.IWordService;
import com.yseop.web.table.Concept;
import com.yseop.web.table.LeffSem;
import com.yseop.web.table.Rel;
import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;
import com.yseop.web.table.WordForm;

/**
 * Controller of Access API of Lexicon.
 * 
 * Example :
 * GET :
 * Find all words : http://localhost:8080/api/words/
 * Find a word by id 15 : http://localhost:8080/api/word/id/15
 * Find a word by lemma "inspirer" : http://localhost:8080/api/word/lemma/inspirer
 * 
 * POST :
 * Add a word : http://localhost:8080/api/word/add/
 * And JSON format in the Body.
 * 
 * PUT :
 * Update a word 237779 : http://localhost:8080/api/word/update/237779
 * And JSON format in the Body.
 * 
 * DELETE :
 * Delete a word 15 : http://localhost:8080/api/word/delete/15
 * Delete all words : http://localhost:8080/api/words/delete/
 * 
 * Same with other table(key word : wordform, rel, concept, sense, leffsem).
 *
 */
@RestController
@RequestMapping("/api")
public class APIController {

    public static final Logger logger = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private IWordService wordService;

    @Autowired
    private IConceptService conceptService;

    @Autowired
    private ISenseService senseService;

    @Autowired
    private IRelService relService;

    /**
     * Retrieve All Words.
     * Limit to 30 Words.
     * 
     * @return A tableau of Word. And return HttpStatus.OK(200, if repository exist 50 Words)
     * else return HttpStatus.NO_CONTENT(204, if not).
     */
    @RequestMapping(value = "/words/", method = RequestMethod.GET)
    public ResponseEntity<List<Word>> listAllWords() {
        List<Word> words = wordService.findAllWords();
        if (words.isEmpty()) {
            return new ResponseEntity<List<Word>>(HttpStatus.NO_CONTENT);
            // or return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Word>>(words, HttpStatus.OK);
    }

    /**
     * Retrieve All Relations.
     * Limit to 30 Relations.
     * 
     * @return A tableau of Relations. And return HttpStatus.OK(200, if repository exist 50 Words)
     * else return HttpStatus.NO_CONTENT(204, if not).
     */
    @RequestMapping(value = "/rels/", method = RequestMethod.GET)
    public ResponseEntity<List<Rel>> listAllRels() {
        List<Rel> rels = relService.findAll();
        if (rels.isEmpty()) {
            return new ResponseEntity<List<Rel>>(HttpStatus.NO_CONTENT);
            // or return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Rel>>(rels, HttpStatus.OK);
    }

    /**
     * Retrieve Single Word By Id
     * 
     * @param id Id of Word.
     * @return A word found. And return HttpStatus.OK(200, if repository exist this word).
     */
    @GetMapping("word/id/{id}")
    public ResponseEntity<Word> getWordById(@PathVariable("id") Integer id) {
        // Detect if word do not exist.
        Word word = wordService.findById(id);
        return new ResponseEntity<Word>(word, HttpStatus.OK);
    }

    /**
     * Retrieve Single Word By Lemma.
     * 
     * @param lemma Lemma of Word.
     * @return A List of Words found by Lemma. And return HttpStatus.OK(200, if found).
     */
    @GetMapping(path = "word/lemma/{lemma}")
    @ResponseBody
    public ResponseEntity<List<Word>> getWordByLemma(@PathVariable("lemma") String lemma) {
        // Detect if word do not exist.
        List<Word> words = wordService.findByLemma(lemma);
        return new ResponseEntity<List<Word>>(words, HttpStatus.OK);
    }

    /**
     * Retrieve Single Relation By Source Id.
     * 
     * @param id Id of Source Concept.
     * @return A List of Relation of this Concept. And return HttpStatus.OK(200, if found).
     */
    @GetMapping("rel/sourceId/{sourceid}")
    public ResponseEntity<List<Rel>> getRelBySourceId(@PathVariable("sourceid") Integer id) {
        // Detect if source Id do not exist.
        List<Rel> rel = relService.findBySourceId(id);
        return new ResponseEntity<List<Rel>>(rel, HttpStatus.OK);
    }

    /**
     * Retrieve Single Relation By Target Id.
     * 
     * @param id Id of Target Concept.
     * @return A List of Relation of this Concept. And return HttpStatus.OK(200, if found).
     */
    @GetMapping("rel/targetId/{targetid}")
    public ResponseEntity<List<Rel>> getRelByTargetId(@PathVariable("targetid") Integer id) {
        // Detect if target Id do not exist.
        List<Rel> rel = relService.findByTargetId(id);
        return new ResponseEntity<List<Rel>>(rel, HttpStatus.OK);
    }

    /**
     * Retrieve Single Relation By Name.
     * 
     * @param name Name of Relation.
     * @return A List of Relation found by Name of Relation. And return HttpStatus.OK(200, if found).
     */
    @GetMapping("rel/name/{name}")
    public ResponseEntity<List<Rel>> getRelById(@PathVariable("name") String name) {
        // Detect if name of relation do not exist.
        List<Rel> rel = relService.findByName(name);
        return new ResponseEntity<List<Rel>>(rel, HttpStatus.OK);
    }

    /**
     * Retrieve Single Concept By Id.
     * 
     * @param id Id of Concept.
     * @return A Concept found. And return HttpStatus.OK(200, if found).
     */
    @GetMapping("concept/id/{id}")
    public ResponseEntity<Concept> getConceptById(@PathVariable("id") Integer id) {
        // Detect if name of relation do not exist.
        Concept concept = conceptService.findConceptById(id);
        return new ResponseEntity<Concept>(concept, HttpStatus.OK);
    }

    /**
     * Retrieve Single Sense By Id.
     * 
     * @param id Id of Sense.
     * @return A Sense found. And return HttpStatus.OK(200, if found).
     */
    @GetMapping("sense/id/{id}")
    public ResponseEntity<Sense> getSenseById(@PathVariable("id") Integer id) {
        Sense sense = senseService.findById(id);
        return new ResponseEntity<Sense>(sense, HttpStatus.OK);
    }

    /**
     * Create a Word.
     * 
     * @param word Word information Get by Browser.
     * @param ucBuilder Builder of Uniform Resource Identifier.
     * @return A String. And return HttpStatus.OK(200, if found).
     */
    @RequestMapping(value = "/word/add/", method = RequestMethod.POST)
    public ResponseEntity<?> createWord(@RequestBody Word word, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Word : {}", word);
        // Detect a word exist or not found, not finish.
        wordService.addWord(word);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/word/add/{id}").buildAndExpand(word.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    /**
     * Create a Word complete.
     * 
     * @param word Word information Get by Browser.
     * @param ucBuilder Builder of Uniform Resource Identifier.
     * @return A String. And return HttpStatus.OK(200, if found).
     */
    @RequestMapping(value = "/word/addComplete/", method = RequestMethod.POST)
    public ResponseEntity<?> createWordComplete(@RequestBody Word word, List<Sense> sense, List<WordForm> wf, List<LeffSem> lfs,
            UriComponentsBuilder ucBuilder) {
        logger.info("Creating Word : {}", word);
        // Detect a word exist or not found
        wordService.addWordComplete(word, sense, wf, lfs);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/word/add/{id}").buildAndExpand(word.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a Word.
     * 
     * @param id Id of Word Update.
     * @param word Content of word want update. Null is the feature of word not going to update.
     * @return A Word Updated.
     */
    @RequestMapping(value = "/word/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWord(@PathVariable("id") Integer id, @RequestBody Word word) {
        logger.info("Updating Word with id {}", id);
        Word currentWord = wordService.findById(id);
        if (currentWord == null) {
            logger.error("Unable to update. Word with id {} not found.", id);
            return new ResponseEntity<Object>(new CustomErrorType("Unable to upate. Word with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        // Detect if a feature is null. if is null. get the origin content of this feature.
        currentWord.setLemma(word.getLemma());
        currentWord.setModal(word.getModal());
        currentWord.setNeg(word.getNeg());
        currentWord.setDisabled(word.getDisabled());
        currentWord.setCpos(word.getCpos());
        currentWord.setPos(word.getPos());
        currentWord.setLang(word.getLang());
        currentWord.setTag(word.getTag());
        currentWord.setOrigin(word.getOrigin());
        currentWord.setInfl(word.getInfl());
        currentWord.setSenses(word.getSenses());
        currentWord.setWordForm(word.getWordForm());
        currentWord.setLeffSems(word.getLeffSems());

        wordService.updateWord(currentWord);
        return new ResponseEntity<Word>(currentWord, HttpStatus.OK);
    }

    /**
     * Delete a Word.
     * 
     * @param id Id of Word want Delete.(Function Not active)
     * @return A HttpStatus.NO_CONTENT. It means this word are delete.
     */
    @RequestMapping(value = "/word/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWord(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting Word with id {}", id);
        // Check the word exist or not.
        Word word = wordService.findById(id);
        if (word == null) {
            logger.error("Unable to delete. Word with id {} not found.", id);
            return new ResponseEntity<Object>(new CustomErrorType("Unable to delete. Word with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        wordService.deleteWordById(id);
        return new ResponseEntity<Word>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete All Words.
     * 
     * @return A HttpStatus.NO_CONTENT(204). It means all words are delete.
     */
    @RequestMapping(value = "/word/deletes/", method = RequestMethod.DELETE)
    public ResponseEntity<Word> deleteAllWords() {
        logger.info("Deleting All Words");
        // Check database exist a word or not.
        wordService.deleteAllWords();
        return new ResponseEntity<Word>(HttpStatus.NO_CONTENT);
    }

}
