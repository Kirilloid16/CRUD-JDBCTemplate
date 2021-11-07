package ru.lukash.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.lukash.model.Person;

import java.util.List;
@Component
public class Peopledao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public Peopledao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> AllPeople(){
        return jdbcTemplate.query("SELECT * FROM Person",new Mapper());
    }
    public Person ShowPerson(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new Mapper())
                .stream().findAny().orElse(null);
    }
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)",person.getName(),person.getAge(),person.getEmail());
    }

    public void update(int id,Person person) {
        jdbcTemplate.update("UPDATE Person SET name=?,age=?,email=? WHERE id=?",
                person.getName(),person.getAge(),person.getEmail(),id);
    }
    public void delete(int id){
       jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }

}
