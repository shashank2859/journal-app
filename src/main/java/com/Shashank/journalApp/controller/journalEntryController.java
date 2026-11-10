package com.Shashank.journalApp.controller;

import com.Shashank.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Journal")
public class journalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<Long, JournalEntry>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<JournalEntry>(journalEntries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getJournalId(), myEntry);
        return "Journal Created";

    }
    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getJournalId(), myEntry);
        return myEntry;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntry(@PathVariable Long myId){
        journalEntries.remove(myId);
        return null;
    }


}
