import database.NotesDatabase;
import notes.core.application.ConcreteNotesEditor;
import notes.core.domain.Note;
import notes.infrastructure.persistance.NotesDbContext;
import notes.presentation.queries.controllers.NotesController;
import notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
       // Note note = new Note(1001, 21, "title #0", "details #0", new Date());
        Note note = new Note(1001, "title #0", "details #0");

        NotesController controller = new NotesController(
                new ConcreteNotesEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));
        controller.routeGetAll();
        System.out.println();
        controller.routeRemoveNote(note);
        controller.routeGetAll();
    }
}


