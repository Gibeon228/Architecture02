package notes.infrastructure.persistance;

import database.NotesDatabase;
import database.NotesRecord;
import notes.core.application.interfaces.NotesDatabaseContext;
import notes.core.domain.Note;
import notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {


    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase) database).getNotesTable().getRecords()) {
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    @Override
    public Collection<Note> remove(Note note) {
        Collection<Note> notesList = getAll();
        for (Note note1 : notesList) {
            if (note1.equals(note)) {
                notesList.remove(note1);
                return notesList;
            }
        }
        throw new RuntimeException("Введён некорректный элемент");
    }
}
