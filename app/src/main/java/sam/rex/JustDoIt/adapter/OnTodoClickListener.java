package sam.rex.JustDoIt.adapter;

import sam.rex.JustDoIt.model.Task;

public interface OnTodoClickListener {
    void onTodoClick(Task task);
    void onTodoRadioButtonClick(Task task);
}
