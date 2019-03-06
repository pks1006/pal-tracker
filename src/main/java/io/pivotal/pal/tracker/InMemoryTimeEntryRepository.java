package io.pivotal.pal.tracker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> repo = new HashMap<>();
    private long counter =1;

    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(counter++);
        repo.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return repo.get(id);
    }

    public List<TimeEntry> list() {
        return Arrays.asList(repo.values().toArray(new TimeEntry[]{}));
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (!repo.containsKey(id)){
            return null;
        }
        timeEntry.setId(id);
        repo.put(id,timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        repo.remove(id);
    }

}

