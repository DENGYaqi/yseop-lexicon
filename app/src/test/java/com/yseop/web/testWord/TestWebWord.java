package com.yseop.web.testWord;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.yseop.web.table.Word;

public class TestWebWord {

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    private static void listAllWords() {
        System.out.println("Testing listAllWords API----------- Limite the size of Word : 10");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> wordsMap = restTemplate.getForObject(REST_SERVICE_URI + "/word/", List.class);

        if (wordsMap != null) {
            for (LinkedHashMap<String, Object> map : wordsMap) {
                System.out.println(
                        "Word : id=" + map.get("id") + ", Lemma=" + map.get("lemma") + ", Infl=" + map.get("infl") + ", Lang=" + map.get("lang"));;
            }
        } else {
            System.out.println("No word exist----------");
        }
    }

    /* GET */
    private static void getWord() {
        System.out.println("Testing getWord API----------");
        RestTemplate restTemplate = new RestTemplate();
        Word word = restTemplate.getForObject(REST_SERVICE_URI + "/word/237771", Word.class);
        System.out.println(word);
    }

    /* DELETE */
    private static void deleteWord() {
        System.out.println("Testing delete Word API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/word/237771", Word.class);
    }

    /* POST */
    private static void createWord() {
        System.out.println("Testing create Word API----------");
        RestTemplate restTemplate = new RestTemplate();
        Word word = new Word((int) 1L, 0, 0, false, "lemmaTest", "cpos1", "pos1", "fr", "tag1", "origin1", "infl1");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/word/", word, Word.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    /* PUT */
    private static void updateWord() {
        System.out.println("Testing update Word API----------");
        RestTemplate restTemplate = new RestTemplate();
        Word word = new Word((int) 1L, 0, 0, false, "lemmaTest", "cpos1", "pos1", "de", "tag1", "origin1", "infl1");
        restTemplate.put(REST_SERVICE_URI + "/word/237771", word);
        System.out.println(word);
    }

    /* DELETE */
    private static void deleteAllWords() {
        System.out.println("Testing all delete Words API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "word/10000");
    }

    public static void main(String args[]) {
        // listAllWords();
        // createWord();
        // getWord();
        // updateWord();
        // getWord();
        // deleteWord();
    }
}
