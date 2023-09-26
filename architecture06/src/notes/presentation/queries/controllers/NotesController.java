package notes.presentation.queries.controllers;

import notes.core.application.interfaces.NotesEditor;
import notes.core.domain.Note;

public class NotesController extends Controller {

    private final NotesEditor notesEditor;

    public NotesController(NotesEditor notesEditor) {
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note) {
        this.notesEditor.add(note);
    }
    public void routeRemoveNote(Note note) {
        this.notesEditor.remove(note);
    }

    public void routeGetAll() {
        this.notesEditor.printAll();
    }
}
