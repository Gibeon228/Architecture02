package notes.core.application.interfaces;

import notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();
    Collection<Note> remove(Note note);

    boolean saveChanges();

}
