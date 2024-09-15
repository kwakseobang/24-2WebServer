package org.zerock.work1.todo.service;


import org.zerock.work1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// enum 타입으로 클래스를 작성하는 경우 가장 큰 장점은 정해진 수 만큼만 객체를 생성할 수 이따.
public enum TodoService {
   //객체의 개수를 정하는 부분으로 한 개만 지정되어 있어 하나의 객체만을 생성해서 사용
    //객체를 하나만 생성해서 사용하느 패턴을 '싱글톤 패턴'이라고 한다.
    INSTANCE;

    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG....." + todoDTO);
    }

    public List<TodoDTO> getList() {
        return IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());
    }

    public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return  dto;
    }
}
