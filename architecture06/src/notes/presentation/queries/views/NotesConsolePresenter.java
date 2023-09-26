package notes.presentation.queries.views;

import notes.core.application.interfaces.NotesPresenter;
import notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {

    public NotesConsolePresenter() {
    }

    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
