package gbro.todolist.domain.list;


import lombok.Data;

@Data
public class MyList {

    private Long id;
    private String listName;
    private String contents;

    public MyList(){

    }

    public MyList(Long id, String listName, String contents) {
        this.id = id;
        this.listName = listName;
        this.contents = contents;
    }
}
