package gbro.todolist.domain.mylist;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MyListRepository {

    private static final Map<Long, MyList> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public MyList save(MyList myList){
        myList.setId(++sequence);
        store.put(myList.getId(),myList);

        return myList;
    }

    public MyList findById(Long id){
        return store.get(id);
    }

    public List<MyList> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long listId, MyList updateParam){

        MyList myList = findById(listId);
        myList.setListName(updateParam.getListName());
        myList.setContents(updateParam.getContents());
    }

    public void clearStore(){
        store.clear();
    }
}
