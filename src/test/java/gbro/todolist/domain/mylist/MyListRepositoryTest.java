package gbro.todolist.domain.mylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MyListRepositoryTest {

    MyListRepository myListRepository = new MyListRepository();

    @AfterEach
    void afterEach(){
        myListRepository.clearStore();
    }

    @Test
    void save() {
        //given
        MyList myList = new MyList("List1", "Contents");
        //when
        MyList savedList = myListRepository.save(myList);
        //then
        MyList findList = myListRepository.findById(savedList.getId());
        assertThat(findList).isEqualTo(savedList);
    }

    @Test
    void findAll() {
        //given
        MyList myList1 = new MyList("List1", "Contents");
        MyList myList2 = new MyList("List2", "Contents");

        myListRepository.save(myList1);
        myListRepository.save(myList2);

        //when
        List<MyList> result = myListRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(myList1,myList2);
    }

    @Test
    void update() {

        //given
        MyList myList = new MyList("List1", "Contents");

        MyList savedItem = myListRepository.save(myList);
        Long listId = savedItem.getId();

        //when

        MyList updateParam = new MyList("List2", "Contents22");
        myListRepository.update(listId,updateParam);

        MyList findList = myListRepository.findById(listId);
        //then

        assertThat(findList.getListName()).isEqualTo(updateParam.getListName());
        assertThat(findList.getContents()).isEqualTo(updateParam.getContents());

    }
}