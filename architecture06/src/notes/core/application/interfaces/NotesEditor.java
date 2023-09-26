package notes.core.application.interfaces;

import notes.core.domain.Note;

public interface NotesEditor extends Editor<Note, Integer> {

    void printAll();


}
