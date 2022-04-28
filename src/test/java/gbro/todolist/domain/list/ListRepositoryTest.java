package gbro.todolist.domain.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

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

        //when

        //then

    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }
}