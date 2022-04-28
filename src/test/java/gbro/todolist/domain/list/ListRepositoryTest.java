package gbro.todolist.domain.list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ListRepositoryTest {

    ListRepository listRepository = new ListRepository();

    @AfterEach
    void afterEach(){
        listRepository.clearStore();
    }

    @Test
    void save() {
        //given
        MyList myList = new MyList("List1", "Contents");
        //when
        MyList savedList = listRepository.save(myList);
        //then
        MyList findList = listRepository.findById(savedList.getId());
        assertThat(findList).isEqualTo(savedList);
    }

    @Test
    void findAll() {
        //given
        MyList myList1 = new MyList("List1", "Contents");
        MyList myList2 = new MyList("List2", "Contents");

        listRepository.save(myList1);
        listRepository.save(myList2);

        //when
        List<MyList> result = listRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(myList1,myList2);
    }

    @Test
    void update() {

        //given
        MyList myList = new MyList("List1", "Contents");

        MyList savedItem = listRepository.save(myList);
        Long listId = savedItem.getId();

        //when

        MyList updateParam = new MyList("List2", "Contents22");
        listRepository.update(listId,updateParam);

        MyList findList = listRepository.findById(listId);
        //then

        assertThat(findList.getListName()).isEqualTo(updateParam.getListName());
        assertThat(findList.getContents()).isEqualTo(updateParam.getContents());

    }
}