package com.yseop.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yseop.web.service.IConceptService;
import com.yseop.web.service.IDomainService;
import com.yseop.web.service.ILeffSemService;
import com.yseop.web.service.IRelService;
import com.yseop.web.service.ISenseService;
import com.yseop.web.service.IWordFormService;
import com.yseop.web.service.IWordService;
import com.yseop.web.table.Concept;
import com.yseop.web.table.Domain;
import com.yseop.web.table.LeffSem;
import com.yseop.web.table.Rel;
import com.yseop.web.table.RelPrimaryKey;
import com.yseop.web.table.Request;
import com.yseop.web.table.Sense;
import com.yseop.web.table.Word;
import com.yseop.web.table.WordForm;

@Controller
public class WebController {

    @Autowired
    private IWordService wordService;

    @Autowired
    private IConceptService conceptService;

    @Autowired
    private ISenseService senseService;

    @Autowired
    private ILeffSemService leffSemService;

    @Autowired
    private IRelService relService;

    @Autowired
    private IWordFormService wordFormService;

    @Autowired
    private IDomainService domainService;

    private String message = "Hello";

    private String errorMessage = "Information not complete!";

    private String errorMesOfWord = "This Word Not exist!";

    private String errorMesOfConcept = "This Concept Not exist!";

    private String errorMesOfSourceConcept = "This Source Concept Not exist!";

    private String errorMesOfTargetConcept = "This Target Concept Not exist!";

    protected List<Word> words = new ArrayList<>();

    protected List<Concept> concepts = new ArrayList<>();

    protected List<Sense> senses = new ArrayList<>();

    /**
     * Home page.
     * 
     * @param model Model.
     * @return post massage to index.html
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "redirect:/";
    }

    /**
     * Page of "Show Words".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Words to wordList.ftl
     */
    @RequestMapping(value = "/wordList", method = RequestMethod.GET)
    public String wordList(Model model) {
        List<Word> words = wordService.findAllWords();
        List<Word> sublist = words.subList(0, 30);
        Long nbWord = wordService.countWord();
        model.addAttribute("nbWords", nbWord);
        model.addAttribute("words", sublist);
        return "wordList";
    }

    /**
     * Page of "Show Relations".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Relations to relList.ftl
     */
    @RequestMapping(value = "/relList", method = RequestMethod.GET)
    public String relList(Model model) {
        List<Rel> rels = relService.findAll();
        List<Rel> sublist = rels.subList(0, 30);
        Long nbRel = relService.countRel();
        model.addAttribute("rels", sublist);
        model.addAttribute("nbRels", nbRel);
        return "relList";
    }

    /**
     * Page of "Show Concept".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Concepts to conceptList.ftl
     */
    @RequestMapping(value = "/conceptList", method = RequestMethod.GET)
    public String conceptList(Model model) {
        List<Concept> concepts = conceptService.findAll();
        List<Concept> sublist = concepts.subList(0, 30);
        model.addAttribute("concepts", sublist);
        Long nbConcept = conceptService.countConcept();
        model.addAttribute("nbConcepts", nbConcept);
        return "conceptList";
    }

    /**
     * Page of "Show LeffSem".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of LeffSems
     */
    @RequestMapping(value = "/leffSemList", method = RequestMethod.GET)
    public String leffSemList(Model model) {
        List<LeffSem> leffSems = leffSemService.findAll();
        List<LeffSem> sublist = leffSems.subList(0, 30);
        model.addAttribute("leffSems", sublist);
        Long nbLeffSem = leffSemService.countLeffSem();
        model.addAttribute("nbLeffSems", nbLeffSem);
        return "leffSemList";
    }

    /**
     * Page of "Show Sense".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Sense
     */
    @RequestMapping(value = "/senseList", method = RequestMethod.GET)
    public String senseList(Model model) {
        List<Sense> senses = senseService.findAllSenses();
        List<Sense> sublist = senses.subList(0, 30);
        model.addAttribute("senses", sublist);
        Long nbSense = senseService.countSense();
        model.addAttribute("nbSenses", nbSense);
        return "senseList";
    }

    /**
     * Page of "Show Domain".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Domain
     */
    @RequestMapping(value = "/domainList", method = RequestMethod.GET)
    public String domainList(Model model) {
        List<Domain> domains = domainService.findAll();
        if (domains.size() < 30) {
            model.addAttribute("domains", domains);
            Long nbDomains = domainService.countDomain();
            model.addAttribute("nbDomains", nbDomains);
            return "domainList";
        } else {
            List<Domain> sublist = domains.subList(0, 30);
            model.addAttribute("domains", sublist);
            Long nbDomain = domainService.countDomain();
            model.addAttribute("nbDomains", nbDomain);
            return "domainList";
        }
    }

    /**
     * Page of "Show Word Form".
     * Limit to 30 items.
     * 
     * @param model Model
     * @return Post a List of Word Form
     */
    @RequestMapping(value = "/wordFormList", method = RequestMethod.GET)
    public String wordFormList(Model model) {
        List<WordForm> wordForms = wordFormService.findAll();
        List<WordForm> sublist = wordForms.subList(0, 30);
        Long nbWordForm = wordFormService.countWordForm();
        model.addAttribute("wordForms", sublist);
        model.addAttribute("nbWordForm", nbWordForm);
        return "wordFormList";
    }

    /**
     * Page Get information of word of "Create a word".
     * 
     * @param model Model
     * @return A new word empty.
     */
    @RequestMapping(value = "/addWord", method = RequestMethod.GET)
    public String showAddWordPage(Model model) {
        Word word = new Word();
        model.addAttribute("word", word);
        return "addWord";
    }

    /**
     * Page Post information of word of "Create a word".
     * 
     * @param model Model
     * @param word a word fill in with information by user.
     * @return If a word created, redirect to result to show all information of this word. else show information not complete.
     */
    @RequestMapping(value = "/addWord", method = RequestMethod.POST)
    public String saveWord(Model model, @ModelAttribute("word") Word word) {
        if (word.getLemma() != null && word.getLemma().length() > 0 && word.getPos() != null && word.getPos().length() > 0 &&
                word.getLang() != null && word.getLang().length() > 0 && word.getInfl() != null &&
                word.getInfl().length() > 0 && word.getTag() != null && word.getTag().length() > 0 && word.getModal() != null &&
                word.getNeg() != null && word.getOrigin() != null && word.getOrigin().length() > 0 && word.getCpos() != null &&
                word.getCpos().length() > 0 && word.getDisabled() != null) {
            // Save word
            Word wSaved = wordService.saveAndFlush(word);
            // Create and save new sense, leffSem and wordForm with this word id. But those new instance are empty with value
            Sense sense = new Sense(wSaved.getId());
            Sense sSaved = senseService.saveAndFlush(sense);
            LeffSem leffSem = new LeffSem(wSaved.getId());
            LeffSem lfSaved = leffSemService.saveAndFlush(leffSem);
            WordForm wordForm = new WordForm(wSaved.getId());
            WordForm wfSaved = wordFormService.saveAndFlush(wordForm);
            // Create a new list of these new instance in word and establish a link with this word.
            List<Sense> senses = new ArrayList<Sense>();
            senses.add(sSaved);
            wSaved.setSenses(senses);
            List<LeffSem> leffSems = new ArrayList<LeffSem>();
            leffSems.add(lfSaved);
            wSaved.setLeffSems(leffSems);
            List<WordForm> wordForms = new ArrayList<WordForm>();
            wordForms.add(wfSaved);
            wSaved.setWordForm(wordForms);
            return "redirect:/word/" + wSaved.getId();
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addWord";
        }
    }

    /**
     * Page Get information of word of "Create a sense".
     * 
     * @param model Model
     * @return A new word empty.
     */
    @RequestMapping(value = "/addSense", method = RequestMethod.GET)
    public String showAddSensePage(Model model) {
        Sense sense = new Sense();
        model.addAttribute("sense", sense);
        return "addSense";
    }

    /**
     * Page Post information of word of "Create a Sense".
     * 
     * @param model Model
     * @param sense a sense fill in with information by user.
     * @return If a sense created, redirect to result to show word relevance. else show information not complete.
     */
    @RequestMapping(value = "/addSense", method = RequestMethod.POST)
    public String saveSense(Model model, @ModelAttribute("sense") Sense sense) {
        if (sense.getScore() != null && sense.getDomain() != null && sense.getConcept() != null && sense.getOrigin() != null &&
                sense.getOrigin().length() > 0) {
            if (wordService.findById(sense.getWord()) == null) {
                model.addAttribute("errorMesOfWord", errorMesOfWord);
                return "addSense";
            } else if (conceptService.findConceptById(sense.getConcept()) == null) {
                model.addAttribute("errorMesOfConcept", errorMesOfConcept);
                return "addSense";
            } else {
                Sense sSaved = senseService.saveAndFlush(sense);
                return "redirect:/word/" + sSaved.getWord();
            }
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addSense";
        }
    }

    /**
     * Page Get information of word of "Create a Word Form".
     * 
     * @param model Model
     * @return A new Word Form empty.
     */
    @RequestMapping(value = "/addWordForm", method = RequestMethod.GET)
    public String showAddWordFormPage(Model model) {
        WordForm wordForm = new WordForm();
        model.addAttribute("wordForm", wordForm);
        return "addWordForm";
    }

    /**
     * Page Post information of "Create a WordForm".
     * 
     * @param model Model
     * @param wordform a model of wordform fill in with information by user.
     * @return If a wordform created, redirect to result to show word relevance. else show information not complete.
     */
    @RequestMapping(value = "/addWordForm", method = RequestMethod.POST)
    public String saveWordForm(Model model, @ModelAttribute("wordForm") WordForm wordForm) {
        if (wordForm.getWord() != null && wordForm.getDisabled() != null && wordForm.getForm() != null && wordForm.getMorph() != null &&
                wordForm.getLefffpos() != null) {
            WordForm wfSaved = wordFormService.saveAndFlush(wordForm);
            return "redirect:/word/" + wfSaved.getWord();
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addWordForm";
        }
    }

    /**
     * Page Get information of "Create a Domain".
     * 
     * @param model Model
     * @return A new Domain empty.
     */
    @RequestMapping(value = "/addDomain", method = RequestMethod.GET)
    public String showAddDomainPage(Model model) {
        Domain domain = new Domain();
        model.addAttribute("domain", domain);
        return "addDomain";
    }

    /**
     * Page Post information of "Create a Domain".
     * 
     * @param model Model
     * @param wordform a model of domain fill in with information by user.
     * @return If a domain created, redirect to result to show domain relevance. else show information not complete.
     */
    @RequestMapping(value = "/addDomain", method = RequestMethod.POST)
    public String saveDomain(Model model, @ModelAttribute("domain") Domain domain) {
        if (domain.getValue() != null) {
            Domain dSaved = domainService.saveAndFlush(domain);
            return "redirect:/domain/" + dSaved.getId();
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addDomain";
        }
    }

    /**
     * Page Get information of "Create a LeffSem".
     * 
     * @param model Model
     * @return A new leffSem empty.
     */
    @RequestMapping(value = "/addLeffSem", method = RequestMethod.GET)
    public String showAddLeffSemPage(Model model) {
        LeffSem leffSem = new LeffSem();
        model.addAttribute("leffSem", leffSem);
        return "addLeffSem";
    }

    /**
     * Page Post information of word of "Create a LeffSem".
     * 
     * @param model Model
     * @param leffSem a LeffSem fill in with information by user.
     * @return If a leffSem created, redirect to result to show word relevance. else show information not complete.
     */
    @RequestMapping(value = "/addLeffSem", method = RequestMethod.POST)
    public String saveLeffSem(Model model, @ModelAttribute("leffSem") LeffSem leffSem) {
        if (leffSem.getWordId() != null && leffSem.getForm() != null && leffSem.getPred() != null && leffSem.getTag() != null &&
                leffSem.getTag().length() > 0 && leffSem.getFrame() != null && leffSem.getSyntax() != null) {
            if (wordService.findById(leffSem.getWordId()) == null) {
                model.addAttribute("errorMesOfWord", errorMesOfWord);
                return "addLeffSem";
            } else {
                LeffSem lfSaved = leffSemService.saveAndFlush(leffSem);
                return "redirect:/word/" + lfSaved.getWordId();
            }
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addLeffSem";
        }
    }

    /**
     * Page Get information of word of "Create a Concept".
     * 
     * @param model Model
     * @return A new concept empty.
     */
    @RequestMapping(value = "/addConcept", method = RequestMethod.GET)
    public String showAddConceptPage(Model model) {
        Concept concept = new Concept();
        model.addAttribute("concept", concept);
        return "addConcept";
    }

    /**
     * Page Post information of word of "Create a Concept".
     * 
     * @param model Model
     * @param concept a Concept fill in with information by user.
     * @return concept created.
     */
    @RequestMapping(value = "/addConcept", method = RequestMethod.POST)
    public String saveConcept(Model model, @ModelAttribute("concept") Concept concept) {
        if (concept.getScore() != null && concept.getDisabled() != null && concept.getName() != null && concept.getDef() != null &&
                concept.getUsages().length() > 0 && concept.getUsages() != null && concept.getSemclass() != null && concept.getOrigin() != null) {
            Concept cSaved = conceptService.saveAndFlush(concept);
            return "redirect:/concept/" + cSaved.getId();
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addConcept";
        }
    }

    /**
     * Page Get information of word of "Create a Relation".
     * 
     * @param model Model
     * @return A new relation empty.
     */
    @RequestMapping(value = "/addRelation", method = RequestMethod.GET)
    public String showAddRelationPage(Model model) {
        Rel rel = new Rel();
        model.addAttribute("rel", rel);
        return "addRelation";
    }

    /**
     * Page Post information of word of "Create a Relation".
     * 
     * @param model Model
     * @param rel a relation fill in with information by user.
     * @return If a relation created.
     */
    @RequestMapping(value = "/addRelation", method = RequestMethod.POST)
    public String saveRelation(Model model, @ModelAttribute("rel") Rel rel) {
        if (rel.getName() != null && rel.getDisabled() != null && rel.getSource() != null && rel.getTarget() != null &&
                rel.getDomain() != null && rel.getDescription() != null && rel.getOrigin() != null) {
            if (conceptService.findConceptById(rel.getSource()) == null) {
                model.addAttribute("errorMesOfSourceConcept", errorMesOfSourceConcept);
                return "addRelation";
            } else if (conceptService.findConceptById(rel.getTarget()) == null) {
                model.addAttribute("errorMesOfTargetConcept", errorMesOfTargetConcept);
                return "addRelation";
            } else {
                RelPrimaryKey rpk = new RelPrimaryKey(rel.getSource(), rel.getName(), rel.getTarget(), rel.getDomain());
                rel.setPrimaryKey(rpk);
                Rel rSaved = relService.saveAndFlush(rel);

                // Create a relation inverse of concept target.
                Rel otherRelforTagerConcept = new Rel();
                otherRelforTagerConcept.setName(rel.getName());
                otherRelforTagerConcept.setSource(rel.getTarget());
                otherRelforTagerConcept.setTarget(rel.getSource());
                otherRelforTagerConcept.setDomain(rel.getDomain());
                otherRelforTagerConcept.setDescription(rel.getDescription());
                otherRelforTagerConcept.setDisabled(rel.getDisabled());
                otherRelforTagerConcept.setOrigin(rel.getOrigin());
                RelPrimaryKey rpkOther = new RelPrimaryKey(otherRelforTagerConcept.getSource(), otherRelforTagerConcept.getName(),
                        otherRelforTagerConcept.getTarget(), otherRelforTagerConcept.getDomain());
                otherRelforTagerConcept.setPrimaryKey(rpkOther);
                Rel rcSaved = relService.saveAndFlush(otherRelforTagerConcept);
                return "redirect:/concept/" + rSaved.getSource();
            }
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "addRelation";
        }
    }

    /**
     * Page of "Find Word By Id" with input box empty.
     * 
     * @param model Model
     * @return A input box empty.
     */
    @GetMapping("/findWordById")
    public String wordForm(Model model) {
        model.addAttribute("greeting", new Request());
        return "findWordById";
    }

    /**
     * Page of "Find Word By Id" with information input by user.
     * 
     * @param model Model
     * @param greeting
     * @return If word exist, show all information of this word, redirect to add word if not.
     */
    @PostMapping("/findWordById")
    public String wordSubmit(Model model, @ModelAttribute Request request) {
        Word word = wordService.findById(request.getId());
        if (word == null) {
            model.addAttribute("errorMesOfWord", errorMesOfWord);
            return "inExistence";
        } else {
            words.add(word);
            model.addAttribute("words", words);
            words = new ArrayList<>();
            // avoid previous search store in list of word.
            // This can be use in future, example : record of user search.
            return "showWord";
        }
    }

    /**
     * Page of "Find word by Lemma" with input box empty.
     * 
     * @param model Modal
     * @return A input box empty.
     */
    @GetMapping("/findWordByLemma")
    public String wordByLemmaForm(Model model) {
        model.addAttribute("greeting", new Request());
        return "findWordByLemma";
    }

    /**
     * Page of "Find word by Lemma" with information input by user.
     * 
     * @param model
     * @param greeting
     * @return If word exist, show all information of this word, redirect to add word if not.
     */
    @PostMapping("/findWordByLemma")
    public String wordByLemmaSubmit(Model model, @ModelAttribute Request request) {
        List<Word> word = wordService.findByLemma(request.getLemma());
        if (word.size() == 0) {
            model.addAttribute("errorMesOfWord", errorMesOfWord);
            return "inExistence";
        } else {
            words = word;
            model.addAttribute("words", words);
            words = new ArrayList<>();
            // Idem
            return "showWord";
        }
    }

    @GetMapping("rel/target/{id}")
    public String getRelByTargetId(@PathVariable("id") String idString, Model model) {
        // cause value in Freemarker add automatism a comma in number.
        // so delete comma and turn to number.
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);

        List<Rel> rels = relService.findByTargetId(id);
        model.addAttribute("rels", rels);
        return "showRel";
    }

    @GetMapping("sense/{id}")
    public String getSenseById(@PathVariable("id") String idString, Model model) {
        // cause value in Freemarker add automatism a comma in number.
        // so delete comma and turn to number.
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);

        Sense sense = senseService.findById(id);
        model.addAttribute("sense", sense);
        return "showSense";
    }

    @GetMapping("domain/{id}")
    public String getDomainById(@PathVariable("id") String idString, Model model) {
        // cause value in Freemarker add automatism a comma in number.
        // so delete comma and turn to number.
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);

        Domain domain = domainService.findDomainById(id);
        model.addAttribute("domain", domain);
        return "showDomain";
    }

    @GetMapping("rel/{name}")
    public String getRelByName(@PathVariable("name") String name, Model model) {
        List<Rel> rels = relService.findByName(name);
        if (rels.size() >= 30) {
            List<Rel> subList = rels.subList(0, 50);
            model.addAttribute("rels", subList);
            return "showRel";
        } else {
            model.addAttribute("rels", rels);
            return "showRel";
        }

    }

    @GetMapping("word/{id}")
    public String getWordById(@PathVariable("id") String idString, Model model) {
        // idem
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);
        words.add(wordService.findById(id));
        model.addAttribute("words", words);
        words = new ArrayList<>();
        return "showWord";
    }

    @GetMapping("concept/{id}")
    public String getConceptById(@PathVariable("id") String idString, Model model) {
        // idem
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);

        Concept concept = conceptService.findConceptById(id);
        if (concept == null) {
            return "redirect:addConcept";
        } else {
            // Find word of concept via sense.
            List<Sense> senses = senseService.findSenseByConcept(id);

            List<Word> wordsFind = new ArrayList<>();
            List<Rel> relsFind = relService.findBySourceId(id);
            for (int i = 0; i < senses.size(); i++) {
                if (senses.get(i).getConcept() == id) {
                    wordsFind.add(wordService.findById(senses.get(i).getWord()));
                }
            }
            model.addAttribute("concept", concept);
            model.addAttribute("words", wordsFind);
            model.addAttribute("rels", relsFind);
            // avoid previous search store in list of word.
            // but this can be use in future, exemple : record of user search.
            return "showConcept";
        }
    }

    /**
     * Page of "Find Concept By Id" with input box empty.
     * 
     * @param model Model
     * @return A input box empty.
     */
    @GetMapping("/findConceptById")
    public String conceptForm(Model model) {
        model.addAttribute("greeting", new Request());
        return "findConceptById";
    }

    @PostMapping("/findConceptById")
    public String conceptSubmit(Model model, @ModelAttribute Request request) {
        int id = request.getId();
        Concept concept = conceptService.findConceptById(id);
        if (concept == null) {
            model.addAttribute("errorMesOfConcept", errorMesOfConcept);
            return "inExistence";
        } else {
            // Find word of concept via sense.
            List<Sense> senses = senseService.findSenseByConcept(id);

            List<Word> wordsFind = new ArrayList<>();
            List<Rel> relsFind = relService.findBySourceId(id);
            for (int i = 0; i < senses.size(); i++) {
                if (senses.get(i).getConcept() == id) {
                    wordsFind.add(wordService.findById(senses.get(i).getWord()));
                }
            }

            model.addAttribute("concept", concept);
            model.addAttribute("words", wordsFind);
            model.addAttribute("rels", relsFind);
            // avoid previous search store in list of word.
            // but this can be use in future, example : record of user search.
            return "showConcept";
        }
    }

    /**
     * 
     * Not finish.
     * Page Get information of "Update a sense".
     * 
     * @param model Model
     * @return the information change of this sense.
     */
    @GetMapping("updateSense/{id}")
    public String showUpdateSensePage(@PathVariable("id") String idString, Model model) {
        String elimineComma = idString.replace(",", "");
        int id = Integer.parseInt(elimineComma);
        Sense sense = senseService.findById(id);
        model.addAttribute("sense", sense);
        return "updateSense";
    }

    /**
     * 
     * Not finish.
     * Page Post information of "Update a Sense".
     * 
     * @param model Model
     * @param sense a sense exist in Database.
     * @return If successful update, redirect to result to show word relevance. else show information not exist.
     */
    @RequestMapping(value = "updateSense/", method = RequestMethod.PUT)
    public @ResponseBody String updateSense(Model model, @ModelAttribute("sense") Sense sense) {
        if (sense.getScore() != null && sense.getDomain() != null && sense.getConcept() != null && sense.getOrigin() != null &&
                sense.getOrigin().length() > 0) {
            Sense sSaved = senseService.save(sense);
            return "redirect:/word/" + sSaved.getWord();
        } else {
            model.addAttribute("errorMessage", errorMessage);
            return "inExistence";
        }
    }
}
